package com.example.fixitkuv1.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.example.fixitkuv1.databinding.ActivityMaterimainviewBinding

class MateriAct: AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMaterimainviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMaterimainviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}