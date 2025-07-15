package com.daniel.budgetplanner.dashboard.data.local.database

import androidx.room.TypeConverter
import java.time.LocalDate

class Converters {
    @TypeConverter
    fun fromTime(value: String?): LocalDate? {
        return value?.let { LocalDate.parse(it) }
    }

    @TypeConverter
    fun dateToTime(date: LocalDate?): String? {
        return date?.toString()
    }
}
