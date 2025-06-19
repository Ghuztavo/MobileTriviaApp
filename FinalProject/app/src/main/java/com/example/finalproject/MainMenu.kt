package com.example.finalproject

import android.content.Intent
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainMenu : AppCompatActivity() , OnCategoryClickedListener
{
    override fun onGroupClicked(position: Int) {
        val selectedTime = timeSeekBar.progress + 30
        val intent = Intent(this, Game::class.java)
        intent.putExtra("category", position)
        intent.putExtra("time", selectedTime)
        startActivity(intent)
    }
    lateinit var categoryRecyclerView: RecyclerView

    lateinit var timeSeekBar: SeekBar
    lateinit var timeText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        AppData.initializeCategories()

        timeSeekBar = findViewById<SeekBar>(R.id.timeSeekBar_id)
        timeText = findViewById<TextView>(R.id.timeText_id)

        timeSeekBar.max = 90
        timeSeekBar.progress = 0
        timeText.text = "30s"

        timeSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val totalTime = progress + 30
                timeText.text = "${totalTime}s"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        categoryRecyclerView = findViewById(R.id.testsRecyclerView_id)
        categoryRecyclerView.layoutManager = LinearLayoutManager(this)
        categoryRecyclerView.adapter = CategoryAdapter(this)
    }
}

