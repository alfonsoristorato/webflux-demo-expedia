import io.gatling.javaapi.core.*
import io.gatling.javaapi.http.*
import io.gatling.javaapi.core.CoreDsl.*
import io.gatling.javaapi.http.HttpDsl.*

class Scenario : Simulation() {
    // This is a very stupid load test, as the db will always return the same values,
    // but it should demonstrate which is faster between blocking and reactive
    private val userToken = "eyJraWQiOiJtb2NrZWQiLCJ0eXAiOiJKV1QiLCJhbGciOiJFUzM4NCJ9.eyJzdWIiOiJ1c2VyMSIsIm5iZiI6MTcyMjI1NTc0NSwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgxL21vY2tlZCIsImV4cCI6MTcyMjI1OTM0NSwiaWF0IjoxNzIyMjU1NzQ1LCJqdGkiOiJhNWYzNjg3My0xYWNlLTRmN2QtYTYyNS05MTY0NzMyMGYyMDcifQ.fNXJ9Mjqolt1s9lHTvZ0a_gG7fcViWK1OTwLtZ7-tISjfMIo6q8_YDiMTSM9Rw6RGwMhb1V8NbGLZqlGfzXe1pLItVB0gt5kTf9ltJ6c_uF6DG1Gz6CdjR4KLb-jiRAR"
    private val httpProtocol =
        http.baseUrl("http://localhost:8080")
            .authorizationHeader("Bearer $userToken")


    private val scenario = scenario("getAll").exec(http("Get All").post("/post/all"))
    init {
        setUp(
            scenario.injectOpen(constantUsersPerSec(300.0).during(120)),
        ).protocols(httpProtocol)
    }
}
