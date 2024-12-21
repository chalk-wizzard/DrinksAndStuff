package com.example.drinksandstuff

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.LinearLayout

class GlasswareCategoryActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glassware_category)

        val type = intent.getStringExtra("type") ?: "serving"

        val buttonBack: Button = findViewById(R.id.backBtn)

        val layoutContainer: LinearLayout = findViewById(R.id.glassware_list_container)

        val glassware = if (type == "serving") {
            listOf("Бокал для вина" to R.drawable.glass1, "Кубок" to R.drawable.glass4)
        } else {
            listOf("Шейкер" to R.drawable.glass3, "Джиггер" to R.drawable.glass2)
        }

        for ((name, imageRes) in glassware) {
            val button = Button(this)
            button.text = name
            button.setOnClickListener {
                val intent = Intent(this, GlasswareDetailActivity::class.java)
                intent.putExtra("glass_name", name)
                intent.putExtra("type", type)
                startActivity(intent)
            }
            layoutContainer.addView(button)
        }

        buttonBack.setOnClickListener() {
            finish()
        }
    }
}
