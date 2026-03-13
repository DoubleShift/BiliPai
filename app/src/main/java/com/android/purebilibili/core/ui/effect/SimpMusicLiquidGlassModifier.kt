package com.android.purebilibili.core.ui.effect

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape

/**
 * SimpMusic Style Liquid Glass Modifier
 * 
 * [优化] 移除 Backdrop 依赖，返回原始 Modifier
 */
@RequiresApi(Build.VERSION_CODES.O)
fun Modifier.simpMusicLiquidGlass(
    backdrop: Any? = null,
    shape: Shape = RectangleShape,
    onLuminanceChanged: (Float) -> Unit = {}
): Modifier = composed {
    // [优化] 禁用液态玻璃效果
    return@composed this
}

/**
 * [优化] 空的 LayerBackdrop 类型别名
 */
typealias LayerBackdrop = Any?

/**
 * [优化] 创建空的 LayerBackdrop
 */
@Composable
fun rememberLayerBackdrop(): LayerBackdrop {
    return null
}
