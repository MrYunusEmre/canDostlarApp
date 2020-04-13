package com.example.candostlarapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detay.*

class DetayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay)

        var gelenIntent = intent

        if(gelenIntent != null){

            tvDetay.setText(gelenIntent.getStringExtra("isim"))
            imgDetay.setImageResource(gelenIntent.getIntExtra("resim",R.drawable.ani_cat_five))

        }

    }
}
