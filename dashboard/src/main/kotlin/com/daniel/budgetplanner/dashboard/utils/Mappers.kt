package com.daniel.budgetplanner.dashboard.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.daniel.budgetplanner.dashboard.R
import java.text.NumberFormat
import java.util.Locale

@Composable
fun String.toFormattedName(): AnnotatedString = buildAnnotatedString {
    withStyle(style = SpanStyle(fontWeight = FontWeight.Light)) {
        append(stringResource(id = R.string.hello))
    }
    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp)) {
        append(" ")
        append(this@toFormattedName)
    }
}

fun Int.toFormattedAmount(isVisible: Boolean = true): String {
    val numberFormat = NumberFormat.getCurrencyInstance(Locale("es", "CL"))
    val obfuscationChar = '•'
    numberFormat.maximumFractionDigits = 0
    val formatNumber = numberFormat.format(this)
    return if (isVisible) formatNumber else obfuscationChar.toString().repeat(formatNumber.length)
}

fun setActualBalanceColor(actualBalance: Int): Color {
    return if (actualBalance < 0) Color.Red else Color.Black
}
