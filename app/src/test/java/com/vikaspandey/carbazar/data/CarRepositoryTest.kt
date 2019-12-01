package com.vikaspandey.carbazar.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.*
import com.vikaspandey.carbazar.utils.getTestDeliveryItem
import com.vikaspandey.carbazar.utils.getTestLiveDataDeliveryItem
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.hamcrest.CoreMatchers
import org.junit.*

import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.mock

@RunWith(JUnit4::class)
class CarRepositoryTest {
    private val boundaryCallback = mock(DeliveryItemBoundaryCallback::class.java)
    private  val deliveriesLocalCache = mock( CarsLocalCache::class.java)

    // Class under test
    private lateinit var carRepository: CarRepository

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @Before
    fun setUp() {
     carRepository = CarRepository(deliveriesLocalCache,boundaryCallback)
    }

    @Test
    fun testNotNull() {
        Assert.assertThat(boundaryCallback, CoreMatchers.notNullValue())
        Assert.assertThat(deliveriesLocalCache, CoreMatchers.notNullValue())
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getDeliveryItem(){

        val liveDataItem  = getTestLiveDataDeliveryItem()
        val item = getTestDeliveryItem()
        whenever(deliveriesLocalCache.getCar(item.id)).thenReturn(liveDataItem)

        val resultItem =  carRepository.getCar(item.id)


        Assert.assertTrue(resultItem == resultItem)

    }


    @Test
    fun onRefresh_call_BoundrycallBack_refresh()
    {
        //void method of mocked object do nothing by default
//        whenever(boundaryCallback.cancelAllJobs()).then { doNothing() }

        carRepository.cancelAllJobs()
        verify(boundaryCallback, times(1)).cancelAllJobs()

    }

    @Test
    fun onCancal_call_BoundrycallBack_Call()
    {
        carRepository.refresh()
        verify(boundaryCallback, times(1)).refresh()

    }

}