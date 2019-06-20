package com.industrialegg.kcardsandroid

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class ConfirmCoCDiaglogFragement : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)
            builder.setMessage("Remember to ask your question, in the form of a question.")
                .setPositiveButton("Got it",
                    DialogInterface.OnClickListener { _, _ ->
                        // Continue to room
                    })
                .setNegativeButton("Well, actually..",
                    DialogInterface.OnClickListener { _, _ ->
                        val homeIntent = Intent(activity , MainActivity::class.java)
                        startActivity(homeIntent)
                    })
            // Create the AlertDialog object and return it
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}