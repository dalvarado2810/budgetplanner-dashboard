package com.daniel.budgetplanner.dashboard.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.daniel.budgetplanner.dashboard.data.local.dao.MovementsDao
import com.daniel.budgetplanner.dashboard.data.local.entities.MovementEntity

@Database(entities = [MovementEntity::class], version = 2)
@TypeConverters(Converters::class)
abstract class MovementDataBase: RoomDatabase() {
    abstract val movementsDao: MovementsDao
}
