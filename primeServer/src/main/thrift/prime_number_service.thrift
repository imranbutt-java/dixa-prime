namespace * com.dixa.prime.thrift

exception BadInput {
    1: string error_msg;
}

struct PrimeResponse {
    1: string status,
    2: string message,
    3: i32 upperLimit,
    4: list<i32> primeList
}

service PrimeNumberService {
    PrimeResponse generatePrime(1: i32 n) throws (1: BadInput badInput);
}
