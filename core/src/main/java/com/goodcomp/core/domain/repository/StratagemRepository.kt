package com.goodcomp.core.domain.repository

import com.goodcomp.core.domain.entity.Stratagem
import kotlinx.coroutines.flow.Flow

interface StratagemRepository {

    fun getStratagems(): Flow<List<Stratagem>>
}