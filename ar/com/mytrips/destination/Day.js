var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":53,"id":953,"methods":[{"el":12,"sc":5,"sl":12},{"el":14,"sc":5,"sl":14},{"el":16,"sc":5,"sl":16},{"el":20,"sc":5,"sl":17},{"el":24,"sc":5,"sl":22},{"el":27,"sc":5,"sl":25},{"el":36,"sc":5,"sl":29},{"el":41,"sc":5,"sl":38},{"el":46,"sc":5,"sl":43},{"el":52,"sc":5,"sl":48}],"name":"Day","sl":8}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_13":{"methods":[{"sl":12},{"sl":25}],"name":"when a trip is subtract a day to one of its destinations, it should return the updated destination","pass":true,"statements":[{"sl":26}]},"test_15":{"methods":[{"sl":38}],"name":"when create an activity for a day, it should return the full activity.","pass":true,"statements":[{"sl":39},{"sl":40}]},"test_17":{"methods":[{"sl":29}],"name":"when delete an activity for a day, but the activity is invalid, it should throw an exception","pass":true,"statements":[{"sl":30},{"sl":31}]},"test_18":{"methods":[{"sl":29},{"sl":38}],"name":"when delete an activity for a day, but the activity is valid, should be able to delete it","pass":true,"statements":[{"sl":30},{"sl":33},{"sl":34},{"sl":35},{"sl":39},{"sl":40}]},"test_19":{"methods":[{"sl":12},{"sl":48}],"name":"when a trip is copied, a new trip with the same configuration is returned","pass":true,"statements":[{"sl":49},{"sl":50},{"sl":51}]},"test_26":{"methods":[{"sl":38}],"name":"when update an activity for a day, it should return an updated activity","pass":true,"statements":[{"sl":39},{"sl":40}]},"test_27":{"methods":[{"sl":12},{"sl":22}],"name":"when a trip is added a day to one of its destinations, it should return the updated destination","pass":true,"statements":[{"sl":23}]},"test_3":{"methods":[{"sl":12},{"sl":25}],"name":"by subtracting days, the previous destination cannot run out of days\n","pass":true,"statements":[{"sl":26}]},"test_30":{"methods":[{"sl":43}],"name":"when a trip is asked for the total cost, it should return it.","pass":true,"statements":[{"sl":44},{"sl":45}]},"test_8":{"methods":[{"sl":12},{"sl":22}],"name":"when adding days, the next destination cannot run out of days","pass":true,"statements":[{"sl":23}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [8, 3, 13, 19, 27], [], [], [], [], [], [], [], [], [], [8, 27], [8, 27], [], [3, 13], [3, 13], [], [], [17, 18], [17, 18], [17], [], [18], [18], [18], [], [], [15, 26, 18], [15, 26, 18], [15, 26, 18], [], [], [30], [30], [30], [], [], [19], [19], [19], [19], [], []]
