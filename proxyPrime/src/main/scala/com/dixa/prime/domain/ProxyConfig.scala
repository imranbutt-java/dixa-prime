package com.dixa.prime.domain

import com.dixa.prime.model.ConfigProperty.ServerConfig
import com.typesafe.config.ConfigFactory

/* imransarwar created on 26/10/2020*/
trait ProxyConfig {
  private[this] lazy val proxyConfig = ConfigFactory.load().getConfig("dixa.prime.proxy.server")

  lazy val proxyServerConfig = ServerConfig(proxyConfig.getString("name"),
    proxyConfig.getString("host"),
    proxyConfig.getInt("port"))
}
