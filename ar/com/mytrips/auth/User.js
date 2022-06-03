var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":30,"id":737,"methods":[{"el":10,"sc":5,"sl":10},{"el":20,"sc":5,"sl":15},{"el":24,"sc":5,"sl":22},{"el":28,"sc":5,"sl":26}],"name":"User","sl":4}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_13":{"methods":[{"sl":10},{"sl":26}],"name":"when create a user, it should return an access token","pass":true,"statements":[{"sl":27}]},"test_5":{"methods":[{"sl":10}],"name":"when create a user, but there exists a user with the same email, it should throw an exception","pass":true,"statements":[]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [5, 13], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [13], [13], [], [], []]
