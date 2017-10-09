'use strict';
let users = {
    r1: {
        "username": "test@gmail.com",
        "password": "123",
    }
};

let job2 = {
    "title": "problems about COMP9021(Principles of Programming)",
    "description": "I never use Python(version 3) before this semester. the every week quiz takes me a lot of time to deal with, So can anyone give me some tips about this course. the assignment is challenge too.",
    "author": "test@gmail.com",
    "tags": [
        {
            "name": "comp"
        },
        {
            "name": "cse"
        },
        {
            "name": "9021"
        }

    ]
};
let job3 = {
    "title": "how do you think about GSOE9820(Engineering Project Management)",
    "description": "The semester is very difficult to understand why IT students need to be necessary to complete this class (just want to honestly do not want to be a migrant workers), the whole engineering college people together, talk about something more virtual, there is a certain project management Work experience people may be some gains, but such people must have been exempted from this lesson (laughs)",
    "author": "test@gmail.com",
    "tags": [
        {
            "name": "gsoe"
        },
        {
            "name": "cse"
        },
        {
            "name": "9021"
        },

    ]
};
let job4 = {
    "title": "problems about COMP9021(Data Structures and Algorithms)",
    "description": "I never use Python(version 3) before this semester. the every week quiz takes me a lot of time to deal with, So can anyone give me some tips about this course. the assignment is challenge too.",
    "author": "test@gmail.com",
    "tags": [
        {
            "name": "comp"
        },
        {
            "name": "cse"
        },
        {
            "name": "9021"
        }

    ]
};
let job6 = {
    "title": "need help in COMP9020(Foundations of Computer Science)",
    "description": "Why many student say that: If the teacher is Kai, then do not choose",
    "author": "test@gmail.com",
    "tags": [
        {
            "name": "comp"
        },
        {
            "name": "cse"
        },
        {
            "name": "9021"
        }

    ]
};
let job5 = {
    "title": "problems about COMP9021(Principles of Programming)",
    "description": "I never use Python(version 3) before this semester. the every week quiz takes me a lot of time to deal with, So can anyone give me some tips about this course. the assignment is challenge too.",
    "author": "test@gmail.com",
    "tags": [
        {
            "name": "comp"
        },
        {
            "name": "cse"
        },
        {
            "name": "9021"
        }

    ]
}
let job7 = {
    "title": "problems about COMP9021(Principles of Programming)",
    "description": "I never use Python(version 3) before this semester. the every week quiz takes me a lot of time to deal with, So can anyone give me some tips about this course. the assignment is challenge too.",
    "author": "test@gmail.com",
    "tags": [
        {
            "name": "comp"
        },
        {
            "name": "cse"
        },
        {
            "name": "9021"
        }

    ]
};
let job8 = {
    "title": "problems about COMP9021(Principles of Programming)",
    "description": "I never use Python(version 3) before this semester. the every week quiz takes me a lot of time to deal with, So can anyone give me some tips about this course. the assignment is challenge too.",
    "author": "test@gmail.com",
    "tags": [
        {
            "name": "comp"
        },
        {
            "name": "cse"
        },
        {
            "name": "9021"
        }

    ]
};
let job9 = {
    "title": "problems about COMP9021(Principles of Programming)",
    "description": "I never use Python(version 3) before this semester. the every week quiz takes me a lot of time to deal with, So can anyone give me some tips about this course. the assignment is challenge too.",
    "author": "test@gmail.com",
    "tags": [
        {
            "name": "comp"
        },
        {
            "name": "cse"
        },
        {
            "name": "9021"
        }

    ]
};
let job10 = {
    "title": "problems about COMP9021(Principles of Programming)",
    "description": "I never use Python(version 3) before this semester. the every week quiz takes me a lot of time to deal with, So can anyone give me some tips about this course. the assignment is challenge too.",
    "author": "test@gmail.com",
    "tags": [
        {
            "name": "comp"
        },
        {
            "name": "cse"
        },
        {
            "name": "9021"
        }

    ]
};
let job11 = {
    "title": "problems about COMP9021(Principles of Programming)",
    "description": "I never use Python(version 3) before this semester. the every week quiz takes me a lot of time to deal with, So can anyone give me some tips about this course. the assignment is challenge too.",
    "author": "alice",
    "tags": [
        {
            "name": "comp"
        },
        {
            "name": "cse"
        },
        {
            "name": "9021"
        }

    ]
};
let job12 = {
    "title": "problems about COMP9021(Principles of Programming)",
    "description": "I never use Python(version 3) before this semester. the every week quiz takes me a lot of time to deal with, So can anyone give me some tips about this course. the assignment is challenge too.",
    "author": "alice",
    "tags": [
        {
            "name": "comp"
        },
        {
            "name": "cse"
        },
        {
            "name": "9021"
        }

    ]
};

let request = require('sync-request');
let baseUrl = 'http://localhost:8080';
let apiRegister = '/api/register';
let apiQuestion = '/api/question';
let apiLogin = '/api/login';
let res;
let login;
let token;
let commonHeader;

(function postJobs2() {
    login = request('POST', baseUrl + apiLogin, {
        json: {
            username: users.r1.username,
            password: users.r1.password
        }
    });
    token = login.headers['x-auth-token'];
    console.log(token);
    commonHeader = {
        'x-auth-token': token,
        'content-type': 'application/json'
    };

    res = request('POST', baseUrl + apiQuestion, {
        headers: commonHeader,
        json: job2
    });
    console.log('jb2 response', res.getBody('utf-8'));
})();

(function postJobs3() {
    login = request('POST', baseUrl + apiLogin, {
        json: {
            username: users.r1.username,
            password: users.r1.password
        }
    });
    token = login.headers['x-auth-token'];
    console.log(token);
    commonHeader = {
        'x-auth-token': token,
        'content-type': 'application/json'
    };

    res = request('POST', baseUrl + apiQuestion, {
        headers: commonHeader,
        json: job3
    });
    console.log('jb2 response', res.getBody('utf-8'));
})();


(function postJobs4() {
    login = request('POST', baseUrl + apiLogin, {
        json: {
            username: users.r1.username,
            password: users.r1.password
        }
    });
    token = login.headers['x-auth-token'];
    console.log(token);
    commonHeader = {
        'x-auth-token': token,
        'content-type': 'application/json'
    };

    res = request('POST', baseUrl + apiQuestion, {
        headers: commonHeader,
        json: job4
    });
    console.log('jb2 response', res.getBody('utf-8'));
})();


(function postJobs5() {
    login = request('POST', baseUrl + apiLogin, {
        json: {
            username: users.r1.username,
            password: users.r1.password
        }
    });
    token = login.headers['x-auth-token'];
    console.log(token);
    commonHeader = {
        'x-auth-token': token,
        'content-type': 'application/json'
    };

    res = request('POST', baseUrl + apiQuestion, {
        headers: commonHeader,
        json: job5
    });
    console.log('jb2 response', res.getBody('utf-8'));
})();

(function postJobs6() {
    login = request('POST', baseUrl + apiLogin, {
        json: {
            username: users.r1.username,
            password: users.r1.password
        }
    });
    token = login.headers['x-auth-token'];
    console.log(token);
    commonHeader = {
        'x-auth-token': token,
        'content-type': 'application/json'
    };

    res = request('POST', baseUrl + apiQuestion, {
        headers: commonHeader,
        json: job6
    });
    console.log('jb2 response', res.getBody('utf-8'));
})();
(function postJobs7() {
    login = request('POST', baseUrl + apiLogin, {
        json: {
            username: users.r1.username,
            password: users.r1.password
        }
    });
    token = login.headers['x-auth-token'];
    console.log(token);
    commonHeader = {
        'x-auth-token': token,
        'content-type': 'application/json'
    };

    res = request('POST', baseUrl + apiQuestion, {
        headers: commonHeader,
        json: job7
    });
    console.log('jb2 response', res.getBody('utf-8'));
})();
(function postJobs8() {
    login = request('POST', baseUrl + apiLogin, {
        json: {
            username: users.r1.username,
            password: users.r1.password
        }
    });
    token = login.headers['x-auth-token'];
    console.log(token);
    commonHeader = {
        'x-auth-token': token,
        'content-type': 'application/json'
    };

    res = request('POST', baseUrl + apiQuestion, {
        headers: commonHeader,
        json: job8
    });
    console.log('jb2 response', res.getBody('utf-8'));
})();
(function postJobs9() {
    login = request('POST', baseUrl + apiLogin, {
        json: {
            username: users.r1.username,
            password: users.r1.password
        }
    });
    token = login.headers['x-auth-token'];
    console.log(token);
    commonHeader = {
        'x-auth-token': token,
        'content-type': 'application/json'
    };

    res = request('POST', baseUrl + apiQuestion, {
        headers: commonHeader,
        json: job9
    });
    console.log('jb2 response', res.getBody('utf-8'));
})();
