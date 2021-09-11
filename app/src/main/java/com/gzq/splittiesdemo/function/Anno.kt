package com.gzq.splittiesdemo.function

import androidx.annotation.Dimension

/**
 *company：成都环宇知了科技有限公司
 *date：2021/9/11 上午9:28
 *coder：gzq
 *email：guozhiqiang@zlketang.com
 *description:
 */

@MustBeDocumented
@kotlin.annotation.Retention(AnnotationRetention.BINARY)
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER,
    AnnotationTarget.VALUE_PARAMETER,
    AnnotationTarget.FIELD,
    AnnotationTarget.LOCAL_VARIABLE
)
@Dimension(unit = Dimension.DP)
annotation class Dp