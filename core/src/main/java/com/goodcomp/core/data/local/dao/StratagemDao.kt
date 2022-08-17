package com.goodcomp.core.data.local.dao

import androidx.room.*
import com.goodcomp.core.data.local.entity.StratagemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface StratagemDao {

    @Query("SELECT * FROM ${StratagemEntity.TABLE_NAME}")
    fun getStratagems(): Flow<List<StratagemEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStratagems(stratagemEntity: StratagemEntity)

    @Update
    suspend fun updateStratagems(stratagemEntity: StratagemEntity)

    @Delete
    suspend fun deleteStratagems(stratagemEntity: StratagemEntity)
}