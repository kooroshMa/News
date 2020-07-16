package com.example.rss.di.module

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.*
import com.example.rss.BuildConfig
import com.example.rss.data.di.Cloud
import com.example.rss.data.di.Mock
import com.example.rss.data.restful.APIs
import com.example.rss.data.source.cloud.BaseCloudRepository
import com.example.rss.data.source.cloud.CloudMockRepository
import com.example.rss.data.source.cloud.CloudRepository
import com.example.rss.util.SecretFields
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
object NetworkModule {


    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder()
            .registerTypeAdapter(
                Date::class.java,
                JsonDeserializer { json, typeOfT, context -> Date(json.asJsonPrimitive.asLong) })
            .registerTypeAdapter(
                Date::class.java,
                JsonSerializer<Date> { src, typeOfSrc, context -> JsonPrimitive(src.time) })
            .create()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(loggingInterceptor)
            builder.addNetworkInterceptor(StethoInterceptor())
        }
        builder.connectTimeout(20L, TimeUnit.SECONDS)
        builder.readTimeout(20L, TimeUnit.SECONDS)
        builder.writeTimeout(20L, TimeUnit.SECONDS)
        return builder.build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder().client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(SecretFields().getBaseURI())
            .build()
    }

    @Singleton
    @Provides
    fun provideService(retrofit: Retrofit): APIs {
        return retrofit.create(APIs::class.java)
    }

    @Cloud
    @Provides
    fun provideCloudRepository(apIs: APIs): BaseCloudRepository {
        return CloudRepository(apIs)
    }

    @Mock
    @Provides
    fun provideCloudMockRepository(apIs: APIs, gson: Gson): BaseCloudRepository {
        return if (BuildConfig.DEBUG)
            CloudMockRepository(gson)
        else
            CloudRepository(apIs)
    }
}
