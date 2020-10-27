import com.typesafe.sbt.packager.docker.ExecCmd
name := "dixa-prime"
version := "0.1"
scalaVersion := "2.12.10"

resolvers += Resolver.bintrayRepo("thesamet", "sbt-protoc")

lazy val proxyPrime = project
  .dependsOn(primeServer)
  .enablePlugins(JavaAppPackaging)
  .enablePlugins(DockerPlugin)
  .enablePlugins(AkkaGrpcPlugin)
  .settings(
    libraryDependencies ++= Dependencies.proxyServerDependencies
//    dockerCommands := dockerCommands.value.filterNot {
//      case ExecCmd("ENTRYPOINT", _) => true
//      case _ => false
//    },
//    dockerCommands ++= Seq(ExecCmd("ENTRYPOINT", "/opt/docker/bin/proxy-server"))
  )

lazy val primeServer = project
  .enablePlugins(JavaAppPackaging)
  .enablePlugins(DockerPlugin)
  .enablePlugins(AkkaGrpcPlugin)
  .settings(
    libraryDependencies ++= Dependencies.primeServerDependencies
//    dockerCommands := dockerCommands.value.filterNot {
//      case ExecCmd("ENTRYPOINT", _) => true
//      case _ => false
//    },
//    dockerCommands ++= Seq(ExecCmd("ENTRYPOINT", "/opt/docker/bin/prime-server"))
  )

enablePlugins(AkkaGrpcPlugin)