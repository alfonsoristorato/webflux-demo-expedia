var stats = {
    type: "GROUP",
name: "All Requests",
path: "",
pathFormatted: "group_missing-name--1146707516",
stats: {
    "name": "All Requests",
    "numberOfRequests": {
        "total": "108000",
        "ok": "107984",
        "ko": "16"
    },
    "minResponseTime": {
        "total": "2",
        "ok": "2",
        "ko": "138"
    },
    "maxResponseTime": {
        "total": "1088",
        "ok": "1088",
        "ko": "429"
    },
    "meanResponseTime": {
        "total": "36",
        "ok": "36",
        "ko": "239"
    },
    "standardDeviation": {
        "total": "69",
        "ok": "69",
        "ko": "111"
    },
    "percentiles1": {
        "total": "7",
        "ok": "7",
        "ko": "177"
    },
    "percentiles2": {
        "total": "29",
        "ok": "29",
        "ko": "377"
    },
    "percentiles3": {
        "total": "177",
        "ok": "177",
        "ko": "429"
    },
    "percentiles4": {
        "total": "277",
        "ok": "277",
        "ko": "429"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 107905,
    "percentage": 99.91203703703704
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 79,
    "percentage": 0.07314814814814816
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
    "count": 16,
    "percentage": 0.014814814814814815
},
    "meanNumberOfRequestsPerSecond": {
        "total": "360",
        "ok": "359.95",
        "ko": "0.05"
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
        "ok": "53991",
        "ko": "9"
    },
    "minResponseTime": {
        "total": "2",
        "ok": "2",
        "ko": "138"
    },
    "maxResponseTime": {
        "total": "1031",
        "ok": "1031",
        "ko": "429"
    },
    "meanResponseTime": {
        "total": "32",
        "ok": "32",
        "ko": "213"
    },
    "standardDeviation": {
        "total": "67",
        "ok": "67",
        "ko": "103"
    },
    "percentiles1": {
        "total": "5",
        "ok": "5",
        "ko": "175"
    },
    "percentiles2": {
        "total": "23",
        "ok": "23",
        "ko": "177"
    },
    "percentiles3": {
        "total": "168",
        "ok": "168",
        "ko": "409"
    },
    "percentiles4": {
        "total": "262",
        "ok": "262",
        "ko": "425"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 53947,
    "percentage": 99.90185185185186
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 44,
    "percentage": 0.08148148148148147
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
    "count": 9,
    "percentage": 0.016666666666666666
},
    "meanNumberOfRequestsPerSecond": {
        "total": "180",
        "ok": "179.97",
        "ko": "0.03"
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
        "ok": "53993",
        "ko": "7"
    },
    "minResponseTime": {
        "total": "3",
        "ok": "3",
        "ko": "162"
    },
    "maxResponseTime": {
        "total": "1088",
        "ok": "1088",
        "ko": "429"
    },
    "meanResponseTime": {
        "total": "40",
        "ok": "40",
        "ko": "271"
    },
    "standardDeviation": {
        "total": "72",
        "ok": "72",
        "ko": "113"
    },
    "percentiles1": {
        "total": "8",
        "ok": "8",
        "ko": "183"
    },
    "percentiles2": {
        "total": "37",
        "ok": "37",
        "ko": "386"
    },
    "percentiles3": {
        "total": "186",
        "ok": "186",
        "ko": "419"
    },
    "percentiles4": {
        "total": "289",
        "ok": "289",
        "ko": "427"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 53958,
    "percentage": 99.92222222222222
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 35,
    "percentage": 0.06481481481481481
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
    "count": 7,
    "percentage": 0.012962962962962963
},
    "meanNumberOfRequestsPerSecond": {
        "total": "180",
        "ok": "179.98",
        "ko": "0.02"
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
