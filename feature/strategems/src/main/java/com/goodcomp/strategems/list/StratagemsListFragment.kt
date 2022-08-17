package com.goodcomp.strategems.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.goodcomp.core.device.base_screen.BaseAppFragment
import com.goodcomp.core.device.base_screen.BaseAppViewModel
import com.goodcomp.strategems.R
import com.goodcomp.strategems.databinding.FragmentStratagemsListBinding
import com.goodcomp.strategems.list.adapter.StratagemsListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StratagemsListFragment : BaseAppFragment<StratagemsListViewModel>(
    R.layout.fragment_stratagems_list
) {

    override val viewModel: StratagemsListViewModel by viewModels()

    private val binding: FragmentStratagemsListBinding by viewBinding()

    override fun handleEvent(event: BaseAppViewModel.BaseEvent) {
        when(event) {
            is StratagemsListViewModel.Event.NavigateToStratagemDetail -> {
                findNavController()
                    .navigate(
                        StratagemsListFragmentDirections
                            .actionStratagemsListFragmentToStratagemDetailFragment(event.stratagem)
                    )
            }
            else -> super.handleEvent(event)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initStratagemsList()
    }

    private fun initStratagemsList() {
        val adapter = StratagemsListAdapter(
            onItemClick = { viewModel.onStratagemItemClick(it) }
        ).apply {
            stateRestorationPolicy = RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY
        }
        binding.rvStratagemsList.adapter = adapter
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.stratagemList.collect {
                adapter.submitList(it)
            }
        }
    }
}