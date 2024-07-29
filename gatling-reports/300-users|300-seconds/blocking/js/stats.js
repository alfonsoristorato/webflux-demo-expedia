var stats = {
    type: "GROUP",
name: "All Requests",
path: "",
pathFormatted: "group_missing-name--1146707516",
stats: {
    "name": "All Requests",
    "numberOfRequests": {
        "total": "90000",
        "ok": "90000",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "2",
        "ok": "2",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "1139",
        "ok": "1139",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "35",
        "ok": "35",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "64",
        "ok": "64",
        "ko": "-"
    },
    "percentiles1": {
        "total": "9",
        "ok": "9",
        "ko": "-"
    },
    "percentiles2": {
        "total": "25",
        "ok": "25",
        "ko": "-"
    },
    "percentiles3": {
        "total": "167",
        "ok": "167",
        "ko": "-"
    },
    "percentiles4": {
        "total": "270",
        "ok": "270",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 89960,
    "percentage": 99.95555555555555
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 40,
    "percentage": 0.044444444444444446
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
    "count": 0,
    "percentage": 0.0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "300",
        "ok": "300",
        "ko": "-"
    }
},
contents: {
"req_get-all-1587943831": {
        type: "REQUEST",
        name: "Get All",
path: "Get All",
pathFormatted: "req_get-all-1587943831",
stats: {
    "name": "Get All",
    "numberOfRequests": {
        "total": "45000",
        "ok": "45000",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "2",
        "ok": "2",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "1088",
        "ok": "1088",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "30",
        "ok": "30",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "61",
        "ok": "61",
        "ko": "-"
    },
    "percentiles1": {
        "total": "5",
        "ok": "5",
        "ko": "-"
    },
    "percentiles2": {
        "total": "19",
        "ok": "19",
        "ko": "-"
    },
    "percentiles3": {
        "total": "155",
        "ok": "155",
        "ko": "-"
    },
    "percentiles4": {
        "total": "247",
        "ok": "247",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 44976,
    "percentage": 99.94666666666666
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 24,
    "percentage": 0.05333333333333334
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
    "count": 0,
    "percentage": 0.0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "150",
        "ok": "150",
        "ko": "-"
    }
}
    },"req_get-one-1587957340": {
        type: "REQUEST",
        name: "Get One",
path: "Get One",
pathFormatted: "req_get-one-1587957340",
stats: {
    "name": "Get One",
    "numberOfRequests": {
        "total": "45000",
        "ok": "45000",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "3",
        "ok": "3",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "1139",
        "ok": "1139",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "40",
        "ok": "40",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "67",
        "ok": "67",
        "ko": "-"
    },
    "percentiles1": {
        "total": "11",
        "ok": "11",
        "ko": "-"
    },
    "percentiles2": {
        "total": "32",
        "ok": "32",
        "ko": "-"
    },
    "percentiles3": {
        "total": "179",
        "ok": "179",
        "ko": "-"
    },
    "percentiles4": {
        "total": "292",
        "ok": "292",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 44984,
    "percentage": 99.96444444444444
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 16,
    "percentage": 0.035555555555555556
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
    "count": 0,
    "percentage": 0.0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "150",
        "ok": "150",
        "ko": "-"
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
