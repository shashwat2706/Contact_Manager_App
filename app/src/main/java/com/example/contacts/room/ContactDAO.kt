package com.example.contacts.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ContactDAO {
    @Insert
    suspend fun insert(contact: Contact) :  Long
    @Update
    suspend fun update(contact: Contact)
    @Delete
    suspend fun delete(contact: Contact)
    @Query("SELECT * FROM contacts_table")
    fun getAllContacts(): LiveData<List<Contact>>
    @Query("DELETE FROM contacts_table")
    suspend fun deleteAll()
}