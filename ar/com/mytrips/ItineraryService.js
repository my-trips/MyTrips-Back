var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":33,"id":387,"methods":[{"el":19,"sc":5,"sl":16},{"el":25,"sc":5,"sl":21},{"el":32,"sc":5,"sl":27}],"name":"ItineraryService","sl":11}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_10":{"methods":[{"sl":16},{"sl":27}],"name":"when delete an itinerary for a day, but the itinerary is valid, should be able to delete it","pass":true,"statements":[{"sl":17},{"sl":18},{"sl":28},{"sl":29},{"sl":30},{"sl":31}]},"test_14":{"methods":[{"sl":16}],"name":"when delete an itinerary for a day, but the itinerary is invalid, it should throw an exception","pass":true,"statements":[{"sl":17}]},"test_4":{"methods":[{"sl":27}],"name":"when create an itinerary for a day, it should return the full itinerary.","pass":true,"statements":[{"sl":28},{"sl":29},{"sl":30},{"sl":31}]},"test_7":{"methods":[{"sl":21},{"sl":27}],"name":"when update an itinerary for a day, it should return an updated itinerary","pass":true,"statements":[{"sl":22},{"sl":23},{"sl":24},{"sl":28},{"sl":29},{"sl":30},{"sl":31}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [14, 10], [14, 10], [10], [], [], [7], [7], [7], [7], [], [], [7, 10, 4], [7, 10, 4], [7, 10, 4], [7, 10, 4], [7, 10, 4], [], []]
