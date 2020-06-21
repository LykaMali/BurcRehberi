package com.example.kotlinburcrehberi2

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.tek_satir.view.*

class BurclarArrayAdapter(
    var gelenContext: Context,
    var resource: Int,
    var textViewResourceId: Int,
    var burcAdlari: Array<String>,
    var burcTarihleri: Array<String>,
    var burcResimleri: Array<Int>
) : ArrayAdapter<String>(gelenContext, resource, textViewResourceId, burcAdlari) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tek_satir_view=convertView
        var viewHolder : ViewHolder?=null

        if (tek_satir_view == null){
            val inflater=LayoutInflater.from(gelenContext)
            tek_satir_view=inflater.inflate(R.layout.tek_satir, parent, false)

            viewHolder= ViewHolder(tek_satir_view)
            tek_satir_view.tag=viewHolder

            Log.e("Memo","inflation Yapıldı : " + burcAdlari[position])
        }else{
            viewHolder= tek_satir_view.getTag() as ViewHolder
        }



       viewHolder.burcResim.setImageResource(burcResimleri[position])
      viewHolder.burcAdi.setText(burcAdlari[position])
        viewHolder.burcTarihi.setText(burcTarihleri[position])

        return tek_satir_view!!
    }

    class ViewHolder(tek_satir_view:View){

        var burcResim:ImageView
        var burcAdi:TextView
        var burcTarihi:TextView

        init {
            this.burcResim=tek_satir_view.imgBurcSembol
            this.burcAdi=tek_satir_view.tvBurcAdi
            this.burcTarihi=tek_satir_view.tvBurcTarihi
        }

    }

}