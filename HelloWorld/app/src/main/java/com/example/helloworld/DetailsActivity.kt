package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import timber.log.Timber

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        Timber.d("DetailsActivity_TAG: onCreate: ")
        val comment = intent.getStringExtra(COMMENT) ?: return
        Timber.d("DetailsActivity_TAG: onCreate: comment: $comment")

        findViewById<TextView>(R.id.tvComment).text = comment
    }
}
