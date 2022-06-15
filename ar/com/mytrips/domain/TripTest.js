var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":84,"id":295,"methods":[{"el":17,"sc":5,"sl":9},{"el":26,"sc":5,"sl":19},{"el":35,"sc":5,"sl":28},{"el":44,"sc":5,"sl":37},{"el":55,"sc":5,"sl":46},{"el":65,"sc":5,"sl":57},{"el":75,"sc":5,"sl":67},{"el":83,"sc":5,"sl":77}],"name":"TripTest","sl":7}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_16":{"methods":[{"sl":28}],"name":"when a trip is asked for the start date, it should return it.","pass":true,"statements":[{"sl":30},{"sl":31},{"sl":34}]},"test_18":{"methods":[{"sl":9}],"name":"when destinations are added to a trip, it must return the updated trip.","pass":true,"statements":[{"sl":11},{"sl":14},{"sl":15},{"sl":16}]},"test_24":{"methods":[{"sl":37}],"name":"when a trip is asked for the end date, it should return it.","pass":true,"statements":[{"sl":39},{"sl":40},{"sl":43}]},"test_33":{"methods":[{"sl":46}],"name":"when a trip is asked for the first destination, it should return it.","pass":true,"statements":[{"sl":48},{"sl":49},{"sl":50},{"sl":53},{"sl":54}]},"test_34":{"methods":[{"sl":67}],"name":"when a trip is asked for the total cost, it should return it.","pass":true,"statements":[{"sl":69},{"sl":70},{"sl":73},{"sl":74}]},"test_42":{"methods":[{"sl":77}],"name":"when ask a trip if a destination is not the last, and it is not, it should return true.","pass":true,"statements":[{"sl":79},{"sl":82}]},"test_45":{"methods":[{"sl":19}],"name":"when total days of a trip is requested, it should return the number of days.","pass":true,"statements":[{"sl":21},{"sl":22},{"sl":25}]},"test_5":{"methods":[{"sl":57}],"name":"when a trip is asked for the destinations without origin, it should return it.","pass":true,"statements":[{"sl":59},{"sl":60},{"sl":63},{"sl":64}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [18], [], [18], [], [], [18], [18], [18], [], [], [45], [], [45], [45], [], [], [45], [], [], [16], [], [16], [16], [], [], [16], [], [], [24], [], [24], [24], [], [], [24], [], [], [33], [], [33], [33], [33], [], [], [33], [33], [], [], [5], [], [5], [5], [], [], [5], [5], [], [], [34], [], [34], [34], [], [], [34], [34], [], [], [42], [], [42], [], [], [42], [], []]