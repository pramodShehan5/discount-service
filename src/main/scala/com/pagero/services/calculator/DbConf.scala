package com.pagero.services.calculator

import com.googlecode.flyway.core.Flyway
import com.mchange.v2.c3p0.ComboPooledDataSource
import com.typesafe.config.ConfigFactory
import slick.driver.PostgresDriver.api._

import scala.util.Try

trait DbConf {
  val config = ConfigFactory.load("database.conf");

  lazy val dbName = Try(config.getString("psql.dbName")).getOrElse("postgres")
  lazy val psqlHost = Try(config.getString("localhost")).getOrElse("localhost")
  lazy val psqlPort = Try(config.getString("psql.port")).getOrElse("5432")
  lazy val psqlUser = Try(config.getString("psql.user")).getOrElse("postgres")
  lazy val psqlPassword = Try(config.getString("psql.password")).getOrElse("12345")
  lazy val url = s"jdbc:postgresql://$psqlHost:$psqlPort/$dbName"
  lazy val dbDriver = "org.postgresql.Driver";

  val db = {
    val ds = new ComboPooledDataSource
    ds.setDriverClass("org.postgresql.Driver")
    ds.setUser(psqlUser)
    ds.setPassword(psqlPassword)
    ds.setJdbcUrl(url)
    ds.setMaxPoolSize(20)
    ds.setTestConnectionOnCheckin(true)
    ds.setPreferredTestQuery("SELECT 1")
    ds.setIdleConnectionTestPeriod(300)
    ds.setMaxIdleTimeExcessConnections(240)

    val flyway: Flyway = new Flyway()
    flyway.setInitOnMigrate(true)
    flyway.setDataSource(ds)
    flyway.migrate()

    Database.forDataSource(ds)
  }


}
