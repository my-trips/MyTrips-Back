var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":234,"id":64,"methods":[{"el":34,"sc":5,"sl":20},{"el":45,"sc":5,"sl":36},{"el":59,"sc":5,"sl":47},{"el":67,"sc":5,"sl":61},{"el":81,"sc":5,"sl":69},{"el":89,"sc":5,"sl":83},{"el":100,"sc":5,"sl":91},{"el":110,"sc":5,"sl":102},{"el":122,"sc":5,"sl":112},{"el":133,"sc":5,"sl":124},{"el":147,"sc":5,"sl":135},{"el":159,"sc":5,"sl":149},{"el":171,"sc":5,"sl":161},{"el":183,"sc":5,"sl":173},{"el":195,"sc":5,"sl":185},{"el":208,"sc":5,"sl":197},{"el":217,"sc":5,"sl":210},{"el":233,"sc":5,"sl":219}],"name":"TripServiceTest","sl":12}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_0":{"methods":[{"sl":69}],"name":"when search for all trips for a user, it should return all of them","pass":true,"statements":[{"sl":71},{"sl":74},{"sl":77},{"sl":78},{"sl":79},{"sl":80}]},"test_16":{"methods":[{"sl":185}],"name":"when the owner is removed as a traveller, it should throw an exception","pass":true,"statements":[{"sl":187},{"sl":189},{"sl":192},{"sl":193},{"sl":194}]},"test_18":{"methods":[{"sl":102}],"name":"when delete a trip for a user, but the user is invalid, it should throw an exception","pass":true,"statements":[{"sl":104},{"sl":107},{"sl":108},{"sl":109}]},"test_25":{"methods":[{"sl":197}],"name":"when a non-owner user removes a traveller, it should throw an exception","pass":true,"statements":[{"sl":199},{"sl":200},{"sl":202},{"sl":205},{"sl":206},{"sl":207}]},"test_3":{"methods":[{"sl":112}],"name":"when a trip is copied, a new trip with the same configuration is returned","pass":true,"statements":[{"sl":114},{"sl":116},{"sl":119},{"sl":120},{"sl":121}]},"test_30":{"methods":[{"sl":219}],"name":"when get public a trip, it should return a trip published","pass":true,"statements":[{"sl":221},{"sl":222},{"sl":225},{"sl":228},{"sl":229},{"sl":230},{"sl":231},{"sl":232}]},"test_33":{"methods":[{"sl":149}],"name":"when the owner is added as a traveller, it should throw an exception","pass":true,"statements":[{"sl":151},{"sl":153},{"sl":156},{"sl":157},{"sl":158}]},"test_35":{"methods":[{"sl":124}],"name":"when a traveller is added, it should should increase the list of travellers","pass":true,"statements":[{"sl":126},{"sl":128},{"sl":131},{"sl":132}]},"test_36":{"methods":[{"sl":161}],"name":"when a traveller is removed, it should be removed from the list of travellers","pass":true,"statements":[{"sl":163},{"sl":164},{"sl":167},{"sl":170}]},"test_37":{"methods":[{"sl":173}],"name":"when removing a traveller that doesn't exist, it should throw an exception","pass":true,"statements":[{"sl":175},{"sl":177},{"sl":180},{"sl":181},{"sl":182}]},"test_38":{"methods":[{"sl":210}],"name":"when changeVisibility is called with true, the trip becomes public","pass":true,"statements":[{"sl":212},{"sl":214},{"sl":216}]},"test_40":{"methods":[{"sl":91}],"name":"when delete a trip from a user, you should be able to delete it","pass":true,"statements":[{"sl":93},{"sl":96},{"sl":99}]},"test_43":{"methods":[{"sl":135}],"name":"when add a traveller that already exists, it should throw an exception","pass":true,"statements":[{"sl":137},{"sl":138},{"sl":141},{"sl":144},{"sl":145},{"sl":146}]},"test_44":{"methods":[{"sl":61}],"name":"when fetch a trip for id, if the trip doesn't exits it shouldn't return it","pass":true,"statements":[{"sl":63},{"sl":66}]},"test_47":{"methods":[{"sl":83}],"name":"when search for all trips for a user, and the user has no trips it should not return nothing.","pass":true,"statements":[{"sl":85},{"sl":88}]},"test_5":{"methods":[{"sl":36}],"name":"when create a trip, it should return a complete trip","pass":true,"statements":[{"sl":38},{"sl":41},{"sl":42},{"sl":43},{"sl":44}]},"test_8":{"methods":[{"sl":47}],"name":"when fetch a trip for id, if the trip exists it should return it","pass":true,"statements":[{"sl":49},{"sl":52},{"sl":55},{"sl":56},{"sl":57},{"sl":58}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [5], [], [5], [], [], [5], [5], [5], [5], [], [], [8], [], [8], [], [], [8], [], [], [8], [8], [8], [8], [], [], [44], [], [44], [], [], [44], [], [], [0], [], [0], [], [], [0], [], [], [0], [0], [0], [0], [], [], [47], [], [47], [], [], [47], [], [], [40], [], [40], [], [], [40], [], [], [40], [], [], [18], [], [18], [], [], [18], [18], [18], [], [], [3], [], [3], [], [3], [], [], [3], [3], [3], [], [], [35], [], [35], [], [35], [], [], [35], [35], [], [], [43], [], [43], [43], [], [], [43], [], [], [43], [43], [43], [], [], [33], [], [33], [], [33], [], [], [33], [33], [33], [], [], [36], [], [36], [36], [], [], [36], [], [], [36], [], [], [37], [], [37], [], [37], [], [], [37], [37], [37], [], [], [16], [], [16], [], [16], [], [], [16], [16], [16], [], [], [25], [], [25], [25], [], [25], [], [], [25], [25], [25], [], [], [38], [], [38], [], [38], [], [38], [], [], [30], [], [30], [30], [], [], [30], [], [], [30], [30], [30], [30], [30], [], []]
