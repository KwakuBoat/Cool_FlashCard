package com.example.flashcard_fall2022

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val flashcardQuestion = findViewById<TextView>(R.id.flashcard_question)
        val flashcardAnswer = findViewById<TextView>(R.id.flashcard_answer)
        val addQuestionButton = findViewById<ImageView>(R.id.add_question_button)


        flashcardQuestion.setOnClickListener{
            flashcardAnswer.visibility = View.VISIBLE
            flashcardQuestion.visibility = View.INVISIBLE
            ///snack bar: it's similar to toast
            Snackbar.make(flashcardQuestion, "Question button was clicked", Snackbar.LENGTH_SHORT).show()
        }

        flashcardAnswer.setOnClickListener{
            flashcardAnswer.visibility = View.INVISIBLE
            flashcardQuestion.visibility= View.VISIBLE
        }

        val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result ->

            val data : Intent? = result.data

            if (data != null){
                val questionString = data.getStringExtra("QUESTION_KEY")
                val answerString = data.getStringExtra("ANSWER_KEY")

                flashcardQuestion.text = questionString
                flashcardAnswer.text = answerString

                Log.i("Gideon: MainActivity", "Question: $questionString")
                Log.i("Gideon: MainActivity", "Answer: $answerString")
            }else{
                Log.i("Gideon: MainActivity", "Returned null data from AddCardActivity")
            }
        }
        addQuestionButton.setOnClickListener{
            val intent = Intent(this, AddCardActivity::class.java)
            resultLauncher.launch(intent)
        }
    }
}