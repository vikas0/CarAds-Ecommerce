package com.vikaspandey.carbazar.di
import android.app.Application
import com.vikaspandey.carbazar.App
import com.vikaspandey.carbazar.di.local.DbModule
import com.vikaspandey.carbazar.di.network.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton



@Component (modules = [ AndroidSupportInjectionModule::class, NetworkModule::class,
    DbModule::class,
    MainActivityModule::class, AppModule::class])
@Singleton
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }
}