package com.andrejzdravev.task

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.andrejzdravev.task.adapter.CustomViewHolder.Companion.FACTS_DATA
import com.andrejzdravev.task.model.All
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val all = intent.extras!!.getSerializable(FACTS_DATA) as? All

        factTextDetails.text = all!!.text
        factAuthor.text = resources.getString(R.string.name_surname, all.user.name.first, all.user.name.last)
        factVotes.text = resources.getString(R.string.fact_votes, all.upvotes.toString())
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}