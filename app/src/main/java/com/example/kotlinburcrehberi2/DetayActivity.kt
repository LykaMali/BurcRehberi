package com.example.kotlinburcrehberi2

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.palette.graphics.Palette
import kotlinx.android.synthetic.main.activity_detay2.*

class DetayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay2)


        var position=intent.extras?.get("tiklanilanOgePosition") as Int
        var tumBurcBilgileri = intent.extras?.get("tumBurcBilgileri") as ArrayList<Burclar>

        tvBurcOzellikleri.setText(tumBurcBilgileri.get(position).burcGenelOzellikleri)
        heade2r.setImageResource(tumBurcBilgileri.get(position).burcBuyukResim)

        setSupportActionBar(anim_toolbar)
        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)

        collapsing_toolbar2.title=tumBurcBilgileri.get(position).burcAdi

        var bitmap=BitmapFactory.decodeResource(resources,tumBurcBilgileri.get(position).burcBuyukResim )
        Palette.from(bitmap).generate(object : Palette.PaletteAsyncListener{
            override fun onGenerated(palette: Palette?) {

                var color = palette?.getVibrantColor(R.attr.colorAccent)
                collapsing_toolbar2.setContentScrimColor(color!!)

                window.statusBarColor=color

            }

        })


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}