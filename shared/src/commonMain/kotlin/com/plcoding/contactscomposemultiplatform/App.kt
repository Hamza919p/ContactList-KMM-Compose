package com.plcoding.contactscomposemultiplatform

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.plcoding.contactscomposemultiplatform.contacts.presentation.ContactListScreen
import com.plcoding.contactscomposemultiplatform.core.presentation.ContactsTheme

@Composable
fun App(
    darkTheme: Boolean,
    dynamicColors: Boolean
) {
    ContactsTheme(
        darkTheme = darkTheme,
        dynamicColors = dynamicColors
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {

            ContactListScreen(

            )

        }
    }
}