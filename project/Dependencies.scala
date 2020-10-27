import sbt._

object Dependencies {
  val finchCore = "com.github.finagle" %% "finch-core" % "0.31.0"
  val finchCirce = "com.github.finagle" %% "finch-circe" % "0.31.0"
  val finchRefined = "com.github.finagle" %% "finch-refined" % "0.31.0"
  val circeGeneric = "io.circe" %% "circe-generic" % "0.12.3"
  val finaggleThrift = "com.twitter" %% "finagle-thrift" % "20.1.0"
  val thriftMux = "com.twitter" %% "finagle-thriftmux" % "20.1.0"
  val finaggleHttp = "com.twitter" %% "finagle-http" % "20.1.0"
  val twitterUtil = "com.twitter" %% "util-core" % "20.1.0"
  val scrooge = "com.twitter" %% "scrooge-core" % "20.1.0"
  val twitterServer = "com.twitter" %% "twitter-server" % "20.1.0"
  val logback = "ch.qos.logback" % "logback-classic" % "1.1.7"
  val scalactic = "org.scalactic" %% "scalactic" % "3.1.1"
  val scalaTest = "org.scalatest" %% "scalatest" % "3.1.1"

  val commonDependencies: Seq[ModuleID] = Seq(logback, scalactic, scalaTest % Test)

  val proxyServerDependencies: Seq[ModuleID] = Seq(finchCore, finchCirce, finchRefined, circeGeneric,
    finaggleThrift, finaggleHttp, twitterUtil, twitterServer) ++ commonDependencies

  val primeServerDependencies: Seq[ModuleID] = Seq(finchCore, finchCirce, finchRefined, circeGeneric,
    finaggleThrift, thriftMux, finaggleHttp, twitterUtil, twitterServer, scrooge) ++ commonDependencies
}