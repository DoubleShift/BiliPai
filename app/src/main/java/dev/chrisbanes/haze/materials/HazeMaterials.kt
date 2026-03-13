// 兼容层：Haze Materials 毛玻璃效果替代
// [优化] 禁用毛玻璃效果
package dev.chrisbanes.haze.materials

import androidx.compose.runtime.Composable
import dev.chrisbanes.haze.HazeStyle

/**
 * [优化] ExperimentalHazeMaterialsApi 空注解
 */
@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class ExperimentalHazeMaterialsApi

/**
 * [优化] ExperimentalHazeApi 空注解
 */
@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class ExperimentalHazeApi

/**
 * [优化] HazeMaterials 空实现
 */
object HazeMaterials {
    @Composable
    fun thin(): HazeStyle = HazeStyle()
    
    @Composable
    fun thick(): HazeStyle = HazeStyle()
    
    @Composable
    fun ultraThin(): HazeStyle = HazeStyle()
    
    @Composable
    fun regular(): HazeStyle = HazeStyle()
}
