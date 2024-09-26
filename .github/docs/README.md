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

## Contributors to this project 

@CONTRIBUTORS_TABLE@
