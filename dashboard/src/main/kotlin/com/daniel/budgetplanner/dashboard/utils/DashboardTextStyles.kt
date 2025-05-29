package com.daniel.budgetplanner.dashboard.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.daniel.base.ui.theme.fonts

object DashboardTextStyles {
    val text14spBold = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold
    )

    val text12spBlack = TextStyle(
        fontSize = 12.sp,
        color = Color.Black,
        fontFamily = fonts
    )
}
