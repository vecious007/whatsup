package org.acad.presentation.screens.phone

import org.acad.domain.model.User
import org.acad.domain.usecase.auth.SendSmsCodeUseCase
import org.acad.presentation.base.BaseVM
import org.acad.presentation.screens.phone.PhoneVM.*

/**
 * Created by Acad Bek on 9/13/2023.
 */
class PhoneVM(
    private val sendSmsCodeUseCase: SendSmsCodeUseCase
) : BaseVM<State, Input, Effect>() {
    data class State(
        val user: User? = null
    )
    class Input
    class Effect

    override fun getDefaultState() = State()

    override fun processInput(input: Input) {
        TODO("Not implemented")
    }
}