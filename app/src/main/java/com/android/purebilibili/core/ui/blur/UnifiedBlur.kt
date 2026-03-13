// 文件路径: core/ui/blur/UnifiedBlur.kt
package com.android.purebilibili.core.ui.blur

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.platform.LocalContext
import com.android.purebilibili.core.ui.adaptive.MotionTier
import com.android.purebilibili.core.store.SettingsManager
import androidx.compose.ui.draw.clip

private val LocalUnifiedBlurIntensity = staticCompositionLocalOf<BlurIntensity?> { null }

internal fun resolveUnifiedBlurIntensity(
    provided: BlurIntensity?,
    fallback: BlurIntensity
): BlurIntensity {
    return provided ?: fallback
}

@Composable
fun ProvideUnifiedBlurIntensity(
    content: @Composable () -> Unit
) {
    val context = LocalContext.current
    val blurIntensity by SettingsManager.getBlurIntensity(context)
        .collectAsState(initial = BlurIntensity.THIN)
    CompositionLocalProvider(
        LocalUnifiedBlurIntensity provides blurIntensity,
        content = content
    )
}

@Composable
fun currentUnifiedBlurIntensity(): BlurIntensity {
    val providedBlurIntensity = LocalUnifiedBlurIntensity.current
    if (providedBlurIntensity != null) {
        return providedBlurIntensity
    }

    val context = LocalContext.current
    val fallbackBlurIntensity by SettingsManager.getBlurIntensity(context)
        .collectAsState(initial = BlurIntensity.THIN)
    return fallbackBlurIntensity
}

/**
 *  统一的模糊Modifier
 * 
 * [优化] 移除 Haze 依赖，返回原始 Modifier
 * 
 * @param hazeState Haze状态（已忽略）
 * @param enabled 是否启用模糊（已忽略）
 * @return 原始 Modifier
 */
@Composable
fun Modifier.unifiedBlur(
    hazeState: Any?,
    enabled: Boolean = true,
    shape: androidx.compose.ui.graphics.Shape? = null,
    surfaceType: BlurSurfaceType = BlurSurfaceType.GENERIC,
    motionTier: MotionTier = MotionTier.Normal,
    isScrolling: Boolean = false,
    isTransitionRunning: Boolean = false,
    forceLowBudget: Boolean = false
): Modifier = composed {
    // [优化] 禁用模糊效果，仅保留 clip
    if (shape != null) {
        this.clip(shape)
    } else {
        this
    }
}
