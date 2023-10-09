package org.acad.presentation.screens.onboarding

import com.github.terrakok.cicerone.Router
import org.acad.domain.usecase.settings.OnBoardedUseCase
import org.acad.presentation.base.BaseVM
import org.acad.presentation.navigation.Screens.phoneScreen
import org.acad.presentation.screens.onboarding.OnboardingVM.Effect
import org.acad.presentation.screens.onboarding.OnboardingVM.Input
import org.acad.presentation.screens.onboarding.OnboardingVM.Input.Onboarded
import org.acad.presentation.screens.onboarding.OnboardingVM.State

/**
 * Created by Acad Bek on 10/9/2023.
 */
class OnboardingVM(
    private val onBoardedUseCase: OnBoardedUseCase,
    private val router: Router
) : BaseVM<State, Input, Effect>() {
    class State
    sealed class Input {
        data object Onboarded : Input()
    }

    class Effect

    override fun getDefaultState() = State()

    override fun processInput(input: Input) {
        when (input) {
            Onboarded -> onboarded()
        }
    }

    private fun onboarded() {
        onBoardedUseCase().subscribe {
            router.replaceScreen(phoneScreen())
        }
    }
}