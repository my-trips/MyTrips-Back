var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":193,"id":1008,"methods":[{"el":21,"sc":5,"sl":21},{"el":22,"sc":5,"sl":22},{"el":24,"sc":5,"sl":24},{"el":26,"sc":5,"sl":26},{"el":33,"sc":5,"sl":28},{"el":35,"sc":5,"sl":35},{"el":42,"sc":5,"sl":37},{"el":49,"sc":5,"sl":44},{"el":67,"sc":5,"sl":51},{"el":81,"sc":5,"sl":69},{"el":90,"sc":5,"sl":83},{"el":97,"sc":5,"sl":92},{"el":101,"sc":5,"sl":99},{"el":105,"sc":5,"sl":103},{"el":109,"sc":5,"sl":107},{"el":113,"sc":5,"sl":111},{"el":117,"sc":5,"sl":115},{"el":121,"sc":5,"sl":119},{"el":125,"sc":5,"sl":123},{"el":131,"sc":5,"sl":127},{"el":137,"sc":5,"sl":133},{"el":142,"sc":5,"sl":139},{"el":148,"sc":5,"sl":144},{"el":154,"sc":5,"sl":150},{"el":159,"sc":5,"sl":156},{"el":168,"sc":5,"sl":161},{"el":176,"sc":5,"sl":170},{"el":185,"sc":5,"sl":178},{"el":192,"sc":5,"sl":187}],"name":"Destination","sl":12}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_0":{"methods":[{"sl":21},{"sl":22}],"name":"when search for all trips for a user, it should return all of them","pass":true,"statements":[]},"test_10":{"methods":[{"sl":69},{"sl":99},{"sl":107},{"sl":111},{"sl":123},{"sl":133},{"sl":139},{"sl":150}],"name":"by subtracting days, the previous destination cannot run out of days\n","pass":true,"statements":[{"sl":70},{"sl":71},{"sl":73},{"sl":74},{"sl":75},{"sl":76},{"sl":78},{"sl":79},{"sl":100},{"sl":108},{"sl":112},{"sl":124},{"sl":134},{"sl":135},{"sl":140},{"sl":141},{"sl":151},{"sl":152}]},"test_14":{"methods":[{"sl":51},{"sl":99},{"sl":103},{"sl":115},{"sl":119},{"sl":127},{"sl":139},{"sl":144}],"name":"when a trip is added a day to one of its destinations, it should return the updated destination","pass":true,"statements":[{"sl":52},{"sl":53},{"sl":55},{"sl":59},{"sl":60},{"sl":61},{"sl":64},{"sl":65},{"sl":66},{"sl":100},{"sl":104},{"sl":116},{"sl":120},{"sl":128},{"sl":129},{"sl":140},{"sl":141},{"sl":145},{"sl":146}]},"test_15":{"methods":[{"sl":99}],"name":"when destinations are added to a trip, it must return the updated trip.","pass":true,"statements":[{"sl":100}]},"test_17":{"methods":[{"sl":21},{"sl":22},{"sl":92}],"name":"when a trip is copied, a new trip with the same configuration is returned","pass":true,"statements":[{"sl":93},{"sl":94},{"sl":95},{"sl":96}]},"test_24":{"methods":[{"sl":51},{"sl":99},{"sl":103},{"sl":115},{"sl":119},{"sl":127},{"sl":139},{"sl":144}],"name":"when adding days, the next destination cannot run out of days","pass":true,"statements":[{"sl":52},{"sl":53},{"sl":55},{"sl":56},{"sl":59},{"sl":60},{"sl":61},{"sl":64},{"sl":65},{"sl":66},{"sl":100},{"sl":104},{"sl":116},{"sl":120},{"sl":128},{"sl":129},{"sl":140},{"sl":141},{"sl":145},{"sl":146}]},"test_25":{"methods":[{"sl":187}],"name":"when a trip is asked for the total cost, it should return it.","pass":true,"statements":[{"sl":188},{"sl":189},{"sl":190},{"sl":191}]},"test_26":{"methods":[{"sl":156}],"name":"when update an stay for a destination, it should return an updated stay","pass":true,"statements":[{"sl":157},{"sl":158}]},"test_28":{"methods":[{"sl":161}],"name":"when delete an stay for a destination, but the stay is invalid, it should throw an exception","pass":true,"statements":[{"sl":162},{"sl":163}]},"test_29":{"methods":[{"sl":156},{"sl":161}],"name":"when delete an stay for a destination, but the stay is valid, should be able to delete it","pass":true,"statements":[{"sl":157},{"sl":158},{"sl":162},{"sl":165},{"sl":166},{"sl":167}]},"test_31":{"methods":[{"sl":69},{"sl":99},{"sl":107},{"sl":111},{"sl":123},{"sl":133},{"sl":139},{"sl":150}],"name":"when a trip is subtract a day to one of its destinations, it should return the updated destination","pass":true,"statements":[{"sl":70},{"sl":73},{"sl":74},{"sl":75},{"sl":76},{"sl":78},{"sl":79},{"sl":100},{"sl":108},{"sl":112},{"sl":124},{"sl":134},{"sl":135},{"sl":140},{"sl":141},{"sl":151},{"sl":152}]},"test_5":{"methods":[{"sl":83},{"sl":127},{"sl":139}],"name":"when update the arrival and departure dates of a transport between two destinations of a trip, it should return an updated transport","pass":true,"statements":[{"sl":84},{"sl":85},{"sl":89},{"sl":128},{"sl":129},{"sl":140},{"sl":141}]},"test_8":{"methods":[{"sl":156}],"name":"when create an stay for a destination, it should return the full stay.","pass":true,"statements":[{"sl":157},{"sl":158}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [0, 17], [0, 17], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [24, 14], [24, 14], [24, 14], [], [24, 14], [24], [], [], [24, 14], [24, 14], [24, 14], [], [], [24, 14], [24, 14], [24, 14], [], [], [10, 31], [10, 31], [10], [], [10, 31], [10, 31], [10, 31], [10, 31], [], [10, 31], [10, 31], [], [], [], [5], [5], [5], [], [], [], [5], [], [], [17], [17], [17], [17], [17], [], [], [24, 15, 10, 31, 14], [24, 15, 10, 31, 14], [], [], [24, 14], [24, 14], [], [], [10, 31], [10, 31], [], [], [10, 31], [10, 31], [], [], [24, 14], [24, 14], [], [], [24, 14], [24, 14], [], [], [10, 31], [10, 31], [], [], [24, 14, 5], [24, 14, 5], [24, 14, 5], [], [], [], [10, 31], [10, 31], [10, 31], [], [], [], [24, 10, 31, 14, 5], [24, 10, 31, 14, 5], [24, 10, 31, 14, 5], [], [], [24, 14], [24, 14], [24, 14], [], [], [], [10, 31], [10, 31], [10, 31], [], [], [], [8, 26, 29], [8, 26, 29], [8, 26, 29], [], [], [29, 28], [29, 28], [28], [], [29], [29], [29], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [25], [25], [25], [25], [25], [], []]
