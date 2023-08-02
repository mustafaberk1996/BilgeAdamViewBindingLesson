package com.example.viewbindinglesson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.example.viewbindinglesson.databinding.ActivitySahibindenBinding

class SahibindenActivity : AppCompatActivity() {


    val categories = listOf(
        Category(name = "Emlak", subTitle =  "konut, isyeri arsa"),
        Category(name = "Vasita", subTitle =  "arac, SUV, arazi araci motosiklet deniz araclar, hasarli araclar"),
        Category(name = "Yedek Parca Aksesuar", subTitle =  "Otomotiv Ekipmanları Motosiklet Ekipmanları Deniz Aracı Ekipmanları"),
        Category(name = "İkinci El ve Sıfır Alışveriş", subTitle =  "Bilgisayar Cep Telefonu Fotoğraf & Kamera Ev Dekorasyon Ev Elektroniği Elektrikli Ev Aletleri Giyim & Aksesuar Saat Anne & Bebek Kişisel Bakım & Kozmetik"),
        Category(name = "İş Makineleri & Sanayi ", subTitle =  "İş Makineleri Tarım Makineleri Sanayi Elektrik & Enerji"),
        Category(name = "Ustalar ve Hizmetler", subTitle =  "Ev Tadilat & Dekorasyon Nakliye Araç Servis & Bakım"),
        Category(name = "Özel Ders Verenler", subTitle =  "Lise & Üniversite İlkokul & Ortaokul Yabancı Dil"),
    )

    private lateinit var binding:ActivitySahibindenBinding
    lateinit var adapter:CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySahibindenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = CategoryAdapter(this, categories)
        binding.rvCategories.adapter = adapter

        binding.etSearch.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                println("beforeTextChanged: $s")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (!s.isNullOrEmpty()){
                    val filteredList = categories.filter { it.name.contains(s.toString(),true) || it.subTitle.contains(s.toString(), true)  }
                    adapter.updateList(filteredList)
                }else{
                    adapter.updateList(categories)
                }
                adapter.notifyDataSetChanged()
            }

            override fun afterTextChanged(s: Editable?) {
                println("afterTextChanged: ${s.toString()}")
            }

        })


    }


}