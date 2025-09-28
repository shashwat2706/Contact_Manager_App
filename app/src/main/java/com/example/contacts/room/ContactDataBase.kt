package com.example.contacts.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Contact::class], version = 1, exportSchema = false)
abstract class ContactDataBase : RoomDatabase() {
    abstract val contactDAO: ContactDAO

    companion object{
        @Volatile
        private var INSTANCE: ContactDataBase? = null

        fun getDatabase(context: Context): ContactDataBase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ContactDataBase::class.java,
                        "contacts_database"
                    ).build()
                }
                INSTANCE = instance
                return instance
            }
        }
    }
}