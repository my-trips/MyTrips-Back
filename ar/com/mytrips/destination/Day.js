var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":50,"id":671,"methods":[{"el":14,"sc":5,"sl":14},{"el":16,"sc":5,"sl":16},{"el":18,"sc":5,"sl":18},{"el":22,"sc":5,"sl":19},{"el":26,"sc":5,"sl":24},{"el":29,"sc":5,"sl":27},{"el":38,"sc":5,"sl":31},{"el":43,"sc":5,"sl":40},{"el":48,"sc":5,"sl":45}],"name":"Day","sl":10}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_0":{"methods":[{"sl":14},{"sl":27}],"name":"hen a trip is subtract a day to one of its destinations, it should return the updated destination","pass":true,"statements":[{"sl":28}]},"test_11":{"methods":[{"sl":14},{"sl":24}],"name":"when a trip is added a day to one of its destinations, it should return the updated destination","pass":true,"statements":[{"sl":25}]},"test_3":{"methods":[{"sl":31}],"name":"when delete an itinerary for a day, but the itinerary is invalid, it should throw an exception","pass":true,"statements":[{"sl":32},{"sl":33}]},"test_6":{"methods":[{"sl":40}],"name":"when create an itinerary for a day, it should return the full itinerary.","pass":true,"statements":[{"sl":41},{"sl":42}]},"test_8":{"methods":[{"sl":40}],"name":"when update an itinerary for a day, it should return an updated itinerary","pass":true,"statements":[{"sl":41},{"sl":42}]},"test_9":{"methods":[{"sl":31},{"sl":40}],"name":"when delete an itinerary for a day, but the itinerary is valid, should be able to delete it","pass":true,"statements":[{"sl":32},{"sl":35},{"sl":36},{"sl":37},{"sl":41},{"sl":42}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [11, 0], [], [], [], [], [], [], [], [], [], [11], [11], [], [0], [0], [], [], [3, 9], [3, 9], [3], [], [9], [9], [9], [], [], [8, 9, 6], [8, 9, 6], [8, 9, 6], [], [], [], [], [], [], [], []]
