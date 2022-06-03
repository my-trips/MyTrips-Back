var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":58,"id":315,"methods":[{"el":30,"sc":5,"sl":28},{"el":43,"sc":5,"sl":32},{"el":57,"sc":5,"sl":45}],"name":"UserService","sl":19}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_0":{"methods":[{"sl":32}],"name":"when create a user, but there exists a user with the same email, it should throw an exception","pass":true,"statements":[{"sl":33}]},"test_12":{"methods":[{"sl":32},{"sl":45}],"name":"when create a user, it should return an access token","pass":true,"statements":[{"sl":33},{"sl":36},{"sl":37},{"sl":38},{"sl":40},{"sl":41},{"sl":42},{"sl":46},{"sl":48},{"sl":49},{"sl":50},{"sl":52},{"sl":53},{"sl":54},{"sl":55},{"sl":56}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [12, 0], [12, 0], [], [], [12], [12], [12], [], [12], [12], [12], [], [], [12], [12], [], [12], [12], [12], [], [12], [12], [12], [12], [12], [], []]
