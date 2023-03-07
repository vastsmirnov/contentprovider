package com.example.contentprodvider.di

import com.example.contentprodvider.data.repository.ContactRepository
import com.example.contentprodvider.data.repository.ContactRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single <ContactRepository> {
        ContactRepositoryImpl(
            context = androidContext(),
        )
    }
}