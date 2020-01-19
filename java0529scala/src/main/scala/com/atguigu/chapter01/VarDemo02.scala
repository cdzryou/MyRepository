package com.atguigu.chapter01

/*
  * @author 游正荣
  * @create 2020-01-19 17:12
  */
object VarDemo02 {
  def main(args: Array[String]): Unit = {
    //类型推导
    var num = 10 //这时num就是Int
    //方式一，可以利用idea的提示来证明，给出提示
    //方式 2， 使用 isInstanceOf[Int]判断
    println(num.isInstanceOf[Int])

    //类型确定后， 就不能修改， 说明 Scala 是强数据类型语言()
    //num = 2.3,错误

    //3.在声明/定义一个变量时， 可以使用 var 或者 val 来修饰， var 修饰的变量可改变， val 修饰的变量不可改
    var age = 10 //即 age 是可以改变的
    age = 30 //ok

    val num2 = 30
    //num2 = 10// val 修饰的变量是不可以改变

    //scala 设计者为什么设计 var 和 val
  }
}
