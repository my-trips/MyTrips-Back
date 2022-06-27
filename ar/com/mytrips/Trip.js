var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":124,"id":565,"methods":[{"el":16,"sc":5,"sl":16},{"el":18,"sc":5,"sl":18},{"el":19,"sc":5,"sl":19},{"el":20,"sc":5,"sl":20},{"el":22,"sc":5,"sl":22},{"el":23,"sc":5,"sl":23},{"el":30,"sc":5,"sl":25},{"el":36,"sc":5,"sl":32},{"el":37,"sc":5,"sl":37},{"el":51,"sc":5,"sl":40},{"el":58,"sc":5,"sl":53},{"el":65,"sc":5,"sl":60},{"el":71,"sc":5,"sl":67},{"el":75,"sc":5,"sl":73},{"el":79,"sc":5,"sl":77},{"el":83,"sc":5,"sl":81},{"el":87,"sc":5,"sl":85},{"el":92,"sc":5,"sl":89},{"el":98,"sc":5,"sl":94},{"el":103,"sc":5,"sl":100},{"el":107,"sc":5,"sl":105},{"el":111,"sc":5,"sl":109},{"el":115,"sc":5,"sl":113},{"el":118,"sc":5,"sl":116},{"el":123,"sc":5,"sl":120}],"name":"Trip","sl":13}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_0":{"methods":[{"sl":89},{"sl":120}],"name":"when create an stay for a destination, it should return the full stay.","pass":true,"statements":[{"sl":90},{"sl":91},{"sl":121},{"sl":122}]},"test_1":{"methods":[{"sl":16},{"sl":18},{"sl":19},{"sl":20},{"sl":40},{"sl":81}],"name":"when a trip is asked for the end date, it should return it.","pass":true,"statements":[{"sl":41},{"sl":42},{"sl":43},{"sl":44},{"sl":45},{"sl":47},{"sl":50},{"sl":82}]},"test_10":{"methods":[{"sl":85},{"sl":89},{"sl":120}],"name":"when delete an activity for a day, but the activity is valid, should be able to delete it","pass":true,"statements":[{"sl":86},{"sl":90},{"sl":91},{"sl":121},{"sl":122}]},"test_11":{"methods":[{"sl":120}],"name":"when update the type of transport between two destinations of a trip, it should return an updated transport","pass":true,"statements":[{"sl":121},{"sl":122}]},"test_13":{"methods":[{"sl":89},{"sl":100},{"sl":120}],"name":"by subtracting days, the previous destination cannot run out of days\n","pass":true,"statements":[{"sl":90},{"sl":91},{"sl":101},{"sl":102},{"sl":121},{"sl":122}]},"test_14":{"methods":[{"sl":16},{"sl":18},{"sl":19},{"sl":20},{"sl":40},{"sl":85},{"sl":89}],"name":"when a trip is asked for the first destination, it should return it.","pass":true,"statements":[{"sl":41},{"sl":42},{"sl":43},{"sl":44},{"sl":45},{"sl":47},{"sl":50},{"sl":86},{"sl":90},{"sl":91}]},"test_15":{"methods":[{"sl":85},{"sl":89},{"sl":113},{"sl":116},{"sl":120}],"name":"when fetch a trip for id, if the trip exists it should return it","pass":true,"statements":[{"sl":86},{"sl":90},{"sl":91},{"sl":114},{"sl":117},{"sl":121},{"sl":122}]},"test_16":{"methods":[{"sl":85},{"sl":89},{"sl":120}],"name":"when create an activity for a day, it should return the full activity.","pass":true,"statements":[{"sl":86},{"sl":90},{"sl":91},{"sl":121},{"sl":122}]},"test_17":{"methods":[{"sl":16},{"sl":18},{"sl":19},{"sl":20},{"sl":40},{"sl":85},{"sl":89},{"sl":94}],"name":"when a trip is asked for the total cost, it should return it.","pass":true,"statements":[{"sl":41},{"sl":42},{"sl":43},{"sl":44},{"sl":45},{"sl":47},{"sl":50},{"sl":86},{"sl":90},{"sl":91},{"sl":95},{"sl":96},{"sl":97}]},"test_18":{"methods":[{"sl":89},{"sl":100},{"sl":120}],"name":"when adding days, the next destination cannot run out of days","pass":true,"statements":[{"sl":90},{"sl":91},{"sl":101},{"sl":102},{"sl":121},{"sl":122}]},"test_2":{"methods":[{"sl":89},{"sl":120}],"name":"when delete an stay for a destination, but the stay is valid, should be able to delete it","pass":true,"statements":[{"sl":90},{"sl":91},{"sl":121},{"sl":122}]},"test_21":{"methods":[{"sl":53},{"sl":85},{"sl":89}],"name":"when the owner is added as a traveller, it should throw an exception","pass":true,"statements":[{"sl":54},{"sl":55},{"sl":86},{"sl":90},{"sl":91}]},"test_23":{"methods":[{"sl":16},{"sl":18},{"sl":19},{"sl":20},{"sl":40},{"sl":73},{"sl":77},{"sl":81}],"name":"when total days of a trip is requested, it should return the number of days.","pass":true,"statements":[{"sl":41},{"sl":42},{"sl":43},{"sl":44},{"sl":45},{"sl":47},{"sl":50},{"sl":74},{"sl":78},{"sl":82}]},"test_24":{"methods":[{"sl":85},{"sl":89},{"sl":113},{"sl":116},{"sl":120}],"name":"when get public a trip, it should return a trip published","pass":true,"statements":[{"sl":86},{"sl":90},{"sl":91},{"sl":114},{"sl":117},{"sl":121},{"sl":122}]},"test_25":{"methods":[{"sl":89}],"name":"when delete an stay for a destination, but the stay is invalid, it should throw an exception","pass":true,"statements":[{"sl":90},{"sl":91}]},"test_26":{"methods":[{"sl":85},{"sl":89}],"name":"when create a trip, it should return a complete trip","pass":true,"statements":[{"sl":86},{"sl":90},{"sl":91}]},"test_27":{"methods":[{"sl":16},{"sl":18},{"sl":19},{"sl":20},{"sl":40},{"sl":67},{"sl":85},{"sl":89}],"name":"when a trip is copied, a new trip with the same configuration is returned","pass":true,"statements":[{"sl":41},{"sl":42},{"sl":43},{"sl":44},{"sl":45},{"sl":47},{"sl":50},{"sl":68},{"sl":69},{"sl":70},{"sl":86},{"sl":90},{"sl":91}]},"test_28":{"methods":[{"sl":53},{"sl":60},{"sl":85},{"sl":89}],"name":"when a traveller is removed, it should be removed from the list of travellers","pass":true,"statements":[{"sl":54},{"sl":57},{"sl":61},{"sl":64},{"sl":86},{"sl":90},{"sl":91}]},"test_3":{"methods":[{"sl":85},{"sl":89},{"sl":113},{"sl":116},{"sl":120}],"name":"when search for all trips for a user, it should return all of them","pass":true,"statements":[{"sl":86},{"sl":90},{"sl":91},{"sl":114},{"sl":117},{"sl":121},{"sl":122}]},"test_31":{"methods":[{"sl":16},{"sl":18},{"sl":19},{"sl":20},{"sl":40},{"sl":77}],"name":"when a trip is asked for the start date, it should return it.","pass":true,"statements":[{"sl":41},{"sl":42},{"sl":43},{"sl":44},{"sl":45},{"sl":47},{"sl":50},{"sl":78}]},"test_32":{"methods":[{"sl":85},{"sl":89}],"name":"when changeVisibility is called with true, the trip becomes public","pass":true,"statements":[{"sl":86},{"sl":90},{"sl":91}]},"test_33":{"methods":[{"sl":53},{"sl":85},{"sl":89}],"name":"when add a traveller that already exists, it should throw an exception","pass":true,"statements":[{"sl":54},{"sl":55},{"sl":57},{"sl":86},{"sl":90},{"sl":91}]},"test_37":{"methods":[{"sl":89},{"sl":120}],"name":"when update an stay for a destination, it should return an updated stay","pass":true,"statements":[{"sl":90},{"sl":91},{"sl":121},{"sl":122}]},"test_38":{"methods":[{"sl":16},{"sl":18},{"sl":19},{"sl":20},{"sl":40},{"sl":89}],"name":"when a trip is asked for the destinations without origin, it should return it.","pass":true,"statements":[{"sl":41},{"sl":42},{"sl":43},{"sl":44},{"sl":45},{"sl":47},{"sl":50},{"sl":90},{"sl":91}]},"test_4":{"methods":[{"sl":89},{"sl":100},{"sl":120}],"name":"when a trip is subtract a day to one of its destinations, it should return the updated destination","pass":true,"statements":[{"sl":90},{"sl":91},{"sl":101},{"sl":102},{"sl":121},{"sl":122}]},"test_40":{"methods":[{"sl":85},{"sl":89},{"sl":120}],"name":"when update an activity for a day, it should return an updated activity","pass":true,"statements":[{"sl":86},{"sl":90},{"sl":91},{"sl":121},{"sl":122}]},"test_41":{"methods":[{"sl":16},{"sl":18},{"sl":19},{"sl":20},{"sl":40},{"sl":85},{"sl":89},{"sl":100}],"name":"when ask a trip if a destination is not the last, and it is not, it should return true.","pass":true,"statements":[{"sl":41},{"sl":42},{"sl":43},{"sl":44},{"sl":45},{"sl":47},{"sl":50},{"sl":86},{"sl":90},{"sl":91},{"sl":101},{"sl":102}]},"test_42":{"methods":[{"sl":89},{"sl":100},{"sl":120}],"name":"when a trip is added a day to one of its destinations, it should return the updated destination","pass":true,"statements":[{"sl":90},{"sl":91},{"sl":101},{"sl":102},{"sl":121},{"sl":122}]},"test_43":{"methods":[{"sl":60},{"sl":85},{"sl":89}],"name":"when the owner is removed as a traveller, it should throw an exception","pass":true,"statements":[{"sl":61},{"sl":62},{"sl":86},{"sl":90},{"sl":91}]},"test_47":{"methods":[{"sl":60},{"sl":85},{"sl":89}],"name":"when removing a traveller that doesn't exist, it should throw an exception","pass":true,"statements":[{"sl":61},{"sl":62},{"sl":86},{"sl":90},{"sl":91}]},"test_48":{"methods":[{"sl":85},{"sl":89}],"name":"when delete a trip from a user, you should be able to delete it","pass":true,"statements":[{"sl":86},{"sl":90},{"sl":91}]},"test_5":{"methods":[{"sl":85},{"sl":89}],"name":"when a non-owner user removes a traveller, it should throw an exception","pass":true,"statements":[{"sl":86},{"sl":90},{"sl":91}]},"test_50":{"methods":[{"sl":53},{"sl":85},{"sl":89}],"name":"when a traveller is added, it should should increase the list of travellers","pass":true,"statements":[{"sl":54},{"sl":57},{"sl":86},{"sl":90},{"sl":91}]},"test_6":{"methods":[{"sl":120}],"name":"when update the arrival and departure dates of a transport between two destinations of a trip, it should return an updated transport","pass":true,"statements":[{"sl":121},{"sl":122}]},"test_7":{"methods":[{"sl":16},{"sl":18},{"sl":19},{"sl":20},{"sl":40},{"sl":85},{"sl":89}],"name":"when destinations are added to a trip, it must return the updated trip.","pass":true,"statements":[{"sl":41},{"sl":42},{"sl":43},{"sl":44},{"sl":45},{"sl":47},{"sl":50},{"sl":86},{"sl":90},{"sl":91}]},"test_8":{"methods":[{"sl":85},{"sl":89}],"name":"when delete an activity for a day, but the activity is invalid, it should throw an exception","pass":true,"statements":[{"sl":86},{"sl":90},{"sl":91}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [1, 41, 27, 7, 38, 23, 14, 17, 31], [], [1, 41, 27, 7, 38, 23, 14, 17, 31], [1, 41, 27, 7, 38, 23, 14, 17, 31], [1, 41, 27, 7, 38, 23, 14, 17, 31], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [1, 41, 27, 7, 38, 23, 14, 17, 31], [1, 41, 27, 7, 38, 23, 14, 17, 31], [1, 41, 27, 7, 38, 23, 14, 17, 31], [1, 41, 27, 7, 38, 23, 14, 17, 31], [1, 41, 27, 7, 38, 23, 14, 17, 31], [1, 41, 27, 7, 38, 23, 14, 17, 31], [], [1, 41, 27, 7, 38, 23, 14, 17, 31], [], [], [1, 41, 27, 7, 38, 23, 14, 17, 31], [], [], [28, 21, 33, 50], [28, 21, 33, 50], [21, 33], [], [28, 33, 50], [], [], [28, 43, 47], [28, 43, 47], [43, 47], [], [28], [], [], [27], [27], [27], [27], [], [], [23], [23], [], [], [23, 31], [23, 31], [], [], [1, 23], [1, 23], [], [], [41, 28, 40, 43, 16, 27, 15, 21, 26, 47, 48, 10, 5, 7, 32, 3, 24, 8, 33, 14, 17, 50], [41, 28, 40, 43, 16, 27, 15, 21, 26, 47, 48, 10, 5, 7, 32, 3, 24, 8, 33, 14, 17, 50], [], [], [41, 18, 28, 13, 42, 2, 40, 43, 16, 0, 27, 15, 21, 26, 47, 48, 10, 5, 7, 32, 3, 37, 24, 25, 8, 38, 4, 33, 14, 17, 50], [41, 18, 28, 13, 42, 2, 40, 43, 16, 0, 27, 15, 21, 26, 47, 48, 10, 5, 7, 32, 3, 37, 24, 25, 8, 38, 4, 33, 14, 17, 50], [41, 18, 28, 13, 42, 2, 40, 43, 16, 0, 27, 15, 21, 26, 47, 48, 10, 5, 7, 32, 3, 37, 24, 25, 8, 38, 4, 33, 14, 17, 50], [], [], [17], [17], [17], [17], [], [], [41, 18, 13, 42, 4], [41, 18, 13, 42, 4], [41, 18, 13, 42, 4], [], [], [], [], [], [], [], [], [], [], [15, 3, 24], [15, 3, 24], [], [15, 3, 24], [15, 3, 24], [], [], [18, 13, 42, 2, 40, 16, 0, 15, 10, 3, 37, 24, 4, 6, 11], [18, 13, 42, 2, 40, 16, 0, 15, 10, 3, 37, 24, 4, 6, 11], [18, 13, 42, 2, 40, 16, 0, 15, 10, 3, 37, 24, 4, 6, 11], [], []]
