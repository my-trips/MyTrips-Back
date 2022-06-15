var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":214,"id":55,"methods":[{"el":30,"sc":5,"sl":18},{"el":41,"sc":5,"sl":32},{"el":55,"sc":5,"sl":43},{"el":63,"sc":5,"sl":57},{"el":77,"sc":5,"sl":65},{"el":85,"sc":5,"sl":79},{"el":96,"sc":5,"sl":87},{"el":106,"sc":5,"sl":98},{"el":118,"sc":5,"sl":108},{"el":129,"sc":5,"sl":120},{"el":143,"sc":5,"sl":131},{"el":155,"sc":5,"sl":145},{"el":167,"sc":5,"sl":157},{"el":179,"sc":5,"sl":169},{"el":191,"sc":5,"sl":181},{"el":204,"sc":5,"sl":193},{"el":213,"sc":5,"sl":206}],"name":"TripServiceTest","sl":11}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_10":{"methods":[{"sl":98}],"name":"when delete a trip for a user, but the user is invalid, it should throw an exception","pass":true,"statements":[{"sl":100},{"sl":103},{"sl":104},{"sl":105}]},"test_11":{"methods":[{"sl":57}],"name":"when fetch a trip for id, if the trip doesn't exits it shouldn't return it","pass":true,"statements":[{"sl":59},{"sl":62}]},"test_12":{"methods":[{"sl":131}],"name":"when add a traveller that already exists, it should throw an exception","pass":true,"statements":[{"sl":133},{"sl":134},{"sl":137},{"sl":140},{"sl":141},{"sl":142}]},"test_13":{"methods":[{"sl":145}],"name":"when the owner is added as a traveller, it should throw an exception","pass":true,"statements":[{"sl":147},{"sl":149},{"sl":152},{"sl":153},{"sl":154}]},"test_14":{"methods":[{"sl":108}],"name":"when a trip is copied, a new trip with the same configuration is returned","pass":true,"statements":[{"sl":110},{"sl":112},{"sl":115},{"sl":116},{"sl":117}]},"test_19":{"methods":[{"sl":65}],"name":"when search for all trips for a user, it should return all of them","pass":true,"statements":[{"sl":67},{"sl":70},{"sl":73},{"sl":74},{"sl":75},{"sl":76}]},"test_20":{"methods":[{"sl":32}],"name":"when create a trip, it should return a complete trip","pass":true,"statements":[{"sl":34},{"sl":37},{"sl":38},{"sl":39},{"sl":40}]},"test_24":{"methods":[{"sl":43}],"name":"when fetch a trip for id, if the trip exists it should return it","pass":true,"statements":[{"sl":45},{"sl":48},{"sl":51},{"sl":52},{"sl":53},{"sl":54}]},"test_25":{"methods":[{"sl":120}],"name":"when a traveller is added, it should should increase the list of travellers","pass":true,"statements":[{"sl":122},{"sl":124},{"sl":127},{"sl":128}]},"test_26":{"methods":[{"sl":87}],"name":"when delete a trip from a user, you should be able to delete it","pass":true,"statements":[{"sl":89},{"sl":92},{"sl":95}]},"test_28":{"methods":[{"sl":169}],"name":"when removing a traveller that doesn't exist, it should throw an exception","pass":true,"statements":[{"sl":171},{"sl":173},{"sl":176},{"sl":177},{"sl":178}]},"test_37":{"methods":[{"sl":79}],"name":"when search for all trips for a user, and the user has no trips it should not return nothing.","pass":true,"statements":[{"sl":81},{"sl":84}]},"test_4":{"methods":[{"sl":193}],"name":"when a non-owner user removes a traveller, it should throw an exception","pass":true,"statements":[{"sl":195},{"sl":196},{"sl":198},{"sl":201},{"sl":202},{"sl":203}]},"test_44":{"methods":[{"sl":157}],"name":"when a traveller is removed, it should be removed from the list of travellers","pass":true,"statements":[{"sl":159},{"sl":160},{"sl":163},{"sl":166}]},"test_8":{"methods":[{"sl":206}],"name":"when changeVisibility is called with true, the trip becomes public","pass":true,"statements":[{"sl":208},{"sl":210},{"sl":212}]},"test_9":{"methods":[{"sl":181}],"name":"when the owner is removed as a traveller, it should throw an exception","pass":true,"statements":[{"sl":183},{"sl":185},{"sl":188},{"sl":189},{"sl":190}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [20], [], [20], [], [], [20], [20], [20], [20], [], [], [24], [], [24], [], [], [24], [], [], [24], [24], [24], [24], [], [], [11], [], [11], [], [], [11], [], [], [19], [], [19], [], [], [19], [], [], [19], [19], [19], [19], [], [], [37], [], [37], [], [], [37], [], [], [26], [], [26], [], [], [26], [], [], [26], [], [], [10], [], [10], [], [], [10], [10], [10], [], [], [14], [], [14], [], [14], [], [], [14], [14], [14], [], [], [25], [], [25], [], [25], [], [], [25], [25], [], [], [12], [], [12], [12], [], [], [12], [], [], [12], [12], [12], [], [], [13], [], [13], [], [13], [], [], [13], [13], [13], [], [], [44], [], [44], [44], [], [], [44], [], [], [44], [], [], [28], [], [28], [], [28], [], [], [28], [28], [28], [], [], [9], [], [9], [], [9], [], [], [9], [9], [9], [], [], [4], [], [4], [4], [], [4], [], [], [4], [4], [4], [], [], [8], [], [8], [], [8], [], [8], [], []]
