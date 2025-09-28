package com.example.contacts.repository

import com.example.contacts.room.Contact
import com.example.contacts.room.ContactDAO

class ContactRepository(private val contactDAO: ContactDAO)  {
    val contacts = contactDAO.getAllContacts()
    suspend fun insert(contact: Contact): Long{
      return contactDAO.insert(contact)
    }
    suspend fun update(contact: Contact) {
        contactDAO.update(contact)
    }
    suspend fun delete(contact: Contact) {
        contactDAO.delete(contact)
    }
    suspend fun deleteAll() {
        contactDAO.deleteAll()
    }
}