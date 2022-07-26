package com.example.fixitkuv1.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fixitkuv1.R
import com.example.fixitkuv1.databinding.FragmentAccountDetailBinding
import com.example.fixitkuv1.sharedpref.FixAppClassSession
import com.example.fixitkuv1.view.LoginAct

class AccountDetailFrag : Fragment() {

    private var _binding: FragmentAccountDetailBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //modifying view here will not change the value, do it on oncreateview

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentAccountDetailBinding.inflate(layoutInflater)
        // after inflate, do ur code to modify the layout so the data can be displayed
        val namaSiswa = FixAppClassSession.sessionManager.getString("nama", )
        _binding?.etiDetailUsername?.setText(namaSiswa)
        _binding?.tvTestdata?.text = namaSiswa

        _binding!!.btnOut.setOnClickListener {
            FixAppClassSession.sessionManager.clearSession()
            val thisActivity: Activity? = activity
            if (thisActivity != null) {
                startActivity(Intent(thisActivity, LoginAct::class.java)) // if needed
                thisActivity.finish()
            }
            Log.d("btnLogout", "SIGNED OUT")
        }

        return binding.root



    }
}