var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":54,"id":822,"methods":[{"el":21,"sc":5,"sl":21},{"el":32,"sc":5,"sl":23},{"el":33,"sc":5,"sl":33},{"el":39,"sc":5,"sl":35},{"el":49,"sc":5,"sl":41},{"el":53,"sc":5,"sl":51}],"name":"Transport","sl":8}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_0":{"methods":[{"sl":41}],"name":"when update the arrival and departure dates of a transport between two destinations of a trip, it should return an updated transport","pass":true,"statements":[{"sl":42},{"sl":43},{"sl":46},{"sl":47}]},"test_31":{"methods":[{"sl":51}],"name":"when a trip is copied, a new trip with the same configuration is returned","pass":true,"statements":[{"sl":52}]},"test_37":{"methods":[{"sl":41}],"name":"when update the type of transport between two destinations of a trip, it should return an updated transport","pass":true,"statements":[{"sl":42},{"sl":43},{"sl":46}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [37, 0], [37, 0], [37, 0], [], [], [37, 0], [0], [], [], [], [31], [31], [], []]