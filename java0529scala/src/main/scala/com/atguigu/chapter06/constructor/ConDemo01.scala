package com.atguigu.chapter06.constructor

/*
  * @author 游正荣
  * @create 2020-01-21 15:37
  */
object ConDemo01 {
  def main(args: Array[String]): Unit = {
    //    val p1 = new Person("jack", 20)
    //    println(p1)
    val p2 = new Person("tom")
    println(p2)
  }
}

class Person(inName: String, inAge: Int) {
  var name: String = inName
  var age: Int = inAge
  age += 10
  println("~~~~~~~~~~~~")

  override def toString: String = {
    "name=" + this.name + "\t age" + this.age
  }

  println("ok~~~~~~~")
  println("age=" + age)

  def this(name: String) {
    this("jack", 10)
    this.name = name
  }

}

class A() {

}
