package com.industrialegg.kcardsandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar

class RoomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        val username = this.intent.getStringExtra("username")
        Snackbar.make(findViewById(android.R.id.content), "Welcome $username", Snackbar.LENGTH_LONG).show()
    }
}
