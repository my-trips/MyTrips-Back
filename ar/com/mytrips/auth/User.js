var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":38,"id":1017,"methods":[{"el":13,"sc":5,"sl":13},{"el":18,"sc":5,"sl":18},{"el":25,"sc":5,"sl":20},{"el":30,"sc":5,"sl":27},{"el":32,"sc":5,"sl":32},{"el":36,"sc":5,"sl":34}],"name":"User","sl":6}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_12":{"methods":[{"sl":13}],"name":"when create a user, but there exists a user with the same email, it should throw an exception","pass":true,"statements":[]},"test_16":{"methods":[{"sl":13},{"sl":34}],"name":"when create a user, it should return an user with authorities","pass":true,"statements":[{"sl":35}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [16, 12], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [16], [16], [], [], []]
