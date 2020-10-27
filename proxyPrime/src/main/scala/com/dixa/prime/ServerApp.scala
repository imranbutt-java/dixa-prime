package com.dixa.prime

import com.dixa.prime.domain.ProxyConfig
import com.dixa.prime.server.PrimeProxyServer

/* imransarwar created on 26/10/2020*/
object ServerApp extends ProxyConfig {
  lazy val primeProxyServer = new PrimeProxyServer()

  def main(args: Array[String]): Unit = {
    primeProxyServer.run
  }
}
