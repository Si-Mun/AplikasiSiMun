package com.example.aplikasisimun

import android.animation.LayoutTransition
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.aplikasisimun.R
import com.example.aplikasisimun.data.Mountain

class DetailMountain : AppCompatActivity() {
    private lateinit var expand: CardView
    private lateinit var layout: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dataMountain = intent.getParcelableExtra<Mountain>("key_mountain") as Mountain


        val tvDetailName: TextView = findViewById(R.id.tv_detail_name)
        val ivDetailPhoto: ImageView = findViewById(R.id.iv_detail_photo)
        val tvDetailLocation: TextView = findViewById(R.id.tv_detail_location)


        val tvDetailDescription:TextView = findViewById(R.id.tv_detail_description)
        layout = findViewById(R.id.layouts)
        expand = findViewById(R.id.expands)

        layout.layoutTransition.enableTransitionType(LayoutTransition.CHANGING)
        expand.setOnClickListener{
            val v = if(tvDetailDescription.visibility == View.GONE) View.VISIBLE else View.GONE
            tvDetailDescription.visibility = v
        }
        tvDetailDescription.text = dataMountain.description
        tvDetailName.text = dataMountain.name
        ivDetailPhoto.setImageResource(dataMountain.photo)
        tvDetailLocation.text = dataMountain.location
    }
}