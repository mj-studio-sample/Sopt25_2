package happy.mjstudio.sopt25_2.di

import happy.mjstudio.sopt25_2.presentation.profile.ProfileViewModel
import happy.mjstudio.sopt25_2.presentation.repo.RepoViewModel
import happy.mjstudio.sopt25_2.presentation.signin.SignInViewModel
import happy.mjstudio.sopt25_2.presentation.signup.SignUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by mj on 18, October, 2019
 */

val viewModelModule = module {
    viewModel { SignInViewModel(get()) }
    viewModel { SignUpViewModel(get()) }
    viewModel { ProfileViewModel(get()) }
    viewModel { RepoViewModel() }
}