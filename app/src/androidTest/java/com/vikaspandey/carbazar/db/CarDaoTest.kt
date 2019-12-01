package com.vikaspandey.carbazar.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.vikaspandey.carbazar.utils.getTestDeliveryItem
import com.vikaspandey.carbazar.utils.getTestDeliveryItemList
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CarDaoTest:CarsDbTest()
{
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()



    @Test
    fun insertAndReadTest() {

        db.carDao.deleteAll()

        assert(db.carDao.getCount() == 0)

        val deliveryItem = getTestDeliveryItem()

        db.carDao.insert(deliveryItem)

        assert(db.carDao.getCount() == 1)

        val item = (db.carDao.getCarOfId(deliveryItem.id))
        assert(item.value == deliveryItem)

    }

    @Test
    fun insertAllAndReadTest() {
        val list = getTestDeliveryItemList()


        db.carDao.deleteAll()

        assert(db.carDao.getCount() == 0)

        db.carDao.insertAll(list)

        assert(db.carDao.getCount() == list.size)

    }
}