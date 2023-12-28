package com.qq.compose101.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.qq.compose101.R

val Typography = Typography()

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val fontName = GoogleFont("Inter")

val InterFont = FontFamily(
    Font(googleFont = fontName, fontProvider = provider)
)

//private val InterFont = FontFamily(
//    Font(R.font.soft_pos_inter_bold, FontWeight.Bold),
//    Font(R.font.soft_pos_inter_semi_bold, FontWeight.SemiBold),
//    Font(R.font.soft_pos_inter_medium, FontWeight.Medium),
//    Font(R.font.soft_pos_inter_regular, FontWeight.Normal),
//)

val Typography.headline: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = InterFont,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )
    }
val Typography.title: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = InterFont,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp
        )
    }

val Typography.label: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = InterFont,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp
        )
    }

val Typography.body: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = InterFont,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp
        )
    }

val Typography.caption: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = InterFont,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp
        )
    }
