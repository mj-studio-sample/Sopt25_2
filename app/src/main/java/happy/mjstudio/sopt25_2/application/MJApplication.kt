package happy.mjstudio.sopt25_2.application

import android.app.Application
import happy.mjstudio.sopt25_2.common.util.SPUtil
import happy.mjstudio.sopt25_2.data.UserRepository
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

/**
 * Created by mj on 12, October, 2019
 */

class MJApplication : Application() {


    private val module = module {
        single { SPUtil(get()) }
        single { UserRepository(get()) }
    }

    override fun onCreate() {
        super.onCreate()

        inject()
    }

    private fun inject() {
        startKoin {
            androidContext(this@MJApplication)

            modules(module)
        }
    }
}