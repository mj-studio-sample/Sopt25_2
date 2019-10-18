package happy.mjstudio.sopt25_2.application

import android.app.Application
import happy.mjstudio.sopt25_2.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

/**
 * Created by mj on 12, October, 2019
 */

class MJApplication : Application() {



    override fun onCreate() {
        super.onCreate()

        inject()
    }

    private fun inject() {
        startKoin {

            androidLogger(Level.DEBUG)

            androidContext(this@MJApplication)

            modules(listOf(
                appModule,
                apiModule,
                repositoryModule,
                utilModule,
                viewModelModule
            ))
        }
    }
}