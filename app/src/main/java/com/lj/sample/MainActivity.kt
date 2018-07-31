package com.lj.sample

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.lj.sample.event.FirstEvent
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity : AppCompatActivity() {

    private var btn: Button ?= null
    private var tv: TextView ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initview()
        EventBus.getDefault().register(this)
    }
    fun initview() {
        btn = findViewById(R.id.btn)
        tv = findViewById(R.id.tv)
        btn!!.setOnClickListener({  // !!双感叹号表示btn为空时抛出异常
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(intent)
        })
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessage(event : FirstEvent) {
        tv!!.text = event.message
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }
}
