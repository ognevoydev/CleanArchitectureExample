package com.example.cleanarchitecture.di

import com.example.cleanarchitecture.presentation.activities.MainActivity
import dagger.Component

@Component(modules = [AppModule::class, DomainModule::class, DataModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
}