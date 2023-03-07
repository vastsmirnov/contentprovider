package com.example.contentprodvider.data.repository

import androidx.activity.result.ActivityResultLauncher
import com.example.contentprodvider.domain.models.contacts.Contact

interface ContactRepository {
    fun getList(requestPermissionLauncher: ActivityResultLauncher<String>): ArrayList<Contact>
}