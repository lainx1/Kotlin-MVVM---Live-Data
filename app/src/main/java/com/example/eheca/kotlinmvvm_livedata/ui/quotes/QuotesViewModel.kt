package com.example.eheca.kotlinmvvm_livedata.ui.quotes

import androidx.lifecycle.ViewModel
import com.example.eheca.kotlinmvvm_livedata.data.Quote
import com.example.eheca.kotlinmvvm_livedata.data.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository): ViewModel() {
    fun getQuotes() = quoteRepository.getQuptes()

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)


}