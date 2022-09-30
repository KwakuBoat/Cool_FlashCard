package com.example.flashcard_fall2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val flashcardQuestion = findViewById<TextView>(R.id.flashcard_question)
        val flashcardAnswer = findViewById<TextView>(R.id.flashcard_answer)
        flashcardQuestion.setOnClickListener{
            flashcardAnswer.visibility = View.VISIBLE
            flashcardQuestion.visibility = View.INVISIBLE

            /// when click is pops up the text
            //Toast.makeText(this, "Question button was clicked", Toast.LENGTH_SHORT).show()
            ///snack bar: it's similar to toast
            Snackbar.make(flashcardQuestion, "Question button was clicked", Snackbar.LENGTH_SHORT).show()
        }

        flashcardAnswer.setOnClickListener{
            flashcardAnswer.visibility = View.INVISIBLE
            flashcardQuestion.visibility= View.VISIBLE
        }



    }
}