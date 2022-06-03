var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":93,"id":0,"methods":[{"el":26,"sc":5,"sl":22},{"el":64,"sc":5,"sl":35},{"el":66,"sc":5,"sl":66},{"el":76,"sc":5,"sl":68},{"el":92,"sc":5,"sl":78}],"name":"UserServiceTest","sl":20}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_0":{"methods":[{"sl":78}],"name":"when create a user, but there exists a user with the same email, it should throw an exception","pass":true,"statements":[{"sl":80},{"sl":81},{"sl":86},{"sl":89},{"sl":90},{"sl":91}]},"test_12":{"methods":[{"sl":68}],"name":"when create a user, it should return an access token","pass":true,"statements":[{"sl":70},{"sl":73},{"sl":74},{"sl":75}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [12], [], [12], [], [], [12], [12], [12], [], [], [0], [], [0], [0], [], [], [], [], [0], [], [], [0], [0], [0], [], []]
