var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":89,"id":186,"methods":[{"el":13,"sc":5,"sl":13},{"el":18,"sc":5,"sl":18},{"el":24,"sc":5,"sl":20},{"el":29,"sc":5,"sl":26},{"el":30,"sc":5,"sl":30},{"el":44,"sc":5,"sl":33},{"el":48,"sc":5,"sl":46},{"el":52,"sc":5,"sl":50},{"el":56,"sc":5,"sl":54},{"el":60,"sc":5,"sl":58},{"el":65,"sc":5,"sl":62},{"el":71,"sc":5,"sl":67},{"el":76,"sc":5,"sl":73},{"el":80,"sc":5,"sl":78},{"el":83,"sc":5,"sl":81},{"el":88,"sc":5,"sl":85}],"name":"Trip","sl":10}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_1":{"methods":[{"sl":58},{"sl":62}],"name":"when delete an itinerary for a day, but the itinerary is invalid, it should throw an exception","pass":true,"statements":[{"sl":59},{"sl":63},{"sl":64}]},"test_11":{"methods":[{"sl":58},{"sl":62},{"sl":85}],"name":"when update an itinerary for a day, it should return an updated itinerary","pass":true,"statements":[{"sl":59},{"sl":63},{"sl":64},{"sl":86},{"sl":87}]},"test_14":{"methods":[{"sl":85}],"name":"when update the arrival and departure dates of a transport between two destinations of a trip, it should return an updated transport","pass":true,"statements":[{"sl":86},{"sl":87}]},"test_15":{"methods":[{"sl":85}],"name":"when update the type of transport between two destinations of a trip, it should return an updated transport","pass":true,"statements":[{"sl":86},{"sl":87}]},"test_16":{"methods":[{"sl":58},{"sl":62}],"name":"when delete a trip from a user, you should be able to delete it","pass":true,"statements":[{"sl":59},{"sl":63},{"sl":64}]},"test_2":{"methods":[{"sl":13},{"sl":58},{"sl":62},{"sl":78},{"sl":81},{"sl":85}],"name":"when fetch a trip for id, if the trip exists it should return it","pass":true,"statements":[{"sl":59},{"sl":63},{"sl":64},{"sl":79},{"sl":82},{"sl":86},{"sl":87}]},"test_3":{"methods":[{"sl":58},{"sl":62},{"sl":85}],"name":"when create an itinerary for a day, it should return the full itinerary.","pass":true,"statements":[{"sl":59},{"sl":63},{"sl":64},{"sl":86},{"sl":87}]},"test_4":{"methods":[{"sl":58},{"sl":62},{"sl":78},{"sl":81},{"sl":85}],"name":"when search for all trips for a user, it should return all of them","pass":true,"statements":[{"sl":59},{"sl":63},{"sl":64},{"sl":79},{"sl":82},{"sl":86},{"sl":87}]},"test_5":{"methods":[{"sl":62},{"sl":73},{"sl":85}],"name":"when a trip is added a day to one of its destinations, it should return the updated destination","pass":true,"statements":[{"sl":63},{"sl":64},{"sl":74},{"sl":75},{"sl":86},{"sl":87}]},"test_6":{"methods":[{"sl":58},{"sl":62},{"sl":85}],"name":"when delete an itinerary for a day, but the itinerary is valid, should be able to delete it","pass":true,"statements":[{"sl":59},{"sl":63},{"sl":64},{"sl":86},{"sl":87}]},"test_7":{"methods":[{"sl":58},{"sl":62}],"name":"when create a trip, it should return a complete trip","pass":true,"statements":[{"sl":59},{"sl":63},{"sl":64}]},"test_8":{"methods":[{"sl":62},{"sl":73},{"sl":85}],"name":"hen a trip is subtract a day to one of its destinations, it should return the updated destination","pass":true,"statements":[{"sl":63},{"sl":64},{"sl":74},{"sl":75},{"sl":86},{"sl":87}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [2], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [4, 1, 2, 3, 11, 6, 7, 16], [4, 1, 2, 3, 11, 6, 7, 16], [], [], [4, 1, 2, 3, 8, 11, 6, 7, 16, 5], [4, 1, 2, 3, 8, 11, 6, 7, 16, 5], [4, 1, 2, 3, 8, 11, 6, 7, 16, 5], [], [], [], [], [], [], [], [], [8, 5], [8, 5], [8, 5], [], [], [4, 2], [4, 2], [], [4, 2], [4, 2], [], [], [4, 2, 3, 8, 11, 6, 14, 5, 15], [4, 2, 3, 8, 11, 6, 14, 5, 15], [4, 2, 3, 8, 11, 6, 14, 5, 15], [], []]
