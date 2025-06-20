package com.example.finalproject

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Game : AppCompatActivity() {
    lateinit var categoryNameTextView: TextView
    lateinit var timeCounterTextView: TextView
    lateinit var questionTextView: TextView
    lateinit var bAnswer1: Button
    lateinit var bAnswer2: Button
    lateinit var bAnswer3: Button
    lateinit var bAnswer4: Button
    lateinit var scoreTextView: TextView
    lateinit var backButton: Button

    private lateinit var questions: MutableList<Question>
    private var currentQuestion: Question? = null
    private var score = 0
    private var timeLeft = 30
    private var timer: CountDownTimer? = null
    private var isAnswering = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_game)

        val startingTime = intent.getIntExtra("time", 30)
        timeLeft = startingTime
        val categoryIndex = intent.getIntExtra("category", 0)
        val category = AppData.categories[categoryIndex]
        categoryNameTextView = findViewById(R.id.categoryNameTextView)
        categoryNameTextView.text = category.name

        questions = category.questions.shuffled().toMutableList()

        initializeViews()
        startTimer()
        loadNextQuestion()

        backButton = findViewById(R.id.goBackButton_id)
        backButton.setOnClickListener {
            finish()
        }
    }

    private fun initializeViews() {
        timeCounterTextView = findViewById(R.id.timeCounterTextView)
        questionTextView = findViewById(R.id.questionTextView)
        scoreTextView = findViewById(R.id.scoreTextView)

        bAnswer1 = findViewById(R.id.answerButton1)
        bAnswer2 = findViewById(R.id.answerButton2)
        bAnswer3 = findViewById(R.id.answerButton3)
        bAnswer4 = findViewById(R.id.answerButton4)

        val buttons = listOf(bAnswer1, bAnswer2, bAnswer3, bAnswer4)
        for (button in buttons) {
            button.setOnClickListener {
                if (!isAnswering) return@setOnClickListener
                checkAnswer(button)
            }
        }
    }

    private fun startTimer() {
        timer = object : CountDownTimer(timeLeft * 1000L, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeft = (millisUntilFinished / 1000).toInt()
                timeCounterTextView.text = "Time: $timeLeft"
            }

            override fun onFinish() {
                endGame()
            }
        }.start()
    }

    private fun loadNextQuestion() {
        if (questions.isEmpty()) {
            endGame()
            return
        }

        isAnswering = true
        val question = questions.removeAt(0)
        currentQuestion = question

        questionTextView.text = question.question
        val answers = listOf(
            question.answers.answer1,
            question.answers.answer2,
            question.answers.answer3,
            question.answers.answer4
    ).shuffled()

        bAnswer1.text = answers[0]
        bAnswer2.text = answers[1]
        bAnswer3.text = answers[2]
        bAnswer4.text = answers[3]

        resetButtonColors()
    }

    private fun checkAnswer(selectedButton: Button) {
        isAnswering = false
        val correct = selectedButton.text == currentQuestion?.correctAnswer

        if (correct) {
            selectedButton.setBackgroundColor(getColor(R.color.green))
            score++
            scoreTextView.text = "Score: $score"
        } else {
            selectedButton.setBackgroundColor(getColor(R.color.red))
            highlightCorrectAnswer()
        }

        selectedButton.postDelayed({
            resetButtonColors()
            loadNextQuestion()
        }, 500)
    }

    private fun resetButtonColors() {
        val buttons = listOf(bAnswer1, bAnswer2, bAnswer3, bAnswer4)
        for (button in buttons) {
            button.setBackgroundColor(getColor(R.color.default_button))
        }
    }

    private fun highlightCorrectAnswer() {
        val buttons = listOf(bAnswer1, bAnswer2, bAnswer3, bAnswer4)
        for (button in buttons) {
            if (button.text == currentQuestion?.correctAnswer) {
                button.setBackgroundColor(getColor(R.color.green))
                break
            }
        }
    }

    private fun endGame() {
        timer?.cancel()

        val intent = Intent(this, GameOver::class.java)
        intent.putExtra("score", score)
        startActivity(intent)
        finish()
    }
}