# dixa-prime

### Application Architecture
1. Tried to implement with Hexagonal Architecture
 
### Environment Setup
1. `git clone https://github.com/imranbutt-java/dixa-prime.git`
2. import project from IntelliJ
3. Build project
4. open sbt console
5. ;clean ;compile
6. Even `scrooge` generate code from thrift but if it doesn't, open terminal and run the command
```
cd primeServer
thrift --gen java ./src/main/thrift/prime_number_service.thrift
```
### Run Application
1. Run `ServerApp.scala`
2. Run `PrimeNumberServer.scala`
3. From terminal, run the command
`curl http://127.0.0.1:8080/prime/12`

### Changes Required
1. sbt docker plugin integration
2. Service Discovery implementation
3. Proper json response
