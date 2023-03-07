package com.example.contentprodvider.di

import com.example.contentprodvider.domain.usecases.contacts.GetContactListUseCase
import com.example.contentprodvider.domain.usecases.contacts.GetContactListUseCaseImpl
import org.koin.dsl.module

val domainModule = module {
    single<GetContactListUseCase> {
        GetContactListUseCaseImpl(
            contactRepository = get()
        )
    }
}