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

package com.alejandrohdezma.string.box

import scala.io.AnsiColor._

import munit.FunSuite

class BoxedSuite extends FunSuite {

  test("boxed should wrap the string in a box") {
    val string = "Hello\nWorld\nI'm a long line"

    val expected =
      """┌─────────────────┐
        |│ Hello           │
        |│ World           │
        |│ I'm a long line │
        |└─────────────────┘""".stripMargin

    assertEquals(string.boxed, expected)
  }

  test("boxed should wrap the string in a box with ANSI colors") {
    val string = s"${RED}Hello$RESET\n${GREEN}World$RESET\n${BLUE}I'm a long line$RESET"

    val expected =
      s"""┌─────────────────┐
         |│ ${RED}Hello$RESET           │
         |│ ${GREEN}World$RESET           │
         |│ ${BLUE}I'm a long line$RESET │
         |└─────────────────┘""".stripMargin

    assertEquals(string.boxed, expected)
  }

}
