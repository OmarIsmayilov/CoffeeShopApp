package com.example.coffeeshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.coffeeshop.databinding.ActivityLoginBinding
import com.example.coffeeshop.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnLogin.setOnClickListener {
            val name = binding.etName.text.toString().trim()
            val pass = binding.etPass.text.toString().trim()


            if(name.isNotEmpty() && pass.isNotEmpty()){
                startActivity(Intent(this,MainActivity::class.java))
                finish()
            }else{
                Toast.makeText(applicationContext,"Please fill the blank areas⚠", Toast.LENGTH_LONG).show()
            }


        }
    }
}