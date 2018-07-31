# EventBusSample
EventBus使用笔记

使用三步骤：
1、定义一个事件实体类，作为发送和接受事件时传递数据的载体
class FirstEvent (msg: String){
    var message = msg
}

2、在接受事件的组件中声明订阅函数
@Subscribe(threadMode = ThreadMode.MAIN)
fun onMessage(event : FirstEvent) {

}

然后在组件的生命周期函数中函数注册和解注册订阅者
override fun onCreate(savedInstanceState: Bundle?) {
    EventBus.getDefault().register(this)
}

override fun onDestroy() {
    EventBus.getDefault().unRegister(this)
}

3、在订阅组件中发送事件
EventBus.getDefault().post(FirstEvent("message"))

进阶：
Subscribe注解
