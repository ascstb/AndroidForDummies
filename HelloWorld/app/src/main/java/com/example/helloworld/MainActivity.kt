package com.example.helloworld

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber


class MainActivity : AppCompatActivity() {

    //region Life Cycle
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.d("MainActivity_TAG: onCreate: ")

        val tvName = findViewById<TextView>(R.id.tvName)
        val tvLastName = findViewById<TextView>(R.id.tvLastName)

        tvName.text = "Christian"
        tvLastName.text = "Salazar"
    }

    override fun onStart() {
        super.onStart()
        Timber.d("MainActivity_TAG: onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Timber.d("MainActivity_TAG: onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Timber.d("MainActivity_TAG: onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Timber.d("MainActivity_TAG: onStop: ")
    }

    override fun onRestart() {
        super.onRestart()
        Timber.d("MainActivity_TAG: onRestart: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("MainActivity_TAG: onDestroy: ")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Timber.d("MainActivity_TAG: onSaveInstanceState: ")
        val etComment = findViewById<EditText>(R.id.etComment)
        outState.putString(COMMENT, etComment.text.toString())

        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Timber.d("MainActivity_TAG: onRestoreInstanceState: ")
        super.onRestoreInstanceState(savedInstanceState)

        val etCommentText = savedInstanceState.getString(COMMENT) ?: return
        val etComment = findViewById<EditText>(R.id.etComment)
        etComment.setText(etCommentText)
    }
    //endregion

    //region event
    fun onMoreInfoClicked(view: View) {
        val orientationDescription = when (resources.configuration.orientation) {
            Configuration.ORIENTATION_PORTRAIT -> "Portrait"
            else -> "Landscape"
        }

        Timber.d("MainActivity_TAG: onMoreInfoClicked: viewId: ${view.id}, orientation: $orientationDescription")

        val intent = Intent(this, DetailsActivity::class.java)
        val etCommentText = findViewById<EditText>(R.id.etComment)
        intent.putExtra(COMMENT, etCommentText.text.toString())
        startActivity(intent)
    }

    fun onShareButtonClicked(view: View) {
        Timber.d("MainActivity_TAG: onShareButtonClicked: ${view.id}")
        val shareBody = "Here is the share content body"
        val sharingIntent = Intent(Intent.ACTION_SEND)
        sharingIntent.type = "text/plain"
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "My Subject")
        sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
        startActivity(Intent.createChooser(sharingIntent, "Something"))
    }
    //endregion
}
