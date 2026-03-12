package com.terabyte.networkmonitor.ui.navigation

import androidx.annotation.DrawableRes
import com.terabyte.networkmonitor.R

sealed class BottomNavItem(
    val route: String,
    val title: String,
    @DrawableRes val icon: Int,
    @DrawableRes val iconFilled: Int
) {
    data object MonitorStatus : BottomNavItem(
        route = "monitorStatus",
        title = "Status",
        icon = R.drawable.ic_monitor_status,
        iconFilled = R.drawable.ic_monitor_status_filled
    )

    data object Logs : BottomNavItem(
        route = "logs",
        title = "Logs",
        icon = R.drawable.ic_logs,
        iconFilled = R.drawable.ic_logs_filled
    )

    data object Settings : BottomNavItem(
        route = "settings",
        title = "Settings",
        icon = R.drawable.ic_settings,
        iconFilled = R.drawable.ic_settings_filled
    )
}

val bottomNavItems = listOf(
    BottomNavItem.MonitorStatus,
    BottomNavItem.Logs,
    BottomNavItem.Settings
)