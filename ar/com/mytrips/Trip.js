var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":95,"id":329,"methods":[{"el":13,"sc":5,"sl":13},{"el":16,"sc":5,"sl":16},{"el":18,"sc":5,"sl":18},{"el":24,"sc":5,"sl":20},{"el":29,"sc":5,"sl":26},{"el":30,"sc":5,"sl":30},{"el":44,"sc":5,"sl":33},{"el":50,"sc":5,"sl":46},{"el":54,"sc":5,"sl":52},{"el":58,"sc":5,"sl":56},{"el":62,"sc":5,"sl":60},{"el":66,"sc":5,"sl":64},{"el":71,"sc":5,"sl":68},{"el":77,"sc":5,"sl":73},{"el":82,"sc":5,"sl":79},{"el":86,"sc":5,"sl":84},{"el":89,"sc":5,"sl":87},{"el":94,"sc":5,"sl":91}],"name":"Trip","sl":10}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_1":{"methods":[{"sl":13},{"sl":16},{"sl":33},{"sl":64},{"sl":68}],"name":"when destinations are added to a trip, it must return the updated trip.","pass":true,"statements":[{"sl":34},{"sl":35},{"sl":36},{"sl":37},{"sl":38},{"sl":40},{"sl":43},{"sl":65},{"sl":69},{"sl":70}]},"test_10":{"methods":[{"sl":13},{"sl":16},{"sl":33},{"sl":68}],"name":"when a trip is asked for the destinations without origin, it should return it.","pass":true,"statements":[{"sl":34},{"sl":35},{"sl":36},{"sl":37},{"sl":38},{"sl":40},{"sl":43},{"sl":69},{"sl":70}]},"test_11":{"methods":[{"sl":13},{"sl":16},{"sl":33},{"sl":64},{"sl":68}],"name":"when a trip is asked for the first destination, it should return it.","pass":true,"statements":[{"sl":34},{"sl":35},{"sl":36},{"sl":37},{"sl":38},{"sl":40},{"sl":43},{"sl":65},{"sl":69},{"sl":70}]},"test_12":{"methods":[{"sl":13},{"sl":16},{"sl":33},{"sl":46},{"sl":64},{"sl":68}],"name":"Copy a trip","pass":true,"statements":[{"sl":34},{"sl":35},{"sl":36},{"sl":37},{"sl":38},{"sl":40},{"sl":43},{"sl":47},{"sl":48},{"sl":49},{"sl":65},{"sl":69},{"sl":70}]},"test_13":{"methods":[{"sl":64},{"sl":68}],"name":"when delete an activity for a day, but the activity is invalid, it should throw an exception","pass":true,"statements":[{"sl":65},{"sl":69},{"sl":70}]},"test_14":{"methods":[{"sl":91}],"name":"when update the arrival and departure dates of a transport between two destinations of a trip, it should return an updated transport","pass":true,"statements":[{"sl":92},{"sl":93}]},"test_16":{"methods":[{"sl":64},{"sl":68},{"sl":91}],"name":"when update an activity for a day, it should return an updated activity","pass":true,"statements":[{"sl":65},{"sl":69},{"sl":70},{"sl":92},{"sl":93}]},"test_17":{"methods":[{"sl":13},{"sl":16},{"sl":33},{"sl":60}],"name":"when a trip is asked for the end date, it should return it.","pass":true,"statements":[{"sl":34},{"sl":35},{"sl":36},{"sl":37},{"sl":38},{"sl":40},{"sl":43},{"sl":61}]},"test_18":{"methods":[{"sl":68},{"sl":79},{"sl":91}],"name":"hen a trip is subtract a day to one of its destinations, it should return the updated destination","pass":true,"statements":[{"sl":69},{"sl":70},{"sl":80},{"sl":81},{"sl":92},{"sl":93}]},"test_19":{"methods":[{"sl":64},{"sl":68},{"sl":84},{"sl":87},{"sl":91}],"name":"when search for all trips for a user, it should return all of them","pass":true,"statements":[{"sl":65},{"sl":69},{"sl":70},{"sl":85},{"sl":88},{"sl":92},{"sl":93}]},"test_2":{"methods":[{"sl":13},{"sl":16},{"sl":33},{"sl":56}],"name":"when a trip is asked for the start date, it should return it.","pass":true,"statements":[{"sl":34},{"sl":35},{"sl":36},{"sl":37},{"sl":38},{"sl":40},{"sl":43},{"sl":57}]},"test_20":{"methods":[{"sl":13},{"sl":16},{"sl":33},{"sl":64},{"sl":68},{"sl":79}],"name":"when ask a trip if a destination is not the last, and it is not, it should return true.","pass":true,"statements":[{"sl":34},{"sl":35},{"sl":36},{"sl":37},{"sl":38},{"sl":40},{"sl":43},{"sl":65},{"sl":69},{"sl":70},{"sl":80},{"sl":81}]},"test_21":{"methods":[{"sl":64},{"sl":68}],"name":"when delete a trip from a user, you should be able to delete it","pass":true,"statements":[{"sl":65},{"sl":69},{"sl":70}]},"test_23":{"methods":[{"sl":68},{"sl":79},{"sl":91}],"name":"by subtracting days, the previous destination cannot run out of days\n","pass":true,"statements":[{"sl":69},{"sl":70},{"sl":80},{"sl":81},{"sl":92},{"sl":93}]},"test_24":{"methods":[{"sl":64},{"sl":68},{"sl":84},{"sl":87},{"sl":91}],"name":"when fetch a trip for id, if the trip exists it should return it","pass":true,"statements":[{"sl":65},{"sl":69},{"sl":70},{"sl":85},{"sl":88},{"sl":92},{"sl":93}]},"test_26":{"methods":[{"sl":13},{"sl":16},{"sl":33},{"sl":52},{"sl":56},{"sl":60}],"name":"when total days of a trip is requested, it should return the number of days.","pass":true,"statements":[{"sl":34},{"sl":35},{"sl":36},{"sl":37},{"sl":38},{"sl":40},{"sl":43},{"sl":53},{"sl":57},{"sl":61}]},"test_27":{"methods":[{"sl":64},{"sl":68},{"sl":91}],"name":"when delete an activity for a day, but the activity is valid, should be able to delete it","pass":true,"statements":[{"sl":65},{"sl":69},{"sl":70},{"sl":92},{"sl":93}]},"test_3":{"methods":[{"sl":68},{"sl":79},{"sl":91}],"name":"when a trip is added a day to one of its destinations, it should return the updated destination","pass":true,"statements":[{"sl":69},{"sl":70},{"sl":80},{"sl":81},{"sl":92},{"sl":93}]},"test_4":{"methods":[{"sl":91}],"name":"when update the type of transport between two destinations of a trip, it should return an updated transport","pass":true,"statements":[{"sl":92},{"sl":93}]},"test_5":{"methods":[{"sl":13},{"sl":16},{"sl":33},{"sl":64},{"sl":68},{"sl":73}],"name":"when a trip is asked for the total cost, it should return it.","pass":true,"statements":[{"sl":34},{"sl":35},{"sl":36},{"sl":37},{"sl":38},{"sl":40},{"sl":43},{"sl":65},{"sl":69},{"sl":70},{"sl":74},{"sl":75},{"sl":76}]},"test_6":{"methods":[{"sl":68},{"sl":79},{"sl":91}],"name":"when adding days, the next destination cannot run out of days","pass":true,"statements":[{"sl":69},{"sl":70},{"sl":80},{"sl":81},{"sl":92},{"sl":93}]},"test_8":{"methods":[{"sl":64},{"sl":68}],"name":"when create a trip, it should return a complete trip","pass":true,"statements":[{"sl":65},{"sl":69},{"sl":70}]},"test_9":{"methods":[{"sl":64},{"sl":68},{"sl":91}],"name":"when create an activity for a day, it should return the full activity.","pass":true,"statements":[{"sl":65},{"sl":69},{"sl":70},{"sl":92},{"sl":93}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [20, 10, 17, 1, 12, 5, 26, 11, 2], [], [], [20, 10, 17, 1, 12, 5, 26, 11, 2], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [20, 10, 17, 1, 12, 5, 26, 11, 2], [20, 10, 17, 1, 12, 5, 26, 11, 2], [20, 10, 17, 1, 12, 5, 26, 11, 2], [20, 10, 17, 1, 12, 5, 26, 11, 2], [20, 10, 17, 1, 12, 5, 26, 11, 2], [20, 10, 17, 1, 12, 5, 26, 11, 2], [], [20, 10, 17, 1, 12, 5, 26, 11, 2], [], [], [20, 10, 17, 1, 12, 5, 26, 11, 2], [], [], [12], [12], [12], [12], [], [], [26], [26], [], [], [26, 2], [26, 2], [], [], [17, 26], [17, 26], [], [], [20, 21, 1, 12, 5, 13, 19, 11, 27, 24, 8, 9, 16], [20, 21, 1, 12, 5, 13, 19, 11, 27, 24, 8, 9, 16], [], [], [20, 6, 21, 10, 1, 23, 3, 12, 5, 13, 18, 19, 11, 27, 24, 8, 9, 16], [20, 6, 21, 10, 1, 23, 3, 12, 5, 13, 18, 19, 11, 27, 24, 8, 9, 16], [20, 6, 21, 10, 1, 23, 3, 12, 5, 13, 18, 19, 11, 27, 24, 8, 9, 16], [], [], [5], [5], [5], [5], [], [], [20, 6, 23, 3, 18], [20, 6, 23, 3, 18], [20, 6, 23, 3, 18], [], [], [19, 24], [19, 24], [], [19, 24], [19, 24], [], [], [6, 4, 23, 3, 14, 18, 19, 27, 24, 9, 16], [6, 4, 23, 3, 14, 18, 19, 27, 24, 9, 16], [6, 4, 23, 3, 14, 18, 19, 27, 24, 9, 16], [], []]
