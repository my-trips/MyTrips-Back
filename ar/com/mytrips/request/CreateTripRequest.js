var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":19,"id":380,"methods":[{"el":18,"sc":5,"sl":13}],"name":"CreateTripRequest","sl":10},{"el":51,"id":385,"methods":[{"el":32,"sc":5,"sl":30},{"el":40,"sc":5,"sl":34},{"el":45,"sc":5,"sl":42},{"el":50,"sc":5,"sl":47}],"name":"DestinationCommand","sl":21},{"el":75,"id":399,"methods":[{"el":74,"sc":5,"sl":65}],"name":"PlaceCommand","sl":53},{"el":111,"id":408,"methods":[{"el":100,"sc":5,"sl":89},{"el":105,"sc":5,"sl":102},{"el":110,"sc":5,"sl":107}],"name":"TransportCommand","sl":77},{"el":123,"id":423,"methods":[{"el":122,"sc":5,"sl":119}],"name":"CreateUserRequest","sl":113},{"el":140,"id":425,"methods":[{"el":134,"sc":5,"sl":130},{"el":139,"sc":5,"sl":136}],"name":"UserCommand","sl":125},{"el":155,"id":431,"methods":[{"el":154,"sc":5,"sl":147}],"name":"CountryCommand","sl":143},{"el":189,"id":438,"methods":[{"el":173,"sc":5,"sl":166},{"el":183,"sc":5,"sl":175},{"el":188,"sc":5,"sl":185}],"name":"ActivityCommand","sl":158},{"el":225,"id":454,"methods":[{"el":214,"sc":5,"sl":203},{"el":223,"sc":5,"sl":216}],"name":"AttractionCommand","sl":191},{"el":264,"id":472,"methods":[{"el":255,"sc":5,"sl":242},{"el":258,"sc":5,"sl":257},{"el":263,"sc":5,"sl":260}],"name":"StayCommand","sl":227}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_19":{"methods":[{"sl":166},{"sl":185}],"name":"when update an activity for a day, it should return an updated activity","pass":true,"statements":[{"sl":167},{"sl":168},{"sl":169},{"sl":170},{"sl":171},{"sl":172},{"sl":187}]},"test_23":{"methods":[{"sl":242},{"sl":260}],"name":"when update an stay for a destination, it should return an updated stay","pass":true,"statements":[{"sl":243},{"sl":244},{"sl":245},{"sl":246},{"sl":247},{"sl":248},{"sl":249},{"sl":250},{"sl":251},{"sl":252},{"sl":253},{"sl":254},{"sl":262}]},"test_35":{"methods":[{"sl":89},{"sl":107}],"name":"when update the type of transport between two destinations of a trip, it should return an updated transport","pass":true,"statements":[{"sl":90},{"sl":91},{"sl":92},{"sl":93},{"sl":94},{"sl":95},{"sl":96},{"sl":97},{"sl":98},{"sl":99},{"sl":109}]},"test_7":{"methods":[{"sl":107}],"name":"when update the arrival and departure dates of a transport between two destinations of a trip, it should return an updated transport","pass":true,"statements":[{"sl":109}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [35], [35], [35], [35], [35], [35], [35], [35], [35], [35], [35], [], [], [], [], [], [], [], [7, 35], [], [7, 35], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [19], [19], [19], [19], [19], [19], [19], [], [], [], [], [], [], [], [], [], [], [], [], [19], [], [19], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [23], [23], [23], [23], [23], [23], [23], [23], [23], [23], [23], [23], [23], [], [], [], [], [], [23], [], [23], [], [], []]
