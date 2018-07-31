package com.lj.sample

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import com.lj.sample.event.FirstEvent
import com.lj.sample.event.SecondEvent
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class SecondActivity : AppCompatActivity() {

    private var btn : Button ?= null
    private var tv : TextView ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        EventBus.getDefault().register(this)
        btn = findViewById(R.id.btn_second)
        tv = findViewById(R.id.tv_second)
        btn!!.setOnClickListener({responseClick()})
    }

    private fun responseClick() {
//        val event = FirstEvent("接受事件！")
//        EventBus.getDefault().post(event)
//        finish()
        startActivity(Intent(this, ThirdActivity::class.java))
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessage(msg : SecondEvent) {
        tv!!.text = msg.message
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }
}