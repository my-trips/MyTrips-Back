var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":73,"id":136,"methods":[{"el":26,"sc":5,"sl":10},{"el":40,"sc":5,"sl":28},{"el":58,"sc":5,"sl":42},{"el":72,"sc":5,"sl":60}],"name":"DestinationServiceTest","sl":8}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_1":{"methods":[{"sl":60}],"name":"by subtracting days, the previous destination cannot run out of days\n","pass":true,"statements":[{"sl":62},{"sl":65},{"sl":66},{"sl":69},{"sl":70},{"sl":71}]},"test_10":{"methods":[{"sl":10}],"name":"when a trip is added a day to one of its destinations, it should return the updated destination","pass":true,"statements":[{"sl":12},{"sl":13},{"sl":14},{"sl":15},{"sl":16},{"sl":19},{"sl":22},{"sl":23},{"sl":24},{"sl":25}]},"test_16":{"methods":[{"sl":28}],"name":"when adding days, the next destination cannot run out of days","pass":true,"statements":[{"sl":30},{"sl":33},{"sl":34},{"sl":37},{"sl":38},{"sl":39}]},"test_19":{"methods":[{"sl":42}],"name":"hen a trip is subtract a day to one of its destinations, it should return the updated destination","pass":true,"statements":[{"sl":44},{"sl":45},{"sl":46},{"sl":47},{"sl":48},{"sl":51},{"sl":54},{"sl":55},{"sl":56},{"sl":57}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [10], [], [10], [10], [10], [10], [10], [], [], [10], [], [], [10], [10], [10], [10], [], [], [16], [], [16], [], [], [16], [16], [], [], [16], [16], [16], [], [], [19], [], [19], [19], [19], [19], [19], [], [], [19], [], [], [19], [19], [19], [19], [], [], [1], [], [1], [], [], [1], [1], [], [], [1], [1], [1], [], []]