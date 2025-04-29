package com.example.myapplication.common.di.module

import android.content.Context
import com.example.myapplication.BuildConfig
import com.example.myapplication.common.systems.network.SocketManager
import com.example.myapplication.common.systems.notification.NotificationManager
import com.example.myapplication.common.systems.prefs.PrefsService

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SingletonModule {

    @Provides
    @Singleton
    fun provideNotificationManager(): NotificationManager {
        return NotificationManager()
    }

    @Provides
    @Singleton
    fun provideSocketManager(): SocketManager {
        return SocketManager(BuildConfig.SERVER_ADDRESS, BuildConfig.SERVER_PORT)
    }

    @Provides
    @Singleton
    fun providePrefsService(
        @ApplicationContext context: Context
    ): PrefsService {
        return PrefsService(context, BuildConfig.APPLICATION_ID)
    }
}