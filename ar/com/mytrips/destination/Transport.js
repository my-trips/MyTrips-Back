var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":50,"id":518,"methods":[{"el":21,"sc":5,"sl":21},{"el":32,"sc":5,"sl":23},{"el":33,"sc":5,"sl":33},{"el":39,"sc":5,"sl":35},{"el":49,"sc":5,"sl":41}],"name":"Transport","sl":8}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_19":{"methods":[{"sl":41}],"name":"when update the arrival and departure dates of a transport between two destinations of a trip, it should return an updated transport","pass":true,"statements":[{"sl":42},{"sl":43},{"sl":46},{"sl":47}]},"test_9":{"methods":[{"sl":41}],"name":"when update the type of transport between two destinations of a trip, it should return an updated transport","pass":true,"statements":[{"sl":42},{"sl":43},{"sl":46}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [19, 9], [19, 9], [19, 9], [], [], [19, 9], [19], [], [], []]
