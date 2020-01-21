package com.atguigu.chapter05

/*
  * @author 游正荣
  * @create 2020-01-21 14:52
  */
object LazyDemo01 {

  //sum 函数， 返回和
  def sum(i: Int, i1: Int): Int = {
    println("sum()执行了...")
    i + i1
  }


  def main(args: Array[String]): Unit = {
    lazy val res = sum(10, 20)
    println("---------------")
    println("res=" + res) //在要使用res前，才执行
  }
}
