package jp.co.lumber_mill.fourchoicequestiontemplate

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.list_view)
        val items = arrayOf("anime", "game")
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items)
        listView.adapter = adapter
    }
}
