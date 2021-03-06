package com.example.eheca.kotlinmvvm_livedata.data



import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeQuoteDao {
    private val quoteList = mutableListOf<Quote>()
    private val quotes = MutableLiveData<List<Quote>>()

    init {
        refreshQuoteList()
    }
    fun addQuote(quote: Quote){
        quoteList.add(quote)
        refreshQuoteList()
    }
    fun refreshQuoteList(){
        quotes.value = quoteList
    }

    fun getQuotes() = quotes as LiveData<List<Quote>>
}