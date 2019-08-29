package com.andrejzdravev.task

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.andrejzdravev.task.adapter.FactsAdapter
import com.andrejzdravev.task.`interface`.CommonResponseListener
import com.andrejzdravev.task.model.Factss
import com.andrejzdravev.task.network.NetworkCall
import com.andrejzdravev.task.network.WebUrls
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CommonResponseListener {

    private var adapter = FactsAdapter(emptyList())
    private val networkAccessor = NetworkCall()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        networkAccessor.commonNetworkCall(this@MainActivity, WebUrls.BASE_URL)
    }

    override fun onSuccessResponse(result: Factss?, code: Int) {
        if (result != null) {
            adapter = FactsAdapter(result.all)
            recyclerView.adapter = adapter
        }
    }

    override fun onError(msg: String) {}
}

