package com.industrialegg.kcardsandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mooveit.library.Fakeit
import kotlinx.android.synthetic.main.activity_join.*


class JoinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        join.setOnClickListener {
            val intent = RoomActivity.newIntent(this, name.text.toString())
            startActivity(intent)
            finish()
        }
    }
}
