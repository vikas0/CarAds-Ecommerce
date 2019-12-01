/*
 * Copyright (C) 2019 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.vikaspandey.carbazar.data

import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.vikaspandey.carbazar.db.Car
import com.vikaspandey.carbazar.db.CarDao
import com.vikaspandey.carbazar.db.CarsLoadResult
import com.vikaspandey.carbazar.utils.Constants.Companion.PAGE_SIZE
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CarRepository @Inject constructor(
    val carDao: CarDao
) {

fun addCars(cars:List<Car>) {
    carDao.insertAll(cars)
}
    fun insertAd(car:Car)
    {
        carDao.insert(car)
    }
    fun getCar(id: Int) = carDao.getCarOfId(id)

    fun loadCars()= carDao.getCars()

}
