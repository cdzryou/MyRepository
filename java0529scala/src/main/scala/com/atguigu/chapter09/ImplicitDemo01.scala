package com.atguigu.chapter09

/*
  * @author 游正荣
  * @create 2020-02-02 9:57
  */
object ImplicitDemo01 {

  def main(args: Array[String]): Unit = {
    //编写一个隐式函数转成 Double->Int 转换
    //隐式函数应当在作用域才能生效
    implicit def f1(d: Double): Int = {
      d.toInt
    }

    implicit def f2(f: Float): Int = {
      f.toInt
    }

    val num: Int = 3.5 // 底层编译 f1$1(3.5)
    val num2: Int = 4.5f //
    println("num =" + num)
  }

}
