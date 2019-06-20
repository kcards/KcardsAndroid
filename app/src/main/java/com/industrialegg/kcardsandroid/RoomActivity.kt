package com.industrialegg.kcardsandroid

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_room.*

class RoomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        val newFragment = ConfirmCoCDiaglogFragement()
        newFragment.show(supportFragmentManager, "CoC")

        val username = this.intent.getStringExtra("username")
        Snackbar.make(findViewById(android.R.id.content), "Welcome $username", Snackbar.LENGTH_LONG).show()

        newTopic.setOnClickListener {
            println("New Topic!")
        }

        followup.setOnClickListener {
            println("Followup!")
        }

        interruption.setOnClickListener {
            println("Interruption!")
            vibrate()
        }

    }

    companion object {

        private val INTENT_USER_ID = "username"

        fun newIntent(context: Context, username: String): Intent {
            val intent = Intent(context, RoomActivity::class.java)
            intent.putExtra(INTENT_USER_ID, username)
            return intent
        }
    }
}


fun Context.vibrate(milliseconds:Long = 500){
    val vibrator = this.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

    // Check whether device/hardware has a vibrator
    val canVibrate:Boolean = vibrator.hasVibrator()

    if(canVibrate){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            // void vibrate (VibrationEffect vibe)
            vibrator.vibrate(
                VibrationEffect.createOneShot(
                    milliseconds,
                    // The default vibration strength of the device.
                    VibrationEffect.DEFAULT_AMPLITUDE
                )
            )
        }else{
            // This method was deprecated in API level 26
            vibrator.vibrate(milliseconds)
        }
    }
}


// Extension property to check whether device has Vibrator
val Context.hasVibrator:Boolean
    get() {
        val vibrator = this.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        return vibrator.hasVibrator()
    }