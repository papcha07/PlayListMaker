package com.example.playlistmaker

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.settings)

        val backButton = findViewById<ImageView>(R.id.back)

         backButton.setOnClickListener{

             val backIntent = Intent(this, MainActivity::class.java)
             startActivity(backIntent)

         }


        val shareButtonId = findViewById<LinearLayout>(R.id.shareButton)
        shareButtonId.setOnClickListener{

            val sendIntent = Intent(Intent.ACTION_SEND)
            sendIntent.type = "text/plain"
            sendIntent.putExtra(Intent.EXTRA_TEXT, "https://practicum.yandex.ru/profile/android-developer/")
            startActivity(sendIntent)

        }


        val reportButtonId = findViewById<LinearLayout>(R.id.reportButton)
        reportButtonId.setOnClickListener{


            val reportIntent = Intent(Intent.ACTION_SEND)

            val subjectText = "Сообщение разработчикам и разработчицам приложения Playlist Maker"
            val text = "Спасибо разработчикам и разработчицам за крутое приложение!"


            reportIntent.setType("message/rfc822")


            reportIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("legoman056@gmail.com"))
            reportIntent.putExtra(Intent.EXTRA_SUBJECT, subjectText)
            reportIntent.putExtra(Intent.EXTRA_TEXT, text)

            startActivity(reportIntent)
        }


        val documentsButtonId = findViewById<LinearLayout>(R.id.documentsId)

        documentsButtonId.setOnClickListener{


            val browserUri = Uri.parse("https://yandex.ru/legal/practicum_offer/")
            val browserIntent = Intent(Intent.ACTION_VIEW,browserUri)

            startActivity(browserIntent)



        }











    }
}