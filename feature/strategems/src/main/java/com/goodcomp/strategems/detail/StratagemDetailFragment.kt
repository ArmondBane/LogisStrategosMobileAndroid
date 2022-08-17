package com.goodcomp.strategems.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.goodcomp.core.device.base_screen.BaseAppFragment
import com.goodcomp.strategems.R
import com.goodcomp.strategems.databinding.FragmentStratagemDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StratagemDetailFragment : BaseAppFragment<StratagemDetailViewModel>(
    R.layout.fragment_stratagem_detail
) {

    override val viewModel: StratagemDetailViewModel by viewModels()

    private val binding: FragmentStratagemDetailBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initStratagem()
    }

    private fun initStratagem() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.stratagem.collect {
                if (it == null) {
                    findNavController().popBackStack()
                    return@collect
                }
                binding.ivPicture.setImageResource(it.picture)
                binding.tvName.text = it.name
                binding.tvFaction.text = it.faction
                binding.tvStyle.text = it.style
                binding.tvCost.text = it.cost
                binding.tvDescription.text = it.description
                binding.tvEffect.text = it.effect
            }
        }
    }
}