package jp.co.lumber_mill.fourchoicequestiontemplate

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

class QuizActivity : AppCompatActivity(), View.OnClickListener {
    // 使用する問題を入れておく変数
    private lateinit var questions: ArrayList<ArrayList<String>>

    // 問題の数をカウントする変数
    private var index: Int = 0

    // 次の問題を表示するためのボタン
    private lateinit var next: Button

    // マル・バツを表示するImageView
    private lateinit var judge: ImageView

    // 正解を入れておく変数
    private var correct: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        // MainActivityから`id`を取得
        val id = intent.getIntExtra("id", 0)
        // Context.ktで作成したquestionsのキーの名前を取得します
        val keys = Context.questions.keys.toTypedArray()
        // idとキーの名前から問題を取得します
        questions = Context.questions[keys[id]]!!
        // 毎回違う順番で問題を出すため、取得した問題の順番をシャッフルします
        questions.shuffle()

        next = findViewById(R.id.next)
        next.setOnClickListener {
            if (questions.count() <= index) {
                // アクティビティを終了します
                finish()
            } else {
                changeView(questions[index])
            }
        }

        judge = findViewById(R.id.judge)

        changeView(questions[index])
    }

    /**
     * 表示する問題を入れ替える関数
     * @param question
     */
    private fun changeView(question: ArrayList<String>) {
        // 問題用の画像を表示するImageViewを取得します
        val imageView = findViewById<ImageView>(R.id.imageView)

        // 選択肢1〜4までのボタンを取得します
        val btn1 = findViewById<Button>(R.id.button1)
        val btn2 = findViewById<Button>(R.id.button2)
        val btn3 = findViewById<Button>(R.id.button3)
        val btn4 = findViewById<Button>(R.id.button4)

        // 次の問題を表示するボタンを無効にし、マル・バツを透明にします
        next.isEnabled = false
        judge.alpha = 0f

        // 問題の正解を入れておきます
        // 配列の0番目を正解とします
        correct = question[0]
        // 正解と同じ名前の画像を取得し、ImageViewに表示します
        val resId = resources.getIdentifier(correct, "drawable", packageName)
        imageView.setImageResource(resId)

        // 問題をシャッフルしボタンに表示します
        question.shuffle()
        btn1.text = question[0]
        btn2.text = question[1]
        btn3.text = question[2]
        btn4.text = question[3]

        // ボタンをタップした時の動作を登録します
        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
    }

    /**
     * 選択肢のボタンをタップした際に呼び出される関数
     */
    override fun onClick(p0: View?) {
        // タップされたボタンの文字を取得します
        val answer = (p0 as Button).text as String

        // 正誤判定をし、マル・バツの画像をjudgeにセットします
        if (answer == correct) {
            judge.setImageResource(R.drawable.correct)
        } else {
            judge.setImageResource(R.drawable.wrong)
        }

        // 問題のカウントを+1します
        index += 1
        // 透明にしていたマル・バツの画像を表示します
        judge.alpha = 1f
        // 次の問題を表示するボタンを有効にします
        next.isEnabled = true
    }
}
