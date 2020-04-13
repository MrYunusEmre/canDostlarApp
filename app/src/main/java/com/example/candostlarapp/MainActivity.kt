package com.example.candostlarapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var tumDostlar = ArrayList<Dost>()
    lateinit var myAdapter:dostlarRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        veriKaynaginiDoldur()

        myAdapter = dostlarRecyclerViewAdapter(tumDostlar)

       recyclerViewDostlar.adapter = myAdapter

        var layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        recyclerViewDostlar.layoutManager = layoutManager

        searchViewDost.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                myAdapter.filter.filter(newText)

                return false
            }


        })





    }
/*
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.filtre_menu,menu)

        var aramaIconu = menu?.findItem(R.id.app_bar_search)

        var searchView = aramaIconu?.actionView as android.widget.SearchView

        searchView.setOnQueryTextListener(this)


        return super.onCreateOptionsMenu(menu)
    }
*/

    private fun veriKaynaginiDoldur() {

        var resimler = arrayOf(R.drawable.ani_cat_one,
            R.drawable.ani_cat_two,
            R.drawable.ani_cat_three,
            R.drawable.ani_cat_four,
            R.drawable.ani_cat_five,
            R.drawable.ani_cat_six,
            R.drawable.ani_cat_seven,

            R.drawable.ani_dog_one,
            R.drawable.ani_dog_two,
            R.drawable.ani_dog_three,
            R.drawable.ani_dog_four,
            R.drawable.ani_dog_five,

            R.drawable.ani_deer_one,
            R.drawable.ani_deer_two,
            R.drawable.ani_deer_three,
            R.drawable.ani_deer_four,

            R.drawable.bird_parrot_one,
            R.drawable.bird_parrot_two,
            R.drawable.bird_parrot_three,
            R.drawable.bird_parrot_four,
            R.drawable.bird_parrot_five,
            R.drawable.bird_parrot_six,
            R.drawable.bird_parrot_seven,
            R.drawable.bird_parrot_eight)

        var isimler = arrayOf("Kedi 1", "Kedi 2", "Kedi 3", "Kedi 4", "Kedi 5", "Kedi 6", "Kedi 7",
            "Köpek 1", "Köpek 2", "Köpek 3", "Köpek 4", "Köpek 5",
            "Geyik 1", "Geyik 2", "Geyik 3", "Geyik 4",
            " Papagan 1", " Papagan 2", " Papagan 3", " Papagan 4", " Papagan 5", " Papagan 6", " Papagan 7", " Papagan 8")

        for(i in 0..resimler.size-1){
            var eklenecekDost = Dost(isimler[i],resimler[i])
            tumDostlar.add(eklenecekDost)
        }


    }
/*
    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        var girilenVeri = newText?.toLowerCase()

        var arananlar = ArrayList<Dost>()

        for(i in tumDostlar){
            var ad = i.isim.toLowerCase()

            if(ad.contains(girilenVeri.toString())){
                arananlar.add(i)
            }
        }

        myAdapter.setFilter(arananlar)

        return true
    }
*/

}
