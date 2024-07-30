var stats = {
    type: "GROUP",
name: "All Requests",
path: "",
pathFormatted: "group_missing-name--1146707516",
stats: {
    "name": "All Requests",
    "numberOfRequests": {
        "total": "108000",
        "ok": "107660",
        "ko": "340"
    },
    "minResponseTime": {
        "total": "2",
        "ok": "2",
        "ko": "49"
    },
    "maxResponseTime": {
        "total": "562",
        "ok": "562",
        "ko": "396"
    },
    "meanResponseTime": {
        "total": "43",
        "ok": "42",
        "ko": "217"
    },
    "standardDeviation": {
        "total": "71",
        "ok": "71",
        "ko": "61"
    },
    "percentiles1": {
        "total": "8",
        "ok": "8",
        "ko": "212"
    },
    "percentiles2": {
        "total": "42",
        "ok": "41",
        "ko": "254"
    },
    "percentiles3": {
        "total": "205",
        "ok": "203",
        "ko": "345"
    },
    "percentiles4": {
        "total": "299",
        "ok": "297",
        "ko": "380"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 107660,
    "percentage": 99.68518518518519
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
    "count": 340,
    "percentage": 0.3148148148148148
},
    "meanNumberOfRequestsPerSecond": {
        "total": "358.8",
        "ok": "357.67",
        "ko": "1.13"
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
        "total": "54000",
        "ok": "53824",
        "ko": "176"
    },
    "minResponseTime": {
        "total": "2",
        "ok": "2",
        "ko": "51"
    },
    "maxResponseTime": {
        "total": "558",
        "ok": "558",
        "ko": "396"
    },
    "meanResponseTime": {
        "total": "38",
        "ok": "37",
        "ko": "214"
    },
    "standardDeviation": {
        "total": "67",
        "ok": "66",
        "ko": "60"
    },
    "percentiles1": {
        "total": "5",
        "ok": "5",
        "ko": "213"
    },
    "percentiles2": {
        "total": "35",
        "ok": "34",
        "ko": "247"
    },
    "percentiles3": {
        "total": "194",
        "ok": "192",
        "ko": "332"
    },
    "percentiles4": {
        "total": "276",
        "ok": "274",
        "ko": "360"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 53824,
    "percentage": 99.67407407407407
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
    "count": 176,
    "percentage": 0.3259259259259259
},
    "meanNumberOfRequestsPerSecond": {
        "total": "179.4",
        "ok": "178.82",
        "ko": "0.58"
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
        "total": "54000",
        "ok": "53836",
        "ko": "164"
    },
    "minResponseTime": {
        "total": "3",
        "ok": "3",
        "ko": "49"
    },
    "maxResponseTime": {
        "total": "562",
        "ok": "562",
        "ko": "396"
    },
    "meanResponseTime": {
        "total": "48",
        "ok": "47",
        "ko": "221"
    },
    "standardDeviation": {
        "total": "75",
        "ok": "74",
        "ko": "63"
    },
    "percentiles1": {
        "total": "10",
        "ok": "10",
        "ko": "212"
    },
    "percentiles2": {
        "total": "50",
        "ok": "49",
        "ko": "258"
    },
    "percentiles3": {
        "total": "215",
        "ok": "213",
        "ko": "350"
    },
    "percentiles4": {
        "total": "322",
        "ok": "320",
        "ko": "385"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 53836,
    "percentage": 99.6962962962963
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
    "count": 164,
    "percentage": 0.3037037037037037
},
    "meanNumberOfRequestsPerSecond": {
        "total": "179.4",
        "ok": "178.86",
        "ko": "0.54"
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
