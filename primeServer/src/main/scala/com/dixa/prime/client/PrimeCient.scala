package com.dixa.prime.client

import com.dixa.prime.domain.PrimeConfig
import com.dixa.prime.thrift.PrimeNumberService
import com.twitter.finagle.ThriftMux
import com.twitter.finagle.thriftmux.service.ThriftMuxResponseClassifier

/* imransarwar created on 26/10/2020*/
object PrimeCient extends PrimeConfig {
  val client = ThriftMux.client
    .withResponseClassifier(ThriftMuxResponseClassifier.ThriftExceptionsAsFailures)
    .build[PrimeNumberService.MethodPerEndpoint](s"${primeClientConfig.host}:${primeClientConfig.port}", s"${primeClientConfig.name}")

}
