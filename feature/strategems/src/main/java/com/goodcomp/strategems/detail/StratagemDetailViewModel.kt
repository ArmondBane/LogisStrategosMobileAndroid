package com.goodcomp.strategems.detail

import androidx.lifecycle.SavedStateHandle
import com.goodcomp.core.device.base_screen.BaseAppViewModel
import com.goodcomp.core.domain.entity.Stratagem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class StratagemDetailViewModel @Inject constructor(
    stateHandle: SavedStateHandle
) : BaseAppViewModel() {

    val stratagem = stateHandle.getStateFlow<Stratagem?>("stratagem", null)
}