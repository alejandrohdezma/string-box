Simple utility to create nice boxed strings

## Installation

Add the following line to your build.sbt file:

```sbt
libraryDependencies += "com.alejandrohdezma" %% "string-box" % "1.0.0"
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

## Contributors to this project 

| <a href="https://github.com/alejandrohdezma"><img alt="alejandrohdezma" src="https://avatars.githubusercontent.com/u/9027541?v=4&s=120" width="120px" /></a> |
| :--: |
| <a href="https://github.com/alejandrohdezma"><sub><b>alejandrohdezma</b></sub></a> |
