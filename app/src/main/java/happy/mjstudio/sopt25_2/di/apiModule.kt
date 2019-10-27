package happy.mjstudio.sopt25_2.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import happy.mjstudio.sopt25_2.data.api.GithubAPI
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by mj on 18, October, 2019
 */
val apiModule = module {

    single {
        GsonBuilder()
            .create()
    } bind Gson::class

    single {
        HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }
    } bind Interceptor::class

    single {
        OkHttpClient.Builder()
            .addInterceptor(get<Interceptor>())
            .callTimeout(10_000L,TimeUnit.SECONDS)
            .build()
    } bind OkHttpClient::class



    single {
        Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single {get<Retrofit>().create(GithubAPI::class.java)}
}