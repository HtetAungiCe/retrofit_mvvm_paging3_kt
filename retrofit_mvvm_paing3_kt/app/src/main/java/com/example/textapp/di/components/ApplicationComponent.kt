package com.example.textapp.di.components

import android.app.Activity
import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import com.example.textapp.activities.MainActivity
import com.example.textapp.di.modules.NetworkModule
import dagger.Component
import javax.inject.Singleton


@Component(modules = [NetworkModule::class])
interface ApplicationComponent {
    fun inject(activity:MainActivity)
}

 class MyApplication:Application(){
    val appComponent = DaggerApplicationComponent.create()
}





