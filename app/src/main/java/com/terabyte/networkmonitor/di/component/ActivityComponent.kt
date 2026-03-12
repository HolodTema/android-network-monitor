package com.terabyte.networkmonitor.di.component

import com.terabyte.networkmonitor.activity.MainActivity
import com.terabyte.networkmonitor.di.module.ActivityModule
import com.terabyte.networkmonitor.di.scope.ActivityScope
import dagger.Subcomponent

@Subcomponent(
    modules = [
        ActivityModule::class
    ]
)
@ActivityScope
interface ActivityComponent {

    fun inject(activity: MainActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): ActivityComponent
    }
}