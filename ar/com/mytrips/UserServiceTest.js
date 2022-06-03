var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":63,"id":0,"methods":[{"el":17,"sc":5,"sl":13},{"el":35,"sc":5,"sl":22},{"el":37,"sc":5,"sl":37},{"el":46,"sc":5,"sl":39},{"el":62,"sc":5,"sl":48}],"name":"UserServiceTest","sl":11}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_14":{"methods":[{"sl":48}],"name":"when create a user, but there exists a user with the same email, it should throw an exception","pass":true,"statements":[{"sl":50},{"sl":51},{"sl":56},{"sl":59},{"sl":60},{"sl":61}]},"test_15":{"methods":[{"sl":39}],"name":"when create a user, it should return an access token","pass":true,"statements":[{"sl":41},{"sl":44},{"sl":45}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [15], [], [15], [], [], [15], [15], [], [], [14], [], [14], [14], [], [], [], [], [14], [], [], [14], [14], [14], [], []]
