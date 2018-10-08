package jp.co.lumber_mill.fourchoicequestiontemplate

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

class QuizActivity : AppCompatActivity() {
    private lateinit var questions: ArrayList<ArrayList<String>>
    private var index: Int = 0
    private lateinit var next: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        val id = intent.getIntExtra("id", 0)
        val keys = Context.questions.keys.toTypedArray()
        questions = Context.questions[keys[id]]!!
        questions.shuffle()

        next = findViewById(R.id.next)
        next.setOnClickListener {
            if (questions.count() <= index) {
                finish()
            } else {
                changeView(questions[index])
            }
        }

        changeView(questions[index])
    }

    private fun changeView(question: ArrayList<String>) {
        val imageView = findViewById<ImageView>(R.id.imageView)
        val btn1 = findViewById<Button>(R.id.button1)
        val btn2 = findViewById<Button>(R.id.button2)
        val btn3 = findViewById<Button>(R.id.button3)
        val btn4 = findViewById<Button>(R.id.button4)

        next.isEnabled = false

        val answer = question[0]
        val resId = resources.getIdentifier(answer, "drawable", packageName)
        imageView.setImageResource(resId)
        question.shuffle()

        btn1.text = question[0]
        btn2.text = question[1]
        btn3.text = question[2]
        btn4.text = question[3]

        btn1.setOnClickListener { onClick(it, answer) }
        btn2.setOnClickListener { onClick(it, answer) }
        btn3.setOnClickListener { onClick(it, answer) }
        btn4.setOnClickListener { onClick(it, answer) }
    }

    private fun onClick(btn: View, answer: String) {
        val text = (btn as Button).text as String
        if (text == answer) {
            val judge = findViewById<ImageView>(R.id.judge)
            judge.setImageResource(R.drawable.correct)
        } else {
            val judge = findViewById<ImageView>(R.id.judge)
            judge.setImageResource(R.drawable.wrong)
        }
        index += 1
        next.isEnabled = true
    }
}
