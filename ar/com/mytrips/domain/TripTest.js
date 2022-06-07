var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":85,"id":178,"methods":[{"el":18,"sc":5,"sl":10},{"el":27,"sc":5,"sl":20},{"el":36,"sc":5,"sl":29},{"el":45,"sc":5,"sl":38},{"el":56,"sc":5,"sl":47},{"el":66,"sc":5,"sl":58},{"el":76,"sc":5,"sl":68},{"el":84,"sc":5,"sl":78}],"name":"TripTest","sl":8}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_1":{"methods":[{"sl":10}],"name":"when destinations are added to a trip, it must return the updated trip.","pass":true,"statements":[{"sl":12},{"sl":15},{"sl":16},{"sl":17}]},"test_10":{"methods":[{"sl":58}],"name":"when a trip is asked for the destinations without origin, it should return it.","pass":true,"statements":[{"sl":60},{"sl":61},{"sl":64},{"sl":65}]},"test_11":{"methods":[{"sl":47}],"name":"when a trip is asked for the first destination, it should return it.","pass":true,"statements":[{"sl":49},{"sl":50},{"sl":51},{"sl":54},{"sl":55}]},"test_17":{"methods":[{"sl":38}],"name":"when a trip is asked for the end date, it should return it.","pass":true,"statements":[{"sl":40},{"sl":41},{"sl":44}]},"test_2":{"methods":[{"sl":29}],"name":"when a trip is asked for the start date, it should return it.","pass":true,"statements":[{"sl":31},{"sl":32},{"sl":35}]},"test_20":{"methods":[{"sl":78}],"name":"when ask a trip if a destination is not the last, and it is not, it should return true.","pass":true,"statements":[{"sl":80},{"sl":83}]},"test_26":{"methods":[{"sl":20}],"name":"when total days of a trip is requested, it should return the number of days.","pass":true,"statements":[{"sl":22},{"sl":23},{"sl":26}]},"test_5":{"methods":[{"sl":68}],"name":"when a trip is asked for the total cost, it should return it.","pass":true,"statements":[{"sl":70},{"sl":71},{"sl":74},{"sl":75}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [1], [], [1], [], [], [1], [1], [1], [], [], [26], [], [26], [26], [], [], [26], [], [], [2], [], [2], [2], [], [], [2], [], [], [17], [], [17], [17], [], [], [17], [], [], [11], [], [11], [11], [11], [], [], [11], [11], [], [], [10], [], [10], [10], [], [], [10], [10], [], [], [5], [], [5], [5], [], [], [5], [5], [], [], [20], [], [20], [], [], [20], [], []]
