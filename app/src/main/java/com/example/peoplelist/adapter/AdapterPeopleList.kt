package com.example.peoplelist.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.peoplelist.PeopleInfo
import com.example.peoplelist.R
import com.example.peoplelist.data.model.Results
import kotlinx.android.synthetic.main.item_all_people.view.*

class AdapterPeopleList(private var results: ArrayList<Results?>?) :
    RecyclerView.Adapter<AdapterPeopleList.ViewHolder>() {

    companion object {
        const val URL: String = "URL"
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterPeopleList.ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_all_people, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return results!!.size
    }

    fun addData(result: ArrayList<Results?>?) {
        for (items in result!!) {
            results!!.add(items)
        }
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: AdapterPeopleList.ViewHolder, position: Int) {
        val results = results?.get(position)
        results?.let { holder.bind(it) }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @SuppressLint("SetTextI18n")
        fun bind(result: Results) {

            getGender(result)

            itemView.name.text = result.getName()
            itemView.heights.text = "рост. " + result.getHeight()
            itemView.mass.text = "вес. " + result.getMass()

            itemView.setOnClickListener { it ->
//                val intent = Intent(itemView.context, PeopleInfo::class.java)
//                intent.putExtra(URL, result.getUrl().toString())
//                itemView.context.startActivity(intent)
            }
        }

        private fun getGender(results: Results) {
            when {
                results.getGender() == "male" -> {
                    itemView.gender.text = "пол. Мужской"
                }
                results.getGender() == "female" -> {
                    itemView.gender.text = "пол. Женский"
                }
                else -> {
                    itemView.gender.text = "пол. n/a"
                }
            }
        }
    }
}