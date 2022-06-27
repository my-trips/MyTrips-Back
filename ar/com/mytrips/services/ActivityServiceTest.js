var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":89,"id":309,"methods":[{"el":28,"sc":5,"sl":19},{"el":44,"sc":5,"sl":30},{"el":61,"sc":5,"sl":46},{"el":74,"sc":5,"sl":63},{"el":88,"sc":5,"sl":76}],"name":"ActivityServiceTest","sl":13}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_10":{"methods":[{"sl":63}],"name":"when delete an activity for a day, but the activity is valid, should be able to delete it","pass":true,"statements":[{"sl":65},{"sl":66},{"sl":67},{"sl":70},{"sl":73}]},"test_16":{"methods":[{"sl":30}],"name":"when create an activity for a day, it should return the full activity.","pass":true,"statements":[{"sl":32},{"sl":33},{"sl":36},{"sl":39},{"sl":40},{"sl":41},{"sl":42},{"sl":43}]},"test_40":{"methods":[{"sl":46}],"name":"when update an activity for a day, it should return an updated activity","pass":true,"statements":[{"sl":48},{"sl":49},{"sl":50},{"sl":52},{"sl":55},{"sl":58},{"sl":59},{"sl":60}]},"test_8":{"methods":[{"sl":76}],"name":"when delete an activity for a day, but the activity is invalid, it should throw an exception","pass":true,"statements":[{"sl":78},{"sl":79},{"sl":82},{"sl":85},{"sl":86},{"sl":87}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [16], [], [16], [16], [], [], [16], [], [], [16], [16], [16], [16], [16], [], [], [40], [], [40], [40], [40], [], [40], [], [], [40], [], [], [40], [40], [40], [], [], [10], [], [10], [10], [10], [], [], [10], [], [], [10], [], [], [8], [], [8], [8], [], [], [8], [], [], [8], [8], [8], [], []]
