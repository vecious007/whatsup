package org.acad.whatsup.di

import org.acad.data.local.user.UserStorage
import org.acad.data.local.user.UserStorageImpl
import org.acad.data.remote.auth.AuthFireBaseImpl
import org.acad.data.remote.auth.AuthFirebase
import org.acad.data.repo.AuthRepoImpl
import org.acad.domain.repo.AuthRepo
import org.acad.domain.usecase.auth.SendSmsCodeUseCase
import org.acad.presentation.screens.phone.PhoneVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Acad Bek on 10/5/2023.
 */

val repoModule = module {
    single<AuthRepo> { AuthRepoImpl(get()) }
}

val useCaseModule = module {
    single { SendSmsCodeUseCase(get()) }
}

val localModule = module {
    single<UserStorage> { UserStorageImpl() }
}

val remoteModule = module {
    single<AuthFirebase> { AuthFireBaseImpl() }
}

val viewModelModule = module {
    viewModel { PhoneVM(get()) }
}