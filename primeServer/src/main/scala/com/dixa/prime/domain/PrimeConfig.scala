package com.dixa.prime.domain

import com.dixa.prime.model.ConfigProperty.ServerConfig
import com.typesafe.config.ConfigFactory

/* imransarwar created on 26/10/2020*/
trait PrimeConfig {
  private[this] lazy val serverConfig = ConfigFactory.load().getConfig("dixa.prime.server")
  private[this] lazy val clientConfig = ConfigFactory.load().getConfig("dixa.prime.client")

  lazy val primeServerConfig = ServerConfig(serverConfig.getString("name"),
    serverConfig.getString("host"),
    serverConfig.getInt("port"))

  lazy val primeClientConfig = ServerConfig(clientConfig.getString("name"),
    clientConfig.getString("host"),
    clientConfig.getInt("port"))
}
