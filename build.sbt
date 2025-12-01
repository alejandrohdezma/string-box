ThisBuild / scalaVersion           := "2.13.18"
ThisBuild / crossScalaVersions     := Seq("2.13.18", "3.3.6")
ThisBuild / organization           := "com.alejandrohdezma"
ThisBuild / versionPolicyIntention := Compatibility.None

addCommandAlias("ci-test", "fix --check; versionPolicyCheck; mdoc; publishLocal; +test")
addCommandAlias("ci-docs", "github; mdoc; headerCreateAll")
addCommandAlias("ci-publish", "versionCheck; github; ci-release")

lazy val documentation = project
  .enablePlugins(MdocPlugin)
  .dependsOn(`string-box`)

lazy val `string-box` = module
  .settings(libraryDependencies += "org.scalameta" %% "munit" % "1.1.1" % Test)
