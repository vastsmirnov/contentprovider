package com.example.contentprodvider.ui.contacts

import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contentprodvider.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val contactListViewModel by viewModel<ContactListViewModel>()

    val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean -> onRequestPermissionResult(isGranted) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ContactListAdapter()
        contactListViewModel.contactListLiveData.observe(this) {
            adapter.loadData(it)
        }

        contactListViewModel.load(requestPermissionLauncher)

        binding.apply {
            contactsRv.layoutManager = LinearLayoutManager(this@MainActivity)
            contactsRv.adapter = adapter
        }

    }

    private fun onRequestPermissionResult(isGranted: Boolean) {
        if (!isGranted) {
            Toast.makeText(this, "Permission not granted", Toast.LENGTH_LONG)
                .show()
        }
    }
}