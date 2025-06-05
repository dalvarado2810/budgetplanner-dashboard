package com.daniel.budgetplanner.dashboard.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.daniel.base.ui.theme.fonts

object DashboardTextStyles {
    val text14spBold = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold
    )

    val text10spMedium = TextStyle(
        fontSize = 10.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = fonts
    )

    val text12spBold = TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = fonts
    )

    val text12spBoldRegular = TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = fonts,
        lineHeight = 14.sp
    )

    val text12spBlack = TextStyle(
        fontSize = 12.sp,
        color = Color.Black,
        fontFamily = fonts
    )

    val text16spBold = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = fonts
    )

    val text16spBolNoFonts = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold
    )

    val text10spBold = TextStyle(
        fontSize = 10.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Black
    )

    val balanceTextStyle = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.Both
        )
    )

    val text38spBold = TextStyle(
        fontSize = 38.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = fonts
    )

    val text19spBlackCenter = TextStyle(
        textAlign = TextAlign.Center,
        color = Color.Black,
        fontSize = 19.sp,
        fontFamily = fonts
    )

    val text22spBlackBoldCenter = TextStyle(
        fontWeight = FontWeight.Bold,
        fontFamily = fonts,
        fontSize = 22.sp,
        textAlign = TextAlign.Center,
        color = Color.Black
    )

    val text14spMediumBlack = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        color = Color.Black
    )

    val textAlign22spBold = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )

    val text16spBoldStart = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Start
    )

    val text18spBoldBlack = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Black
    )

    val text18spBoldAlign = TextStyle(
        fontSize = 18.sp,
        fontFamily = fonts,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )

    val text20spBoldAlign = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
}
