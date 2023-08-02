package com.example.viewbindinglesson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.viewbindinglesson.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val users =
        listOf("String", "String", "Strinsefefg", "Strisefeng", "String", "String", "String", "String")
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.user = User(1, "Mustafa","Berk")
        binding.adapterKullaniciListesi = UsersAdapter(this, users)

        //binding.tvInformation?.text = "blablabla"

        ///binding.rvUsers.adapter = UsersAdapter(this, users)


    }
}