package happy.mjstudio.sopt25_2.di

import happy.mjstudio.sopt25_2.data.repository.GithubRepositoryImpl
import happy.mjstudio.sopt25_2.data.repository.UserRepositoryImpl
import happy.mjstudio.sopt25_2.domain.repository.GithubRepository
import happy.mjstudio.sopt25_2.domain.repository.UserRepository
import org.koin.dsl.bind
import org.koin.dsl.module

/**
 * Created by mj on 18, October, 2019
 */

val repositoryModule = module {
    single { UserRepositoryImpl(get()) } bind UserRepository::class
    single { GithubRepositoryImpl(get()) } bind GithubRepository::class
}
