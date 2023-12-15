package com.seregaklim.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.seregaklim.entity.ResponsePEntity

@Dao
interface ResponsePDao {
    //записываем
    @Insert
    suspend fun insert(responsePEntity: ResponsePEntity)
    //берем все
    @Query("SELECT * FROM response")
    fun getAll(): LiveData<List<ResponsePEntity>>
    @Delete
    suspend fun delete(responsePEntity: ResponsePEntity)
}