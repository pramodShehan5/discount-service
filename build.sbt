name := "discounting-service"

description := "Discounting service"

enablePlugins(ServicePlugin)

libraryDependencies ++= Seq(
  "com.pagero" % "discounting-spec" % "0.1-SNAPSHOT" % "proto",
  "org.postgresql" % "postgresql" % "9.4-1201-jdbc41",
  "com.pagero" %% "pagero-slick" % "1.5.1-GO",
  "org.hsqldb" % "hsqldb" % "2.3.3" % "test",
  "org.slf4j" % "slf4j-nop" % "1.6.4",
  "c3p0" % "c3p0" % "0.9.1.2",
    "org.scalatest" %% "scalatest" % "3.0.0" % "test",
  "com.googlecode.flyway" % "flyway-core" % "2.3.1"
)

parallelExecution in Test := false

parallelExecution in IntegrationTest := false

servicesToDeploy := Seq("etcd", "rabbitmq", "cassandra", "compliancedb")

//deployServicesExtraArgs := Seq("--force-update", "compliancedb")
