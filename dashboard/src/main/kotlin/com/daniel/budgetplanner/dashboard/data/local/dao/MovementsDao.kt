package com.daniel.budgetplanner.dashboard.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.daniel.budgetplanner.dashboard.data.local.entities.MovementEntity
import com.daniel.budgetplanner.dashboard.domain.model.MovementsDb
import com.daniel.budgetplanner.dashboard.utils.DB_MOVEMENTS
import kotlinx.coroutines.flow.Flow

@Dao
interface MovementsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addMovement(movement: MovementEntity)

    @Query("SELECT * FROM $DB_MOVEMENTS WHERE date BETWEEN :startDate AND :endDate" )
    fun getAllMonthlyMovements(startDate: String, endDate: String): Flow<MovementsDb>

    @Delete
    suspend fun deleteMovement(movement: MovementEntity)

    @Update
    suspend fun editMovement(movement: MovementEntity)

    @Query("SELECT * FROM $DB_MOVEMENTS WHERE date BETWEEN :startDate AND :endDate AND movementUser = :user" )
    fun getAllMonthlyMovementsByUser(startDate: String, endDate: String, user: String): Flow<MovementsDb>
}
