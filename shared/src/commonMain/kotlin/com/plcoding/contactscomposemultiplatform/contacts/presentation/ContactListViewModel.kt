package com.plcoding.contactscomposemultiplatform.contacts.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.plcoding.contactscomposemultiplatform.contacts.domain.Contact
import com.plcoding.contactscomposemultiplatform.contacts.domain.ContactDataSource
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

class ContactListViewModel(
    private val contactDataSource: ContactDataSource
) : ViewModel() {
    private val _state = MutableStateFlow(ContactListState())
    val state = combine(
        _state,
        contactDataSource.getContacts(),
        contactDataSource.getRecentContacts()
    ) { state, contacts, recentContacts ->

        state.copy(
            contacts = contacts,
            recentlyAddedContacts = recentContacts
        )

    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), ContactListState())

    var newContact: Contact? by mutableStateOf(null)
        private set

    fun onEvent(event: ContactListEvent) {
        when (event) {
            ContactListEvent.DeleteContact -> TODO()
            ContactListEvent.DismissContact -> TODO()
            is ContactListEvent.EditContact -> TODO()
            ContactListEvent.OnAddNewContactClick -> TODO()
            ContactListEvent.OnAddPhotoClicked -> TODO()
            is ContactListEvent.OnEmailChanged -> TODO()
            is ContactListEvent.OnFirstNameChanged -> TODO()
            is ContactListEvent.OnLastNameChanged -> TODO()
            is ContactListEvent.OnPhoneNumberChanged -> TODO()
            is ContactListEvent.OnPhotoPicked -> TODO()
            ContactListEvent.SaveContact -> TODO()
            is ContactListEvent.SelectContact -> TODO()
        }
    }
}