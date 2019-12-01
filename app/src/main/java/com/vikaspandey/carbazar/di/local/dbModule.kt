package com.vikaspandey.carbazar.di.local

import android.app.Application
import androidx.room.Room
import com.vikaspandey.carbazar.db.CarsDb
import com.vikaspandey.carbazar.db.CarDao
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
class DbModule {
    @Singleton
    @Provides
    fun provideDb(app: Application): CarsDb {
        return Room
            .databaseBuilder(app, CarsDb::class.java, "delivery.db")
            .fallbackToDestructiveMigration()
            .build()

    }
    @Singleton
    @Provides
    fun provideUserDao(db: CarsDb): CarDao {
        return db.carDao
    }

    @Singleton
    @Provides
    fun provideCache(carDao: CarDao): CarsLocalCache {
        return CarsLocalCache(carDao, Executors.newSingleThreadExecutor())
    }
}