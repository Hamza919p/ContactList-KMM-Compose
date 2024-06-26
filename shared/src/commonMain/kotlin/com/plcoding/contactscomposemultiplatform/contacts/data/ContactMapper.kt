package com.plcoding.contactscomposemultiplatform.contacts.data

import com.plcoding.contactscomposemultiplatform.contacts.domain.Contact
import database.ContactEntity

fun ContactEntity.toContacts() : Contact {
    return Contact(
        id = id,
        firstName = firstName,
        lastName = lastName,
        email = email,
        phoneNumber = phoneNumber,
        photoBytes = null
    )
}