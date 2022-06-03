var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":166,"id":588,"methods":[{"el":21,"sc":5,"sl":21},{"el":23,"sc":5,"sl":23},{"el":25,"sc":5,"sl":25},{"el":32,"sc":5,"sl":27},{"el":34,"sc":5,"sl":34},{"el":42,"sc":5,"sl":36},{"el":49,"sc":5,"sl":44},{"el":63,"sc":5,"sl":51},{"el":76,"sc":5,"sl":65},{"el":85,"sc":5,"sl":78},{"el":89,"sc":5,"sl":87},{"el":93,"sc":5,"sl":91},{"el":97,"sc":5,"sl":95},{"el":101,"sc":5,"sl":99},{"el":105,"sc":5,"sl":103},{"el":109,"sc":5,"sl":107},{"el":113,"sc":5,"sl":111},{"el":119,"sc":5,"sl":115},{"el":125,"sc":5,"sl":121},{"el":130,"sc":5,"sl":127},{"el":136,"sc":5,"sl":132},{"el":142,"sc":5,"sl":138},{"el":150,"sc":5,"sl":144},{"el":159,"sc":5,"sl":152},{"el":165,"sc":5,"sl":161}],"name":"Destination","sl":12}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_1":{"methods":[{"sl":65},{"sl":87},{"sl":95},{"sl":99},{"sl":111},{"sl":121},{"sl":127},{"sl":138}],"name":"hen a trip is subtract a day to one of its destinations, it should return the updated destination","pass":true,"statements":[{"sl":66},{"sl":67},{"sl":68},{"sl":69},{"sl":70},{"sl":72},{"sl":73},{"sl":88},{"sl":96},{"sl":100},{"sl":112},{"sl":122},{"sl":123},{"sl":128},{"sl":129},{"sl":139},{"sl":140}]},"test_10":{"methods":[{"sl":21}],"name":"when fetch a trip for id, if the trip exists it should return it","pass":true,"statements":[]},"test_13":{"methods":[{"sl":21}],"name":"when search for all trips for a user, it should return all of them","pass":true,"statements":[]},"test_19":{"methods":[{"sl":78},{"sl":115},{"sl":127}],"name":"when update the arrival and departure dates of a transport between two destinations of a trip, it should return an updated transport","pass":true,"statements":[{"sl":79},{"sl":80},{"sl":84},{"sl":116},{"sl":117},{"sl":128},{"sl":129}]},"test_20":{"methods":[{"sl":161}],"name":"when a trip is asked for the total cost, it should return it.","pass":true,"statements":[{"sl":162},{"sl":163},{"sl":164}]},"test_4":{"methods":[{"sl":51},{"sl":87},{"sl":91},{"sl":103},{"sl":107},{"sl":115},{"sl":127},{"sl":132}],"name":"when a trip is added a day to one of its destinations, it should return the updated destination","pass":true,"statements":[{"sl":52},{"sl":53},{"sl":55},{"sl":56},{"sl":57},{"sl":60},{"sl":61},{"sl":62},{"sl":88},{"sl":92},{"sl":104},{"sl":108},{"sl":116},{"sl":117},{"sl":128},{"sl":129},{"sl":133},{"sl":134}]},"test_5":{"methods":[{"sl":87}],"name":"when destinations are added to a trip, it must return the updated trip.","pass":true,"statements":[{"sl":88}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [13, 10], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [4], [4], [4], [], [4], [4], [4], [], [], [4], [4], [4], [], [], [1], [1], [1], [1], [1], [1], [], [1], [1], [], [], [], [], [19], [19], [19], [], [], [], [19], [], [], [5, 4, 1], [5, 4, 1], [], [], [4], [4], [], [], [1], [1], [], [], [1], [1], [], [], [4], [4], [], [], [4], [4], [], [], [1], [1], [], [], [19, 4], [19, 4], [19, 4], [], [], [], [1], [1], [1], [], [], [], [19, 4, 1], [19, 4, 1], [19, 4, 1], [], [], [4], [4], [4], [], [], [], [1], [1], [1], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [20], [20], [20], [20], [], []]
