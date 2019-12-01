package com.vikaspandey.carbazar.db

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface CarDao {

    @Query("SELECT * from car_table ORDER BY id ASC")
    fun getCars(): LiveData<List<Car>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll( items: List<Car>)

    @Query("DELETE FROM car_table")
    fun deleteAll()

    @Query("SELECT * from car_table WHERE id = :carId ")
    fun getCarOfId(carId: Int): LiveData<Car>

    @Query("SELECT count(*) FROM car_table")
    fun getCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: Car)

}
