package com.android.purebilibili.core.ui.blur

import android.os.Build
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.android.purebilibili.core.lifecycle.BackgroundManager

internal fun shouldEnableRecoverableHeavyVisualEffects(
    userEnabled: Boolean,
    isAppInBackground: Boolean
): Boolean {
    return userEnabled && !isAppInBackground
}

internal fun shouldRecreateRecoverableHazeState(
    sdkInt: Int
): Boolean {
    return sdkInt >= 36
}

internal fun shouldAllowDirectHazeLiquidGlassFallback(
    sdkInt: Int
): Boolean {
    return sdkInt < 36
}

/**
 * [优化] 返回 null 而不是 HazeState，禁用模糊效果
 */
@Composable
fun rememberRecoverableHazeState(
    userEnabled: Boolean = true,
    initialBlurEnabled: Boolean = true,
    sdkInt: Int = Build.VERSION.SDK_INT
): Any? {
    // [优化] 返回 null，禁用所有模糊效果
    return null
}
