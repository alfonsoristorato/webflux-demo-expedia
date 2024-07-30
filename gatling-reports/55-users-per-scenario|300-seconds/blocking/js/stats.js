var stats = {
    type: "GROUP",
name: "All Requests",
path: "",
pathFormatted: "group_missing-name--1146707516",
stats: {
    "name": "All Requests",
    "numberOfRequests": {
        "total": "99000",
        "ok": "98975",
        "ko": "25"
    },
    "minResponseTime": {
        "total": "2",
        "ok": "2",
        "ko": "152"
    },
    "maxResponseTime": {
        "total": "471",
        "ok": "471",
        "ko": "385"
    },
    "meanResponseTime": {
        "total": "33",
        "ok": "33",
        "ko": "202"
    },
    "standardDeviation": {
        "total": "54",
        "ok": "54",
        "ko": "69"
    },
    "percentiles1": {
        "total": "9",
        "ok": "9",
        "ko": "176"
    },
    "percentiles2": {
        "total": "29",
        "ok": "29",
        "ko": "177"
    },
    "percentiles3": {
        "total": "161",
        "ok": "160",
        "ko": "365"
    },
    "percentiles4": {
        "total": "240",
        "ok": "240",
        "ko": "381"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 98975,
    "percentage": 99.97474747474747
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
    "count": 25,
    "percentage": 0.025252525252525252
},
    "meanNumberOfRequestsPerSecond": {
        "total": "328.9",
        "ok": "328.82",
        "ko": "0.08"
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
        "ok": "49492",
        "ko": "8"
    },
    "minResponseTime": {
        "total": "3",
        "ok": "3",
        "ko": "174"
    },
    "maxResponseTime": {
        "total": "471",
        "ok": "471",
        "ko": "385"
    },
    "meanResponseTime": {
        "total": "37",
        "ok": "37",
        "ko": "263"
    },
    "standardDeviation": {
        "total": "57",
        "ok": "57",
        "ko": "91"
    },
    "percentiles1": {
        "total": "11",
        "ok": "11",
        "ko": "236"
    },
    "percentiles2": {
        "total": "32",
        "ok": "32",
        "ko": "360"
    },
    "percentiles3": {
        "total": "172",
        "ok": "172",
        "ko": "379"
    },
    "percentiles4": {
        "total": "253",
        "ok": "253",
        "ko": "384"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 49492,
    "percentage": 99.98383838383839
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
    "count": 8,
    "percentage": 0.01616161616161616
},
    "meanNumberOfRequestsPerSecond": {
        "total": "164.45",
        "ok": "164.43",
        "ko": "0.03"
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
        "ok": "49483",
        "ko": "17"
    },
    "minResponseTime": {
        "total": "2",
        "ok": "2",
        "ko": "152"
    },
    "maxResponseTime": {
        "total": "450",
        "ok": "450",
        "ko": "267"
    },
    "meanResponseTime": {
        "total": "29",
        "ok": "29",
        "ko": "174"
    },
    "standardDeviation": {
        "total": "51",
        "ok": "51",
        "ko": "25"
    },
    "percentiles1": {
        "total": "6",
        "ok": "6",
        "ko": "175"
    },
    "percentiles2": {
        "total": "25",
        "ok": "25",
        "ko": "177"
    },
    "percentiles3": {
        "total": "150",
        "ok": "150",
        "ko": "195"
    },
    "percentiles4": {
        "total": "228",
        "ok": "228",
        "ko": "253"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 49483,
    "percentage": 99.96565656565657
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
    "count": 17,
    "percentage": 0.03434343434343434
},
    "meanNumberOfRequestsPerSecond": {
        "total": "164.45",
        "ok": "164.4",
        "ko": "0.06"
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
