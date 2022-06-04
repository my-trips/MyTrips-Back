var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":30,"id":452,"methods":[{"el":17,"sc":5,"sl":15},{"el":29,"sc":5,"sl":19}],"name":"UserService","sl":10}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_15":{"methods":[{"sl":19}],"name":"when create a user, it should return an access token","pass":true,"statements":[{"sl":20},{"sl":23},{"sl":24},{"sl":25},{"sl":27},{"sl":28}]},"test_18":{"methods":[{"sl":19}],"name":"when create a user, but there exists a user with the same email, it should throw an exception","pass":true,"statements":[{"sl":20}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [18, 15], [18, 15], [], [], [15], [15], [15], [], [15], [15], [], []]
