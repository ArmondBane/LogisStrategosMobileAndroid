package com.goodcomp.strategems.list

import com.goodcomp.core.device.base_screen.BaseAppViewModel
import com.goodcomp.core.domain.entity.Stratagem
import com.goodcomp.core.domain.usecase.GetAllStratagemsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StratagemsListViewModel @Inject constructor(
    getAllStratagemsUseCase: GetAllStratagemsUseCase
) : BaseAppViewModel() {

    val stratagemList = getAllStratagemsUseCase()

    fun onStratagemItemClick(stratagem: Stratagem) {
        emitEvent(Event.NavigateToStratagemDetail(stratagem))
    }

    sealed class Event : BaseEvent {
        data class NavigateToStratagemDetail(val stratagem: Stratagem) : Event()
    }
}