package com.example.contacts.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts_table")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var name: String,
    var phoneNumber: String
)
