package com.goodcomp.main

import com.goodcomp.core.device.base_screen.BaseAppViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(

) : BaseAppViewModel() {

    fun onToStratagemButtonClick() {
        emitEvent(Event.NavigateToStratagemsScreen)
    }

    sealed class Event : BaseEvent{
        object NavigateToStratagemsScreen : Event()
    }
}