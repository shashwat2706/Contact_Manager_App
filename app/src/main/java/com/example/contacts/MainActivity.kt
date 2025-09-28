package com.example.contacts

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contacts.databinding.ActivityMainBinding
import com.example.contacts.repository.ContactRepository
import com.example.contacts.room.Contact
import com.example.contacts.room.ContactDAO
import com.example.contacts.room.ContactDataBase
import com.example.contacts.view.MyRecyclerViewAdapter
import com.example.contacts.viewmodel.ContactViewModel
import com.example.contacts.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {
   private lateinit var binding: ActivityMainBinding
   private lateinit var contactViewModel: ContactViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // ROOM DataBase
        val dao = ContactDataBase.getDatabase(applicationContext).contactDAO
        val repository = ContactRepository(dao)
        val factory = ViewModelFactory(repository)

        //ViewModel
        contactViewModel = ViewModelProvider(this,factory).get(ContactViewModel::class.java)
        binding.contactViewModel = contactViewModel
        binding.lifecycleOwner = this
        initRecyclerView()

    }
    private fun initRecyclerView(){
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        displayContactsList()
    }
    private fun displayContactsList(){
        contactViewModel.contacts.observe(this,{
            binding.recyclerView.adapter = MyRecyclerViewAdapter(it,{selectedItem: Contact ->listItemClicked(selectedItem)})
        })
    }
    /*private fun listItemClicked(contact: Contact){
        contactViewModel.initUpdateAndDelete(contact)
    }*/
    private fun listItemClicked(selectedItem: Contact){
        Toast.makeText(this,"selected name is ${selectedItem.name}", Toast.LENGTH_LONG).show()
        contactViewModel.initUpdateAndDelete(selectedItem)
    }
}