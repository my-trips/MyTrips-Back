var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":35,"id":807,"methods":[{"el":19,"sc":5,"sl":16},{"el":25,"sc":5,"sl":21},{"el":34,"sc":5,"sl":27}],"name":"ActivityService","sl":11}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_2":{"methods":[{"sl":21},{"sl":27}],"name":"when update an activity for a day, it should return an updated activity","pass":true,"statements":[{"sl":22},{"sl":23},{"sl":24},{"sl":28},{"sl":29},{"sl":31},{"sl":32},{"sl":33}]},"test_20":{"methods":[{"sl":27}],"name":"when create an activity for a day, it should return the full activity.","pass":true,"statements":[{"sl":28},{"sl":29},{"sl":31},{"sl":32},{"sl":33}]},"test_21":{"methods":[{"sl":16}],"name":"when delete an activity for a day, but the activity is invalid, it should throw an exception","pass":true,"statements":[{"sl":17}]},"test_23":{"methods":[{"sl":16},{"sl":27}],"name":"when delete an activity for a day, but the activity is valid, should be able to delete it","pass":true,"statements":[{"sl":17},{"sl":18},{"sl":28},{"sl":29},{"sl":31},{"sl":32},{"sl":33}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [21, 23], [21, 23], [23], [], [], [2], [2], [2], [2], [], [], [2, 20, 23], [2, 20, 23], [2, 20, 23], [], [2, 20, 23], [2, 20, 23], [2, 20, 23], [], []]