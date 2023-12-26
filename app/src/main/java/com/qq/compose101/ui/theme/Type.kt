package com.qq.compose101.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.qq.compose101.R

val Typography = Typography(

    displaySmall = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp
    ),
    headlineSmall = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 30.sp
    ),
    labelSmall = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp
    ),
    titleSmall = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    titleMedium = TextStyle(
        fontWeight = FontWeight.SemiBold,
        letterSpacing = (.5).sp,
        fontSize = 18.sp
    ),
    titleLarge = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp
    )
)

private val interBlack900 = FontFamily(
    Font(R.font.soft_pos_inter_black)
)

private val interExtraBold800 = FontFamily(
    Font(R.font.soft_pos_inter_extra_bold)
)

private val interBold700 = FontFamily(
    Font(R.font.soft_pos_inter_bold)
)

private val interSemiBold600 = FontFamily(
    Font(R.font.soft_pos_inter_semi_bold)
)

private val interMedium500 = FontFamily(
    Font(R.font.soft_pos_inter_medium)
)

private val interRegular400 = FontFamily(
    Font(R.font.soft_pos_inter_regular)
)

data class CustomTypography(
    val headline: TextStyle = TextStyle(
        fontFamily = interBold700,
        fontSize = 24.sp
    ),
    val title: TextStyle = TextStyle(
        fontFamily = interSemiBold600,
        fontSize = 16.sp
    ),
    val label: TextStyle = TextStyle(
        fontFamily = interMedium500,
        fontSize = 16.sp
    ),
    val body: TextStyle = TextStyle(
        fontFamily = interRegular400,
        fontSize = 14.sp
    ),
    val caption: TextStyle = TextStyle(
        fontFamily = interRegular400,
        fontSize = 12.sp
    )
)

internal val LocalTypography = staticCompositionLocalOf {
    CustomTypography()
}