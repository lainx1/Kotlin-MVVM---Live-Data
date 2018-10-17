package com.example.eheca.kotlinmvvm_livedata.uitilities

import com.example.eheca.kotlinmvvm_livedata.data.FakeDatabase
import com.example.eheca.kotlinmvvm_livedata.data.QuoteRepository
import com.example.eheca.kotlinmvvm_livedata.ui.quotes.QuotesViewModelFactory

object InjectorUtilities {
    fun privideQuotesViewModelFactory(): QuotesViewModelFactory{
        val quotesRepository = QuoteRepository.get_Instance(FakeDatabase.get_Instance().quoteDao)
        return QuotesViewModelFactory(quotesRepository)
    }
}