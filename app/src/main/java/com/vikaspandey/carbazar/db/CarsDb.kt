package com.vikaspandey.carbazar.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Car::class], version = 1)
abstract class CarsDb: RoomDatabase() {
    abstract val carDao: CarDao
}

