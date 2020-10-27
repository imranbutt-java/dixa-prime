package com.dixa.prime

import akka.http.scaladsl.model.StatusCodes
import com.dixa.prime.service.PrimeNumberGenerator
import com.twitter.util.{Return, Throw, Future => TwitterFuture}
import org.scalatest.funsuite.AsyncFunSuite

import scala.concurrent.{Future, Promise}

/* imransarwar created on 26/10/2020*/
class PrimeNumberGeneratorTest extends AsyncFunSuite {

  def fromTwitter[A](twitterFuture: TwitterFuture[A]): Future[A] = {
    val promise = Promise[A]()
    twitterFuture respond {
      case Return(value) => promise.success(value)
      case Throw(exception) => promise.failure(exception)
    }
    promise.future
  }

  test("Generate list of primes") {
    val primeNumberGenerator = new PrimeNumberGenerator
    val future = fromTwitter(primeNumberGenerator.generatePrime(17))
    future map { numbers => assertResult (numbers._4) (Seq(2,3,5,7,11,13,17)) }
  }

  test("input is 2") {
    val primeNumberGenerator = new PrimeNumberGenerator
    val future = fromTwitter(primeNumberGenerator.generatePrime(2))
    future map { numbers => assertResult (numbers._4) (Seq(2)) }
  }

  test("input is zero") {
    val primeNumberGenerator = new PrimeNumberGenerator
    val future = fromTwitter(primeNumberGenerator.generatePrime(0))
    future map { numbers => assertResult (numbers._1) (StatusCodes.BadRequest.toString) }
  }
}
