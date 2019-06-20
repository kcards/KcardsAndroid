package com.industrialegg.kcardsandroid

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_join.*


class JoinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        val roomCode = intent.getStringExtra(INTENT_ROOM_CODE)
        roomId.text = roomCode

        join.setOnClickListener {
            val intent = RoomActivity.newIntent(this, name.text.toString())
            startActivity(intent)
            finish()
        }
    }

    companion object {

        private val INTENT_ROOM_CODE = "room_code"

        fun newIntent(context: Context, roomCode: String?): Intent {
            val intent = Intent(context, JoinActivity::class.java)
            intent.putExtra(INTENT_ROOM_CODE, roomCode)
            return intent
        }
    }
}
