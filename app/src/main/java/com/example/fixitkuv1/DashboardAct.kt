package com.example.fixitkuv1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fixitkuv1.databinding.ActivityDashboardBinding

class DashboardAct : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}