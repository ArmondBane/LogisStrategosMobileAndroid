package com.goodcomp.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.goodcomp.core.device.base_screen.BaseAppFragment
import com.goodcomp.core.device.base_screen.BaseAppViewModel
import com.goodcomp.main.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseAppFragment<MainViewModel>(
    R.layout.fragment_main
) {

    override val viewModel: MainViewModel by viewModels()

    private val binding: FragmentMainBinding by viewBinding()

    override fun handleEvent(event: BaseAppViewModel.BaseEvent) {
        when(event) {
            is MainViewModel.Event.NavigateToStratagemsScreen ->
                findNavController()
                    .navigate(
                        MainFragmentDirections.actionMainFragmentToStratagemsNavGraph()
                    )
            else -> super.handleEvent(event)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvToStrategemsButton.setOnClickListener {
            viewModel.onToStratagemButtonClick()
        }
    }
}