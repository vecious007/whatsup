package org.acad.whatsup.di

import com.github.terrakok.cicerone.Cicerone
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import org.acad.data.local.settings.SettingsRealm
import org.acad.data.local.settings.SettingsStorage
import org.acad.data.local.settings.SettingsStorageImpl
import org.acad.data.local.user.UserStorage
import org.acad.data.local.user.UserStorageImpl
import org.acad.data.remote.auth.AuthFireBaseImpl
import org.acad.data.remote.auth.AuthFirebase
import org.acad.data.repo.AuthRepoImpl
import org.acad.data.repo.SettingsRepoImpl
import org.acad.domain.repo.AuthRepo
import org.acad.domain.repo.SettingsRepo
import org.acad.domain.usecase.auth.SendSmsCodeUseCase
import org.acad.domain.usecase.auth.VerifyCodeUseCase
import org.acad.domain.usecase.settings.GetOnBoardedUseCase
import org.acad.domain.usecase.settings.OnBoardedUseCase
import org.acad.presentation.screens.main.MainVM
import org.acad.presentation.screens.onboarding.OnboardingVM
import org.acad.presentation.screens.phone.PhoneVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Acad Bek on 10/5/2023.
 */

private val cicerone = Cicerone.create()

val config = RealmConfiguration.create(schema = setOf(SettingsRealm::class))

val appModule = module {
    single { cicerone.router }
    single { cicerone.getNavigatorHolder() }
    single { Realm.open(config) }
}

val repoModule = module {
    single<AuthRepo> { AuthRepoImpl(get()) }
    single<SettingsRepo> { SettingsRepoImpl(get()) }
}

val useCaseModule = module {
    single { SendSmsCodeUseCase(get()) }
    single { OnBoardedUseCase(get()) }
    single { GetOnBoardedUseCase(get()) }
    single { VerifyCodeUseCase(get()) }
}

val localModule = module {
    single<UserStorage> { UserStorageImpl() }
    single<SettingsStorage> { SettingsStorageImpl(get()) }
}

val remoteModule = module {
    single<AuthFirebase> { AuthFireBaseImpl() }
}

val viewModelModule = module {
    viewModel { PhoneVM(get()) }
    viewModel { MainVM(get(), get()) }
    viewModel { OnboardingVM(get(), get()) }
}