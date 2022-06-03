var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":33,"id":363,"methods":[{"el":19,"sc":5,"sl":16},{"el":25,"sc":5,"sl":21},{"el":32,"sc":5,"sl":27}],"name":"ItineraryService","sl":11}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_0":{"methods":[{"sl":27}],"name":"when create an itinerary for a day, it should return the full itinerary.","pass":true,"statements":[{"sl":28},{"sl":29},{"sl":30},{"sl":31}]},"test_2":{"methods":[{"sl":21},{"sl":27}],"name":"when update an itinerary for a day, it should return an updated itinerary","pass":true,"statements":[{"sl":22},{"sl":23},{"sl":24},{"sl":28},{"sl":29},{"sl":30},{"sl":31}]},"test_3":{"methods":[{"sl":16},{"sl":27}],"name":"when delete an itinerary for a day, but the itinerary is valid, should be able to delete it","pass":true,"statements":[{"sl":17},{"sl":18},{"sl":28},{"sl":29},{"sl":30},{"sl":31}]},"test_4":{"methods":[{"sl":16}],"name":"when delete an itinerary for a day, but the itinerary is invalid, it should throw an exception","pass":true,"statements":[{"sl":17}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [3, 4], [3, 4], [3], [], [], [2], [2], [2], [2], [], [], [2, 3, 0], [2, 3, 0], [2, 3, 0], [2, 3, 0], [2, 3, 0], [], []]
