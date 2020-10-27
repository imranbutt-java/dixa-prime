package com.dixa.prime.server

import com.dixa.prime.domain.{PrimeConfig, ProxyConfig}
import com.dixa.prime.route.ProxyRoute
import com.dixa.prime.thrift._
import com.twitter.finagle.Http
import com.twitter.finagle.http.service.HttpResponseClassifier
import com.twitter.server.TwitterServer
import com.twitter.util.Await
import io.circe.generic.auto._
import io.finch.circe._
import io.catbird.util._

/* imransarwar created on 26/10/2020*/
class PrimeProxyServer  extends TwitterServer with ProxyConfig {
  def run: Unit = {
    val server = Http.server
      .withStreaming(enabled = true)
      .withLabel(s"${proxyServerConfig.name}")
      .withResponseClassifier(HttpResponseClassifier.ServerErrorsAsFailures)
      .serve(s"${proxyServerConfig.host}:${proxyServerConfig.port}", ProxyRoute.api.toService)

    closeOnExit(server)
    Await.ready(server)
  }
}
