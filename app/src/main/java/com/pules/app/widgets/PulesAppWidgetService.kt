package com.pules.app.widgets

import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import android.widget.RemoteViewsService
import com.pules.app.R
import com.pules.app.domain.model.Article
import com.pules.app.domain.usecase.GetRecommendedArticlesUseCase
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@AndroidEntryPoint
class PulesAppWidgetService : RemoteViewsService() {

    override fun onGetViewFactory(intent: Intent): RemoteViewsFactory {
        return PulesAppWidgetFactory(this.applicationContext, intent)
    }
}

class PulesAppWidgetFactory @Inject constructor(
    private val context: Context,
    intent: Intent,
    private val getRecommendedArticlesUseCase: GetRecommendedArticlesUseCase
) : RemoteViewsService.RemoteViewsFactory {

    private var articles: List<Article> = emptyList()

    override fun onCreate() {
        // In a real app, you might fetch data here synchronously or trigger an update
    }

    override fun onDataSetChanged() {
        // This is called by the app widget manager whenever the data needs to be refreshed.
        // You may take a long time and do work here, so it should be done synchronously.
        runBlocking {
            articles = getRecommendedArticlesUseCase().firstOrNull() ?: emptyList()
        }
    }

    override fun onDestroy() {
        articles = emptyList()
    }

    override fun getCount(): Int {
        return articles.size
    }

    override fun getViewAt(position: Int): RemoteViews {
        if (position < 0 || position >= articles.size) {
            return RemoteViews(context.packageName, R.layout.pules_app_widget_item)
        }

        val article = articles[position]
        val views = RemoteViews(context.packageName, R.layout.pules_app_widget_item)

        views.setTextViewText(R.id.widget_item_title, article.title)
        views.setTextViewText(R.id.widget_item_source, article.sourceName)

        // Fill in the blank for the pending intent template
        val fillInIntent = Intent()
        // You can put extras here if you want to pass data to the activity when an item is clicked
        // fillInIntent.putExtra(EXTRA_ITEM, position)
        views.setOnClickFillInIntent(R.id.widget_item_container, fillInIntent)

        return views
    }

    override fun getLoadingView(): RemoteViews? {
        return null // You can return a custom loading view here if needed
    }

    override fun getViewTypeCount(): Int {
        return 1
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun hasStableIds(): Boolean {
        return true
    }
}

