package com.goodcomp.core.data.repository

import com.goodcomp.core.data.local.source.LocalDataSource
import com.goodcomp.core.domain.repository.StratagemRepository
import javax.inject.Inject

class StratagemRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource
) : StratagemRepository{

    override fun getStratagems() = localDataSource.getAllStratagems()
}