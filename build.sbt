ThisBuild / scalaVersion           := "2.13.14"
ThisBuild / crossScalaVersions     := Seq("2.13.14", "3.3.3")
ThisBuild / organization           := "com.alejandrohdezma"
ThisBuild / versionPolicyIntention := Compatibility.BinaryAndSourceCompatible

addCommandAlias("ci-test", "fix --check; versionPolicyCheck; mdoc; publishLocal; +test")
addCommandAlias("ci-docs", "github; mdoc; headerCreateAll")
addCommandAlias("ci-publish", "versionCheck; github; ci-release")

lazy val documentation = project
  .enablePlugins(MdocPlugin)
  .dependsOn(`string-box`)

lazy val `string-box` = module
  .settings(libraryDependencies += "org.scalameta" %% "munit" % "1.0.2" % Test)
