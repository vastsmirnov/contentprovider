package com.example.contentprodvider.data.repository

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.ContactsContract
import androidx.activity.result.ActivityResultLauncher
import androidx.core.content.ContextCompat
import com.example.contentprodvider.domain.models.contacts.Contact

class ContactRepositoryImpl(
    private val context: Context
) : ContactRepository {
    override fun getList(requestPermissionLauncher: ActivityResultLauncher<String>): ArrayList<Contact> {
        if (ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.READ_CONTACTS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissionLauncher.launch(Manifest.permission.READ_CONTACTS)
        }

        val contactList = ArrayList<Contact>()
        val uri: Uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI
        val cursor = context.contentResolver.query(uri, null, null, null)

        if (cursor!!.count == 0) {
            return contactList
        }

        while (cursor.moveToNext()) {
            val columnIndex = cursor.getColumnIndex(
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
            )

            val name = cursor.getString(columnIndex)
            contactList.add(Contact(name))
        }

        cursor.close()

        return contactList
    }

}