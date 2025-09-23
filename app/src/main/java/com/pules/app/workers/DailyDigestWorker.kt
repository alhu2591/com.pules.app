package com.pules.app.workers

import android.content.Context
import android.graphics.pdf.PdfDocument
import android.graphics.Paint
import android.graphics.Color
import android.graphics.Rect
import android.net.Uri
import androidx.core.content.FileProvider
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.pules.app.domain.usecase.GetRecommendedArticlesUseCase
import com.pules.app.domain.usecase.GetSourcesUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DailyDigestWorker @AssistedInject constructor(
    @Assisted private val appContext: Context,
    @Assisted private val workerParams: WorkerParameters,
    private val getSourcesUseCase: GetSourcesUseCase,
    private val getRecommendedArticlesUseCase: GetRecommendedArticlesUseCase
) : CoroutineWorker(appContext, workerParams) {

    @AssistedFactory
    interface Factory {
        fun create(appContext: Context, workerParams: WorkerParameters): DailyDigestWorker
    }

    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        try {
            // Simulate fetching daily digest content
            val sources = getSourcesUseCase().firstOrNull() // Get some sources
            val recommendedArticles = getRecommendedArticlesUseCase().firstOrNull() // Get some recommended articles

            val pdfFile = generateDailyDigestPdf(sources?.map { it.name } ?: emptyList(), recommendedArticles?.map { it.title } ?: emptyList())
            if (pdfFile != null) {
                println("Daily Digest PDF generated: ${pdfFile.absolutePath}")
                // In a real app, you might want to share this PDF or notify the user
                Result.success()
            } else {
                println("Failed to generate Daily Digest PDF.")
                Result.failure()
            }
        } catch (e: Exception) {
            println("Error preparing daily digest: ${e.message}")
            Result.failure()
        }
    }
}





private fun generateDailyDigestPdf(sources: List<String>, articles: List<String>): File? {
    val document = PdfDocument()
    val pageInfo = PdfDocument.PageInfo.Builder(595, 842, 1).create() // A4 size
    val page = document.startPage(pageInfo)
    val canvas = page.canvas

    val paint = Paint()
    paint.color = Color.BLACK
    paint.textSize = 24f

    var y = 40f
    val x = 30f
    val lineHeight = 30f

    canvas.drawText("ملخص بولس اليومي", x, y, paint)
    y += lineHeight * 2

    paint.textSize = 18f
    canvas.drawText("المصادر التي تتابعها:", x, y, paint)
    y += lineHeight

    paint.textSize = 14f
    if (sources.isEmpty()) {
        canvas.drawText("لا توجد مصادر مضافة.", x, y, paint)
        y += lineHeight
    } else {
        sources.forEach { source ->
            canvas.drawText("- $source", x + 10, y, paint)
            y += lineHeight
        }
    }
    y += lineHeight

    paint.textSize = 18f
    canvas.drawText("المقالات الموصى بها:", x, y, paint)
    y += lineHeight

    paint.textSize = 14f
    if (articles.isEmpty()) {
        canvas.drawText("لا توجد مقالات موصى بها.", x, y, paint)
        y += lineHeight
    } else {
        articles.forEach { article ->
            canvas.drawText("- $article", x + 10, y, paint)
            y += lineHeight
        }
    }

    document.finishPage(page)

    val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
    val fileName = "daily_digest_$timeStamp.pdf"
    val downloadsDir = File(appContext.filesDir, "PulesApp/DailyDigests")
    if (!downloadsDir.exists()) downloadsDir.mkdirs()
    val file = File(downloadsDir, fileName)

    return try {
        document.writeTo(FileOutputStream(file))
        document.close()
        file
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}


