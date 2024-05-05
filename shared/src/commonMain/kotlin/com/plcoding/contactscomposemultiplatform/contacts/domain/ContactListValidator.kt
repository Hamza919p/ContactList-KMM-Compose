package com.plcoding.contactscomposemultiplatform.contacts.domain

object ContactListValidator {

    fun validate(contact: Contact) : ValidationResult {
        var result = ValidationResult()

        if(contact.firstName.isBlank()) {
            result = result.copy(firstNameError = "First name cannot be blank")
        }
        if(contact.lastName.isBlank()) {
            result = result.copy(lastNameError = "Last name cannot be blank")
        }
        if(contact.email.isBlank()) {
            result = result.copy(emailError = "Email cannot be blank")
        }
        if(contact.phoneNumber.isBlank()) {
            result = result.copy(phoneNumberError = "Phone Number cannot be blank")
        }
        return result

    }

    data class ValidationResult (
        val firstNameError: String ?= null,
        val lastNameError: String ?= null,
        val phoneNumberError: String ?= null,
        val emailError: String ?= null
    )

}