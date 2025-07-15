package com.daniel.budgetplanner.dashboard.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.daniel.budgetplanner.dashboard.domain.model.DbMovementType
import com.daniel.budgetplanner.dashboard.domain.model.Category
import com.daniel.budgetplanner.dashboard.utils.DB_MOVEMENTS
import java.time.LocalDate

@Entity(tableName = DB_MOVEMENTS)
data class MovementEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "movementID")
    val id: Int,
    val movementDescription: String,
    val movementAmount: Int,
    val movementType: DbMovementType,
    val movementUser: String,
    val movementCategory: Category,
    val date: LocalDate,
    val month: Int,
    val year: Int
)
