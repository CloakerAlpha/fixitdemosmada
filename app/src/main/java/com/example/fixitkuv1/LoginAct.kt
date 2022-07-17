package com.example.fixitkuv1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.example.fixitkuv1.databinding.ActivityLoginBinding

class LoginAct: AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onClick(v: View) {
        val btn_id = v.id
        when (btn_id) {
            R.id.btn_login -> login()
            R.id.btn_register -> {
                val goToRegisterPage = Intent(this@LoginAct, RegisterAct::class.java)
                startActivity(goToRegisterPage)
            }
        }
    }

    private fun login(){

        /*val usernameL = bindingLoginAct.usernameET.text.toString()
        val passwordL = bindingLoginAct.passwordET.text.toString()

        val client: Call<ResponseUserLogin>? = RetrofitApiConfig.ApiConfig.getApiService().login(usernameL, passwordL)
        client?.enqueue(object : Callback<ResponseUserLogin> {
            override fun onResponse(
                call: Call<ResponseUserLogin>,
                response: Response<ResponseUserLogin>
            ) {
                if (response.isSuccessful) {
                    Log.e(TAG, "userStatus: ${response.body()}")
                    if(!response.body()?.message?.equals("Invalid username or password")!!){
                        showToast(getString(R.string.LoginSuccess))
                        sessionManager.isLoggedIn(SESSION_TOKEN,true)
                        startActivity(Intent(this@LoginAct, DashboardAct::class.java))
                        finish()

                    }else{
                        showToast(getString(R.string.LoginFailed))
                    }

                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<ResponseUserLogin>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}")
            }

        })
*/
    }

}