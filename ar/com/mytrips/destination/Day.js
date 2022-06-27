var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":54,"id":1220,"methods":[{"el":12,"sc":5,"sl":12},{"el":14,"sc":5,"sl":14},{"el":16,"sc":5,"sl":16},{"el":20,"sc":5,"sl":17},{"el":24,"sc":5,"sl":22},{"el":27,"sc":5,"sl":25},{"el":37,"sc":5,"sl":29},{"el":42,"sc":5,"sl":39},{"el":47,"sc":5,"sl":44},{"el":53,"sc":5,"sl":49}],"name":"Day","sl":8}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_10":{"methods":[{"sl":29},{"sl":39}],"name":"when delete an activity for a day, but the activity is valid, should be able to delete it","pass":true,"statements":[{"sl":30},{"sl":33},{"sl":34},{"sl":35},{"sl":36},{"sl":40},{"sl":41}]},"test_13":{"methods":[{"sl":12},{"sl":25}],"name":"by subtracting days, the previous destination cannot run out of days\n","pass":true,"statements":[{"sl":26}]},"test_16":{"methods":[{"sl":39}],"name":"when create an activity for a day, it should return the full activity.","pass":true,"statements":[{"sl":40},{"sl":41}]},"test_17":{"methods":[{"sl":44}],"name":"when a trip is asked for the total cost, it should return it.","pass":true,"statements":[{"sl":45},{"sl":46}]},"test_18":{"methods":[{"sl":12},{"sl":22}],"name":"when adding days, the next destination cannot run out of days","pass":true,"statements":[{"sl":23}]},"test_27":{"methods":[{"sl":12},{"sl":49}],"name":"when a trip is copied, a new trip with the same configuration is returned","pass":true,"statements":[{"sl":50},{"sl":51},{"sl":52}]},"test_4":{"methods":[{"sl":12},{"sl":25}],"name":"when a trip is subtract a day to one of its destinations, it should return the updated destination","pass":true,"statements":[{"sl":26}]},"test_40":{"methods":[{"sl":39}],"name":"when update an activity for a day, it should return an updated activity","pass":true,"statements":[{"sl":40},{"sl":41}]},"test_42":{"methods":[{"sl":12},{"sl":22}],"name":"when a trip is added a day to one of its destinations, it should return the updated destination","pass":true,"statements":[{"sl":23}]},"test_8":{"methods":[{"sl":29}],"name":"when delete an activity for a day, but the activity is invalid, it should throw an exception","pass":true,"statements":[{"sl":30},{"sl":31}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [4, 18, 27, 13, 42], [], [], [], [], [], [], [], [], [], [18, 42], [18, 42], [], [4, 13], [4, 13], [], [], [8, 10], [8, 10], [8], [], [10], [10], [10], [10], [], [], [16, 10, 40], [16, 10, 40], [16, 10, 40], [], [], [17], [17], [17], [], [], [27], [27], [27], [27], [], []]
