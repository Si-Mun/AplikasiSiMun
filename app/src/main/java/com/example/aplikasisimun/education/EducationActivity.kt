package com.example.aplikasisimun.education

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasisimun.R
import com.example.aplikasisimun.adapter.ListEducationAdapter

import com.example.aplikasisimun.data.Education


class EducationActivity : AppCompatActivity() {

    private lateinit var rvEducation: RecyclerView
    private val listEdu = ArrayList<Education>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_education)


        rvEducation = findViewById(R.id.rv_education)
        rvEducation.setHasFixedSize(true)
        listEdu.addAll(getListEducation())
        showRecyclerList()

    }

    private fun getListEducation(): ArrayList<Education>{
        val dataTitle = resources.getStringArray(R.array.title_education)
        val dataDesctiption = resources.getStringArray(R.array.description_education)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)

        val listEducation = ArrayList<Education>()
        for (i in dataTitle.indices) {
            val education = Education( dataTitle[i], dataDesctiption[i], dataPhoto.getResourceId(i, -1))
            listEducation.add(education)
        }
        return listEducation
    }
    private fun showRecyclerList(){
        rvEducation.layoutManager = LinearLayoutManager(this)
        val listEducationAdapter = ListEducationAdapter(listEdu)
        rvEducation.adapter = listEducationAdapter
    }

}