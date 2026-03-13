// 兼容层：Cupertino 组件替代
// [优化] 使用 Material 3 组件替代 Cupertino 组件
package io.github.alexzhirkevich.cupertino

import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

/**
 * [优化] CupertinoSwitch - 使用 Material Switch 替代
 */
@Composable
fun CupertinoSwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: CupertinoSwitchColors = CupertinoSwitchDefaults.colors()
) {
    Switch(
        checked = checked,
        onCheckedChange = onCheckedChange,
        modifier = modifier,
        enabled = enabled,
        colors = SwitchDefaults.colors(
            checkedThumbColor = colors.thumbColor,
            checkedTrackColor = colors.checkedTrackColor,
            uncheckedThumbColor = colors.thumbColor,
            uncheckedTrackColor = colors.uncheckedTrackColor
        )
    )
}

/**
 * [优化] CupertinoSwitchColors
 */
data class CupertinoSwitchColors(
    val thumbColor: Color,
    val checkedTrackColor: Color,
    val uncheckedTrackColor: Color
)

/**
 * [优化] CupertinoSwitchDefaults
 */
object CupertinoSwitchDefaults {
    @Composable
    fun colors(
        thumbColor: Color = Color.White,
        checkedTrackColor: Color = MaterialTheme.colorScheme.primary,
        uncheckedTrackColor: Color = Color(0xFFE9E9EA)
    ): CupertinoSwitchColors = CupertinoSwitchColors(
        thumbColor = thumbColor,
        checkedTrackColor = checkedTrackColor,
        uncheckedTrackColor = uncheckedTrackColor
    )
}

/**
 * [优化] CupertinoSlider - 使用 Material Slider 替代
 */
@Composable
fun CupertinoSlider(
    value: Float,
    onValueChange: (Float) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f,
    steps: Int = 0,
    onValueChangeFinished: (() -> Unit)? = null
) {
    Slider(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        enabled = enabled,
        valueRange = valueRange,
        steps = steps,
        onValueChangeFinished = onValueChangeFinished
    )
}

/**
 * [优化] CupertinoActivityIndicator - 使用 Material CircularProgressIndicator 替代
 */
@Composable
fun CupertinoActivityIndicator(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primary,
    strokeWidth: Dp = 2.dp,
    size: Dp = 24.dp
) {
    CircularProgressIndicator(
        modifier = modifier.size(size),
        color = color,
        strokeWidth = strokeWidth
    )
}

/**
 * [优化] CutePersonLoadingIndicator - 使用简单加载指示器替代
 */
@Composable
fun CutePersonLoadingIndicator(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primary
) {
    CircularProgressIndicator(
        modifier = modifier.size(48.dp),
        color = color,
        strokeWidth = 4.dp
    )
}

/**
 * [优化] 导出 CutePersonLoadingIndicator 到包级别
 */
@Composable
fun CutePersonLoadingIndicator(
    modifier: Modifier = Modifier
) {
    CircularProgressIndicator(
        modifier = modifier.size(48.dp),
        color = MaterialTheme.colorScheme.primary,
        strokeWidth = 4.dp
    )
}
