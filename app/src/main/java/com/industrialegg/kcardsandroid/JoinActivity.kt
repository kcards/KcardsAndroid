package com.industrialegg.kcardsandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mooveit.library.Fakeit
import kotlinx.android.synthetic.main.activity_join.*


class JoinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        join.setOnClickListener {
            val intent = Intent(this, RoomActivity::class.java)
            intent.putExtra("username", name.text.toString())
            startActivity(intent)
            finish()
        }
    }
}
