package com.mad.instagraph

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.mad.instagraph.remote.api.InstagramApi
import com.mad.instagraph.ui.viewmodel.MainViewModel
import okhttp3.OkHttpClient
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val viewModelModule = module {

    viewModel { MainViewModel() }

}

val netModule = module {

    fun provideGson(): Gson {
        return GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create()
    }

    fun provideRetrofit(factory: Gson, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("")
            .addConverterFactory(GsonConverterFactory.create(factory))
            .client(client)
            .build()
    }

    single { provideGson() }
    single { provideRetrofit(get(), get()) }

}

val retrofitServiceModule = module {

    fun <T> provideService(retrofit: Retrofit, service: Class<T>): T {
        return retrofit.create(service)
    }

    single { provideService(get(), InstagramApi::class.java) }

}

val appModules = listOf(viewModelModule, retrofitServiceModule)