package com.example.contentprodvider.ui.contacts

import androidx.activity.result.ActivityResultLauncher
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.contentprodvider.domain.models.contacts.Contact
import com.example.contentprodvider.domain.usecases.contacts.GetContactListUseCase

class ContactListViewModel(
    private val getContactListUseCase: GetContactListUseCase
) : ViewModel() {
    private val _contactListLiveData = MutableLiveData<List<Contact>>()
    val contactListLiveData = _contactListLiveData as LiveData<List<Contact>>

    fun load(requestPermissionLauncher: ActivityResultLauncher<String>) {
        _contactListLiveData.value = getContactListUseCase.execute(requestPermissionLauncher)
    }
}