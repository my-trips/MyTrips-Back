var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":131,"id":0,"methods":[{"el":18,"sc":5,"sl":14},{"el":33,"sc":5,"sl":23},{"el":35,"sc":5,"sl":35},{"el":44,"sc":5,"sl":37},{"el":57,"sc":5,"sl":46},{"el":71,"sc":5,"sl":59},{"el":83,"sc":5,"sl":73},{"el":95,"sc":5,"sl":85},{"el":107,"sc":5,"sl":97},{"el":119,"sc":5,"sl":109},{"el":130,"sc":5,"sl":121}],"name":"UserServiceTest","sl":12}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_12":{"methods":[{"sl":85}],"name":"when I search by email, it returns the users that match","pass":true,"statements":[{"sl":87},{"sl":90},{"sl":93},{"sl":94}]},"test_17":{"methods":[{"sl":109}],"name":"when I search by lastName, it returns the users that match","pass":true,"statements":[{"sl":111},{"sl":114},{"sl":117},{"sl":118}]},"test_22":{"methods":[{"sl":121}],"name":"when I search for a nonexistent value, it should return an empty list","pass":true,"statements":[{"sl":123},{"sl":126},{"sl":129}]},"test_28":{"methods":[{"sl":73}],"name":"when fetch a user for email, if the user exists it should return it","pass":true,"statements":[{"sl":75},{"sl":78},{"sl":81},{"sl":82}]},"test_30":{"methods":[{"sl":59}],"name":"when fetch a user for id, if the user exists it should return it","pass":true,"statements":[{"sl":61},{"sl":64},{"sl":67},{"sl":68},{"sl":69},{"sl":70}]},"test_32":{"methods":[{"sl":97}],"name":"when I search by firstName, it returns the users that match","pass":true,"statements":[{"sl":99},{"sl":102},{"sl":105},{"sl":106}]},"test_7":{"methods":[{"sl":46}],"name":"when create a user, but there exists a user with the same email, it should throw an exception","pass":true,"statements":[{"sl":48},{"sl":49},{"sl":51},{"sl":54},{"sl":55},{"sl":56}]},"test_9":{"methods":[{"sl":37}],"name":"when create a user, it should return an user with authorities","pass":true,"statements":[{"sl":39},{"sl":42},{"sl":43}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [9], [], [9], [], [], [9], [9], [], [], [7], [], [7], [7], [], [7], [], [], [7], [7], [7], [], [], [30], [], [30], [], [], [30], [], [], [30], [30], [30], [30], [], [], [28], [], [28], [], [], [28], [], [], [28], [28], [], [], [12], [], [12], [], [], [12], [], [], [12], [12], [], [], [32], [], [32], [], [], [32], [], [], [32], [32], [], [], [17], [], [17], [], [], [17], [], [], [17], [17], [], [], [22], [], [22], [], [], [22], [], [], [22], [], []]