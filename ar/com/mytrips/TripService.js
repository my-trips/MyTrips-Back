var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":168,"id":643,"methods":[{"el":33,"sc":5,"sl":28},{"el":38,"sc":5,"sl":35},{"el":43,"sc":5,"sl":40},{"el":56,"sc":5,"sl":45},{"el":67,"sc":5,"sl":58},{"el":73,"sc":5,"sl":69},{"el":80,"sc":5,"sl":75},{"el":87,"sc":5,"sl":82},{"el":93,"sc":5,"sl":89},{"el":99,"sc":5,"sl":95},{"el":105,"sc":5,"sl":101},{"el":110,"sc":5,"sl":107},{"el":131,"sc":5,"sl":112},{"el":147,"sc":5,"sl":133},{"el":164,"sc":5,"sl":149}],"name":"TripService","sl":20}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_1":{"methods":[{"sl":89},{"sl":101}],"name":"when delete a trip for a user, but the user is invalid, it should throw an exception","pass":true,"statements":[{"sl":90},{"sl":102},{"sl":103}]},"test_10":{"methods":[{"sl":58},{"sl":75},{"sl":101},{"sl":107},{"sl":112}],"name":"when add a traveller that already exists, it should throw an exception","pass":true,"statements":[{"sl":59},{"sl":60},{"sl":61},{"sl":63},{"sl":64},{"sl":65},{"sl":66},{"sl":76},{"sl":77},{"sl":78},{"sl":79},{"sl":102},{"sl":114},{"sl":115},{"sl":116},{"sl":117},{"sl":118},{"sl":119},{"sl":128}]},"test_11":{"methods":[{"sl":40},{"sl":133}],"name":"when search for all trips for a user, and the user has no trips it should not return nothing.","pass":true,"statements":[{"sl":41},{"sl":42},{"sl":134},{"sl":139},{"sl":140},{"sl":142},{"sl":143}]},"test_16":{"methods":[{"sl":58},{"sl":89},{"sl":101},{"sl":107},{"sl":112}],"name":"when delete a trip from a user, you should be able to delete it","pass":true,"statements":[{"sl":59},{"sl":60},{"sl":61},{"sl":63},{"sl":64},{"sl":65},{"sl":66},{"sl":90},{"sl":91},{"sl":92},{"sl":102},{"sl":114},{"sl":115},{"sl":116},{"sl":117},{"sl":118},{"sl":119},{"sl":128}]},"test_19":{"methods":[{"sl":58},{"sl":69},{"sl":107},{"sl":112}],"name":"when a trip is copied, a new trip with the same configuration is returned","pass":true,"statements":[{"sl":59},{"sl":60},{"sl":61},{"sl":63},{"sl":64},{"sl":65},{"sl":66},{"sl":70},{"sl":71},{"sl":72},{"sl":114},{"sl":115},{"sl":116},{"sl":117},{"sl":118},{"sl":119},{"sl":128}]},"test_20":{"methods":[{"sl":28},{"sl":58},{"sl":107},{"sl":112},{"sl":133}],"name":"when fetch a trip for id, if the trip exists it should return it","pass":true,"statements":[{"sl":29},{"sl":30},{"sl":31},{"sl":59},{"sl":60},{"sl":61},{"sl":63},{"sl":64},{"sl":65},{"sl":66},{"sl":114},{"sl":115},{"sl":116},{"sl":117},{"sl":118},{"sl":119},{"sl":128},{"sl":134},{"sl":139},{"sl":140},{"sl":142},{"sl":143}]},"test_22":{"methods":[{"sl":58},{"sl":75},{"sl":101},{"sl":107},{"sl":112}],"name":"when a traveller is added, it should should increase the list of travellers","pass":true,"statements":[{"sl":59},{"sl":60},{"sl":61},{"sl":63},{"sl":64},{"sl":65},{"sl":66},{"sl":76},{"sl":77},{"sl":78},{"sl":79},{"sl":102},{"sl":114},{"sl":115},{"sl":116},{"sl":117},{"sl":118},{"sl":119},{"sl":128}]},"test_28":{"methods":[{"sl":58},{"sl":82},{"sl":101},{"sl":107},{"sl":112}],"name":"when the owner is removed as a traveller, it should throw an exception","pass":true,"statements":[{"sl":59},{"sl":60},{"sl":61},{"sl":63},{"sl":64},{"sl":65},{"sl":66},{"sl":83},{"sl":84},{"sl":102},{"sl":114},{"sl":115},{"sl":116},{"sl":117},{"sl":118},{"sl":119},{"sl":128}]},"test_32":{"methods":[{"sl":58},{"sl":82},{"sl":101},{"sl":107},{"sl":112}],"name":"when a non-owner user removes a traveller, it should throw an exception","pass":true,"statements":[{"sl":59},{"sl":60},{"sl":61},{"sl":63},{"sl":64},{"sl":65},{"sl":66},{"sl":83},{"sl":102},{"sl":103},{"sl":114},{"sl":115},{"sl":116},{"sl":117},{"sl":118},{"sl":119},{"sl":128}]},"test_35":{"methods":[{"sl":28},{"sl":133}],"name":"when fetch a trip for id, if the trip doesn't exits it shouldn't return it","pass":true,"statements":[{"sl":29},{"sl":30},{"sl":31},{"sl":134},{"sl":139},{"sl":140},{"sl":142},{"sl":143}]},"test_36":{"methods":[{"sl":58},{"sl":75},{"sl":82},{"sl":101},{"sl":107},{"sl":112}],"name":"when a traveller is removed, it should be removed from the list of travellers","pass":true,"statements":[{"sl":59},{"sl":60},{"sl":61},{"sl":63},{"sl":64},{"sl":65},{"sl":66},{"sl":76},{"sl":77},{"sl":78},{"sl":79},{"sl":83},{"sl":84},{"sl":85},{"sl":86},{"sl":102},{"sl":114},{"sl":115},{"sl":116},{"sl":117},{"sl":118},{"sl":119},{"sl":128}]},"test_38":{"methods":[{"sl":58},{"sl":82},{"sl":101},{"sl":107},{"sl":112}],"name":"when removing a traveller that doesn't exist, it should throw an exception","pass":true,"statements":[{"sl":59},{"sl":60},{"sl":61},{"sl":63},{"sl":64},{"sl":65},{"sl":66},{"sl":83},{"sl":84},{"sl":102},{"sl":114},{"sl":115},{"sl":116},{"sl":117},{"sl":118},{"sl":119},{"sl":128}]},"test_42":{"methods":[{"sl":58},{"sl":95},{"sl":101},{"sl":107},{"sl":112}],"name":"when changeVisibility is called with true, the trip becomes public","pass":true,"statements":[{"sl":59},{"sl":60},{"sl":61},{"sl":63},{"sl":64},{"sl":65},{"sl":66},{"sl":96},{"sl":97},{"sl":98},{"sl":102},{"sl":114},{"sl":115},{"sl":116},{"sl":117},{"sl":118},{"sl":119},{"sl":128}]},"test_5":{"methods":[{"sl":40},{"sl":58},{"sl":107},{"sl":112},{"sl":133}],"name":"when search for all trips for a user, it should return all of them","pass":true,"statements":[{"sl":41},{"sl":42},{"sl":59},{"sl":60},{"sl":61},{"sl":63},{"sl":64},{"sl":65},{"sl":66},{"sl":114},{"sl":115},{"sl":116},{"sl":117},{"sl":118},{"sl":119},{"sl":128},{"sl":134},{"sl":139},{"sl":140},{"sl":142},{"sl":143}]},"test_7":{"methods":[{"sl":58},{"sl":75},{"sl":101},{"sl":107},{"sl":112}],"name":"when the owner is added as a traveller, it should throw an exception","pass":true,"statements":[{"sl":59},{"sl":60},{"sl":61},{"sl":63},{"sl":64},{"sl":65},{"sl":66},{"sl":76},{"sl":77},{"sl":102},{"sl":114},{"sl":115},{"sl":116},{"sl":117},{"sl":118},{"sl":119},{"sl":128}]},"test_9":{"methods":[{"sl":58},{"sl":107},{"sl":112}],"name":"when create a trip, it should return a complete trip","pass":true,"statements":[{"sl":59},{"sl":60},{"sl":61},{"sl":63},{"sl":64},{"sl":65},{"sl":66},{"sl":114}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [35, 20], [35, 20], [35, 20], [35, 20], [], [], [], [], [], [], [], [], [11, 5], [11, 5], [11, 5], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [22, 32, 10, 19, 42, 7, 5, 38, 16, 20, 9, 36, 28], [22, 32, 10, 19, 42, 7, 5, 38, 16, 20, 9, 36, 28], [22, 32, 10, 19, 42, 7, 5, 38, 16, 20, 9, 36, 28], [22, 32, 10, 19, 42, 7, 5, 38, 16, 20, 9, 36, 28], [], [22, 32, 10, 19, 42, 7, 5, 38, 16, 20, 9, 36, 28], [22, 32, 10, 19, 42, 7, 5, 38, 16, 20, 9, 36, 28], [22, 32, 10, 19, 42, 7, 5, 38, 16, 20, 9, 36, 28], [22, 32, 10, 19, 42, 7, 5, 38, 16, 20, 9, 36, 28], [], [], [19], [19], [19], [19], [], [], [22, 10, 7, 36], [22, 10, 7, 36], [22, 10, 7, 36], [22, 10, 36], [22, 10, 36], [], [], [32, 38, 36, 28], [32, 38, 36, 28], [38, 36, 28], [36], [36], [], [], [1, 16], [1, 16], [16], [16], [], [], [42], [42], [42], [42], [], [], [22, 32, 10, 1, 42, 7, 38, 16, 36, 28], [22, 32, 10, 1, 42, 7, 38, 16, 36, 28], [32, 1], [], [], [], [22, 32, 10, 19, 42, 7, 5, 38, 16, 20, 9, 36, 28], [], [], [], [], [22, 32, 10, 19, 42, 7, 5, 38, 16, 20, 9, 36, 28], [], [22, 32, 10, 19, 42, 7, 5, 38, 16, 20, 9, 36, 28], [22, 32, 10, 19, 42, 7, 5, 38, 16, 20, 36, 28], [22, 32, 10, 19, 42, 7, 5, 38, 16, 20, 36, 28], [22, 32, 10, 19, 42, 7, 5, 38, 16, 20, 36, 28], [22, 32, 10, 19, 42, 7, 5, 38, 16, 20, 36, 28], [22, 32, 10, 19, 42, 7, 5, 38, 16, 20, 36, 28], [], [], [], [], [], [], [], [], [22, 32, 10, 19, 42, 7, 5, 38, 16, 20, 36, 28], [], [], [], [], [11, 5, 35, 20], [11, 5, 35, 20], [], [], [], [], [11, 5, 35, 20], [11, 5, 35, 20], [], [11, 5, 35, 20], [11, 5, 35, 20], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], []]
