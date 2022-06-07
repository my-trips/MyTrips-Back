var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":39,"id":572,"methods":[{"el":17,"sc":5,"sl":15},{"el":21,"sc":5,"sl":19},{"el":33,"sc":5,"sl":23},{"el":38,"sc":5,"sl":35}],"name":"UserService","sl":10}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_0":{"methods":[{"sl":35}],"name":"when I search by firstName, it returns the users that match","pass":true,"statements":[{"sl":36},{"sl":37}]},"test_18":{"methods":[{"sl":35}],"name":"when I search for a nonexistent value, it should return an empty list","pass":true,"statements":[{"sl":36},{"sl":37}]},"test_29":{"methods":[{"sl":35}],"name":"when I search by lastName, it returns the users that match","pass":true,"statements":[{"sl":36},{"sl":37}]},"test_33":{"methods":[{"sl":23}],"name":"when create a user, but there exists a user with the same email, it should throw an exception","pass":true,"statements":[{"sl":24}]},"test_36":{"methods":[{"sl":19}],"name":"when fetch a user for id, if the user exists it should return it","pass":true,"statements":[{"sl":20}]},"test_38":{"methods":[{"sl":35}],"name":"when I search by email, it returns the users that match","pass":true,"statements":[{"sl":36},{"sl":37}]},"test_7":{"methods":[{"sl":23}],"name":"when create a user, it should return an user with authorities","pass":true,"statements":[{"sl":24},{"sl":27},{"sl":28},{"sl":29},{"sl":31},{"sl":32}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [36], [36], [], [], [7, 33], [7, 33], [], [], [7], [7], [7], [], [7], [7], [], [], [38, 0, 29, 18], [38, 0, 29, 18], [38, 0, 29, 18], [], []]
