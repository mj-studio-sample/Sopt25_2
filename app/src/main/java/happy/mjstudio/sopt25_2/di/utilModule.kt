package happy.mjstudio.sopt25_2.di

import happy.mjstudio.sopt25_2.common.util.SPUtil
import happy.mjstudio.sopt25_2.common.util.ScreenUtil
import org.koin.dsl.module

/**
 * Created by mj on 18, October, 2019
 */

val utilModule = module {
    single { SPUtil(get()) }
    single { ScreenUtil(get())}
}