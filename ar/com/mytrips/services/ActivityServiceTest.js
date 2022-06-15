var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":93,"id":256,"methods":[{"el":27,"sc":5,"sl":18},{"el":43,"sc":5,"sl":29},{"el":65,"sc":5,"sl":45},{"el":78,"sc":5,"sl":67},{"el":92,"sc":5,"sl":80}],"name":"ActivityServiceTest","sl":12}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_0":{"methods":[{"sl":29}],"name":"when create an activity for a day, it should return the full activity.","pass":true,"statements":[{"sl":31},{"sl":32},{"sl":35},{"sl":38},{"sl":39},{"sl":40},{"sl":41},{"sl":42}]},"test_3":{"methods":[{"sl":45}],"name":"when update an activity for a day, it should return an updated activity","pass":true,"statements":[{"sl":47},{"sl":48},{"sl":49},{"sl":51},{"sl":56},{"sl":59},{"sl":60},{"sl":61},{"sl":62},{"sl":63},{"sl":64}]},"test_35":{"methods":[{"sl":80}],"name":"when delete an activity for a day, but the activity is invalid, it should throw an exception","pass":true,"statements":[{"sl":82},{"sl":83},{"sl":86},{"sl":89},{"sl":90},{"sl":91}]},"test_40":{"methods":[{"sl":67}],"name":"when delete an activity for a day, but the activity is valid, should be able to delete it","pass":true,"statements":[{"sl":69},{"sl":70},{"sl":71},{"sl":74},{"sl":77}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [0], [], [0], [0], [], [], [0], [], [], [0], [0], [0], [0], [0], [], [], [3], [], [3], [3], [3], [], [3], [], [], [], [], [3], [], [], [3], [3], [3], [3], [3], [3], [], [], [40], [], [40], [40], [40], [], [], [40], [], [], [40], [], [], [35], [], [35], [35], [], [], [35], [], [], [35], [35], [35], [], []]
