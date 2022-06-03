var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":64,"id":0,"methods":[{"el":18,"sc":5,"sl":14},{"el":36,"sc":5,"sl":23},{"el":38,"sc":5,"sl":38},{"el":47,"sc":5,"sl":40},{"el":63,"sc":5,"sl":49}],"name":"UserServiceTest","sl":12}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_16":{"methods":[{"sl":40}],"name":"when create a user, it should return an access token","pass":true,"statements":[{"sl":42},{"sl":45},{"sl":46}]},"test_6":{"methods":[{"sl":49}],"name":"when create a user, but there exists a user with the same email, it should throw an exception","pass":true,"statements":[{"sl":51},{"sl":52},{"sl":57},{"sl":60},{"sl":61},{"sl":62}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [16], [], [16], [], [], [16], [16], [], [], [6], [], [6], [6], [], [], [], [], [6], [], [], [6], [6], [6], [], []]
