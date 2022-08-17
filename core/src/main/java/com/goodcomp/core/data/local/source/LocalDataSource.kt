package com.goodcomp.core.data.local.source

import com.goodcomp.core.data.local.dao.StratagemDao
import com.goodcomp.core.data.local.mapper.toStratagem
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val stratagemDao: StratagemDao
) {

    fun getAllStratagems() = stratagemDao.getStratagems().map { list ->
        list.map { stratagemEntity ->  stratagemEntity.toStratagem() }
    }
}