package com.example.rss.di.component

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import com.example.rss.app.RSSApplication
import com.example.rss.di.builder.ActivityBuilder
import com.example.rss.di.module.AppModule
import com.example.rss.di.module.NetworkModule
import com.example.rss.di.module.UtilModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        (AndroidSupportInjectionModule::class),
        (AppModule::class),
        (NetworkModule::class),
        (UtilModule::class),
        (ActivityBuilder::class)]
)
interface AppComponent : AndroidInjector<RSSApplication> {

    @Component.Factory
    abstract class Builder : AndroidInjector.Factory<RSSApplication>{
        interface Factory {
            fun create(@BindsInstance application: Context): AppComponent
        }
    }

}
