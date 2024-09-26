/*
 * Copyright 2024 Alejandro Hernández <https://github.com/alejandrohdezma>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alejandrohdezma.string

import scala.io.AnsiColor._

package object box {

  implicit class StringBoxedOps(private val string: String) extends AnyVal {

    /** Returns the string wrapped in a box with the same width as the longest line.
      *
      * @example
      *
      * {{{
      * val string = "Hello\nWorld\mI'm a long line"
      *
      * string.boxed
      * // res0: String =
      * // ┌─────────────────┐
      * // │ Hello           │
      * // │ World           │
      * // │ I'm a long line │
      * // └─────────────────┘
      * }}}
      *
      * @note
      *   This method does not take into account the length of the ANSI colors
      *
      * @return
      *   the string wrapped in a box
      */
    def boxed: String = {
      val linesWithSizes = string.split('\n').map(s => (s, lineSizeWithoutAnsiColors(s))).toList

      val maxColumns = linesWithSizes.map(_._2).max

      val content =
        linesWithSizes.map { case (line, size) => s"│ $line${" ".repeat(maxColumns - size)} │" }.mkString("\n")

      s"┌─${"─".repeat(maxColumns)}─┐\n" + content + s"\n└─${"─".repeat(maxColumns)}─┘"
    }

  }

  private def lineSizeWithoutAnsiColors(line: String) = line
    .replace(BLACK, "")
    .replace(RED, "")
    .replace(GREEN, "")
    .replace(YELLOW, "")
    .replace(BLUE, "")
    .replace(MAGENTA, "")
    .replace(CYAN, "")
    .replace(WHITE, "")
    .replace(BLACK_B, "")
    .replace(RED_B, "")
    .replace(GREEN_B, "")
    .replace(YELLOW_B, "")
    .replace(BLUE_B, "")
    .replace(MAGENTA_B, "")
    .replace(CYAN_B, "")
    .replace(WHITE_B, "")
    .replace(RESET, "")
    .replace(BOLD, "")
    .replace(UNDERLINED, "")
    .replace(BLINK, "")
    .replace(REVERSED, "")
    .replace(INVISIBLE, "")
    .size

}
