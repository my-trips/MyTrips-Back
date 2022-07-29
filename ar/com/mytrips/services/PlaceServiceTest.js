var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":37,"id":261,"methods":[{"el":14,"sc":5,"sl":12},{"el":25,"sc":5,"sl":16},{"el":36,"sc":5,"sl":27}],"name":"PlaceServiceTest","sl":8}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_37":{"methods":[{"sl":27}],"name":"when fetch a place for name, if the place exists it should return it","pass":true,"statements":[{"sl":29},{"sl":32},{"sl":35}]},"test_45":{"methods":[{"sl":16}],"name":"when fetch a place for id, if the place exists it should return it","pass":true,"statements":[{"sl":18},{"sl":21},{"sl":24}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [45], [], [45], [], [], [45], [], [], [45], [], [], [37], [], [37], [], [], [37], [], [], [37], [], []]
