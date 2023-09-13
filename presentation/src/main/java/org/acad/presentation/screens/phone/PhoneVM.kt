package org.acad.presentation.screens.phone

import androidx.lifecycle.ViewModel
import org.acad.domain.usecase.auth.SendSmsCodeUseCase

/**
 * Created by Acad Bek on 9/13/2023.
 */
class PhoneVM constructor(
    private val sendSmsCodeUseCase: SendSmsCodeUseCase
) : ViewModel() {
}