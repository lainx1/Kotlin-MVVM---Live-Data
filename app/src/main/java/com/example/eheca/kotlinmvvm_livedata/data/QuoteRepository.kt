package com.example.eheca.kotlinmvvm_livedata.data

class QuoteRepository private constructor(private val quoteDao: FakeQuoteDao){

    fun addQuote(quote: Quote){
        quoteDao.addQuote(quote)
    }
    fun getQuptes() = quoteDao.getQuotes()

    companion object {
        @Volatile private var instance: QuoteRepository? = null
        fun get_Instance(quoteDao: FakeQuoteDao) =
                instance ?: synchronized(this) {
                    instance ?: QuoteRepository(quoteDao).also { instance = it }
                }
    }
}