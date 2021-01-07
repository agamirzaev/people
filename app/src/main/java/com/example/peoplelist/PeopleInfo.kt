package com.example.peoplelist

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.example.peoplelist.adapter.AdapterPeopleList
import com.example.peoplelist.data.model.Results
import com.example.peoplelist.mvp.peopleInfo.PeopleInfoContract
import com.example.peoplelist.mvp.peopleInfo.PeopleInfoPresenter
import kotlinx.android.synthetic.main.activity_people_info.*

class PeopleInfo : AppCompatActivity(), PeopleInfoContract.View {

    private lateinit var presenter: PeopleInfoPresenter

    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_people_info)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.toolbarInfoUserActivity)

        val url = intent.getStringExtra(AdapterPeopleList.URL).toString()

        presenter = PeopleInfoPresenter((application as App).dataManager!!)
        presenter.attachView(this)
        presenter.loadUserInfo(url)
    }

    @SuppressLint("SetTextI18n")
    override fun showUserInfo(results: Results) {

        name_info.text = results.getName().toString()
        heights_info.text = "рост. " + results.getHeight().toString()
        mass_info.text = "вес. " + results.getMass().toString()

        additional.text = "Дополнительная информация:"

        eye_color.text = "цвет глаз. " + results.getEyeColor().toString()
        skin_color.text = "цвет кожи. " + results.getSkinColor().toString()
        birth_year.text = "год рождения. " + results.getBirthYear().toString()

        getGender(results)
    }

    private fun getGender(results: Results) {
        when {
            results.getGender() == "male" -> {
                gender_info.text = "пол. Мужской"
            }
            results.getGender() == "female" -> {
                gender_info.text = "пол. Женский"
            }
            else -> {
                gender_info.text = "пол. n/a"
            }
        }
    }

    override fun showProgress() {
        progressBarInfoUser!!.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBarInfoUser!!.visibility = View.GONE
    }

    override fun noConnection() {
        noConnectionInfoUser!!.visibility = View.VISIBLE
    }
}