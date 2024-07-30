var stats = {
    type: "GROUP",
name: "All Requests",
path: "",
pathFormatted: "group_missing-name--1146707516",
stats: {
    "name": "All Requests",
    "numberOfRequests": {
        "total": "99000",
        "ok": "98997",
        "ko": "3"
    },
    "minResponseTime": {
        "total": "2",
        "ok": "2",
        "ko": "199"
    },
    "maxResponseTime": {
        "total": "531",
        "ok": "531",
        "ko": "213"
    },
    "meanResponseTime": {
        "total": "26",
        "ok": "26",
        "ko": "205"
    },
    "standardDeviation": {
        "total": "46",
        "ok": "46",
        "ko": "6"
    },
    "percentiles1": {
        "total": "7",
        "ok": "7",
        "ko": "202"
    },
    "percentiles2": {
        "total": "17",
        "ok": "17",
        "ko": "208"
    },
    "percentiles3": {
        "total": "132",
        "ok": "132",
        "ko": "212"
    },
    "percentiles4": {
        "total": "220",
        "ok": "220",
        "ko": "213"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 98997,
    "percentage": 99.9969696969697
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 0,
    "percentage": 0.0
},
    "group3": {
    "name": "t >= 1200 ms",
    "htmlName": "t >= 1200 ms",
    "count": 0,
    "percentage": 0.0
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 3,
    "percentage": 0.0030303030303030303
},
    "meanNumberOfRequestsPerSecond": {
        "total": "330",
        "ok": "329.99",
        "ko": "0.01"
    }
},
contents: {
"req_get-one-1587957340": {
        type: "REQUEST",
        name: "Get One",
path: "Get One",
pathFormatted: "req_get-one-1587957340",
stats: {
    "name": "Get One",
    "numberOfRequests": {
        "total": "49500",
        "ok": "49498",
        "ko": "2"
    },
    "minResponseTime": {
        "total": "3",
        "ok": "3",
        "ko": "199"
    },
    "maxResponseTime": {
        "total": "531",
        "ok": "531",
        "ko": "213"
    },
    "meanResponseTime": {
        "total": "28",
        "ok": "28",
        "ko": "206"
    },
    "standardDeviation": {
        "total": "47",
        "ok": "47",
        "ko": "7"
    },
    "percentiles1": {
        "total": "8",
        "ok": "8",
        "ko": "206"
    },
    "percentiles2": {
        "total": "22",
        "ok": "22",
        "ko": "210"
    },
    "percentiles3": {
        "total": "138",
        "ok": "138",
        "ko": "212"
    },
    "percentiles4": {
        "total": "227",
        "ok": "227",
        "ko": "213"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 49498,
    "percentage": 99.99595959595959
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 0,
    "percentage": 0.0
},
    "group3": {
    "name": "t >= 1200 ms",
    "htmlName": "t >= 1200 ms",
    "count": 0,
    "percentage": 0.0
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 2,
    "percentage": 0.00404040404040404
},
    "meanNumberOfRequestsPerSecond": {
        "total": "165",
        "ok": "164.99",
        "ko": "0.01"
    }
}
    },"req_get-all-1587943831": {
        type: "REQUEST",
        name: "Get All",
path: "Get All",
pathFormatted: "req_get-all-1587943831",
stats: {
    "name": "Get All",
    "numberOfRequests": {
        "total": "49500",
        "ok": "49499",
        "ko": "1"
    },
    "minResponseTime": {
        "total": "2",
        "ok": "2",
        "ko": "202"
    },
    "maxResponseTime": {
        "total": "492",
        "ok": "492",
        "ko": "202"
    },
    "meanResponseTime": {
        "total": "24",
        "ok": "24",
        "ko": "202"
    },
    "standardDeviation": {
        "total": "45",
        "ok": "45",
        "ko": "0"
    },
    "percentiles1": {
        "total": "5",
        "ok": "5",
        "ko": "202"
    },
    "percentiles2": {
        "total": "12",
        "ok": "12",
        "ko": "202"
    },
    "percentiles3": {
        "total": "126",
        "ok": "126",
        "ko": "202"
    },
    "percentiles4": {
        "total": "212",
        "ok": "212",
        "ko": "202"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 49499,
    "percentage": 99.9979797979798
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 0,
    "percentage": 0.0
},
    "group3": {
    "name": "t >= 1200 ms",
    "htmlName": "t >= 1200 ms",
    "count": 0,
    "percentage": 0.0
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 1,
    "percentage": 0.00202020202020202
},
    "meanNumberOfRequestsPerSecond": {
        "total": "165",
        "ok": "165",
        "ko": "0"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
