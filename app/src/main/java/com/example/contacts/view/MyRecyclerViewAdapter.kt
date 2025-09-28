package com.example.contacts.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.R
import com.example.contacts.databinding.CardItemBinding
import com.example.contacts.room.Contact

class MyRecyclerViewAdapter(private val contactsList: List<Contact>, private val clickListener: (Contact) -> Unit) : RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : CardItemBinding = DataBindingUtil.inflate(layoutInflater,
            R.layout.card_item,parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        holder.bind(contactsList[position],clickListener)
    }

    override fun getItemCount(): Int {
        return contactsList.size
    }

    class MyViewHolder(val binding: CardItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(contact: Contact, clickListener: (Contact) -> Unit) {
            binding.contactName.text = contact.name
            binding.contactNumber.text = contact.phoneNumber
            binding.listItemLayout.setOnClickListener {
                clickListener(contact)
            }
        }
    }
}