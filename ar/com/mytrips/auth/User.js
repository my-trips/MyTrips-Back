var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":32,"id":944,"methods":[{"el":11,"sc":5,"sl":11},{"el":21,"sc":5,"sl":16},{"el":26,"sc":5,"sl":23},{"el":30,"sc":5,"sl":28}],"name":"User","sl":4}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_33":{"methods":[{"sl":11}],"name":"when create a user, but there exists a user with the same email, it should throw an exception","pass":true,"statements":[]},"test_7":{"methods":[{"sl":11},{"sl":28}],"name":"when create a user, it should return an user with authorities","pass":true,"statements":[{"sl":29}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [7, 33], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [7], [7], [], [], []]
