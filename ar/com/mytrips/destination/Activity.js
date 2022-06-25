var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":49,"id":1257,"methods":[{"el":17,"sc":5,"sl":17},{"el":19,"sc":5,"sl":19},{"el":28,"sc":5,"sl":21},{"el":30,"sc":5,"sl":30},{"el":36,"sc":5,"sl":32},{"el":40,"sc":5,"sl":38},{"el":44,"sc":5,"sl":42},{"el":48,"sc":5,"sl":46}],"name":"Activity","sl":9}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_13":{"methods":[{"sl":17}],"name":"when create an activity for a day, it should return the full activity.","pass":true,"statements":[]},"test_14":{"methods":[{"sl":17}],"name":"when update an activity for a day, it should return an updated activity","pass":true,"statements":[]},"test_18":{"methods":[{"sl":17}],"name":"when delete an activity for a day, but the activity is invalid, it should throw an exception","pass":true,"statements":[]},"test_29":{"methods":[{"sl":17}],"name":"when delete an activity for a day, but the activity is valid, should be able to delete it","pass":true,"statements":[]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [14, 13, 29, 18], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], []]
