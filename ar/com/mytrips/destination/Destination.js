var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":194,"id":1032,"methods":[{"el":21,"sc":5,"sl":21},{"el":22,"sc":5,"sl":22},{"el":24,"sc":5,"sl":24},{"el":26,"sc":5,"sl":26},{"el":33,"sc":5,"sl":28},{"el":35,"sc":5,"sl":35},{"el":42,"sc":5,"sl":37},{"el":49,"sc":5,"sl":44},{"el":67,"sc":5,"sl":51},{"el":81,"sc":5,"sl":69},{"el":90,"sc":5,"sl":83},{"el":98,"sc":5,"sl":92},{"el":102,"sc":5,"sl":100},{"el":106,"sc":5,"sl":104},{"el":110,"sc":5,"sl":108},{"el":114,"sc":5,"sl":112},{"el":118,"sc":5,"sl":116},{"el":122,"sc":5,"sl":120},{"el":126,"sc":5,"sl":124},{"el":132,"sc":5,"sl":128},{"el":138,"sc":5,"sl":134},{"el":143,"sc":5,"sl":140},{"el":149,"sc":5,"sl":145},{"el":155,"sc":5,"sl":151},{"el":160,"sc":5,"sl":157},{"el":169,"sc":5,"sl":162},{"el":177,"sc":5,"sl":171},{"el":186,"sc":5,"sl":179},{"el":193,"sc":5,"sl":188}],"name":"Destination","sl":12}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_1":{"methods":[{"sl":157},{"sl":162}],"name":"when delete an stay for a destination, but the stay is valid, should be able to delete it","pass":true,"statements":[{"sl":158},{"sl":159},{"sl":163},{"sl":166},{"sl":167},{"sl":168}]},"test_13":{"methods":[{"sl":69},{"sl":100},{"sl":108},{"sl":112},{"sl":124},{"sl":134},{"sl":140},{"sl":151}],"name":"by subtracting days, the previous destination cannot run out of days\n","pass":true,"statements":[{"sl":70},{"sl":71},{"sl":73},{"sl":74},{"sl":75},{"sl":76},{"sl":78},{"sl":79},{"sl":101},{"sl":109},{"sl":113},{"sl":125},{"sl":135},{"sl":136},{"sl":141},{"sl":142},{"sl":152},{"sl":153}]},"test_14":{"methods":[{"sl":157}],"name":"when create an stay for a destination, it should return the full stay.","pass":true,"statements":[{"sl":158},{"sl":159}]},"test_19":{"methods":[{"sl":162}],"name":"when delete an stay for a destination, but the stay is invalid, it should throw an exception","pass":true,"statements":[{"sl":163},{"sl":164}]},"test_20":{"methods":[{"sl":69},{"sl":100},{"sl":108},{"sl":112},{"sl":124},{"sl":134},{"sl":140},{"sl":151}],"name":"when a trip is subtract a day to one of its destinations, it should return the updated destination","pass":true,"statements":[{"sl":70},{"sl":73},{"sl":74},{"sl":75},{"sl":76},{"sl":78},{"sl":79},{"sl":101},{"sl":109},{"sl":113},{"sl":125},{"sl":135},{"sl":136},{"sl":141},{"sl":142},{"sl":152},{"sl":153}]},"test_23":{"methods":[{"sl":157}],"name":"when update an stay for a destination, it should return an updated stay","pass":true,"statements":[{"sl":158},{"sl":159}]},"test_24":{"methods":[{"sl":188}],"name":"when a trip is asked for the total cost, it should return it.","pass":true,"statements":[{"sl":189},{"sl":190},{"sl":191},{"sl":192}]},"test_29":{"methods":[{"sl":83},{"sl":128},{"sl":140}],"name":"when update the arrival and departure dates of a transport between two destinations of a trip, it should return an updated transport","pass":true,"statements":[{"sl":84},{"sl":85},{"sl":89},{"sl":129},{"sl":130},{"sl":141},{"sl":142}]},"test_3":{"methods":[{"sl":21},{"sl":22},{"sl":92}],"name":"when a trip is copied, a new trip with the same configuration is returned","pass":true,"statements":[{"sl":93},{"sl":94},{"sl":95},{"sl":96},{"sl":97}]},"test_31":{"methods":[{"sl":51},{"sl":100},{"sl":104},{"sl":116},{"sl":120},{"sl":128},{"sl":140},{"sl":145}],"name":"when a trip is added a day to one of its destinations, it should return the updated destination","pass":true,"statements":[{"sl":52},{"sl":53},{"sl":55},{"sl":59},{"sl":60},{"sl":61},{"sl":64},{"sl":65},{"sl":66},{"sl":101},{"sl":105},{"sl":117},{"sl":121},{"sl":129},{"sl":130},{"sl":141},{"sl":142},{"sl":146},{"sl":147}]},"test_4":{"methods":[{"sl":51},{"sl":100},{"sl":104},{"sl":116},{"sl":120},{"sl":128},{"sl":140},{"sl":145}],"name":"when adding days, the next destination cannot run out of days","pass":true,"statements":[{"sl":52},{"sl":53},{"sl":55},{"sl":56},{"sl":59},{"sl":60},{"sl":61},{"sl":64},{"sl":65},{"sl":66},{"sl":101},{"sl":105},{"sl":117},{"sl":121},{"sl":129},{"sl":130},{"sl":141},{"sl":142},{"sl":146},{"sl":147}]},"test_9":{"methods":[{"sl":100}],"name":"when destinations are added to a trip, it must return the updated trip.","pass":true,"statements":[{"sl":101}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [3], [3], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [31, 4], [31, 4], [31, 4], [], [31, 4], [4], [], [], [31, 4], [31, 4], [31, 4], [], [], [31, 4], [31, 4], [31, 4], [], [], [20, 13], [20, 13], [13], [], [20, 13], [20, 13], [20, 13], [20, 13], [], [20, 13], [20, 13], [], [], [], [29], [29], [29], [], [], [], [29], [], [], [3], [3], [3], [3], [3], [3], [], [], [20, 13, 31, 9, 4], [20, 13, 31, 9, 4], [], [], [31, 4], [31, 4], [], [], [20, 13], [20, 13], [], [], [20, 13], [20, 13], [], [], [31, 4], [31, 4], [], [], [31, 4], [31, 4], [], [], [20, 13], [20, 13], [], [], [29, 31, 4], [29, 31, 4], [29, 31, 4], [], [], [], [20, 13], [20, 13], [20, 13], [], [], [], [29, 20, 13, 31, 4], [29, 20, 13, 31, 4], [29, 20, 13, 31, 4], [], [], [31, 4], [31, 4], [31, 4], [], [], [], [20, 13], [20, 13], [20, 13], [], [], [], [1, 14, 23], [1, 14, 23], [1, 14, 23], [], [], [1, 19], [1, 19], [19], [], [1], [1], [1], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [24], [24], [24], [24], [24], [], []]
