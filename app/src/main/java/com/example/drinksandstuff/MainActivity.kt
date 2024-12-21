package com.example.drinksandstuff

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Кнопки на главном экране
        val alcoholicImageButton: ImageButton = findViewById(R.id.img_btn_alcoholic)
        val nonAlcoholicImageButton: ImageButton = findViewById(R.id.img_btn_non_alcoholic)
        val servingGlasswareImageButton: ImageButton = findViewById(R.id.img_btn_serving_glassware)
        val workingGlasswareImageButton: ImageButton = findViewById(R.id.img_btn_working_glassware)

        // Обработчики кнопок

        alcoholicImageButton.setOnClickListener {

            val intent = Intent(this, DrinkCategoryActivity::class.java)
            intent.putExtra("categoty", "alcoholic")
            startActivity(intent)


        }
        nonAlcoholicImageButton.setOnClickListener {
            startActivity(Intent(this, DrinkCategoryActivity::class.java).apply {
                putExtra("category", "non_alcoholic")
            })
        }
        servingGlasswareImageButton.setOnClickListener {
            startActivity(Intent(this, GlasswareCategoryActivity::class.java).apply {
                putExtra("type", "serving")
            })
        }
        workingGlasswareImageButton.setOnClickListener {
            startActivity(Intent(this, GlasswareCategoryActivity::class.java).apply {
                putExtra("type", "working")
            })
        }
    }
}