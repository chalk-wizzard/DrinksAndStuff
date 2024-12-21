package com.example.drinksandstuff

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ImageView
import android.widget.TextView

class DrinkCategoryActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drink_category)

        val category = intent.getStringExtra("category") ?: "alcoholic"

        var buttonBack: Button = findViewById(R.id.backBtn)

        val layoutContainer: LinearLayout = findViewById(R.id.drink_list_container)

        val drinks = if (category == "alcoholic") {
            listOf(
                "Маргарита" to R.drawable.drink1, "Мохито" to R.drawable.drink2
            )
        } else {
            listOf(
                "Лимонад" to R.drawable.drink3, "Смузи" to R.drawable.drink4
            )
        }

        for ((name, imageRes) in drinks) {
            val button = Button(this)
            button.text = name
            button.setOnClickListener {
                val intent = Intent(this, DrinkDetailActivity::class.java)
                intent.putExtra("drink_name", name)
                startActivity(intent)
            }
            layoutContainer.addView(button)
        }

        buttonBack.setOnClickListener() {
            finish()
        }
    }
}
