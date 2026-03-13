package com.android.purebilibili.core.ui.blur

import android.os.Build
import androidx.compose.runtime.Composable
import com.android.purebilibili.core.lifecycle.BackgroundManager
import dev.chrisbanes.haze.HazeState

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
 * [优化] 返回 HazeState 但禁用模糊效果
 */
@Composable
fun rememberRecoverableHazeState(
    userEnabled: Boolean = true,
    initialBlurEnabled: Boolean = true,
    sdkInt: Int = Build.VERSION.SDK_INT
): HazeState {
    // [优化] 返回 HazeState 但 blurEnabled 为 false
    return HazeState(initialBlurEnabled = false)
}
