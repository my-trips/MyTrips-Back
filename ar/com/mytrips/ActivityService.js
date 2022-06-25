var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":36,"id":951,"methods":[{"el":19,"sc":5,"sl":16},{"el":25,"sc":5,"sl":21},{"el":35,"sc":5,"sl":27}],"name":"ActivityService","sl":11}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_1":{"methods":[{"sl":16},{"sl":27}],"name":"when delete an activity for a day, but the activity is valid, should be able to delete it","pass":true,"statements":[{"sl":17},{"sl":18},{"sl":28},{"sl":29},{"sl":30},{"sl":32},{"sl":33},{"sl":34}]},"test_15":{"methods":[{"sl":27}],"name":"when create an activity for a day, it should return the full activity.","pass":true,"statements":[{"sl":28},{"sl":29},{"sl":30},{"sl":32},{"sl":33},{"sl":34}]},"test_19":{"methods":[{"sl":21},{"sl":27}],"name":"when update an activity for a day, it should return an updated activity","pass":true,"statements":[{"sl":22},{"sl":23},{"sl":24},{"sl":28},{"sl":29},{"sl":30},{"sl":32},{"sl":33},{"sl":34}]},"test_36":{"methods":[{"sl":16}],"name":"when delete an activity for a day, but the activity is invalid, it should throw an exception","pass":true,"statements":[{"sl":17}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [36, 1], [36, 1], [1], [], [], [19], [19], [19], [19], [], [], [1, 19, 15], [1, 19, 15], [1, 19, 15], [1, 19, 15], [], [1, 19, 15], [1, 19, 15], [1, 19, 15], [], []]
