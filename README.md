Simple utility to create nice boxed strings

## Installation

Add the following line to your build.sbt file:

```sbt
libraryDependencies += "com.alejandrohdezma" %% "string-box" % "2.2.0"
```

## Usage

Add the following import to unblock the syntax:

```scala
import com.alejandrohdezma.string.box._
```

And then use `.boxed` method on any `String` value you want to get wrapped in a box:

```scala
"\n" + "Hello,\nworld!".boxed
// res0: String = """
// ┌────────┐
// │ Hello, │
// │ world! │
// └────────┘"""
```

```scala
"\n" + "Hello,\nworld!\nI'm a very long string that should be wrapped in a box".boxed
// res1: String = """
// ┌────────────────────────────────────────────────────────┐
// │ Hello,                                                 │
// │ world!                                                 │
// │ I'm a very long string that should be wrapped in a box │
// └────────────────────────────────────────────────────────┘"""
```

`boxed` takes ANSI colors (from `scala.io.AnsiColor`) into account, so they're not counted when calculating the width of the box.

Additionally, you can use `table` method to create a table from a list of rows:

```scala
"\n" + table(List(
  List("Users", "Count"),
  List("John", "10"),
  List("Jane", "20"),
  List("Jim", "30"),
  List("Jill", "40")
), "The footer")
// res2: String = """
// ┌───────┬───────┐
// │ Users │ Count │
// ├───────┼───────┤
// │ Jane  │ 20    │
// │ Jill  │ 40    │
// │ Jim   │ 30    │
// │ John  │ 10    │
// ├───────┴───────┤
// │ The footer    │
// └───────────────┘"""
```

```scala
"\n" + table(List(
  List("Users", "Count", "Age"),
  List("John", "10", "20"),
  List("Jane", "20", "30"),
  List("Jim", "30", "40"),
  List("Jill", "40", "50")
))
// res3: String = """
// ┌───────┬───────┬─────┐
// │ Users │ Count │ Age │
// ├───────┼───────┼─────┤
// │ Jane  │ 20    │ 30  │
// │ Jill  │ 40    │ 50  │
// │ Jim   │ 30    │ 40  │
// │ John  │ 10    │ 20  │
// └───────┴───────┴─────┘"""
```

## Contributors to this project 

| <a href="https://github.com/alejandrohdezma"><img alt="alejandrohdezma" src="https://avatars.githubusercontent.com/u/9027541?v=4&s=120" width="120px" /></a> |
| :--: |
| <a href="https://github.com/alejandrohdezma"><sub><b>alejandrohdezma</b></sub></a> |
