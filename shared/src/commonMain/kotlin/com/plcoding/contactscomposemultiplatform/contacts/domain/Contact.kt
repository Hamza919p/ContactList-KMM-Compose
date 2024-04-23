package com.plcoding.contactscomposemultiplatform.contacts.domain

data class Contact(
    val id: Long?,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phoneNumber: String,
    val photoBytes: ByteArray? //to save images in KMM because bitmap is used for android only
)