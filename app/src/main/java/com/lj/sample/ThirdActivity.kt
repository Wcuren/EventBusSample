package com.lj.sample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.lj.sample.event.FirstEvent
import com.lj.sample.event.SecondEvent
import org.greenrobot.eventbus.EventBus

class ThirdActivity : AppCompatActivity() {

    private var btn : Button ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        btn = findViewById(R.id.btn_third)
        btn!!.setOnClickListener({responseClick()})
    }

    private fun responseClick() {
        EventBus.getDefault().post(FirstEvent("first event!"))
        Thread({
            EventBus.getDefault().post(SecondEvent("second event!"))
        }).start()
        finish()
    }
}
