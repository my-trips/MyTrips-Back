var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":169,"id":695,"methods":[{"el":33,"sc":5,"sl":28},{"el":38,"sc":5,"sl":35},{"el":43,"sc":5,"sl":40},{"el":57,"sc":5,"sl":45},{"el":68,"sc":5,"sl":59},{"el":74,"sc":5,"sl":70},{"el":81,"sc":5,"sl":76},{"el":88,"sc":5,"sl":83},{"el":94,"sc":5,"sl":90},{"el":100,"sc":5,"sl":96},{"el":106,"sc":5,"sl":102},{"el":111,"sc":5,"sl":108},{"el":132,"sc":5,"sl":113},{"el":148,"sc":5,"sl":134},{"el":165,"sc":5,"sl":150}],"name":"TripService","sl":20}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_1":{"methods":[{"sl":59},{"sl":90},{"sl":102},{"sl":108},{"sl":113}],"name":"when delete a trip from a user, you should be able to delete it","pass":true,"statements":[{"sl":60},{"sl":61},{"sl":62},{"sl":64},{"sl":65},{"sl":66},{"sl":67},{"sl":91},{"sl":92},{"sl":93},{"sl":103},{"sl":115},{"sl":116},{"sl":117},{"sl":118},{"sl":119},{"sl":120},{"sl":129}]},"test_10":{"methods":[{"sl":59},{"sl":76},{"sl":102},{"sl":108},{"sl":113}],"name":"when the owner is added as a traveller, it should throw an exception","pass":true,"statements":[{"sl":60},{"sl":61},{"sl":62},{"sl":64},{"sl":65},{"sl":66},{"sl":67},{"sl":77},{"sl":78},{"sl":103},{"sl":115},{"sl":116},{"sl":117},{"sl":118},{"sl":119},{"sl":120},{"sl":129}]},"test_13":{"methods":[{"sl":59},{"sl":83},{"sl":102},{"sl":108},{"sl":113}],"name":"when removing a traveller that doesn't exist, it should throw an exception","pass":true,"statements":[{"sl":60},{"sl":61},{"sl":62},{"sl":64},{"sl":65},{"sl":66},{"sl":67},{"sl":84},{"sl":85},{"sl":103},{"sl":115},{"sl":116},{"sl":117},{"sl":118},{"sl":119},{"sl":120},{"sl":129}]},"test_15":{"methods":[{"sl":59},{"sl":76},{"sl":102},{"sl":108},{"sl":113}],"name":"when a traveller is added, it should should increase the list of travellers","pass":true,"statements":[{"sl":60},{"sl":61},{"sl":62},{"sl":64},{"sl":65},{"sl":66},{"sl":67},{"sl":77},{"sl":78},{"sl":79},{"sl":80},{"sl":103},{"sl":115},{"sl":116},{"sl":117},{"sl":118},{"sl":119},{"sl":120},{"sl":129}]},"test_19":{"methods":[{"sl":59},{"sl":76},{"sl":102},{"sl":108},{"sl":113}],"name":"when add a traveller that already exists, it should throw an exception","pass":true,"statements":[{"sl":60},{"sl":61},{"sl":62},{"sl":64},{"sl":65},{"sl":66},{"sl":67},{"sl":77},{"sl":78},{"sl":79},{"sl":80},{"sl":103},{"sl":115},{"sl":116},{"sl":117},{"sl":118},{"sl":119},{"sl":120},{"sl":129}]},"test_25":{"methods":[{"sl":59},{"sl":96},{"sl":102},{"sl":108},{"sl":113}],"name":"when changeVisibility is called with true, the trip becomes public","pass":true,"statements":[{"sl":60},{"sl":61},{"sl":62},{"sl":64},{"sl":65},{"sl":66},{"sl":67},{"sl":97},{"sl":98},{"sl":99},{"sl":103},{"sl":115},{"sl":116},{"sl":117},{"sl":118},{"sl":119},{"sl":120},{"sl":129}]},"test_26":{"methods":[{"sl":59},{"sl":83},{"sl":102},{"sl":108},{"sl":113}],"name":"when a non-owner user removes a traveller, it should throw an exception","pass":true,"statements":[{"sl":60},{"sl":61},{"sl":62},{"sl":64},{"sl":65},{"sl":66},{"sl":67},{"sl":84},{"sl":103},{"sl":104},{"sl":115},{"sl":116},{"sl":117},{"sl":118},{"sl":119},{"sl":120},{"sl":129}]},"test_27":{"methods":[{"sl":40},{"sl":134}],"name":"when search for all trips for a user, and the user has no trips it should not return nothing.","pass":true,"statements":[{"sl":41},{"sl":42},{"sl":135},{"sl":140},{"sl":141},{"sl":143},{"sl":144}]},"test_3":{"methods":[{"sl":59},{"sl":108},{"sl":113}],"name":"when create a trip, it should return a complete trip","pass":true,"statements":[{"sl":60},{"sl":61},{"sl":62},{"sl":64},{"sl":65},{"sl":66},{"sl":67},{"sl":115},{"sl":116},{"sl":117}]},"test_31":{"methods":[{"sl":59},{"sl":70},{"sl":108},{"sl":113}],"name":"when a trip is copied, a new trip with the same configuration is returned","pass":true,"statements":[{"sl":60},{"sl":61},{"sl":62},{"sl":64},{"sl":65},{"sl":66},{"sl":67},{"sl":71},{"sl":72},{"sl":73},{"sl":115},{"sl":116},{"sl":117},{"sl":118},{"sl":119},{"sl":120},{"sl":129}]},"test_39":{"methods":[{"sl":28},{"sl":134}],"name":"when fetch a trip for id, if the trip doesn't exits it shouldn't return it","pass":true,"statements":[{"sl":29},{"sl":30},{"sl":31},{"sl":135},{"sl":140},{"sl":141},{"sl":143},{"sl":144}]},"test_4":{"methods":[{"sl":28},{"sl":59},{"sl":108},{"sl":113},{"sl":134}],"name":"when fetch a trip for id, if the trip exists it should return it","pass":true,"statements":[{"sl":29},{"sl":30},{"sl":31},{"sl":60},{"sl":61},{"sl":62},{"sl":64},{"sl":65},{"sl":66},{"sl":67},{"sl":115},{"sl":116},{"sl":117},{"sl":118},{"sl":119},{"sl":120},{"sl":129},{"sl":135},{"sl":140},{"sl":141},{"sl":143},{"sl":144}]},"test_40":{"methods":[{"sl":59},{"sl":76},{"sl":83},{"sl":102},{"sl":108},{"sl":113}],"name":"when a traveller is removed, it should be removed from the list of travellers","pass":true,"statements":[{"sl":60},{"sl":61},{"sl":62},{"sl":64},{"sl":65},{"sl":66},{"sl":67},{"sl":77},{"sl":78},{"sl":79},{"sl":80},{"sl":84},{"sl":85},{"sl":86},{"sl":87},{"sl":103},{"sl":115},{"sl":116},{"sl":117},{"sl":118},{"sl":119},{"sl":120},{"sl":129}]},"test_44":{"methods":[{"sl":90},{"sl":102}],"name":"when delete a trip for a user, but the user is invalid, it should throw an exception","pass":true,"statements":[{"sl":91},{"sl":103},{"sl":104}]},"test_6":{"methods":[{"sl":40},{"sl":59},{"sl":108},{"sl":113},{"sl":134}],"name":"when search for all trips for a user, it should return all of them","pass":true,"statements":[{"sl":41},{"sl":42},{"sl":60},{"sl":61},{"sl":62},{"sl":64},{"sl":65},{"sl":66},{"sl":67},{"sl":115},{"sl":116},{"sl":117},{"sl":118},{"sl":119},{"sl":120},{"sl":129},{"sl":135},{"sl":140},{"sl":141},{"sl":143},{"sl":144}]},"test_8":{"methods":[{"sl":59},{"sl":83},{"sl":102},{"sl":108},{"sl":113}],"name":"when the owner is removed as a traveller, it should throw an exception","pass":true,"statements":[{"sl":60},{"sl":61},{"sl":62},{"sl":64},{"sl":65},{"sl":66},{"sl":67},{"sl":84},{"sl":85},{"sl":103},{"sl":115},{"sl":116},{"sl":117},{"sl":118},{"sl":119},{"sl":120},{"sl":129}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [4, 39], [4, 39], [4, 39], [4, 39], [], [], [], [], [], [], [], [], [6, 27], [6, 27], [6, 27], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [4, 8, 25, 26, 3, 10, 13, 40, 6, 1, 31, 19, 15], [4, 8, 25, 26, 3, 10, 13, 40, 6, 1, 31, 19, 15], [4, 8, 25, 26, 3, 10, 13, 40, 6, 1, 31, 19, 15], [4, 8, 25, 26, 3, 10, 13, 40, 6, 1, 31, 19, 15], [], [4, 8, 25, 26, 3, 10, 13, 40, 6, 1, 31, 19, 15], [4, 8, 25, 26, 3, 10, 13, 40, 6, 1, 31, 19, 15], [4, 8, 25, 26, 3, 10, 13, 40, 6, 1, 31, 19, 15], [4, 8, 25, 26, 3, 10, 13, 40, 6, 1, 31, 19, 15], [], [], [31], [31], [31], [31], [], [], [10, 40, 19, 15], [10, 40, 19, 15], [10, 40, 19, 15], [40, 19, 15], [40, 19, 15], [], [], [8, 26, 13, 40], [8, 26, 13, 40], [8, 13, 40], [40], [40], [], [], [1, 44], [1, 44], [1], [1], [], [], [25], [25], [25], [25], [], [], [8, 25, 26, 10, 13, 40, 1, 19, 15, 44], [8, 25, 26, 10, 13, 40, 1, 19, 15, 44], [26, 44], [], [], [], [4, 8, 25, 26, 3, 10, 13, 40, 6, 1, 31, 19, 15], [], [], [], [], [4, 8, 25, 26, 3, 10, 13, 40, 6, 1, 31, 19, 15], [], [4, 8, 25, 26, 3, 10, 13, 40, 6, 1, 31, 19, 15], [4, 8, 25, 26, 3, 10, 13, 40, 6, 1, 31, 19, 15], [4, 8, 25, 26, 3, 10, 13, 40, 6, 1, 31, 19, 15], [4, 8, 25, 26, 10, 13, 40, 6, 1, 31, 19, 15], [4, 8, 25, 26, 10, 13, 40, 6, 1, 31, 19, 15], [4, 8, 25, 26, 10, 13, 40, 6, 1, 31, 19, 15], [], [], [], [], [], [], [], [], [4, 8, 25, 26, 10, 13, 40, 6, 1, 31, 19, 15], [], [], [], [], [4, 39, 6, 27], [4, 39, 6, 27], [], [], [], [], [4, 39, 6, 27], [4, 39, 6, 27], [], [4, 39, 6, 27], [4, 39, 6, 27], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], []]
