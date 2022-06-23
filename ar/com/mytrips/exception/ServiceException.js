var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":50,"id":483,"methods":[{"el":13,"sc":5,"sl":11},{"el":20,"sc":5,"sl":15},{"el":25,"sc":5,"sl":22},{"el":29,"sc":5,"sl":27},{"el":33,"sc":5,"sl":31},{"el":37,"sc":5,"sl":35},{"el":41,"sc":5,"sl":39},{"el":45,"sc":5,"sl":43},{"el":49,"sc":5,"sl":47}],"name":"ServiceException","sl":5}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_0":{"methods":[{"sl":11},{"sl":15},{"sl":27}],"name":"when adding days, the next destination cannot run out of days","pass":true,"statements":[{"sl":12},{"sl":16},{"sl":17},{"sl":18},{"sl":19},{"sl":28}]},"test_13":{"methods":[{"sl":11},{"sl":15},{"sl":27}],"name":"when the owner is removed as a traveller, it should throw an exception","pass":true,"statements":[{"sl":12},{"sl":16},{"sl":17},{"sl":18},{"sl":19},{"sl":28}]},"test_14":{"methods":[{"sl":11},{"sl":15},{"sl":27}],"name":"when delete an activity for a day, but the activity is invalid, it should throw an exception","pass":true,"statements":[{"sl":12},{"sl":16},{"sl":17},{"sl":18},{"sl":19},{"sl":28}]},"test_20":{"methods":[{"sl":11},{"sl":15},{"sl":27}],"name":"when removing a traveller that doesn't exist, it should throw an exception","pass":true,"statements":[{"sl":12},{"sl":16},{"sl":17},{"sl":18},{"sl":19},{"sl":28}]},"test_32":{"methods":[{"sl":11},{"sl":15},{"sl":39}],"name":"when a non-owner user removes a traveller, it should throw an exception","pass":true,"statements":[{"sl":12},{"sl":16},{"sl":17},{"sl":18},{"sl":19},{"sl":40}]},"test_34":{"methods":[{"sl":11},{"sl":15},{"sl":27}],"name":"when add a traveller that already exists, it should throw an exception","pass":true,"statements":[{"sl":12},{"sl":16},{"sl":17},{"sl":18},{"sl":19},{"sl":28}]},"test_36":{"methods":[{"sl":11},{"sl":15},{"sl":39}],"name":"when delete a trip for a user, but the user is invalid, it should throw an exception","pass":true,"statements":[{"sl":12},{"sl":16},{"sl":17},{"sl":18},{"sl":19},{"sl":40}]},"test_44":{"methods":[{"sl":11},{"sl":15},{"sl":27}],"name":"when the owner is added as a traveller, it should throw an exception","pass":true,"statements":[{"sl":12},{"sl":16},{"sl":17},{"sl":18},{"sl":19},{"sl":28}]},"test_5":{"methods":[{"sl":11},{"sl":15},{"sl":27}],"name":"by subtracting days, the previous destination cannot run out of days\n","pass":true,"statements":[{"sl":12},{"sl":16},{"sl":17},{"sl":18},{"sl":19},{"sl":28}]},"test_6":{"methods":[{"sl":11},{"sl":15},{"sl":27}],"name":"when create a user, but there exists a user with the same email, it should throw an exception","pass":true,"statements":[{"sl":12},{"sl":16},{"sl":17},{"sl":18},{"sl":19},{"sl":28}]},"test_7":{"methods":[{"sl":11},{"sl":15},{"sl":27}],"name":"when delete an stay for a destination, but the stay is invalid, it should throw an exception","pass":true,"statements":[{"sl":12},{"sl":16},{"sl":17},{"sl":18},{"sl":19},{"sl":28}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [36, 0, 13, 14, 5, 34, 44, 32, 20, 7, 6], [36, 0, 13, 14, 5, 34, 44, 32, 20, 7, 6], [], [], [36, 0, 13, 14, 5, 34, 44, 32, 20, 7, 6], [36, 0, 13, 14, 5, 34, 44, 32, 20, 7, 6], [36, 0, 13, 14, 5, 34, 44, 32, 20, 7, 6], [36, 0, 13, 14, 5, 34, 44, 32, 20, 7, 6], [36, 0, 13, 14, 5, 34, 44, 32, 20, 7, 6], [], [], [], [], [], [], [], [0, 13, 14, 5, 34, 44, 20, 7, 6], [0, 13, 14, 5, 34, 44, 20, 7, 6], [], [], [], [], [], [], [], [], [], [], [36, 32], [36, 32], [], [], [], [], [], [], [], [], [], []]
