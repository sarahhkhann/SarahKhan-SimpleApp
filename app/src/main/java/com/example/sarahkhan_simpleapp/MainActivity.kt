package com.example.sarahkhan_simpleapp

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var editText: EditText
    private val imageIDs = intArrayOf(
        R.drawable.beach, R.drawable.desert, R.drawable.jungle, R.drawable.mountains
    )
    private lateinit var sharedPreferences: SharedPreferences

    companion object {
        private const val PREFS_NAME = "MyApp_Settings"
        private const val KEY_TEXT = "text"
        private const val KEY_IMAGE_INDEX = "imageIndex"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageViewRandom)
        editText = findViewById(R.id.text)
        val button: Button = findViewById(R.id.imageViewButton)

        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
        //editText.setText(sharedPreferences.getString(KEY_TEXT, ""))
        val imageIndex = sharedPreferences.getInt(KEY_IMAGE_INDEX, -1)
        if (imageIndex != -1) {
            imageView.setImageResource(imageIDs[imageIndex])
        }

        button.setOnClickListener {
            val index = Random.nextInt(imageIDs.size)
            imageView.setImageResource(imageIDs[index])
            with(sharedPreferences.edit()) {
                putInt(KEY_IMAGE_INDEX, index)
                apply()
            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        with(sharedPreferences.edit()) {
            putString(KEY_TEXT, editText.text.toString())
            apply()
        }
    }
}