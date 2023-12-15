package com.seregaklim.error

import android.database.SQLException
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton


sealed class AppError  (var code: String) : RuntimeException () {
    companion object {
        fun from(e: Throwable): AppError = when (e) {
            is AppError -> e
            is SQLException -> DbError
            is IOException -> NetworkError
            else -> UnknownError
        }
    }
}

class ApiError (val status: Int, code: String) : AppError(code)
object NetworkError : AppError("error_network")
object DbError : AppError("error_db")
object UnknownError : AppError("error_unknown")




