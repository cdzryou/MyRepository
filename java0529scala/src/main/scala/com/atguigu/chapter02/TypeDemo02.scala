package com.atguigu.chapter02

/*
  * @author 游正荣
  * @create 2020-01-19 17:32
  */
object TypeDemo02 {

  //比如开发中， 我们有一个方法， 就会异常中断， 这时就可以返回 Nothing
  //即当我们 Nothing 做返回值， 就是明确说明该方法没有没有正常返回值
  def sayHello: Nothing = {
    throw new Exception("抛出异常")
  }

  def main(args: Array[String]): Unit = {
    println(sayHello)
  }
}
