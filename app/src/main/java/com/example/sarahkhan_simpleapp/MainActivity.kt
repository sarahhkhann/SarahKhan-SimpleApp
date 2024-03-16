package com.example.sarahkhan_simpleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val imageIDs = arrayOf(
        R.drawable.beach,
        R.drawable.desert,
        R.drawable.jungle,
        R.drawable.mountains
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val imageViewRandom: ImageView = findViewById(R.id.imageViewRandom)
        val buttonShowRandomImage: Button = findViewById(R.id.imageViewButton)

        buttonShowRandomImage.setOnClickListener {
            val randomImageId = imageIDs[Random.nextInt(imageIDs.size)]
            imageViewRandom.setImageResource(randomImageId)
        }


    }
}