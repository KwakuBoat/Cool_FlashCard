package com.example.flashcard_fall2022

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class AddCardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_card)


        val questionEditText = findViewById<EditText>(R.id.flashcard_question_edittext)
        val answerEditText = findViewById<EditText>(R.id.flashcard_answer_edittext)



        val saveButton = findViewById<ImageView>(R.id.flashcard_save_button)
        saveButton.setOnClickListener{
            val questionString = questionEditText.text.toString()
            val answerString = answerEditText.text.toString()

            val data = Intent()
            data.putExtra("QUESTION_KEY", questionString)
            data.putExtra("ANSWER_KEY",answerString)

            Toast.makeText(this, "Save button was clicked", Toast.LENGTH_SHORT).show()

            setResult(RESULT_OK, data)
            finish()
        }

        val cancelButton = findViewById<ImageView>(R.id.flashcard_cancel_button)
        cancelButton.setOnClickListener{
            Snackbar.make(cancelButton, "Cancel button was clicked", Snackbar.LENGTH_SHORT).show()
            finish()
        }
    }
}
