package org.acad.presentation.screens.onboarding

import android.os.Bundle
import android.view.View
import org.acad.presentation.base.BaseFragment
import org.acad.presentation.databinding.FragmentOnboardingBinding
import org.acad.presentation.screens.onboarding.OnboardingVM.Input
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by Acad Bek on 10/9/2023.
 */
class OnboardingFragment :
    BaseFragment<FragmentOnboardingBinding>(FragmentOnboardingBinding::inflate) {

    private val viewModel: OnboardingVM by viewModel()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
    }

    private fun initUI() = with(binding) {
        next.setOnClickListener {
            viewModel.processInput(Input.Onboarded)
        }
    }
}