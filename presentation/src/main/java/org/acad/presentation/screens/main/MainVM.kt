package org.acad.presentation.screens.main

import com.github.terrakok.cicerone.Router
import org.acad.presentation.base.BaseVM
import org.acad.presentation.navigation.Screens.phone
import org.acad.presentation.screens.main.MainVM.*

/**
 * Created by Acad Bek on 10/5/2023.
 */
class MainVM(
    private val router: Router
) : BaseVM<State, Input, Effect>() {
    class State
    class Input
    class Effect
    init {
        router.newRootScreen(phone())
    }
    override fun getDefaultState() = State()
    override fun processInput(input: Input) {  }
}