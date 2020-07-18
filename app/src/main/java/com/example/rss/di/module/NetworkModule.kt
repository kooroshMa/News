package com.example.rss.di.module

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.*
import com.example.rss.BuildConfig
import com.example.rss.data.di.Cloud
import com.example.rss.data.di.JsonFeedQualifier
import com.example.rss.data.di.Mock
import com.example.rss.data.di.XmlFeedQualifier
import com.example.rss.data.restful.APIs
import com.example.rss.data.restful.JsonApis
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
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
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

    @XmlFeedQualifier
    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder().client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(SecretFields().getBaseURI())
            .build()
    }

    @JsonFeedQualifier
    @Singleton
    @Provides
    fun provideRetrofitJsonFeed(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder().client(okHttpClient)
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(SecretFields().getJsonBaseURI())
            .build()
    }

    @Singleton
    @Provides
    fun provideService(@XmlFeedQualifier retrofit: Retrofit): APIs {
        return retrofit.create(APIs::class.java)
    }
    @Singleton
    @Provides
    fun provideJsonFeedService(@JsonFeedQualifier retrofit: Retrofit): JsonApis {
        return retrofit.create(JsonApis::class.java)
    }

    @Cloud
    @Provides
    fun provideCloudRepository(apIs: APIs, jsonApis: JsonApis): BaseCloudRepository {
        return CloudRepository(apIs,jsonApis)
    }

    @Mock
    @Provides
    fun provideCloudMockRepository(apIs: APIs, jsonApis: JsonApis, gson: Gson): BaseCloudRepository {
        return if (BuildConfig.DEBUG)
            CloudMockRepository(gson)
        else
            CloudRepository(apIs,jsonApis)
    }
}
