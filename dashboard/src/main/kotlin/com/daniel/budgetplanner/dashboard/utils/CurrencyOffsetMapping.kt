package com.daniel.budgetplanner.dashboard.utils

import androidx.compose.ui.text.input.OffsetMapping

class CurrencyOffsetMapping(
    private val originalText: String,
    private val formattedText: String,
    private val currencySymbolLength: Int
) : OffsetMapping {
    override fun originalToTransformed(offset: Int): Int {
        if (originalText.isEmpty() || originalText == "0") {
            return currencySymbolLength + offset.coerceAtMost(1)
        }

        var commas = 0
        val originalDigitsLength = originalText.length

        for (i in 0 until offset) {
            val remainingInFullString = originalDigitsLength - 1 - i
            if (remainingInFullString > 0 && remainingInFullString % THREE == 0) {
                commas++
            }
        }
        return currencySymbolLength + offset + commas
    }

    override fun transformedToOriginal(offset: Int): Int {
        if (originalText.isEmpty() || originalText == "0") {
            return (offset - currencySymbolLength).coerceIn(0, 1)
        }

        if (offset <= currencySymbolLength) return 0

        var digitCount = 0
        for (i in currencySymbolLength until offset.coerceAtMost(formattedText.length)) {
            if (formattedText[i].isDigit()) {
                digitCount++
            }
        }
        return digitCount.coerceIn(0, originalText.length)
    }
}
