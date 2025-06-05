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
import com.daniel.base.ui.theme.BudgetGreen
import com.daniel.base.ui.theme.ExpensesColor
import com.daniel.budgetplanner.dashboard.R
import com.daniel.budgetplanner.dashboard.domain.model.Category
import java.text.NumberFormat
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale
import java.util.TimeZone

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

fun Int.toNumberFormat(): String{
    val format = NumberFormat.getInstance()
    return format.format(this)
}

fun setActualBalanceColor(actualBalance: Int): Color {
    return if (actualBalance < 0) Color.Red else Color.Black
}

fun convertMillisToDate(millis: Long):LocalDate {
    val localDate = LocalDateTime
        .ofInstant(
            Instant.ofEpochMilli(millis),
            TimeZone.getDefault().toZoneId())
    return localDate.plusDays(1L).toLocalDate()
}

fun String.changeDateFormat(): String {
    return try {
        val originalDate = LocalDate.parse(this, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        originalDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
    } catch (_: Exception) {
        this
    }
}

val categories = listOf(
    "Alimentación",
    "Gastos hormiga",
    "Servicios Públicos",
    "Salud",
    "Vestimenta",
    "Transporte",
    "Ingresos Mensuales",
    "Ingresos varios"
)

fun LocalDate.toViewPattern(): String = format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))

fun Category.toPainterResource() = when (this) {
    Category.FOOD_EXPENSES -> R.drawable.ic_grocery_store
    Category.ANT_EXPENSES -> R.drawable.ic_edc_machine
    Category.SERVICES_EXPENSES -> R.drawable.ic_services
    Category.OUTFIT_EXPENSES -> R.drawable.ic_outfit
    Category.HEALTH_EXPENSES -> R.drawable.ic_vaccine
    Category.TRANSPORTATION_EXPENSES -> R.drawable.ic_gas
    Category.MONTHLY_INCOMES -> R.drawable.ic_finance_icon
    Category.OTHER_INCOMES -> R.drawable.ic_various_input
}

fun Category.toAmountColor() = when (this) {
    Category.MONTHLY_INCOMES,
    Category.OTHER_INCOMES -> BudgetGreen

    else -> ExpensesColor
}
