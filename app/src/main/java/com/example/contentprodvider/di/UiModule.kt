package com.example.contentprodvider.di

import com.example.contentprodvider.ui.contacts.ContactListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel {
        ContactListViewModel(
            getContactListUseCase = get()
        )
    }
}