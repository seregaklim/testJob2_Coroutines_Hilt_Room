package com.seregaklim.test_job2.db

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.seregaklim.dao.ResponsePDao
import com.seregaklim.db.MainDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object MainDbModel {
    @Provides
    @Singleton
    fun provideDb(@ApplicationContext context: Context): MainDb {
        return Room.databaseBuilder(context, MainDb::class.java, "app.db")
            .fallbackToDestructiveMigration()
            .build()
    }


}
