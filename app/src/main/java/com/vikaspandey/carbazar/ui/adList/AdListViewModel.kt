package com.vikaspandey.carbazar.ui.adList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vikaspandey.carbazar.data.CarRepository
import com.vikaspandey.carbazar.db.Car
import com.vikaspandey.carbazar.utils.Constants.Companion.FROM_RES_FOLDER
import javax.inject.Inject

class AdListViewModel @Inject
constructor(private val carRepository: CarRepository) :
    ViewModel() {

     val cars = carRepository.loadCars()


    private val _navigateToAdDetail = MutableLiveData<Int>()
    val navigateToAdDetail
        get() = _navigateToAdDetail


    fun onAdItemClicked(id: Int) {
        _navigateToAdDetail.value = id
    }

    fun onAdDetailNavigated() {
        _navigateToAdDetail.value = null
    }

    fun addDummyAds() {

        var car1 = Car(1,"Ford","EcoSport 1.5 TDCi Titanium",2016,500000,
            "($FROM_RES_FOLDER)a1_1,($FROM_RES_FOLDER)a1_2,($FROM_RES_FOLDER)a1_3")

        var car2 = Car(1,"Mahindra","XUV500 W8 2WD",2015,300000,
            "($FROM_RES_FOLDER)a2_1,($FROM_RES_FOLDER)a2_2,($FROM_RES_FOLDER)a2_3")

        var car3 = Car(1,"Mercedes-Benz","E-Class E 200 CGI",2018,3300000,
            "($FROM_RES_FOLDER)a3_1,($FROM_RES_FOLDER)a3_2,($FROM_RES_FOLDER)a3_3")

        carRepository.addCars(listOf(car1,car2,car3))


    }

}


