package com.ipieinfotech.appsecurity

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.Web).setOnClickListener {
            viewAWebPage()
        }
        findViewById<Button>(R.id.call).setOnClickListener {
            implicitCallIntent()
        }
        findViewById<Button>(R.id.email).setOnClickListener {
            sendEmailIntent()
        }
        findViewById<Button>(R.id.map).setOnClickListener {
            viewAMap()
        }
    }

    private fun implicitCallIntent() {
        val callIntent: Intent = Uri.parse("tel:8968666401").let { number ->
            Intent(Intent.ACTION_DIAL, number)
        }
        try {
            startActivity(callIntent)
        } catch (e: ActivityNotFoundException) {
            // Define what your app should do if no activity can handle the intent.
        }

    }

    private fun viewAMap() {
        val mapIntent: Intent = Uri.parse(
            "geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California"
        ).let { location ->
            Intent(Intent.ACTION_VIEW, location)
        }
        try {
            startActivity(mapIntent)
        } catch (e: ActivityNotFoundException) {
            // Define what your app should do if no activity can handle the intent.
        }
    }

    private fun viewAWebPage() {
        val webIntent: Intent = Uri.parse(
            "https://www.ipieInfoTech.com"
        ).let { webPage ->
            Intent(Intent.ACTION_VIEW, webPage)
        }
        try {
            startActivity(webIntent)
        } catch (e: ActivityNotFoundException) {
            // Define what your app should do if no activity can handle the intent.
        }
    }


    /**
     * Add extras to an intent
     * --Send an email with an attachment
     */

    private fun sendEmailIntent() {
        val emailIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_EMAIL, arrayOf("dev.prithvi.19@gmail.com")) //recipients
            putExtra(Intent.EXTRA_SUBJECT, "Email subject") //recipients
            putExtra(Intent.EXTRA_TEXT, "Email message text") //recipients
            putExtra(Intent.EXTRA_STREAM, arrayOf("dev.prithvi.19@gmail.com")) //recipients

        }
        try {
            startActivity(emailIntent)
        } catch (e: ActivityNotFoundException) {
            // Define what your app should do if no activity can handle the intent.
        }
    }

}