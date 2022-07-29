var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":20,"id":831,"methods":[{"el":13,"sc":5,"sl":9},{"el":19,"sc":5,"sl":15}],"name":"DestinationService","sl":6}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_10":{"methods":[{"sl":9}],"name":"when adding days, the next destination cannot run out of days","pass":true,"statements":[{"sl":10},{"sl":11},{"sl":12}]},"test_11":{"methods":[{"sl":15}],"name":"by subtracting days, the previous destination cannot run out of days\n","pass":true,"statements":[{"sl":16},{"sl":17},{"sl":18}]},"test_18":{"methods":[{"sl":15}],"name":"when a trip is subtract a day to one of its destinations, it should return the updated destination","pass":true,"statements":[{"sl":16},{"sl":17},{"sl":18}]},"test_4":{"methods":[{"sl":9}],"name":"when a trip is added a day to one of its destinations, it should return the updated destination","pass":true,"statements":[{"sl":10},{"sl":11},{"sl":12}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [10, 4], [10, 4], [10, 4], [10, 4], [], [], [11, 18], [11, 18], [11, 18], [11, 18], [], []]
