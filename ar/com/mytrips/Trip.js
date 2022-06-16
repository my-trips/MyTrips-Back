var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":114,"id":470,"methods":[{"el":14,"sc":5,"sl":14},{"el":16,"sc":5,"sl":16},{"el":17,"sc":5,"sl":17},{"el":18,"sc":5,"sl":18},{"el":20,"sc":5,"sl":20},{"el":21,"sc":5,"sl":21},{"el":28,"sc":5,"sl":23},{"el":34,"sc":5,"sl":30},{"el":35,"sc":5,"sl":35},{"el":49,"sc":5,"sl":38},{"el":56,"sc":5,"sl":51},{"el":63,"sc":5,"sl":58},{"el":69,"sc":5,"sl":65},{"el":73,"sc":5,"sl":71},{"el":77,"sc":5,"sl":75},{"el":81,"sc":5,"sl":79},{"el":85,"sc":5,"sl":83},{"el":90,"sc":5,"sl":87},{"el":96,"sc":5,"sl":92},{"el":101,"sc":5,"sl":98},{"el":105,"sc":5,"sl":103},{"el":108,"sc":5,"sl":106},{"el":113,"sc":5,"sl":110}],"name":"Trip","sl":11}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_1":{"methods":[{"sl":110}],"name":"when update the type of transport between two destinations of a trip, it should return an updated transport","pass":true,"statements":[{"sl":111},{"sl":112}]},"test_10":{"methods":[{"sl":83},{"sl":87},{"sl":103},{"sl":106},{"sl":110}],"name":"when fetch a trip for id, if the trip exists it should return it","pass":true,"statements":[{"sl":84},{"sl":88},{"sl":89},{"sl":104},{"sl":107},{"sl":111},{"sl":112}]},"test_11":{"methods":[{"sl":14},{"sl":16},{"sl":17},{"sl":18},{"sl":38},{"sl":71},{"sl":75},{"sl":79}],"name":"when total days of a trip is requested, it should return the number of days.","pass":true,"statements":[{"sl":39},{"sl":40},{"sl":41},{"sl":42},{"sl":43},{"sl":45},{"sl":48},{"sl":72},{"sl":76},{"sl":80}]},"test_12":{"methods":[{"sl":87},{"sl":110}],"name":"when delete an stay for a destination, but the stay is valid, should be able to delete it","pass":true,"statements":[{"sl":88},{"sl":89},{"sl":111},{"sl":112}]},"test_13":{"methods":[{"sl":110}],"name":"when update the arrival and departure dates of a transport between two destinations of a trip, it should return an updated transport","pass":true,"statements":[{"sl":111},{"sl":112}]},"test_14":{"methods":[{"sl":87},{"sl":110}],"name":"when update an stay for a destination, it should return an updated stay","pass":true,"statements":[{"sl":88},{"sl":89},{"sl":111},{"sl":112}]},"test_15":{"methods":[{"sl":87},{"sl":98},{"sl":110}],"name":"when a trip is added a day to one of its destinations, it should return the updated destination","pass":true,"statements":[{"sl":88},{"sl":89},{"sl":99},{"sl":100},{"sl":111},{"sl":112}]},"test_16":{"methods":[{"sl":87},{"sl":98},{"sl":110}],"name":"by subtracting days, the previous destination cannot run out of days\n","pass":true,"statements":[{"sl":88},{"sl":89},{"sl":99},{"sl":100},{"sl":111},{"sl":112}]},"test_17":{"methods":[{"sl":83},{"sl":87}],"name":"when delete an activity for a day, but the activity is invalid, it should throw an exception","pass":true,"statements":[{"sl":84},{"sl":88},{"sl":89}]},"test_18":{"methods":[{"sl":87}],"name":"when delete an stay for a destination, but the stay is invalid, it should throw an exception","pass":true,"statements":[{"sl":88},{"sl":89}]},"test_19":{"methods":[{"sl":83},{"sl":87},{"sl":110}],"name":"when update an activity for a day, it should return an updated activity","pass":true,"statements":[{"sl":84},{"sl":88},{"sl":89},{"sl":111},{"sl":112}]},"test_20":{"methods":[{"sl":83},{"sl":87}],"name":"when delete a trip from a user, you should be able to delete it","pass":true,"statements":[{"sl":84},{"sl":88},{"sl":89}]},"test_21":{"methods":[{"sl":58},{"sl":83},{"sl":87}],"name":"when the owner is removed as a traveller, it should throw an exception","pass":true,"statements":[{"sl":59},{"sl":60},{"sl":84},{"sl":88},{"sl":89}]},"test_22":{"methods":[{"sl":51},{"sl":83},{"sl":87}],"name":"when the owner is added as a traveller, it should throw an exception","pass":true,"statements":[{"sl":52},{"sl":53},{"sl":84},{"sl":88},{"sl":89}]},"test_23":{"methods":[{"sl":51},{"sl":83},{"sl":87}],"name":"when add a traveller that already exists, it should throw an exception","pass":true,"statements":[{"sl":52},{"sl":53},{"sl":55},{"sl":84},{"sl":88},{"sl":89}]},"test_24":{"methods":[{"sl":83},{"sl":87},{"sl":110}],"name":"when delete an activity for a day, but the activity is valid, should be able to delete it","pass":true,"statements":[{"sl":84},{"sl":88},{"sl":89},{"sl":111},{"sl":112}]},"test_25":{"methods":[{"sl":14},{"sl":16},{"sl":17},{"sl":18},{"sl":38},{"sl":83},{"sl":87},{"sl":92}],"name":"when a trip is asked for the total cost, it should return it.","pass":true,"statements":[{"sl":39},{"sl":40},{"sl":41},{"sl":42},{"sl":43},{"sl":45},{"sl":48},{"sl":84},{"sl":88},{"sl":89},{"sl":93},{"sl":94},{"sl":95}]},"test_26":{"methods":[{"sl":14},{"sl":16},{"sl":17},{"sl":18},{"sl":38},{"sl":87}],"name":"when a trip is asked for the destinations without origin, it should return it.","pass":true,"statements":[{"sl":39},{"sl":40},{"sl":41},{"sl":42},{"sl":43},{"sl":45},{"sl":48},{"sl":88},{"sl":89}]},"test_27":{"methods":[{"sl":83},{"sl":87},{"sl":103},{"sl":106},{"sl":110}],"name":"when search for all trips for a user, it should return all of them","pass":true,"statements":[{"sl":84},{"sl":88},{"sl":89},{"sl":104},{"sl":107},{"sl":111},{"sl":112}]},"test_28":{"methods":[{"sl":14},{"sl":16},{"sl":17},{"sl":18},{"sl":38},{"sl":83},{"sl":87},{"sl":98}],"name":"when ask a trip if a destination is not the last, and it is not, it should return true.","pass":true,"statements":[{"sl":39},{"sl":40},{"sl":41},{"sl":42},{"sl":43},{"sl":45},{"sl":48},{"sl":84},{"sl":88},{"sl":89},{"sl":99},{"sl":100}]},"test_29":{"methods":[{"sl":83},{"sl":87},{"sl":110}],"name":"when create an activity for a day, it should return the full activity.","pass":true,"statements":[{"sl":84},{"sl":88},{"sl":89},{"sl":111},{"sl":112}]},"test_3":{"methods":[{"sl":51},{"sl":58},{"sl":83},{"sl":87}],"name":"when a traveller is removed, it should be removed from the list of travellers","pass":true,"statements":[{"sl":52},{"sl":55},{"sl":59},{"sl":62},{"sl":84},{"sl":88},{"sl":89}]},"test_30":{"methods":[{"sl":87},{"sl":110}],"name":"when create an stay for a destination, it should return the full stay.","pass":true,"statements":[{"sl":88},{"sl":89},{"sl":111},{"sl":112}]},"test_32":{"methods":[{"sl":83},{"sl":87}],"name":"when changeVisibility is called with true, the trip becomes public","pass":true,"statements":[{"sl":84},{"sl":88},{"sl":89}]},"test_33":{"methods":[{"sl":58},{"sl":83},{"sl":87}],"name":"when removing a traveller that doesn't exist, it should throw an exception","pass":true,"statements":[{"sl":59},{"sl":60},{"sl":84},{"sl":88},{"sl":89}]},"test_37":{"methods":[{"sl":83},{"sl":87}],"name":"when create a trip, it should return a complete trip","pass":true,"statements":[{"sl":84},{"sl":88},{"sl":89}]},"test_38":{"methods":[{"sl":51},{"sl":83},{"sl":87}],"name":"when a traveller is added, it should should increase the list of travellers","pass":true,"statements":[{"sl":52},{"sl":55},{"sl":84},{"sl":88},{"sl":89}]},"test_39":{"methods":[{"sl":14},{"sl":16},{"sl":17},{"sl":18},{"sl":38},{"sl":75}],"name":"when a trip is asked for the start date, it should return it.","pass":true,"statements":[{"sl":39},{"sl":40},{"sl":41},{"sl":42},{"sl":43},{"sl":45},{"sl":48},{"sl":76}]},"test_4":{"methods":[{"sl":83},{"sl":87}],"name":"when a non-owner user removes a traveller, it should throw an exception","pass":true,"statements":[{"sl":84},{"sl":88},{"sl":89}]},"test_42":{"methods":[{"sl":14},{"sl":16},{"sl":17},{"sl":18},{"sl":38},{"sl":83},{"sl":87}],"name":"when a trip is asked for the first destination, it should return it.","pass":true,"statements":[{"sl":39},{"sl":40},{"sl":41},{"sl":42},{"sl":43},{"sl":45},{"sl":48},{"sl":84},{"sl":88},{"sl":89}]},"test_43":{"methods":[{"sl":14},{"sl":16},{"sl":17},{"sl":18},{"sl":38},{"sl":83},{"sl":87}],"name":"when destinations are added to a trip, it must return the updated trip.","pass":true,"statements":[{"sl":39},{"sl":40},{"sl":41},{"sl":42},{"sl":43},{"sl":45},{"sl":48},{"sl":84},{"sl":88},{"sl":89}]},"test_44":{"methods":[{"sl":14},{"sl":16},{"sl":17},{"sl":18},{"sl":38},{"sl":79}],"name":"when a trip is asked for the end date, it should return it.","pass":true,"statements":[{"sl":39},{"sl":40},{"sl":41},{"sl":42},{"sl":43},{"sl":45},{"sl":48},{"sl":80}]},"test_6":{"methods":[{"sl":87},{"sl":98},{"sl":110}],"name":"when a trip is subtract a day to one of its destinations, it should return the updated destination","pass":true,"statements":[{"sl":88},{"sl":89},{"sl":99},{"sl":100},{"sl":111},{"sl":112}]},"test_8":{"methods":[{"sl":87},{"sl":98},{"sl":110}],"name":"when adding days, the next destination cannot run out of days","pass":true,"statements":[{"sl":88},{"sl":89},{"sl":99},{"sl":100},{"sl":111},{"sl":112}]},"test_9":{"methods":[{"sl":14},{"sl":16},{"sl":17},{"sl":18},{"sl":38},{"sl":65},{"sl":83},{"sl":87}],"name":"when a trip is copied, a new trip with the same configuration is returned","pass":true,"statements":[{"sl":39},{"sl":40},{"sl":41},{"sl":42},{"sl":43},{"sl":45},{"sl":48},{"sl":66},{"sl":67},{"sl":68},{"sl":84},{"sl":88},{"sl":89}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [28, 39, 42, 44, 26, 9, 43, 11, 25], [], [28, 39, 42, 44, 26, 9, 43, 11, 25], [28, 39, 42, 44, 26, 9, 43, 11, 25], [28, 39, 42, 44, 26, 9, 43, 11, 25], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [28, 39, 42, 44, 26, 9, 43, 11, 25], [28, 39, 42, 44, 26, 9, 43, 11, 25], [28, 39, 42, 44, 26, 9, 43, 11, 25], [28, 39, 42, 44, 26, 9, 43, 11, 25], [28, 39, 42, 44, 26, 9, 43, 11, 25], [28, 39, 42, 44, 26, 9, 43, 11, 25], [], [28, 39, 42, 44, 26, 9, 43, 11, 25], [], [], [28, 39, 42, 44, 26, 9, 43, 11, 25], [], [], [23, 3, 22, 38], [23, 3, 22, 38], [23, 22], [], [23, 3, 38], [], [], [21, 3, 33], [21, 3, 33], [21, 33], [], [3], [], [], [9], [9], [9], [9], [], [], [11], [11], [], [], [39, 11], [39, 11], [], [], [44, 11], [44, 11], [], [], [20, 21, 28, 23, 42, 10, 17, 24, 3, 4, 29, 19, 32, 9, 43, 22, 38, 25, 27, 33, 37], [20, 21, 28, 23, 42, 10, 17, 24, 3, 4, 29, 19, 32, 9, 43, 22, 38, 25, 27, 33, 37], [], [], [20, 21, 28, 23, 42, 10, 26, 15, 17, 24, 3, 4, 29, 16, 19, 32, 12, 18, 9, 43, 22, 6, 14, 38, 25, 27, 30, 33, 37, 8], [20, 21, 28, 23, 42, 10, 26, 15, 17, 24, 3, 4, 29, 16, 19, 32, 12, 18, 9, 43, 22, 6, 14, 38, 25, 27, 30, 33, 37, 8], [20, 21, 28, 23, 42, 10, 26, 15, 17, 24, 3, 4, 29, 16, 19, 32, 12, 18, 9, 43, 22, 6, 14, 38, 25, 27, 30, 33, 37, 8], [], [], [25], [25], [25], [25], [], [], [28, 15, 16, 6, 8], [28, 15, 16, 6, 8], [28, 15, 16, 6, 8], [], [], [10, 27], [10, 27], [], [10, 27], [10, 27], [], [], [10, 13, 15, 24, 29, 16, 19, 12, 1, 6, 14, 27, 30, 8], [10, 13, 15, 24, 29, 16, 19, 12, 1, 6, 14, 27, 30, 8], [10, 13, 15, 24, 29, 16, 19, 12, 1, 6, 14, 27, 30, 8], [], []]
