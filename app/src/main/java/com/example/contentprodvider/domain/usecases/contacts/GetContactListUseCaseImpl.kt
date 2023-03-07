package com.example.contentprodvider.domain.usecases.contacts

import androidx.activity.result.ActivityResultLauncher
import com.example.contentprodvider.data.repository.ContactRepository
import com.example.contentprodvider.domain.models.contacts.Contact

class GetContactListUseCaseImpl(
    private val contactRepository: ContactRepository
) : GetContactListUseCase {
    override fun execute(requestPermissionLauncher: ActivityResultLauncher<String>): ArrayList<Contact> {
        return contactRepository.getList(requestPermissionLauncher)
    }
}