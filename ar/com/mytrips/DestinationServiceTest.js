var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":42,"id":136,"methods":[{"el":23,"sc":5,"sl":7},{"el":41,"sc":5,"sl":25}],"name":"DestinationServiceTest","sl":5}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_13":{"methods":[{"sl":7}],"name":"when a trip is added a day to one of its destinations, it should return the updated destination","pass":true,"statements":[{"sl":9},{"sl":10},{"sl":11},{"sl":12},{"sl":13},{"sl":16},{"sl":19},{"sl":20},{"sl":21},{"sl":22}]},"test_8":{"methods":[{"sl":25}],"name":"hen a trip is subtract a day to one of its destinations, it should return the updated destination","pass":true,"statements":[{"sl":27},{"sl":28},{"sl":29},{"sl":30},{"sl":31},{"sl":34},{"sl":37},{"sl":38},{"sl":39},{"sl":40}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [13], [], [13], [13], [13], [13], [13], [], [], [13], [], [], [13], [13], [13], [13], [], [], [8], [], [8], [8], [8], [8], [8], [], [], [8], [], [], [8], [8], [8], [8], [], []]
