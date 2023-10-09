package org.acad.presentation.screens.main

import android.annotation.SuppressLint
import com.github.terrakok.cicerone.Router
import org.acad.domain.usecase.settings.GetOnBoardedUseCase
import org.acad.presentation.base.BaseVM
import org.acad.presentation.navigation.Screens.onBoardingScreen
import org.acad.presentation.navigation.Screens.phoneScreen
import org.acad.presentation.screens.main.MainVM.*

/**
 * Created by Acad Bek on 10/5/2023.
 */
class MainVM(
    private val getOnBoardedUseCase: GetOnBoardedUseCase,
    private val router: Router
) : BaseVM<State, Input, Effect>() {
    class State
    class Input
    class Effect
    init {
        getOnboarded()
    }

    @SuppressLint("CheckResult")
    private fun getOnboarded() {
        getOnBoardedUseCase().subscribe { onboarded ->
            router.newRootScreen(
                if (onboarded) phoneScreen() else onBoardingScreen()
            )
        }
    }

    override fun getDefaultState() = State()
    override fun processInput(input: Input) {  }
}