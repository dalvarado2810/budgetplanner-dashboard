package com.daniel.budgetplanner.dashboard.utils

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.core.text.isDigitsOnly

class CurrencyVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val originalText = text.text.trim()
        if (originalText.isEmpty()) {
            return TransformedText(text, OffsetMapping.Identity)
        }
        if (originalText.isDigitsOnly().not()) {
            return TransformedText(text, OffsetMapping.Identity)
        }

        val formattedText = buildString {
            append(USD)
            val length = originalText.length
            originalText.forEachIndexed { index, char ->
                append(char)
                val remainingDigits = length - 1 - index
                if (remainingDigits > 0 && remainingDigits % THREE == 0) {
                    append(",")
                }
            }
        }

        return TransformedText(
            AnnotatedString(formattedText),
            CurrencyOffsetMapping(originalText, formattedText, USD.length)
        )
    }
}
