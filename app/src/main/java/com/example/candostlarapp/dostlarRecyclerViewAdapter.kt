package com.example.candostlarapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.tek_oge_layout.view.*
import java.util.zip.Inflater

class dostlarRecyclerViewAdapter(tumDostlar:ArrayList<Dost>) : RecyclerView.Adapter<dostlarRecyclerViewAdapter.dostViewHolder>(), Filterable {

    var dostlar = tumDostlar
    var myFilter = filterHelper(tumDostlar,this)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): dostViewHolder {

        var inflater = LayoutInflater.from(parent.context)
        var tek_uye = inflater.inflate(R.layout.tek_oge_layout,parent,false)

        return dostViewHolder(tek_uye)
    }

    override fun getItemCount(): Int {
        return dostlar.size
    }

    override fun onBindViewHolder(holder: dostViewHolder, position: Int) {

        var currentDost = dostlar.get(position)

        holder.setData(currentDost,position)



    }


    class dostViewHolder(tek_uye : View) : RecyclerView.ViewHolder(tek_uye) {

        var tekDostBilgisi = tek_uye as CardView

        var dostAd = tekDostBilgisi.tvDostAdı
        var dostResim = tekDostBilgisi.imgDost

        fun setData(currentDost:Dost, position:Int){

            dostAd.text = currentDost.isim
            dostResim.setImageResource(currentDost.resim)

            tekDostBilgisi.setOnClickListener{v ->

                Toast.makeText(tekDostBilgisi.context,"Tıklanılan Öge : ${position} , Adı : ${currentDost.isim}",Toast.LENGTH_SHORT).show()

                var intent = Intent(v.context,DetayActivity::class.java)
                intent.putExtra("isim",currentDost.isim)
                intent.putExtra("resim",currentDost.resim)

                v.context.startActivity(intent)


            }


        }

    }

    fun setFilter(arrayList: ArrayList<Dost>) {

        dostlar = arrayList
    }

    override fun getFilter(): Filter {
        return myFilter
    }

/*
    fun setFilter(arananlar:ArrayList<Dost>){

        dostlar = ArrayList<Dost>()

        dostlar.addAll(arananlar)

        notifyDataSetChanged()

    }
*/
}