package com.plcoding.contactscomposemultiplatform.contacts.data

import com.plcoding.contactscomposemultiplatform.contacts.domain.Contact
import com.plcoding.contactscomposemultiplatform.contacts.domain.ContactDataSource
import com.plcoding.contactscomposemultiplatform.database.ContactDatabase
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.datetime.Clock

class SqlDelightContactDataSource(
    db: ContactDatabase
) : ContactDataSource {

    val query = db.contactQueries

    override fun getContacts(): Flow<List<Contact>> {
        return query.getContacts()
            .asFlow()
            .mapToList()
            .map {
            it.map { contactEntity ->
                contactEntity.toContacts()
            }
        }
    }

    override fun getRecentContacts(): Flow<List<Contact>> {
        return query.getRecentContacts().asFlow().mapToList().map {
            it.map {  contactEntity ->
                contactEntity.toContacts()
            }
        }
    }

    override suspend fun insertContact(contact: Contact) {
        query.insertContactEntity(
            id = contact.id,
            firstName = contact.firstName,
            lastName = contact.lastName,
            email = contact.email,
            phoneNumber = contact.phoneNumber,
            createdAt = Clock.System.now().toEpochMilliseconds(),
            imagePath = null
        )
    }

    override suspend fun deleteContact(id: Long) {
        query.deleteContact(id)
    }
}