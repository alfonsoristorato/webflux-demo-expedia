import io.gatling.javaapi.core.CoreDsl.constantUsersPerSec
import io.gatling.javaapi.core.CoreDsl.scenario
import io.gatling.javaapi.core.Simulation
import io.gatling.javaapi.http.HttpDsl.http

class Scenario : Simulation() {
    // This is a very stupid load test and of course it could be written better - do not judge :),
    // but it should demonstrate which is faster between blocking and reactive and which can serve more requests
    private val tokenUser1 =
        "eyJraWQiOiJtb2NrZWQiLCJ0eXAiOiJKV1QiLCJhbGciOiJFUzM4NCJ9.eyJzdWIiOiJ1c2VyMSIsIm5iZiI6MTcyMjMyOTEwMCwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgxL21vY2tlZCIsImV4cCI6MTcyMjMzMjcwMCwiaWF0IjoxNzIyMzI5MTAwLCJqdGkiOiI3NDNkN2ZiNS1iNzM3LTRmZDctYjc4MS04ZmU0OTc2ODA0M2IifQ.NnLsz5Wc1wloQTUJ4xzmQe3fFT95qR-fhElSoSA-1ElE8_PpaqwhFm2IItJvP1-kanQ1jwr18P5WHbXAaKO0-jWOHbJvAuUPmJqXPMl_8rvMarkyBv0vyPISnaYP3Nqj"

    private val tokenUser2 =
        "eyJraWQiOiJtb2NrZWQiLCJ0eXAiOiJKV1QiLCJhbGciOiJFUzM4NCJ9.eyJzdWIiOiJ1c2VyMiIsIm5iZiI6MTcyMjMyOTExNCwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgxL21vY2tlZCIsImV4cCI6MTcyMjMzMjcxNCwiaWF0IjoxNzIyMzI5MTE0LCJqdGkiOiI3MzdhZjljYi0xNGQzLTQ5MDUtYTdlNi00ZGFhZDU4NzRhYWIifQ.VGyCsMeZmJbi1SVBj6V4wvSAig5c6n1yi1Dybw9mInOMWXkpjbUm_9Uo0Oi7uY42kChEBQ1tGyqxRr7sdjtIq0m2lnV92lhLQLnzYiCjcuYluRCrwxdxGYATWg0dylXD"
    private val tokenUser3 =
        "eyJraWQiOiJtb2NrZWQiLCJ0eXAiOiJKV1QiLCJhbGciOiJFUzM4NCJ9.eyJzdWIiOiJ1c2VyMyIsIm5iZiI6MTcyMjMyOTEyNCwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgxL21vY2tlZCIsImV4cCI6MTcyMjMzMjcyNCwiaWF0IjoxNzIyMzI5MTI0LCJqdGkiOiJjYzY4M2ExZC0wODZiLTQ2MGItYTZiZi1hZTAwMzc2MGMyMTUifQ.ig3z6h0RavfE3GRteA1JfqgZJ76lIZ0YT86uwTDGMOti8XBk_8zuTmvaMd0rh7VvXyQRBrSAAoxobdy_aqTl3HReFPNvMT7WBF5h0YE01WIzx6hXPoYyKE8XAF8vZz0G"

    private val postId1 = "68299394-c544-4e61-955a-fba4b80f0eb3"
    private val postId2 = "d462e821-1aa9-4fdc-89e9-37b90ecf6203"
    private val postId3 = "d99205b1-486b-4dba-8ab4-42ee25550fdd"

    private val httpProtocolUser1 =
        http.baseUrl("http://localhost:8080")
            .authorizationHeader("Bearer $tokenUser1")
    private val httpProtocolUser2 =
        http.baseUrl("http://localhost:8080")
            .authorizationHeader("Bearer $tokenUser2")
    private val httpProtocolUser3 =
        http.baseUrl("http://localhost:8080")
            .authorizationHeader("Bearer $tokenUser3")


    private fun getAllScenario(name: String) =
        scenario(name).exec(http("Get All").post("/post/all"))


    private fun getOneScenario(name: String, postId:String) =
        scenario(name).exec(http("Get One").get("/post/$postId/with-comments-zipping-and-is-beautiful"))


    private val duration = 300L
    private val concurrentUsers = 60.0
    init {
        setUp(
            getAllScenario("get all user 1").injectOpen(constantUsersPerSec(concurrentUsers).during(duration)).protocols(httpProtocolUser1),
            getAllScenario("get all user 2").injectOpen(constantUsersPerSec(concurrentUsers).during(duration)).protocols(httpProtocolUser2),
            getAllScenario("get all user 3").injectOpen(constantUsersPerSec(concurrentUsers).during(duration)).protocols(httpProtocolUser3),

            getOneScenario("get one user 1", postId1).injectOpen(constantUsersPerSec(concurrentUsers).during(duration)).protocols(httpProtocolUser1),
            getOneScenario("get one user 2", postId2).injectOpen(constantUsersPerSec(concurrentUsers).during(duration)).protocols(httpProtocolUser2),
            getOneScenario("get one user 3", postId3).injectOpen(constantUsersPerSec(concurrentUsers).during(duration)).protocols(httpProtocolUser3),
        )
    }
}
