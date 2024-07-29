import io.gatling.javaapi.core.CoreDsl.constantUsersPerSec
import io.gatling.javaapi.core.CoreDsl.scenario
import io.gatling.javaapi.core.Simulation
import io.gatling.javaapi.http.HttpDsl.http

class Scenario : Simulation() {
    // This is a very stupid load test and of course it could be written better - do not judge :),
    // but it should demonstrate which is faster between blocking and reactive and which can serve more requests
    private val tokenUser1 =
        "eyJraWQiOiJtb2NrZWQiLCJ0eXAiOiJKV1QiLCJhbGciOiJFUzM4NCJ9.eyJzdWIiOiJ1c2VyMSIsIm5iZiI6MTcyMjI3MDY0MywiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgxL21vY2tlZCIsImV4cCI6MTcyMjI3NDI0MywiaWF0IjoxNzIyMjcwNjQzLCJqdGkiOiJmMTViNWRlOS1kNjZiLTRlZDAtYWZhZC02YzUxM2I3MTZhOTMifQ.rgKSALCgWGA1B-dxZGDd0G19MtOFJzA-AXXOchIUwtpWThyTddWIctwsvHxAbrCHmXrSFyaPXxt9jwKw0syvfmKc--kFfGNroyRkW0mRCrntiCasnIFZ67ddrh5nLcyy"

    private val tokenUser2 =
        "eyJraWQiOiJtb2NrZWQiLCJ0eXAiOiJKV1QiLCJhbGciOiJFUzM4NCJ9.eyJzdWIiOiJ1c2VyMiIsIm5iZiI6MTcyMjI3MDY1NiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgxL21vY2tlZCIsImV4cCI6MTcyMjI3NDI1NiwiaWF0IjoxNzIyMjcwNjU2LCJqdGkiOiIzNjA0ZmY2YS01NWU5LTRjMmEtOTcyNy01NjdiYWNjMmYxZmMifQ.VDdBQf4uB7t-6wbqU961kSe1W-4mvoByTtyBQcsh43zhgHAXB3dpONN3eXTJrRG-h430-bDnB8HS4BmnFgA_FDna1B4ed1cubQWtsZGD3U8OYO4B1kd5wAkZH7rk8sm5"
    private val tokenUser3 =
        "eyJraWQiOiJtb2NrZWQiLCJ0eXAiOiJKV1QiLCJhbGciOiJFUzM4NCJ9.eyJzdWIiOiJ1c2VyMyIsIm5iZiI6MTcyMjI3MDY2NiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgxL21vY2tlZCIsImV4cCI6MTcyMjI3NDI2NiwiaWF0IjoxNzIyMjcwNjY2LCJqdGkiOiIwYjViZGM5Mi1iNDg5LTQ2ZjctOTg4Yy00NTQ4ZTg2NDgyYWMifQ.Yf4gPQC6ufofW8cFfYnD-PCEKVD4bs1lin8NCSz1ICiDbao-i7fEm0I9DsiUzUvQauZ3p68aGPwhzqQOeStlxTzJBAgERF9kP-i0NAUoTeNA13Rl1FAnyg7Y_JkdFLBt"

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
    private val concurrentUsers = 50.0
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
