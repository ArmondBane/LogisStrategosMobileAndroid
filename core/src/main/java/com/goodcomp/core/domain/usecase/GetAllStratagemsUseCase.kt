package com.goodcomp.core.domain.usecase

import com.goodcomp.core.domain.repository.StratagemRepository
import javax.inject.Inject

class GetAllStratagemsUseCase @Inject constructor(
    private val stratagemRepository: StratagemRepository
) {
    operator fun invoke() = stratagemRepository.getStratagems()
}