package com.lj.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.lj.sample.event.MessageEvent
import org.greenrobot.eventbus.EventBus

class SecondActivity : AppCompatActivity() {

    private var btn : Button ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        btn = findViewById(R.id.btn_second)
        btn!!.setOnClickListener({responseClick()})
    }

    private fun responseClick() {
        val event = MessageEvent("接受事件！")
        EventBus.getDefault().post(event)
        finish()
    }
}