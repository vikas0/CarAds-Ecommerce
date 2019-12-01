package com.vikaspandey.carbazar.ui.adDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.vikaspandey.carbazar.data.CarRepository
import com.vikaspandey.carbazar.db.Car
import javax.inject.Inject

class AdDetailViewModel @Inject constructor(private var carRepository: CarRepository
                              ) : ViewModel() {

    private val _adItemId = MutableLiveData<Int>()
    private val adItemId: LiveData<Int>
        get() = _adItemId

    val liveDataadItem: LiveData<Car> =  Transformations.switchMap(adItemId) {
        itemId -> carRepository.getCar(itemId)}

    fun setadItemId(itemId: Int) {
        _adItemId.value = itemId
    }







}
