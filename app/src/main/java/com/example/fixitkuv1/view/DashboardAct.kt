package com.example.fixitkuv1.view

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.fixitkuv1.R
import com.example.fixitkuv1.adapters.AdapterDashboardMateri
import com.example.fixitkuv1.databinding.ActivityDashboardBinding
import com.example.fixitkuv1.dataclasses.DataModelUser
import com.example.fixitkuv1.fragments.AccountDetailFrag
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener

class DashboardAct : AppCompatActivity() {

    /*var sampleImages = arrayOf(
        "https://raw.githubusercontent.com/sayyam/carouselview/master/sample/src/main/res/drawable/image_3.jpg",
        "https://raw.githubusercontent.com/sayyam/carouselview/master/sample/src/main/res/drawable/image_1.jpg",
        "https://raw.githubusercontent.com/sayyam/carouselview/master/sample/src/main/res/drawable/image_2.jpg"
    )*/
    var sampleImages = intArrayOf(
        R.drawable.carouselv_1,
        R.drawable.carouselv_2,
        R.drawable.carouselv_3,
        R.drawable.carouselv_4,
        R.drawable.carouselv_5
    )

    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val namaSiswa = FixAppClass.sessionManager.getString("nama")
        //binding.tvDashboardmembers.text = namaSiswa

        binding.botnav1.setOnItemSelectedListener { item ->
            val fragment: Fragment?
            when (item.itemId) {
                R.id.botnav_account -> {
                    //toolbar?.setTitle("Home")
                    fragment = AccountDetailFrag()
                    loadFragment(fragment)
                    true
                }
                R.id.botnav_home -> {
                    //onBackPressed()
                    true

                }

                else -> false
            }

        }

        binding.botnav1.setOnItemReselectedListener { item ->
            when (item.itemId) {
                R.id.botnav_account -> {
                    Toast.makeText(this, "ACCOUNT PAGE Item reselected", Toast.LENGTH_SHORT).show()
                }
                R.id.botnav_home -> {
                    Toast.makeText(this, "HOME PAGE reselected", Toast.LENGTH_SHORT).show()
                }
            }
        }

        val carouselView = findViewById<CarouselView>(R.id.carouselView)
        carouselView?.pageCount = sampleImages.size
        carouselView?.setImageListener(imageListener)

        val listDetailMateri = listOf(
            DataModelUser(gambar = R.drawable.gambar_coversmada,
                judulmateri = "FOTOGRAFI",
                deskripsimateri = "Fotografi adalah ...",
                linkmateri = "shorturl.at/acgtX"),
            DataModelUser(gambar = R.drawable.gambar_coversmada,
                judulmateri = "FOTOGRAFI",
                deskripsimateri = "Fotografi (bahasa Inggris: photography ...",
                linkmateri = "shorturl.at/aBC46"),
            DataModelUser(gambar = R.drawable.gambar_coversmada,
                judulmateri = "VIDEOGRAFI",
                deskripsimateri = "Sederhananya, videografi adalah proses ...",
                linkmateri = "shorturl.at/aBC46"),
            DataModelUser(gambar = R.drawable.gambar_coversmada,
                judulmateri = "VIDEOGRAFI",
                deskripsimateri = "Sederhananya, videografi adalah proses ...",
                linkmateri = "shorturl.at/aBC46"),
            DataModelUser(gambar = R.drawable.gambar_coversmada,
                judulmateri = "E-SPORTS",
                deskripsimateri = "Perlombaan games antar member ekstra ...",
                linkmateri = "shorturl.at/fnwY1"),
            DataModelUser(gambar = R.drawable.gambar_coversmada,
                judulmateri = "E-SPORTS",
                deskripsimateri = "Perlombaan games antar member ekstra ...",
                linkmateri = "shorturl.at/fnwY1"),
            DataModelUser(gambar = R.drawable.gambar_coversmada,
                judulmateri = "DESAIN GRAFIS",
                deskripsimateri = " Desain grafis salah satu bentuk seni ...",
                linkmateri = "shorturl.at/cKLN3"),
            DataModelUser(gambar = R.drawable.gambar_coversmada,
                judulmateri = "DESAIN GRAFIS",
                deskripsimateri = " Desain grafis salah satu bentuk seni ...",
                linkmateri = "shorturl.at/cKLN3"),
            DataModelUser(gambar = R.drawable.gambar_coversmada,
                judulmateri = "PEMROGRAMAN",
                deskripsimateri = "Pemrograman adalah suatu seni dalam ...",
                linkmateri = "shorturl.at/HPY37"),
            DataModelUser(gambar = R.drawable.gambar_coversmada,
                judulmateri = "PEMROGRAMAN",
                deskripsimateri = "Pemrograman adalah suatu seni dalam ...",
                linkmateri = "shorturl.at/HPY37")
        )

        binding.recView1.layoutManager = LinearLayoutManager(applicationContext)
        val adapter = AdapterDashboardMateri(listDetailMateri)
        binding.recView1.adapter = adapter

        adapter.setOnItemClickCallback(object : AdapterDashboardMateri.OnItemClickCallback {
            override fun onItemClicked(datas: DataModelUser) {
                //showSubjectData(datas)
            }
        })

        Glide.with(this@DashboardAct).load(R.drawable.ava1a)
            .override(125,125).into(binding.imgAvatar1)
        Glide.with(this@DashboardAct).load(R.drawable.ava1a)
            .override(125,125).into(binding.imgAvatar2)
        Glide.with(this@DashboardAct).load(R.drawable.ava1a)
            .override(125,125).into(binding.imgAvatar3)
        Glide.with(this@DashboardAct).load(R.drawable.ava1a)
            .override(125,125).into(binding.imgAvatar4)
        Glide.with(this@DashboardAct).load(R.drawable.ava1a)
            .override(125,125).into(binding.imgAvatar5)

        Glide.with(this@DashboardAct).load(R.drawable.ava1a)
            .override(125,125).into(binding.imgAvatar6)
        Glide.with(this@DashboardAct).load(R.drawable.ava1a)
            .override(125,125).into(binding.imgAvatar7)
        Glide.with(this@DashboardAct).load(R.drawable.ava1a)
            .override(125,125).into(binding.imgAvatar8)
        Glide.with(this@DashboardAct).load(R.drawable.ava1a)
            .override(125,125).into(binding.imgAvatar9)
        Glide.with(this@DashboardAct).load(R.drawable.ava1a)
            .override(125,125).into(binding.imgAvatar10)
        Glide.with(this@DashboardAct).load(R.drawable.ava1a)
            .override(125,125).into(binding.imgAvatar11)
        Glide.with(this@DashboardAct).load(R.drawable.ava1a)
            .override(125,125).into(binding.imgAvatar12)
        Glide.with(this@DashboardAct).load(R.drawable.ava1a)
            .override(125,125).into(binding.imgAvatar13)
        Glide.with(this@DashboardAct).load(R.drawable.ava1a)
            .override(125,125).into(binding.imgAvatar14)
        binding.botnav1.selectedItemId = R.id.botnav_home
    }

    private var imageListener: ImageListener = ImageListener { position, imageView ->
        // You can use Glide or Picasso here
            Glide.with(this@DashboardAct).load(sampleImages[position]).into(imageView)
        }

    private fun showSubjectData(data: DataModelUser) {
        val goUserPage = Intent(this, MateriAct::class.java)
        //goUserPage.putExtra(MateriAct.USERDATA, data)
        startActivity(goUserPage)
    }

    private fun loadFragment(fragment: Fragment) {
        // load fragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_dashboard, fragment)
            .commit()
    }

    /*override fun onBackPressed() {
        if (fragmentManager.backStackEntryCount == 0) {
            finish()
        } else {
            fragmentManager.popBackStack()
        }
    }*/

    companion object{
        const val USERDATA = "parcelized_userdata"
    }

}