package com.example.fixitkuv1.view

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fixitkuv1.R
import com.example.fixitkuv1.databinding.ActivityRegisterBinding
import com.example.fixitkuv1.responses.ResponseLoginData
import com.fakkaru.seani.apis.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterAct: AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_registered -> {
                register()
            }
        }
    }

    private fun register(){

        val usernameR = binding.etiRegUsername.text.toString()
        val emailR = binding.etiRegEmail.text.toString()
        val passwordR = binding.etiRegPassword.text.toString()
        val kelasR = binding.etiRegClass.text.toString()
        val nomorsiswaR = binding.etiRegNis.text.toString().toIntOrNull()
        var tipeR = "user"
        //val tipeR = binding.etiRegUsername.text.toString()

        val client: Call<ResponseLoginData>? =
            ApiConfig.ApiConfig.getApiService().signup(usernameR, emailR, passwordR, kelasR, nomorsiswaR, tipeR)
        client?.enqueue(object : Callback<ResponseLoginData> {
            override fun onResponse(
                call: Call<ResponseLoginData>,
                response: Response<ResponseLoginData>
            ) {
                if (response.isSuccessful) {
                    Log.e(ContentValues.TAG, "userStatus: ${response.body()}")
                    if(!response.body()?.message?.equals("User registered successfully")!!){
                        showToast(getString(R.string.LoginBerhasil))
                        //sessionManager.isLoggedIn(SESSION_TOKEN,true)
                        val goToLoginPage = Intent(this@RegisterAct, LoginAct::class.java)
                        startActivity(goToLoginPage)
                        finish()

                    }else{
                        showToast(getString(R.string.RegistrasiGagal))
                    }

                } else {
                    Log.e(ContentValues.TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<ResponseLoginData>, t: Throwable) {
                Log.e(ContentValues.TAG, "onFailure: ${t.message}")
            }

        })

    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}