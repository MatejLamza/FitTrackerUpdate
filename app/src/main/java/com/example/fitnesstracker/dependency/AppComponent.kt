package com.example.fitnesstracker.dependency

import com.example.fitnesstracker.base.BaseApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class,AppModule::class,BuilderModule::class])
interface AppComponent {
    @Component.Builder
    interface AppComponentBuilder{
        @BindsInstance
        fun setApplication(app:BaseApp):AppComponentBuilder
        fun build():AppComponent
    }
    fun inject(app:BaseApp)
}