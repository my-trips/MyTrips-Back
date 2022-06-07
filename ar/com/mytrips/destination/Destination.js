var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":180,"id":594,"methods":[{"el":22,"sc":5,"sl":22},{"el":24,"sc":5,"sl":24},{"el":26,"sc":5,"sl":26},{"el":33,"sc":5,"sl":28},{"el":35,"sc":5,"sl":35},{"el":43,"sc":5,"sl":37},{"el":50,"sc":5,"sl":45},{"el":68,"sc":5,"sl":52},{"el":82,"sc":5,"sl":70},{"el":91,"sc":5,"sl":84},{"el":99,"sc":5,"sl":93},{"el":103,"sc":5,"sl":101},{"el":107,"sc":5,"sl":105},{"el":111,"sc":5,"sl":109},{"el":115,"sc":5,"sl":113},{"el":119,"sc":5,"sl":117},{"el":123,"sc":5,"sl":121},{"el":127,"sc":5,"sl":125},{"el":133,"sc":5,"sl":129},{"el":139,"sc":5,"sl":135},{"el":144,"sc":5,"sl":141},{"el":150,"sc":5,"sl":146},{"el":156,"sc":5,"sl":152},{"el":164,"sc":5,"sl":158},{"el":173,"sc":5,"sl":166},{"el":179,"sc":5,"sl":175}],"name":"Destination","sl":13}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_1":{"methods":[{"sl":101}],"name":"when destinations are added to a trip, it must return the updated trip.","pass":true,"statements":[{"sl":102}]},"test_12":{"methods":[{"sl":22},{"sl":93}],"name":"Copy a trip","pass":true,"statements":[{"sl":94},{"sl":95},{"sl":96},{"sl":97},{"sl":98}]},"test_14":{"methods":[{"sl":84},{"sl":129},{"sl":141}],"name":"when update the arrival and departure dates of a transport between two destinations of a trip, it should return an updated transport","pass":true,"statements":[{"sl":85},{"sl":86},{"sl":90},{"sl":130},{"sl":131},{"sl":142},{"sl":143}]},"test_18":{"methods":[{"sl":70},{"sl":101},{"sl":109},{"sl":113},{"sl":125},{"sl":135},{"sl":141},{"sl":152}],"name":"hen a trip is subtract a day to one of its destinations, it should return the updated destination","pass":true,"statements":[{"sl":71},{"sl":74},{"sl":75},{"sl":76},{"sl":77},{"sl":79},{"sl":80},{"sl":102},{"sl":110},{"sl":114},{"sl":126},{"sl":136},{"sl":137},{"sl":142},{"sl":143},{"sl":153},{"sl":154}]},"test_23":{"methods":[{"sl":70},{"sl":101},{"sl":109},{"sl":113},{"sl":125},{"sl":135},{"sl":141},{"sl":152}],"name":"by subtracting days, the previous destination cannot run out of days\n","pass":true,"statements":[{"sl":71},{"sl":72},{"sl":74},{"sl":75},{"sl":76},{"sl":77},{"sl":79},{"sl":80},{"sl":102},{"sl":110},{"sl":114},{"sl":126},{"sl":136},{"sl":137},{"sl":142},{"sl":143},{"sl":153},{"sl":154}]},"test_3":{"methods":[{"sl":52},{"sl":101},{"sl":105},{"sl":117},{"sl":121},{"sl":129},{"sl":141},{"sl":146}],"name":"when a trip is added a day to one of its destinations, it should return the updated destination","pass":true,"statements":[{"sl":53},{"sl":54},{"sl":56},{"sl":60},{"sl":61},{"sl":62},{"sl":65},{"sl":66},{"sl":67},{"sl":102},{"sl":106},{"sl":118},{"sl":122},{"sl":130},{"sl":131},{"sl":142},{"sl":143},{"sl":147},{"sl":148}]},"test_5":{"methods":[{"sl":175}],"name":"when a trip is asked for the total cost, it should return it.","pass":true,"statements":[{"sl":176},{"sl":177},{"sl":178}]},"test_6":{"methods":[{"sl":52},{"sl":101},{"sl":105},{"sl":117},{"sl":121},{"sl":129},{"sl":141},{"sl":146}],"name":"when adding days, the next destination cannot run out of days","pass":true,"statements":[{"sl":53},{"sl":54},{"sl":56},{"sl":57},{"sl":60},{"sl":61},{"sl":62},{"sl":65},{"sl":66},{"sl":67},{"sl":102},{"sl":106},{"sl":118},{"sl":122},{"sl":130},{"sl":131},{"sl":142},{"sl":143},{"sl":147},{"sl":148}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [12], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [3, 6], [3, 6], [3, 6], [], [3, 6], [6], [], [], [3, 6], [3, 6], [3, 6], [], [], [3, 6], [3, 6], [3, 6], [], [], [18, 23], [18, 23], [23], [], [18, 23], [18, 23], [18, 23], [18, 23], [], [18, 23], [18, 23], [], [], [], [14], [14], [14], [], [], [], [14], [], [], [12], [12], [12], [12], [12], [12], [], [], [3, 6, 18, 1, 23], [3, 6, 18, 1, 23], [], [], [3, 6], [3, 6], [], [], [18, 23], [18, 23], [], [], [18, 23], [18, 23], [], [], [3, 6], [3, 6], [], [], [3, 6], [3, 6], [], [], [18, 23], [18, 23], [], [], [3, 14, 6], [3, 14, 6], [3, 14, 6], [], [], [], [18, 23], [18, 23], [18, 23], [], [], [], [3, 14, 6, 18, 23], [3, 14, 6, 18, 23], [3, 14, 6, 18, 23], [], [], [3, 6], [3, 6], [3, 6], [], [], [], [18, 23], [18, 23], [18, 23], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [5], [5], [5], [5], [], []]
