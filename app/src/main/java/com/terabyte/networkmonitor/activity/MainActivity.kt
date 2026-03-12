package com.terabyte.networkmonitor.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.terabyte.networkmonitor.application.MyApplication
import com.terabyte.networkmonitor.di.component.ActivityComponent
import com.terabyte.networkmonitor.ui.navigation.BottomNavBar
import com.terabyte.networkmonitor.ui.navigation.BottomNavItem
import com.terabyte.networkmonitor.ui.screen.LogsScreen
import com.terabyte.networkmonitor.ui.screen.MonitorStatusScreen
import com.terabyte.networkmonitor.ui.screen.SettingsScreen
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
            val navController = rememberNavController()

            NetworkMonitorTheme {
                Scaffold(
                    bottomBar = {
                        BottomNavBar(navController)
                    },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = BottomNavItem.MonitorStatus.route,
                        modifier = Modifier
                            .padding(innerPadding)
                    ) {
                        composable(BottomNavItem.MonitorStatus.route) {
                            MonitorStatusScreen()
                        }
                        composable(BottomNavItem.Logs.route) {
                            LogsScreen()
                        }
                        composable(BottomNavItem.Settings.route) {
                            SettingsScreen()
                        }
                    }
                }
            }
        }
    }
}