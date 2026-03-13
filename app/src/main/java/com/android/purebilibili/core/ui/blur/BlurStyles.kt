// 文件路径: core/ui/blur/BlurStyles.kt
package com.android.purebilibili.core.ui.blur

import androidx.compose.runtime.Composable

/**
 *  模糊强度枚举
 * 用户可选的三种模糊强度
 */
enum class BlurIntensity {
    THIN,        // 标准 - 平衡美观与性能（默认）
    THICK,       // 浓郁 - 强烈磨砂质感
    APPLE_DOCK   //  玻璃拟态风格 - 高饱和度 + 精细模糊
}

/**
 *  模糊样式管理
 * 
 * [优化] 移除 Haze 依赖，使用纯色背景替代
 */
object BlurStyles {
    
    /**
     *  获取模糊样式（已禁用）
     *  返回 null 表示不使用模糊效果
     */
    @Composable
    fun getBlurStyle(intensity: BlurIntensity): Any? {
        // [优化] 返回 null，禁用模糊效果
        return null
    }

    @Composable
    fun getBlurStyle(
        intensity: BlurIntensity,
        budget: BlurBudget?
    ): Any? {
        // [优化] 返回 null，禁用模糊效果
        return null
    }
    
    /**
     *  获取不同模糊强度对应的背景透明度
     * - 玻璃拟态: 极低透明度（0.15）让背景颜色透出
     * - 浓郁: 高透明度（0.6）遮盖背景颜色
     * - 标准: 中等透明度
     */
    fun getBackgroundAlpha(intensity: BlurIntensity): Float {
        // [优化] 使用更高的不透明度，因为不再有模糊效果
        return when (intensity) {
            BlurIntensity.THIN -> 0.95f         // 标准 - 几乎不透明
            BlurIntensity.APPLE_DOCK -> 0.9f    // 玻璃拟态 - 高不透明度
            BlurIntensity.THICK -> 0.98f        // 浓郁 - 完全不透明
        }
    }

    fun getBackgroundAlpha(
        intensity: BlurIntensity,
        budget: BlurBudget?
    ): Float {
        val effectiveIntensity = if (budget != null) {
            resolveBudgetedBlurIntensity(intensity, budget)
        } else {
            intensity
        }
        val alpha = getBackgroundAlpha(effectiveIntensity)
        val multiplier = budget?.backgroundAlphaMultiplier ?: 1f
        return (alpha * multiplier).coerceIn(0f, 1f)
    }
}
