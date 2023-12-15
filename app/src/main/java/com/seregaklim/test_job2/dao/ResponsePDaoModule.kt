package com.seregaklim.test_job2.dao

import com.seregaklim.dao.ResponsePDao
import com.seregaklim.db.MainDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
object ResponsePDaoModule {
    @Provides
    fun provideResponsePDao(db: MainDb): ResponsePDao = db.postResponsePDao()
}