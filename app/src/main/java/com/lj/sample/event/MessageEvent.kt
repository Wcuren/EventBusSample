package com.lj.sample.event

class MessageEvent (msg: String){
    var message: String = msg
    get() = field.toUpperCase()
    set(value) {
        field = value
    }

}