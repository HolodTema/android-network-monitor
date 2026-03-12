package com.terabyte.networkmonitor.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.terabyte.networkmonitor.application.MyApplication
import com.terabyte.networkmonitor.di.component.ActivityComponent
import com.terabyte.networkmonitor.ui.theme.NetworkMonitorTheme
import com.terabyte.networkmonitor.viewmodel.MainViewModel
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    lateinit var activityComponent: ActivityComponent

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[MainViewModel::class]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        activityComponent = (application as MyApplication)
            .appComponent
            .activityComponentFactory()
            .create()
        activityComponent.inject(this)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NetworkMonitorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                }
            }
        }
    }
}