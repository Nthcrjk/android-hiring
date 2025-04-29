package com.example.myapplication.common.di.module

import com.example.myapplication.ui.compose.home.HomeInteractor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class ViewModelModule {

    @Provides
    @ViewModelScoped
    fun provideAuthByPhoneInteractor(): HomeInteractor {
        return HomeInteractor()
    }
}