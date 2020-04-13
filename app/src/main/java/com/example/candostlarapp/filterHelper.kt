package com.example.candostlarapp

import android.widget.Filter

class filterHelper(tumDostlar:ArrayList<Dost>,myAdapter:dostlarRecyclerViewAdapter) : Filter(){

    var currentList = tumDostlar
    var currentAdapter = myAdapter


    override fun performFiltering(constraint: CharSequence?): FilterResults {

        var sonuc = FilterResults()

        if(constraint != null && constraint.length>0){

            var aranılan = constraint.toString().toLowerCase()

            var eslesenler = ArrayList<Dost>()

            for(i in currentList){

                var ad = i.isim.toString().toLowerCase()

                if(ad.contains(aranılan.toString())){
                    eslesenler.add(i)
                }
            }
            sonuc.values = eslesenler
            sonuc.count = eslesenler.size
        }else{
            sonuc.count = currentList.size
            sonuc.values = currentList
        }

        return sonuc

    }

    override fun publishResults(constraint: CharSequence?, results: FilterResults?) {

        currentAdapter.setFilter(results?.values as ArrayList<Dost>)
        currentAdapter.notifyDataSetChanged()

    }
}