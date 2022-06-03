var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":31,"id":713,"methods":[{"el":11,"sc":5,"sl":11},{"el":21,"sc":5,"sl":16},{"el":25,"sc":5,"sl":23},{"el":29,"sc":5,"sl":27}],"name":"User","sl":4}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_14":{"methods":[{"sl":11}],"name":"when create a user, but there exists a user with the same email, it should throw an exception","pass":true,"statements":[]},"test_15":{"methods":[{"sl":11},{"sl":27}],"name":"when create a user, it should return an access token","pass":true,"statements":[{"sl":28}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [14, 15], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [15], [15], [], [], []]
