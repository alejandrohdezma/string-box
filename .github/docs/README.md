@DESCRIPTION@

## Installation

Add the following line to your build.sbt file:

```sbt
libraryDependencies += "@ORGANIZATION@" %% "@NAME@" % "@VERSION@"
```

## Usage

Add the following import to unblock the syntax:

```scala mdoc
import com.alejandrohdezma.string.box._
```

And then use `.boxed` method on any `String` value you want to get wrapped in a box:

```scala mdoc
"\n" + "Hello,\nworld!".boxed
```

```scala mdoc
"\n" + "Hello,\nworld!\nI'm a very long string that should be wrapped in a box".boxed
```

`boxed` takes ANSI colors (from `scala.io.AnsiColor`) into account, so they're not counted when calculating the width of the box.

Additionally, you can use `table` method to create a table from a list of rows:

```scala mdoc
"\n" + table(List(
  List("Users", "Count"),
  List("John", "10"),
  List("Jane", "20"),
  List("Jim", "30"),
  List("Jill", "40")
), "The footer")
```

```scala mdoc
"\n" + table(List(
  List("Users", "Count", "Age"),
  List("John", "10", "20"),
  List("Jane", "20", "30"),
  List("Jim", "30", "40"),
  List("Jill", "40", "50")
))
```

## Contributors to this project 

@CONTRIBUTORS_TABLE@
