package com.example.fixitkuv1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fixitkuv1.databinding.ActivityLoginBinding
import com.example.fixitkuv1.databinding.ActivityRegisterBinding

class RegisterAct: AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}