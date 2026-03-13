// 兼容层：Haze 毛玻璃效果替代
// [优化] 禁用毛玻璃效果，使用纯色背景
package dev.chrisbanes.haze

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

/**
 * [优化] HazeState 空实现
 */
class HazeState(
    initialBlurEnabled: Boolean = true
) {
    var blurEnabled: Boolean = initialBlurEnabled
}

/**
 * [优化] HazeStyle 空实现
 */
data class HazeStyle(
    val backgroundColor: Color = Color.Transparent
)

/**
 * [优化] HazeTint 空实现
 */
data class HazeTint(
    val color: Color = Color.Transparent
)

/**
 * [优化] HazeInputScale 空实现
 */
object HazeInputScale {
    val None = Any()
    fun Fixed(scale: Float) = Any()
}

/**
 * [优化] hazeSource Modifier - 空实现
 */
fun Modifier.hazeSource(state: HazeState): Modifier = this

/**
 * [优化] hazeChild Modifier - 空实现
 */
fun Modifier.hazeChild(
    state: HazeState,
    style: HazeStyle? = null
): Modifier = this

/**
 * [优化] haze Modifier - 空实现
 */
fun Modifier.haze(state: HazeState): Modifier = this

/**
 * [优化] rememberHazeState - 返回空实现
 */
@Composable
fun rememberHazeState(initialBlurEnabled: Boolean = true): HazeState {
    return HazeState(initialBlurEnabled)
}
