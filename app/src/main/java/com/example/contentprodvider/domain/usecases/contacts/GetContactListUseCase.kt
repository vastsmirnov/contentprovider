package com.example.contentprodvider.domain.usecases.contacts

import androidx.activity.result.ActivityResultLauncher
import com.example.contentprodvider.domain.models.contacts.Contact

interface GetContactListUseCase {
    fun execute(requestPermissionLauncher: ActivityResultLauncher<String>): ArrayList<Contact>
}