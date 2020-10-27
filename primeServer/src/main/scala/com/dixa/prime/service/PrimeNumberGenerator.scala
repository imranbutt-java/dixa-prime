package com.dixa.prime.service

import akka.http.scaladsl.model.StatusCodes
import com.dixa.prime.thrift.{PrimeNumberService, PrimeResponse}
import com.twitter.util.Future

import scala.collection.mutable


class PrimeNumberGenerator extends PrimeNumberService.MethodPerEndpoint {

  val primes: Stream[Int] = 2 #:: Stream.from(3).filter { n => !primes.takeWhile(_ <= math.sqrt(n)).exists(n % _ == 0) }
  override def generatePrime(n: Int): Future[PrimeResponse] = {
    if (n < 2) return Future.value(PrimeResponse(StatusCodes.BadRequest.toString, "Number should be greater or equal to 2.", n, null))
    Future.value(PrimeResponse(StatusCodes.Accepted.toString, "Prime numbers successfully generated.", n, primes.takeWhile(_ <= n).toList))
  }
}