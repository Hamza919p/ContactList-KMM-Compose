package com.plcoding.contactscomposemultiplatform

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.plcoding.contactscomposemultiplatform.contacts.presentation.ContactListScreen
import com.plcoding.contactscomposemultiplatform.contacts.presentation.ContactListViewModel
import com.plcoding.contactscomposemultiplatform.core.presentation.ContactsTheme
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory

@Composable
fun App(
    darkTheme: Boolean,
    dynamicColors: Boolean
) {

    val viewmodel = getViewModel(
        "contact-list-screen",
        factory = viewModelFactory {
            ContactListViewModel()
        }
    )




    val state by viewmodel.state.collectAsState()



    ContactsTheme(
        darkTheme = darkTheme,
        dynamicColors = dynamicColors
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {

            ContactListScreen(
                state = state,
                newContact = viewmodel.newContact,
                onEvent = viewmodel::onEvent
            )

        }
    }
}