package com.mad.instagraph

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.mad.instagraph.remote.api.Api
import com.mad.instagraph.repository.*
import com.mad.instagraph.ui.viewmodel.MainViewModel
import com.mad.instagraph.usecase.GetPhotoUseCase
import com.mad.instagraph.usecase.GetStatusUseCase
import com.mad.instagraph.usecase.GetUserDetailsUseCase
import com.mad.instagraph.usecase.GetUserUseCase
import okhttp3.OkHttpClient
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val domainModule = module {

    factory { GetUserUseCase(get()) }
    factory { GetPhotoUseCase(get()) }
    factory { GetStatusUseCase(get()) }
    factory { GetUserDetailsUseCase(get()) }

}

val dataModule = module {

    single<UserRepository> { UserRepositoryImpl() }
    single<PhotoRepository> { PhotoRepositoryImpl() }
    single<StatusRepository> { StatusRepositoryImpl() }

}

val viewModelModule = module {

    viewModel { MainViewModel(get(), get(), get(), get()) }

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

    single { provideService(get(), Api::class.java) }

}

val appModules = listOf(domainModule, dataModule, viewModelModule, netModule, retrofitServiceModule)