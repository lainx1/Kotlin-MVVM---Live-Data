package com.example.eheca.kotlinmvvm_livedata.ui.quotes


import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.eheca.kotlinmvvm_livedata.R
import com.example.eheca.kotlinmvvm_livedata.data.Quote
import com.example.eheca.kotlinmvvm_livedata.uitilities.InjectorUtilities
import kotlinx.android.synthetic.main.activity_quotes.*

class QuotesActivity : AppCompatActivity() {
    //Tutorial from https://www.youtube.com/watch?v=d7UxPYxgBoA

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        initializeUi()
    }
    private fun initializeUi(){
        val factory = InjectorUtilities.privideQuotesViewModelFactory()
        val viewModel = ViewModelProviders.of(this, factory)
                .get(QuotesViewModel::class.java)
        viewModel.getQuotes().observe(this, Observer { quotes->
            val stringBuilder = StringBuilder()
            quotes.forEach{quote -> stringBuilder.append("$quote\n\n")}
            textView_quotes.text = stringBuilder.toString()
        })
        button_add_quote.setOnClickListener {
            val quote = Quote(editText_quote.text.toString(), editText_author.text.toString())
            viewModel.addQuote(quote)
            editText_quote.setText("")
            editText_author.setText("")
        }
    }
}
