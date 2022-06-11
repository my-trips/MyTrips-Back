var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":92,"id":220,"methods":[{"el":27,"sc":5,"sl":18},{"el":42,"sc":5,"sl":29},{"el":64,"sc":5,"sl":44},{"el":77,"sc":5,"sl":66},{"el":91,"sc":5,"sl":79}],"name":"ActivityServiceTest","sl":12}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_19":{"methods":[{"sl":29}],"name":"when create an activity for a day, it should return the full activity.","pass":true,"statements":[{"sl":31},{"sl":32},{"sl":35},{"sl":38},{"sl":39},{"sl":40},{"sl":41}]},"test_27":{"methods":[{"sl":44}],"name":"when update an activity for a day, it should return an updated activity","pass":true,"statements":[{"sl":46},{"sl":47},{"sl":48},{"sl":50},{"sl":55},{"sl":58},{"sl":59},{"sl":60},{"sl":61},{"sl":62},{"sl":63}]},"test_37":{"methods":[{"sl":79}],"name":"when delete an activity for a day, but the activity is invalid, it should throw an exception","pass":true,"statements":[{"sl":81},{"sl":82},{"sl":85},{"sl":88},{"sl":89},{"sl":90}]},"test_38":{"methods":[{"sl":66}],"name":"when delete an activity for a day, but the activity is valid, should be able to delete it","pass":true,"statements":[{"sl":68},{"sl":69},{"sl":70},{"sl":73},{"sl":76}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [19], [], [19], [19], [], [], [19], [], [], [19], [19], [19], [19], [], [], [27], [], [27], [27], [27], [], [27], [], [], [], [], [27], [], [], [27], [27], [27], [27], [27], [27], [], [], [38], [], [38], [38], [38], [], [], [38], [], [], [38], [], [], [37], [], [37], [37], [], [], [37], [], [], [37], [37], [37], [], []]
