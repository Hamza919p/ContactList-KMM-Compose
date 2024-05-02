package com.plcoding.contactscomposemultiplatform

import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIScreen
import platform.UIKit.UIUserInterfaceStyle

//THIS will work as a bridge between iOS and Compose
fun MainViewController() = ComposeUIViewController {
    val isDark = UIScreen.mainScreen.traitCollection.userInterfaceStyle ==
            UIUserInterfaceStyle.UIUserInterfaceStyleDark

    App(
        darkTheme = isDark,
        dynamicColors = false
    )
}