package com.example.contentprodvider.ui.contacts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contentprodvider.R
import com.example.contentprodvider.databinding.ContactListItemBinding
import com.example.contentprodvider.domain.models.contacts.Contact

class ContactListAdapter : RecyclerView.Adapter<ContactListAdapter.ContactListHolder>() {
    private val contactList = ArrayList<Contact>()

    class ContactListHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = ContactListItemBinding.bind(item)

        fun bind(position: Int, contact: Contact) {
            binding.apply {
                contactNumber.text = position.inc().toString() + "."
                contactName.text = contact.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactListHolder {
        val view =LayoutInflater.from(parent.context)
            .inflate(R.layout.contact_list_item, parent, false)

        return ContactListHolder(view)
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    override fun onBindViewHolder(holder: ContactListHolder, position: Int) {
        val contact = contactList[position]
        holder.bind(position, contact)
    }

    fun loadData(contacts: List<Contact>) {
        contactList.addAll(contacts)
    }
}