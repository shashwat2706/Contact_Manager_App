package com.example.contacts.viewmodel

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contacts.repository.ContactRepository
import com.example.contacts.room.Contact
import kotlinx.coroutines.launch

class ContactViewModel(private val repository: ContactRepository) : ViewModel(), Observable {
    val contacts = repository.contacts
    private var isUpdateOrDelete = false
    private lateinit var contactToUpdateOrDelete: Contact

    @Bindable
    val inputName = MutableLiveData<String?>()

    @Bindable
    val inputNumber = MutableLiveData<String?>()

    @Bindable
    val saveOrUpdateButtonText = MutableLiveData<String>()

    @Bindable
    val clearAllOrDeleteButtonText = MutableLiveData<String>()

    init {
        saveOrUpdateButtonText.value = "Save"
        clearAllOrDeleteButtonText.value = "Clear All"
    }

    fun insert(contact: Contact) = viewModelScope.launch {
        repository.insert(contact)
    }
    fun update(contact: Contact) = viewModelScope.launch {
        repository.update(contact)
        inputName.value = null
        inputNumber.value = null
        isUpdateOrDelete = false
        saveOrUpdateButtonText.value = "Save"
        clearAllOrDeleteButtonText.value = "Clear All"
    }
    fun delete(contact: Contact) = viewModelScope.launch {
        repository.delete(contact)

        inputName.value = null
        inputNumber.value = null
        isUpdateOrDelete = false
        saveOrUpdateButtonText.value = "Save"
        clearAllOrDeleteButtonText.value = "Clear All"
    }
    fun clearAll() = viewModelScope.launch {
        repository.deleteAll()
    }
    fun saveorUpdate() {
        if (isUpdateOrDelete) {
            contactToUpdateOrDelete.name = inputName.value!!
            contactToUpdateOrDelete.phoneNumber = inputNumber.value!!
            update(contactToUpdateOrDelete)
        } else {
            val name = inputName.value!!
            val number = inputNumber.value!!
            insert(Contact(0, name, number))
            inputName.value = null
            inputNumber.value = null
        }

    }
    fun clearAllOrDelete() {
        if (isUpdateOrDelete) {
            delete(contactToUpdateOrDelete)
        } else {
            clearAll()
        }
    }
    fun initUpdateAndDelete(contact: Contact) {
        inputName.value = contact.name
        inputNumber.value = contact.phoneNumber
        isUpdateOrDelete = true
        contactToUpdateOrDelete = contact
        saveOrUpdateButtonText.value = "Update"
        clearAllOrDeleteButtonText.value = "Delete"
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }
}