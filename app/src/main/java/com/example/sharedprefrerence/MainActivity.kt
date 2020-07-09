package com.example.sharedprefrerence

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    var etSave: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etSave = findViewById<EditText>(R.id.etSave)
        val btnSave = findViewById<Button>(R.id.btnSave)
        val btnLoad = findViewById<Button>(R.id.btnLoad)

        val preference = getSharedPreferences("SharedPreference", Context.MODE_PRIVATE)

        val textFromPref = preference.getString("text", "no saved text")
        etSave?.setText(textFromPref)

        btnSave.setOnClickListener {
            val text = etSave?.text.toString()
            preference.edit().putString("text", text).apply()
        }

        btnLoad.setOnClickListener {
            val textFromPref = preference.getString("text", "no saved text")
            etSave?.setText(textFromPref)
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        val text = etSave?.text.toString()
        val preference = getSharedPreferences("SharedPreference", Context.MODE_PRIVATE)
        preference.edit().putString("text", text).apply()
    }
}