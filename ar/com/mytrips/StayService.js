var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":27,"id":898,"methods":[{"el":15,"sc":5,"sl":11},{"el":21,"sc":5,"sl":17},{"el":26,"sc":5,"sl":23}],"name":"StayService","sl":8}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_27":{"methods":[{"sl":11}],"name":"when create an stay for a destination, it should return the full stay.","pass":true,"statements":[{"sl":12},{"sl":13},{"sl":14}]},"test_37":{"methods":[{"sl":11},{"sl":17}],"name":"when update an stay for a destination, it should return an updated stay","pass":true,"statements":[{"sl":12},{"sl":13},{"sl":14},{"sl":18},{"sl":19},{"sl":20}]},"test_46":{"methods":[{"sl":11},{"sl":23}],"name":"when delete an stay for a destination, but the stay is valid, should be able to delete it","pass":true,"statements":[{"sl":12},{"sl":13},{"sl":14},{"sl":24},{"sl":25}]},"test_7":{"methods":[{"sl":23}],"name":"when delete an stay for a destination, but the stay is invalid, it should throw an exception","pass":true,"statements":[{"sl":24}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [27, 46, 37], [27, 46, 37], [27, 46, 37], [27, 46, 37], [], [], [37], [37], [37], [37], [], [], [46, 7], [46, 7], [46], [], []]
