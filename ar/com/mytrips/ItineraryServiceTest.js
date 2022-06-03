var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":91,"id":98,"methods":[{"el":26,"sc":5,"sl":17},{"el":41,"sc":5,"sl":28},{"el":63,"sc":5,"sl":43},{"el":76,"sc":5,"sl":65},{"el":90,"sc":5,"sl":78}],"name":"ItineraryServiceTest","sl":11}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_0":{"methods":[{"sl":28}],"name":"when create an itinerary for a day, it should return the full itinerary.","pass":true,"statements":[{"sl":30},{"sl":31},{"sl":34},{"sl":37},{"sl":38},{"sl":39},{"sl":40}]},"test_2":{"methods":[{"sl":43}],"name":"when update an itinerary for a day, it should return an updated itinerary","pass":true,"statements":[{"sl":45},{"sl":46},{"sl":47},{"sl":49},{"sl":54},{"sl":57},{"sl":58},{"sl":59},{"sl":60},{"sl":61},{"sl":62}]},"test_3":{"methods":[{"sl":65}],"name":"when delete an itinerary for a day, but the itinerary is valid, should be able to delete it","pass":true,"statements":[{"sl":67},{"sl":68},{"sl":69},{"sl":72},{"sl":75}]},"test_4":{"methods":[{"sl":78}],"name":"when delete an itinerary for a day, but the itinerary is invalid, it should throw an exception","pass":true,"statements":[{"sl":80},{"sl":81},{"sl":84},{"sl":87},{"sl":88},{"sl":89}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [0], [], [0], [0], [], [], [0], [], [], [0], [0], [0], [0], [], [], [2], [], [2], [2], [2], [], [2], [], [], [], [], [2], [], [], [2], [2], [2], [2], [2], [2], [], [], [3], [], [3], [3], [3], [], [], [3], [], [], [3], [], [], [4], [], [4], [4], [], [], [4], [], [], [4], [4], [4], [], []]
