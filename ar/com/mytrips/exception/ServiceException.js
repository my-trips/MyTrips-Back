var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":50,"id":442,"methods":[{"el":13,"sc":5,"sl":11},{"el":20,"sc":5,"sl":15},{"el":25,"sc":5,"sl":22},{"el":29,"sc":5,"sl":27},{"el":33,"sc":5,"sl":31},{"el":37,"sc":5,"sl":35},{"el":41,"sc":5,"sl":39},{"el":45,"sc":5,"sl":43},{"el":49,"sc":5,"sl":47}],"name":"ServiceException","sl":5}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_14":{"methods":[{"sl":11},{"sl":15},{"sl":27}],"name":"when create a user, but there exists a user with the same email, it should throw an exception","pass":true,"statements":[{"sl":12},{"sl":16},{"sl":17},{"sl":18},{"sl":19},{"sl":28}]},"test_4":{"methods":[{"sl":11},{"sl":15},{"sl":27}],"name":"when delete an itinerary for a day, but the itinerary is invalid, it should throw an exception","pass":true,"statements":[{"sl":12},{"sl":16},{"sl":17},{"sl":18},{"sl":19},{"sl":28}]},"test_5":{"methods":[{"sl":11},{"sl":15},{"sl":39}],"name":"when delete a trip for a user, but the user is invalid, it should throw an exception","pass":true,"statements":[{"sl":12},{"sl":16},{"sl":17},{"sl":18},{"sl":19},{"sl":40}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [14, 5, 4], [14, 5, 4], [], [], [14, 5, 4], [14, 5, 4], [14, 5, 4], [14, 5, 4], [14, 5, 4], [], [], [], [], [], [], [], [14, 4], [14, 4], [], [], [], [], [], [], [], [], [], [], [5], [5], [], [], [], [], [], [], [], [], [], []]
