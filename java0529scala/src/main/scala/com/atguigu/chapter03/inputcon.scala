package com.atguigu.chapter03

import scala.io.StdIn

/*
  * @author 游正荣
  * @create 2020-01-21 10:19
  */
object inputcon {
  def main(args: Array[String]): Unit = {
    println("请输入姓名:")
    val name = StdIn.readLine()
    println("请输入年龄:")
    val age = StdIn.readInt()
    println("请输入薪水:")
    val sal = StdIn.readDouble()
    printf("用户的信息为 name=%s age=%d sal=%.3f",name,age,sal)
  }
}
