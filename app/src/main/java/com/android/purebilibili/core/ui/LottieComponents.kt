// 文件路径: core/ui/LottieComponents.kt
package com.android.purebilibili.core.ui

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import kotlinx.coroutines.launch
import kotlin.math.PI
import kotlin.math.sin

/**
 *  Lottie 动画加载器
 * 
 * [优化] 移除 Lottie 依赖，使用简单的 Compose 动画替代
 */
object LottieUrls {
    const val LOADING_DOTS = ""
    const val LOADING_CIRCLE = ""
    const val LOADING_BILIBILI = ""
    const val LIKE_HEART = ""
    const val STAR = ""
    const val SUCCESS_CHECK = ""
    const val ERROR_CROSS = ""
    const val REFRESH = ""
    const val DOWNLOAD = ""
    const val SHARE = ""
    const val COIN = ""
    const val FAVORITE = ""
    const val BONUS = ""
    const val CELEBRATION = ""
    const val FIREWORKS = ""
    const val CONFETTI = ""
    const val TROPHY = ""
    const val MEDAL = ""
    const val LEVEL_UP = ""
}

/**
 * [优化] 简单的加载指示器，替代 Lottie 动画
 */
@Composable
fun SimpleLottieAnimation(
    modifier: Modifier = Modifier,
    url: String? = null,
    @androidx.annotation.RawRes rawRes: Int? = null,
    iterations: Int = 1,
    speed: Float = 1f,
    restartOnPlay: Boolean = true,
    clipToCompositionBounds: Boolean = true,
    maintainOriginalImageBounds: Boolean = false,
    enableMergePaths: Boolean = false,
    outlineMasksAndMattes: Boolean = false,
    applyOpacityToLayers: Boolean = false,
    enableApplyingOpacityToLayers: Boolean = false
) {
    // [优化] 使用简单的 CircularProgressIndicator 替代 Lottie 动画
    CircularProgressIndicator(
        modifier = modifier.size(48.dp),
        color = MaterialTheme.colorScheme.primary,
        strokeWidth = 4.dp
    )
}

/**
 * [优化] 简单的加载指示器
 */
@Composable
fun LottieLoadingIndicator(
    modifier: Modifier = Modifier,
    size: Dp = 48.dp,
    color: Color = MaterialTheme.colorScheme.primary
) {
    CircularProgressIndicator(
        modifier = modifier.size(size),
        color = color,
        strokeWidth = 4.dp
    )
}

/**
 * [优化] 简单的成功动画
 */
@Composable
fun LottieSuccessAnimation(
    modifier: Modifier = Modifier,
    onComplete: () -> Unit = {}
) {
    Icon(
        imageVector = Icons.Filled.CheckCircle,
        contentDescription = "Success",
        modifier = modifier.size(48.dp),
        tint = Color(0xFF4CAF50)
    )
}

/**
 * [优化] 简单的错误动画
 */
@Composable
fun LottieErrorAnimation(
    modifier: Modifier = Modifier,
    onComplete: () -> Unit = {}
) {
    Icon(
        imageVector = Icons.Filled.Error,
        contentDescription = "Error",
        modifier = modifier.size(48.dp),
        tint = MaterialTheme.colorScheme.error
    )
}

/**
 * [优化] 简单的心形动画
 */
@Composable
fun LottieHeartAnimation(
    modifier: Modifier = Modifier,
    isLiked: Boolean = false,
    onClick: () -> Unit = {}
) {
    val scale by animateFloatAsState(
        targetValue = if (isLiked) 1.2f else 1f,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy),
        label = "heart_scale"
    )
    
    Icon(
        imageVector = if (isLiked) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
        contentDescription = if (isLiked) "Liked" else "Like",
        modifier = modifier
            .graphicsLayer { scaleX = scale; scaleY = scale }
            .clickable { onClick() },
        tint = if (isLiked) Color(0xFFFF6B6B) else MaterialTheme.colorScheme.onSurface
    )
}

/**
 * [优化] 简单的星星动画
 */
@Composable
fun LottieStarAnimation(
    modifier: Modifier = Modifier,
    isStarred: Boolean = false,
    onClick: () -> Unit = {}
) {
    val scale by animateFloatAsState(
        targetValue = if (isStarred) 1.2f else 1f,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy),
        label = "star_scale"
    )
    
    Icon(
        imageVector = if (isStarred) Icons.Filled.Star else Icons.Outlined.StarBorder,
        contentDescription = if (isStarred) "Starred" else "Star",
        modifier = modifier
            .graphicsLayer { scaleX = scale; scaleY = scale }
            .clickable { onClick() },
        tint = if (isStarred) Color(0xFFFFD700) else MaterialTheme.colorScheme.onSurface
    )
}

/**
 * [优化] 简单的庆祝动画
 */
@Composable
fun LottieCelebrationAnimation(
    modifier: Modifier = Modifier,
    trigger: Boolean = false,
    onComplete: () -> Unit = {}
) {
    if (trigger) {
        Icon(
            imageVector = Icons.Filled.Celebration,
            contentDescription = "Celebration",
            modifier = modifier.size(48.dp),
            tint = Color(0xFFFFD700)
        )
    }
}

/**
 * [优化] 简单的下载动画
 */
@Composable
fun LottieDownloadAnimation(
    modifier: Modifier = Modifier,
    progress: Float = 0f,
    isDownloading: Boolean = false
) {
    if (isDownloading) {
        CircularProgressIndicator(
            progress = { progress },
            modifier = modifier.size(48.dp),
            color = MaterialTheme.colorScheme.primary,
            strokeWidth = 4.dp
        )
    } else {
        Icon(
            imageVector = Icons.Filled.Download,
            contentDescription = "Download",
            modifier = modifier.size(48.dp)
        )
    }
}

/**
 * [优化] 简单的分享动画
 */
@Composable
fun LottieShareAnimation(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Icon(
        imageVector = Icons.Filled.Share,
        contentDescription = "Share",
        modifier = modifier
            .size(48.dp)
            .clickable { onClick() }
    )
}

/**
 * [优化] 简单的投币动画
 */
@Composable
fun LottieCoinAnimation(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Icon(
        imageVector = Icons.Filled.MonetizationOn,
        contentDescription = "Coin",
        modifier = modifier
            .size(48.dp)
            .clickable { onClick() },
        tint = Color(0xFFFFD700)
    )
}

/**
 * [优化] 简单的收藏动画
 */
@Composable
fun LottieFavoriteAnimation(
    modifier: Modifier = Modifier,
    isFavorite: Boolean = false,
    onClick: () -> Unit = {}
) {
    LottieHeartAnimation(
        modifier = modifier,
        isLiked = isFavorite,
        onClick = onClick
    )
}

// 保留其他必要的类型别名和辅助函数
typealias LottieCompositionResult = Any?
typealias LottieCompositionSpec = Any?
