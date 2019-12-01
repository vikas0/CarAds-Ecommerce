package com.vikaspandey.carbazar.db

import androidx.lifecycle.LiveData
import androidx.paging.PagedList

data class CarsLoadResult(
    val data: LiveData<PagedList<Car>>,
    val errorWhileFetching: LiveData<String>
)
