package com.example.mobile_final

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import com.example.mobile_final.PaintView.Companion.currentBrush
import com.example.mobile_final.PaintView.Companion.pathList

class MainActivity : AppCompatActivity() {

    companion object{
        var path = Path()
        var Brush = Paint()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val redButton = findViewById<ImageButton>(R.id.redcolor)
        val blueButton = findViewById<ImageButton>(R.id.bluecolor)
        val blackButton = findViewById<ImageButton>(R.id.blackcolor)
        val yellowButton = findViewById<ImageButton>(R.id.yellowcolor)
        val whiteButton = findViewById<ImageButton>(R.id.whitecolor) //this is actually erase everything button

        redButton.setOnClickListener {
            Toast.makeText(this, "Red", Toast.LENGTH_SHORT).show()
            Brush.color = Color.RED
            currentColor(Brush.color)
        }
        blueButton.setOnClickListener {
            Toast.makeText(this, "Blue", Toast.LENGTH_SHORT).show()
            Brush.color = Color.BLUE
            currentColor(Brush.color)
        }
        blackButton.setOnClickListener {
            Toast.makeText(this, "Black", Toast.LENGTH_SHORT).show()
            Brush.color = Color.BLACK
            currentColor(Brush.color)
        }
        yellowButton.setOnClickListener {
            Toast.makeText(this, "Yellow", Toast.LENGTH_SHORT).show()
            Brush.color = Color.YELLOW
            currentColor(Brush.color)
        }
        whiteButton.setOnClickListener {
            Toast.makeText(this, "Erase", Toast.LENGTH_SHORT).show()
            pathList.clear()
            path.reset()
        }

    }
    private fun currentColor (color : Int){
        currentBrush = color
        path = Path()
    }
}