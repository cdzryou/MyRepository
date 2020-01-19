package com.atguigu.chapter01

object TestPrint {
  def main(args: Array[String]): Unit = {
    //使用+
    var name: String = "tom"
    val sal: Double = 1.2
    println("hello" + sal + name)
    Predef
    //使用格式化的方式printf
    printf("name=%s sal=%f\n", name, sal)

    //使用$引用的方式，输出变量，类似PHP
    println(s"第三种方式 name=$name sal=${sal + 1}")
  }
}
