package com.example.fixitkuv1.sharedpref

import android.content.Context
import android.content.SharedPreferences

class SessionManager(_context: Context) {
    internal var pref : SharedPreferences
    internal var editor: SharedPreferences.Editor
    internal var PRIVATE_MODE = 0

    init {
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        editor = pref.edit()
    }

    fun isLoggedIn(key: String, value: Boolean){
        editor.putBoolean(key, value)
        editor.commit()
    }

    fun getLogInStatus(key: String): Boolean{
        return pref.getBoolean(key, false)

    }

    fun clearSession() {
        editor.clear()
        editor.commit()
    }

    fun saveInteger(key: String, value: Int) {
        editor.putInt(key, value)
        editor.commit()
    }

    fun getInteger(key: String): Int {
        return pref.getInt(key, 0)
    }

    fun saveString(key: String, value: String) {
        editor.putString(key, value)
        editor.commit()
    }

    fun getString(key: String): String? {
        return pref.getString(key, "")
    }

    fun removeSession(string: String){
        editor.remove(string).commit()
    }

    companion object {
        private val PREF_NAME = "fixapp_session"
        val tipe: String = ""
        val nis: String = ""
        val kelas: String = ""
        val email: String = ""
        val nama: String = ""

        val SESSION_TOKEN = "token"
        //  val NAMA = "nama"
        // val EMAIL = "email"
        // val KELAS = "kelas"
        // val NIS = "nomorsiswa"
        //val TIPE = "nomorsiswa"
    }
}