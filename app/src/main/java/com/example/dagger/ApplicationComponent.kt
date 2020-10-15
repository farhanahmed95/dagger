package com.example.dagger

import com.google.gson.Gson
import dagger.Component
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class CoreModule
{
    @Singleton
    @Provides
    fun gson() = Gson()

    @Singleton
    @Provides
    fun okhttp(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }
}

@Module
class ApiModule(private val baseUrl: String)
{
    @Singleton
    @Provides
    fun retrofit(okHttpClient: OkHttpClient) : Retrofit
    {
        return Retrofit.Builder().baseUrl(baseUrl).build()
    }
}

@Singleton
@Component(modules = [CoreModule::class,ApiModule::class])
interface ApplicationComponent
{ fun inject(mainActivity: MainActivity)
}