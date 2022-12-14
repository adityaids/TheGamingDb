package com.aditya.thegamingdb.ui.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.aditya.thegamingdb.util.Screen

data class NavigationItem(
    val title: String,
    val icon: ImageVector,
    val screen: Screen
)