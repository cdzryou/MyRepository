package com.atguigu.chapter01

/*
  * @author 游正荣
  * @create 2020-01-19 16:47
  */
object VarDemo01 {
  def main(args: Array[String]): Unit = {
    var age: Int = 10
    var sal: Double = 10.9
    var name: String = "tom"
    var isPass: Boolean = true
    //在 scala 中， 小数默认为 Double ,整数默认为 Int
    var score: Float = 70.9f
    println(s"${age} ${isPass}")
  }
}
