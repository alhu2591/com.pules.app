package com.pules.app

import android.content.Context
import android.widget.Toast
import androidx.biometric.BiometricPrompt
import androidx.biometric.BiometricManager
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.hilt.navigation.compose.hiltViewModel
import com.pules.app.ui.viewmodel.SettingsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppLockScreen(onUnlock: () -> Unit, viewModel: SettingsViewModel = hiltViewModel()) {
    val context = LocalContext.current
    val appLockType by viewModel.appLockType.collectAsState()
    val appLockValue by viewModel.appLockValue.collectAsState()

    var pinInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("التطبيق مقفل", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(32.dp))

        when (appLockType) {
            "fingerprint" -> {
                LaunchedEffect(Unit) {
                    authenticateWithBiometrics(context as FragmentActivity, onUnlock)
                }
                Text("يرجى استخدام بصمة الإصبع لفتح التطبيق.")
            }
            "pin" -> {
                TextField(
                    value = pinInput,
                    onValueChange = { pinInput = it },
                    label = { Text("أدخل رمز PIN") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {
                    if (pinInput == appLockValue) {
                        onUnlock()
                    } else {
                        Toast.makeText(context, "رمز PIN غير صحيح", Toast.LENGTH_SHORT).show()
                    }
                }) {
                    Text("فتح")
                }
            }
            "password" -> {
                TextField(
                    value = passwordInput,
                    onValueChange = { passwordInput = it },
                    label = { Text("أدخل كلمة السر") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {
                    if (passwordInput == appLockValue) {
                        onUnlock()
                    } else {
                        Toast.makeText(context, "كلمة السر غير صحيحة", Toast.LENGTH_SHORT).show()
                    }
                }) {
                    Text("فتح")
                }
            }
            else -> {
                Text("لا يوجد نوع قفل محدد. يرجى إعداد القفل في الإعدادات.")
                Button(onClick = onUnlock) {
                    Text("تجاوز (للتطوير فقط)")
                }
            }
        }
    }
}

private fun authenticateWithBiometrics(activity: FragmentActivity, onUnlock: () -> Unit) {
    val biometricManager = BiometricManager.from(activity)
    val executor = ContextCompat.getMainExecutor(activity)
    val biometricPrompt = BiometricPrompt(activity, executor,
        object : BiometricPrompt.AuthenticationCallback() {
            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)
                Toast.makeText(activity, "خطأ في المصادقة: $errString", Toast.LENGTH_SHORT).show()
            }

            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                Toast.makeText(activity, "تم فتح التطبيق بنجاح!", Toast.LENGTH_SHORT).show()
                onUnlock()
            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
                Toast.makeText(activity, "فشل المصادقة", Toast.LENGTH_SHORT).show()
            }
        })

    val promptInfo = BiometricPrompt.PromptInfo.Builder()
        .setTitle("قفل التطبيق")
        .setSubtitle("استخدم بصمة الإصبع لفتح Pules")
        .setNegativeButtonText("إلغاء")
        .setAllowedAuthenticators(BiometricManager.Authenticators.BIOMETRIC_STRONG or BiometricManager.Authenticators.DEVICE_CREDENTIAL)
        .build()

    when (biometricManager.canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_STRONG or BiometricManager.Authenticators.DEVICE_CREDENTIAL)) {
        BiometricManager.BIOMETRIC_SUCCESS -> {
            biometricPrompt.authenticate(promptInfo)
        }
        BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE -> {
            Toast.makeText(activity, "لا توجد ميزات بيومترية على هذا الجهاز", Toast.LENGTH_SHORT).show()
        }
        BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE -> {
            Toast.makeText(activity, "الميزات البيومترية غير متوفرة حاليًا", Toast.LENGTH_SHORT).show()
        }
        BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED -> {
            Toast.makeText(activity, "لا توجد بصمات أصابع مسجلة. يرجى التسجيل في إعدادات الجهاز.", Toast.LENGTH_SHORT).show()
        }
        else -> {
            Toast.makeText(activity, "خطأ غير معروف في المصادقة البيومترية", Toast.LENGTH_SHORT).show()
        }
    }
}


