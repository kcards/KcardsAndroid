package com.industrialegg.kcardsandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.beust.klaxon.JsonObject
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.extensions.jsonBody
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        create.setOnClickListener {
            val rn = roomName.text.toString()
            // Create a new room
            if( rn == "") {
                Fuel.post("https://kcards.herokuapp.com/api/rooms/")
                    .response { _, _, result ->
                        val (bytes, _) = result
                        if (bytes != null) {
                            val room = Klaxon().parse<Room>(String(bytes))
                            val roomCode = room?.code
                            val intent = JoinActivity.newIntent(this, roomCode)
                            startActivity(intent)
                        }
                    }
            } else {
                // Create a new room with the given name, re-prompt if it already exists
                val body = JsonObject()
                body["code"] = rn
                Fuel.post("https://kcards.herokuapp.com/api/rooms/")
                    .jsonBody(body.toJsonString())
                    .response { _, response, result ->
                        if (response.statusCode == 201) {
                            val (bytes, _) = result
                            if (bytes != null) {
                                val room = Klaxon().parse<Room>(String(bytes))
                                val roomCode = room?.code
                                val intent = JoinActivity.newIntent(this, roomCode)
                                startActivity(intent)
                            }
                        }
                        else {
                            Snackbar.make(findViewById(android.R.id.content), "Room with name $rn already exists!", Snackbar.LENGTH_LONG).show()
                        }
                    }
            }
        }
    }
}
class Card(val name: String, val color: String)
class Room(val uri: String, val code: String, val queue: List<Card>)
