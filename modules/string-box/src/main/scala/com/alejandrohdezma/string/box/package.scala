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

  /** Creates a table from a list of rows.
    *
    * @example
    *
    * {{{
    * val rows = List(
    *   List("Users", "Count"),
    *   List("John", "10"),
    *   List("Jane", "20"),
    *   List("Jim", "30"),
    *   List("Jill", "40")d
    * )
    *
    * table(rows, "The footer")
    * // res0: String =
    * // ┌───────┬───────┐
    * // │ Users │ Count │
    * // ├───────┼───────┤
    * // │ Jane  │ 20    │
    * // │ Jill  │ 40    │
    * // │ Jim   │ 30    │
    * // │ John  │ 10    │
    * // ├───────┴───────┤
    * // │ The footer    │
    * // └───────────────┘
    * }}}
    *
    * @param rows
    *   the list of rows
    * @param footer
    *   the footer
    *
    * @return
    *   the table
    */
  def table(rows: List[List[String]], footer: String = "") = {
    def padRow(row: List[String], maxSizePerColumn: List[Int]) =
      row.zip(maxSizePerColumn).map { case (cell, size) => cell.padTo(size, ' ') }

    val maxSizePerColumn = rows.transpose.map(_.map(_.length).max)

    val topBorder = s"┌─${maxSizePerColumn.map("─" * _).mkString("─┬─")}─┐"

    val headerRow = s"│ ${padRow(rows.head, maxSizePerColumn).mkString(" │ ")} │"

    val separator = s"├─${maxSizePerColumn.map("─" * _).mkString("─┼─")}─┤"

    val dataRows = rows.tail.map(row => s"│ ${padRow(row, maxSizePerColumn).mkString(" │ ")} │").sorted

    val footerSection = if (footer.nonEmpty) {
      val footerSeparator = s"├─${maxSizePerColumn.map("─" * _).mkString("─┴─")}─┤"

      val totalWidth = maxSizePerColumn.sum + (maxSizePerColumn.length - 1) * 3

      val footerRows =
        if (totalWidth > footer.length)
          List(s"│ ${footer.padTo(totalWidth, ' ')} │")
        else
          footer.grouped(totalWidth).map(s => s"│ ${s.padTo(totalWidth, ' ')} │").toList

      List(footerSeparator) ++ footerRows
    } else List.empty

    val bottomBorder =
      if (footer.nonEmpty)
        s"└─${maxSizePerColumn.map("─" * _).mkString("───")}─┘"
      else
        s"└─${maxSizePerColumn.map("─" * _).mkString("─┴─")}─┘"

    (List(topBorder, headerRow, separator) ++ dataRows ++ footerSection ++ List(bottomBorder)).mkString("\n")
  }

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
