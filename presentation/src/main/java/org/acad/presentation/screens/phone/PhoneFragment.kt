package org.acad.presentation.screens.phone

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import org.acad.domain.model.User
import org.acad.presentation.base.BaseFragment
import org.acad.presentation.databinding.FragmentPhoneBinding
import org.acad.presentation.screens.phone.PhoneVM.*

/**
 * Created by Acad Bek on 9/13/2023.
 */
class PhoneFragment : BaseFragment<FragmentPhoneBinding>(FragmentPhoneBinding::inflate) {

    private lateinit var viewModel : PhoneVM
    @SuppressLint("CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.state.observe(::renderUser) { it.user!! }
        viewModel.effects.doOnNext(::handleEffects)
    }

    private fun renderUser(user: User?) {  }

    private fun handleEffects(effect: Effect) {  }
}