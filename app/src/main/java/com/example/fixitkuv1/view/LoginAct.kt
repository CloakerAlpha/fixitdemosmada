package com.example.fixitkuv1.view

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.example.fixitkuv1.R
import com.example.fixitkuv1.databinding.ActivityLoginBinding
import com.example.fixitkuv1.responses.ResponseLoginData
import com.example.fixitkuv1.responses.User
import com.example.fixitkuv1.sharedpref.FixAppClassSession.Companion.sessionManager
import com.example.fixitkuv1.sharedpref.SessionManager
import com.example.fixitkuv1.sharedpref.SessionManager.Companion.SESSION_TOKEN
import com.example.fixitkuv1.view.LoginAct.Companion.USERDATA
import com.fakkaru.seani.apis.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginAct: AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sessionManager = SessionManager(_context = applicationContext)
        //check loggedin or not
        if(sessionManager.getLogInStatus(SESSION_TOKEN)){
            finish()
            startActivity(Intent(this@LoginAct, DashboardAct::class.java))
        } else { //stay in login page
        }

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_login -> login()
            R.id.btn_register -> {
                val goToRegisterPage = Intent(this@LoginAct, RegisterAct::class.java)
                startActivity(goToRegisterPage)
            }
        }
    }

    private fun login(){

        val usernameL = binding.namaET.text.toString()
        val passwordL = binding.katasandiET.text.toString()

        val client: Call<ResponseLoginData>? =ApiConfig.ApiConfig.getApiService().login(usernameL, passwordL)
        client?.enqueue(object : Callback<ResponseLoginData> {
            override fun onResponse(
                call: Call<ResponseLoginData>,
                response: Response<ResponseLoginData>
            ) {
                if (response.isSuccessful) {
                    Log.e(TAG, "userStatus: ${response.body()}")

                    val nama = response.body()?.user?.nama.toString()
                    val email = response.body()?.user?.email.toString()
                    val kelas = response.body()?.user?.kelas.toString()
                    val nomorsiswa = response.body()?.user?.nomorsiswa.toString()
                    val tipe = response.body()?.user?.nama.toString()

                    if(!response.body()?.message?.equals("Invalid nama or password")!!){
                        showToast(getString(R.string.LoginBerhasil))

                        sessionManager.isLoggedIn(SESSION_TOKEN,true)
                        sessionManager.saveString("nama",nama)
                        sessionManager.saveString("email", email)
                        sessionManager.saveString("kelas", kelas)
                        sessionManager.saveString("nomorsiswa",nomorsiswa)
                        sessionManager.saveString("tipe", tipe)

                        startActivity(Intent(this@LoginAct, DashboardAct::class.java))
                        finish()

                    }else{
                        showToast(getString(R.string.LoginGagal))
                    }

                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<ResponseLoginData>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}")
            }

        })

    }

    private fun showUserData(data: User) {
        val goUserPage = Intent(this, DashboardAct::class.java)
        goUserPage.putExtra(DashboardAct.USERDATA, data)
        startActivity(goUserPage)
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    companion object{
        const val USERDATA = "parcelized_userdata"
    }

}