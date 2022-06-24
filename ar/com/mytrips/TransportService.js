var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":18,"id":903,"methods":[{"el":17,"sc":5,"sl":12}],"name":"TransportService","sl":8}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_17":{"methods":[{"sl":12}],"name":"when update the type of transport between two destinations of a trip, it should return an updated transport","pass":true,"statements":[{"sl":13},{"sl":14},{"sl":15},{"sl":16}]},"test_20":{"methods":[{"sl":12}],"name":"when update the arrival and departure dates of a transport between two destinations of a trip, it should return an updated transport","pass":true,"statements":[{"sl":13},{"sl":14},{"sl":15},{"sl":16}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [17, 20], [17, 20], [17, 20], [17, 20], [17, 20], [], []]
