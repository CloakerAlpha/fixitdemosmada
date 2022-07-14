package com.example.fixitkuv1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.example.fixitkuv1.databinding.ActivityLoginBinding

class LoginAct: AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            val goToRegisterPage = Intent(this@LoginAct, RegisterAct::class.java)
            startActivity(goToRegisterPage)
        }

    }

}