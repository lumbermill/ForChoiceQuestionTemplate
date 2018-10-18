package jp.co.lumber_mill.fourchoicequestiontemplate

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // xmlのListViewを取得します
        val listView = findViewById<ListView>(R.id.list_view)
        // Context.ktで作成したquestionsのキーの名前を取得します
        val items = Context.questions.keys.toTypedArray()
        // simple_list_item_1というListViewのテンプレートを使用します
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items)
        listView.adapter = adapter
        // listViewのアイテムをクリックした時の動きを登録します
        listView.setOnItemClickListener { adapterView, view, i, l ->
            // Intentを使いQuizActivityを表示します
            val intent = Intent(this, QuizActivity::class.java)
            // ListViewの何番目がクリックされたのかをidという名前でquizActivityに渡します
            intent.putExtra("id", i)
            startActivity(intent)
        }
    }
}
