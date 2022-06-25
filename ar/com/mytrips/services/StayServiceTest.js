var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":139,"id":188,"methods":[{"el":49,"sc":5,"sl":19},{"el":95,"sc":5,"sl":51},{"el":119,"sc":5,"sl":97},{"el":138,"sc":5,"sl":121}],"name":"StayServiceTest","sl":14}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_11":{"methods":[{"sl":97}],"name":"when delete an stay for a destination, but the stay is valid, should be able to delete it","pass":true,"statements":[{"sl":99},{"sl":111},{"sl":112},{"sl":115},{"sl":118}]},"test_2":{"methods":[{"sl":51}],"name":"when update an stay for a destination, it should return an updated stay","pass":true,"statements":[{"sl":53},{"sl":65},{"sl":66},{"sl":68},{"sl":82},{"sl":85},{"sl":86},{"sl":87},{"sl":88},{"sl":89},{"sl":90},{"sl":91},{"sl":92},{"sl":93}]},"test_21":{"methods":[{"sl":19}],"name":"when create an stay for a destination, it should return the full stay.","pass":true,"statements":[{"sl":21},{"sl":34},{"sl":37},{"sl":40},{"sl":41},{"sl":42},{"sl":43},{"sl":44},{"sl":45},{"sl":46},{"sl":47},{"sl":48}]},"test_4":{"methods":[{"sl":121}],"name":"when delete an stay for a destination, but the stay is invalid, it should throw an exception","pass":true,"statements":[{"sl":123},{"sl":129},{"sl":132},{"sl":135},{"sl":136},{"sl":137}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [21], [], [21], [], [], [], [], [], [], [], [], [], [], [], [], [21], [], [], [21], [], [], [21], [21], [21], [21], [21], [21], [21], [21], [21], [], [], [2], [], [2], [], [], [], [], [], [], [], [], [], [], [], [2], [2], [], [2], [], [], [], [], [], [], [], [], [], [], [], [], [], [2], [], [], [2], [2], [2], [2], [2], [2], [2], [2], [2], [], [], [], [11], [], [11], [], [], [], [], [], [], [], [], [], [], [], [11], [11], [], [], [11], [], [], [11], [], [], [4], [], [4], [], [], [], [], [], [4], [], [], [4], [], [], [4], [4], [4], [], []]
