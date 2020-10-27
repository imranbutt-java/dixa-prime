package com.dixa.prime

import com.dixa.prime.domain.PrimeConfig
import com.dixa.prime.service.PrimeNumberGenerator
import com.twitter.app.App
import com.twitter.finagle.ThriftMux
import com.twitter.finagle.thriftmux.service.ThriftMuxResponseClassifier
import com.twitter.util.Await

/* imransarwar created on 26/10/2020*/
object PrimeNumberServer extends App with PrimeConfig {
  private lazy val primeNumberGen = new PrimeNumberGenerator()
  def main(): Unit = {
    val server = ThriftMux.server
      .withResponseClassifier(ThriftMuxResponseClassifier.ThriftExceptionsAsFailures)
      .withLabel(s"${primeServerConfig.name}")
      .serveIface(s"${primeServerConfig.host}:${primeServerConfig.port}", primeNumberGen)
    closeOnExit(server)
    Await.ready(server)
  }
}
