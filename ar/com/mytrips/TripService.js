var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":106,"id":586,"methods":[{"el":35,"sc":5,"sl":22},{"el":39,"sc":5,"sl":37},{"el":50,"sc":5,"sl":41},{"el":56,"sc":5,"sl":52},{"el":62,"sc":5,"sl":58},{"el":71,"sc":5,"sl":64},{"el":76,"sc":5,"sl":73},{"el":97,"sc":5,"sl":78},{"el":105,"sc":5,"sl":99}],"name":"TripService","sl":14}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_10":{"methods":[{"sl":41},{"sl":64}],"name":"when removing a collaborator that doesn't exist, it should throw an exception","pass":true,"statements":[{"sl":42},{"sl":43},{"sl":44},{"sl":46},{"sl":47},{"sl":49},{"sl":65},{"sl":68}]},"test_17":{"methods":[{"sl":41},{"sl":64}],"name":"when the owner is removed as a collaborator, it should throw an exception","pass":true,"statements":[{"sl":42},{"sl":43},{"sl":44},{"sl":46},{"sl":47},{"sl":49},{"sl":65},{"sl":68}]},"test_19":{"methods":[{"sl":41}],"name":"when create a trip, it should return a complete trip","pass":true,"statements":[{"sl":42},{"sl":43},{"sl":44},{"sl":46},{"sl":47},{"sl":49}]},"test_20":{"methods":[{"sl":41},{"sl":58},{"sl":64}],"name":"when a collaborator is removed, it should be removed from the list of collaborators","pass":true,"statements":[{"sl":42},{"sl":43},{"sl":44},{"sl":46},{"sl":47},{"sl":49},{"sl":59},{"sl":60},{"sl":61},{"sl":65},{"sl":68},{"sl":69},{"sl":70}]},"test_22":{"methods":[{"sl":99}],"name":"when delete a trip for a user, but the user is invalid, it should throw an exception","pass":true,"statements":[{"sl":100},{"sl":101}]},"test_23":{"methods":[{"sl":41},{"sl":58}],"name":"when a collaborator is added, it should should increase the list of collaborators","pass":true,"statements":[{"sl":42},{"sl":43},{"sl":44},{"sl":46},{"sl":47},{"sl":49},{"sl":59},{"sl":60},{"sl":61}]},"test_25":{"methods":[{"sl":41},{"sl":58}],"name":"when the owner is added as a collaborator, it should throw an exception","pass":true,"statements":[{"sl":42},{"sl":43},{"sl":44},{"sl":46},{"sl":47},{"sl":49},{"sl":59}]},"test_27":{"methods":[{"sl":22}],"name":"when fetch a trip for id, if the trip doesn't exits it shouldn't return it","pass":true,"statements":[{"sl":23}]},"test_28":{"methods":[{"sl":37}],"name":"when search for all trips for a user, and the user has no trips it should not return nothing.","pass":true,"statements":[{"sl":38}]},"test_31":{"methods":[{"sl":41},{"sl":99}],"name":"when delete a trip from a user, you should be able to delete it","pass":true,"statements":[{"sl":42},{"sl":43},{"sl":44},{"sl":46},{"sl":47},{"sl":49},{"sl":100},{"sl":103},{"sl":104}]},"test_34":{"methods":[{"sl":41},{"sl":58}],"name":"when add a collaborator that already exists, it should throw an exception","pass":true,"statements":[{"sl":42},{"sl":43},{"sl":44},{"sl":46},{"sl":47},{"sl":49},{"sl":59},{"sl":60},{"sl":61}]},"test_37":{"methods":[{"sl":22},{"sl":41}],"name":"when fetch a trip for id, if the trip exists it should return it","pass":true,"statements":[{"sl":23},{"sl":42},{"sl":43},{"sl":44},{"sl":46},{"sl":47},{"sl":49}]},"test_4":{"methods":[{"sl":41},{"sl":64}],"name":"when a non-owner user removes a collaborator, it should throw an exception","pass":true,"statements":[{"sl":42},{"sl":43},{"sl":44},{"sl":46},{"sl":47},{"sl":49},{"sl":65},{"sl":66}]},"test_5":{"methods":[{"sl":41},{"sl":52}],"name":"when a trip is copied, a new trip with the same configuration is returned","pass":true,"statements":[{"sl":42},{"sl":43},{"sl":44},{"sl":46},{"sl":47},{"sl":49},{"sl":53},{"sl":54},{"sl":55}]},"test_8":{"methods":[{"sl":37},{"sl":41}],"name":"when search for all trips for a user, it should return all of them","pass":true,"statements":[{"sl":38},{"sl":42},{"sl":43},{"sl":44},{"sl":46},{"sl":47},{"sl":49}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [27, 37], [27, 37], [], [], [], [], [], [], [], [], [], [], [], [], [], [28, 8], [28, 8], [], [], [34, 5, 17, 20, 10, 23, 31, 4, 8, 19, 25, 37], [34, 5, 17, 20, 10, 23, 31, 4, 8, 19, 25, 37], [34, 5, 17, 20, 10, 23, 31, 4, 8, 19, 25, 37], [34, 5, 17, 20, 10, 23, 31, 4, 8, 19, 25, 37], [], [34, 5, 17, 20, 10, 23, 31, 4, 8, 19, 25, 37], [34, 5, 17, 20, 10, 23, 31, 4, 8, 19, 25, 37], [], [34, 5, 17, 20, 10, 23, 31, 4, 8, 19, 25, 37], [], [], [5], [5], [5], [5], [], [], [34, 20, 23, 25], [34, 20, 23, 25], [34, 20, 23], [34, 20, 23], [], [], [17, 20, 10, 4], [17, 20, 10, 4], [4], [], [17, 20, 10], [20], [20], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [31, 22], [31, 22], [22], [], [31], [31], [], []]
