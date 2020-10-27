package com.dixa.prime.route

import com.dixa.prime.client.PrimeCient
import com.dixa.prime.thrift.PrimeResponse
import io.finch.syntax.get
import io.finch.{Endpoint, Ok, path}

/* imransarwar created on 26/10/2020*/
object ProxyRoute {

  lazy val api: Endpoint[String] = get("prime" :: path[Int] ) { n: Int =>
    PrimeCient.client.generatePrime(n).map(primes => Ok(primes.toString))
  }
}
