/*
 * Copyright Lightbend, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import sbt._

object Version {
  val paradox = "0.6.5"
  val sbtWeb = "1.4.4"


  val specs2 = "4.7.1"
}

object Library {

  val paradox = "com.lightbend.paradox" %% "paradox" % Version.paradox
  
  val sbtParadox = "com.lightbend.paradox" % "sbt-paradox" % Version.paradox
  
  val sbtWeb = "com.typesafe.sbt" % "sbt-web" % Version.sbtWeb

  val specs2 = "org.specs2" %% "specs2-core" % Version.specs2

}
