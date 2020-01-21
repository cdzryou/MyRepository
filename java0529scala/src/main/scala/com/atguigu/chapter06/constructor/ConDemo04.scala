package com.atguigu.chapter06.constructor

/*
  * @author 游正荣
  * @create 2020-01-21 15:59
  */
object ConDemo04 {
  def main(args: Array[String]): Unit = {
    val worker = new Worker("smith")
    worker.name = "abc"
    println(worker.name)
    worker.name //不能访问 inName
    val worker2 = new Worker2("smith2")
    worker2.inName //可以访问 inName
    println(worker2.name)
    val worker3 = new Worker3("jack")
    worker3.inName = "mary"
    println(worker3.inName)
    println(worker3.name)
  }
} //1. 如果 主构造器是 Worker(inName: String) ， 那么 inName 就是一个局部变量
class Worker(inName: String) {
  var name = inName
} //. 如果 主构造器是 Worker2(val inName: String) ， 那么 inName 就是 Worker2 的一个 private 的只读属性
class Worker2(val inName: String) {
  var name = inName
} //如果 主构造器是 Worker3(var inName: String) ， 那么 inName 就是 Worker3 的一个
// 一个 private 的可以读写属性
class Worker3(var inName: String) {
  var name = inName
}
