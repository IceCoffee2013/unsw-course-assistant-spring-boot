'use strict';

let users = {
    r1: {
        "username": "test@gmail.com",
        "password": "123",
    }
};
let job1 = {
    "title": "the experience for COMP6714",
    "content": "Really enjoying the algorithms and the contents in the lecture.\n" +
    "\n" +
    "Lecturer(Wang Wei) is a nice person and a responsible teacher.\n" +
    "At the beginning few weeks of this semester, he looked bit nervous and cannot make the teaching content clear, speaking hundreds of \"actually\" in the 3 hours lecture, however, since week 4, he made a huge improvement, and I really enjoy the content and can not wait to take his lecture! An information retrieval process begins when a user enters a query into the system. Queries are formal statements of information needs, for example search strings in web search engines. In information retrieval a query does not uniquely identify a single object in the collection. Instead, several objects may match the query, perhaps with different degrees of relevancy.\n" +
    "\n" +
    "An object is an entity that is represented by information in a content collection or database. User queries are matched against the database information. However, as opposed to classical SQL queries of a database, in information retrieval the results returned may or may not match the query, so results are typically ranked. This ranking of results is a key difference of information retrieval searching compared to database searching.[1]\n" +
    "\n" +
    "Depending on the application the data objects may be, for example, text documents, images,[2] audio,[3] mind maps[4] or videos. Often the documents themselves are not kept or stored directly in the IR system, but are instead represented in the system by document surrogates or metadata.\n" +
    "\n" +
    "Most IR systems compute a numeric score on how well each object in the database matches the query, and rank the objects according to this value. The top ranking objects are then shown to the user. The process may then be iterated if the user wishes to refine the query.[5]\n" +
    "\n  ",
    "tags": [
        {
            "name": "Information Retrieval"
        },
        {
            "name": "Web Search"
        },
        {
            "name": "COMP6714"
        }
    ]
};
let job2 = {
    "title": "my experience of learn Data Structures and Algorithms",
    "content": "\n" +
    "Repeat degree is relatively high with 9021, the first seven chapters on the data structure, followed by some basic algorithms, breadth can still but no depth\n" +
    "I personally relatively large harvest, never contact before the data structure is considered entry\n" +
    "Before the repair of the 9021 students or the old drivers can be considered free, or you may not have the first year of senior class optional, this lesson is no meaning and is super multi-class front\n" +
    "(Actually did not listen to), basically did not exceed the content of PPT, and Wu teacher Chinese accent heavier (see Rebus), in fact, Wu teacher is good, as a rookie private often ask him some questions, Can be discussed directly in Chinese 233333\n" +
    "Homework in general, basically no change, the second job to use java library that library is more annoying, the third job scheduling bonus more interesting, the fourth suffix tree bonus bad to engage in a few days to pay the last few jobs Hour or give up\n" +
    "Examination is relatively simple, there will be a certain range, some of the more difficult algorithm will not involve such as red and black tree what\n" +
    "Textbooks written in java, more suitable for white, easy to understand, read this can be considered arithmetic :)",
    "tags": [
        {
            "name": "Data Structures "
        },
        {
            "name": "Algorithms"
        },
        {
            "name": "9024"
        }
    ]
};
let job3 = {
    "title": "want to know Computer Vision, click here",
    "content": "- Lectured by PhD students who haven't yet learned public speaking. Loads of ambiguity in assignments, but lecturer refuses to acknowledge this. Very broad, goes over all sorts of things you can do with image and video processing. Assignments are pretty cool, project can be very independent. No exam. So good if you are willing to put in the hours and learn/work on your own. Really fun course if you are interested in the field\n" +
    "- Lots of very difficult maths\n" +
    "- Loads to learn but assignments very ambiguous. Course managament is very messy. Topics are taught after they've been examined in assignments. Would be a much better course if was better handled.",
    "tags": [
        {
            "name": "Computer Vision"
        },
        {
            "name": "9517"
        },
    ]
};
let job4 = {
    "title": "Still confuse in learn Database Systems?",
    "content": "Topics:\n" +
    "\n" +
    "Data modelling\n" +
    "Principles of database design\n" +
    "Data manipulation languages\n" +
    "Database application techniques\n" +
    "Introduction to DBMS internals\n" +
    "Introduction to advanced databases\n" +
    "Design and implementation of a database application using SQL and stored procedures",
    "tags": [
        {
            "name": "Database"
        },
        {
            "name": "9311"
        }
    ]
};
let job5 = {
    "title": "Web Data Compresssion and Search",
    "content": "9319 is one of the most difficult courses recognized in the college (Data Warehousing & Data Mining teacher Wei Wang also recommended in class). As for why it is difficult, personally feel that the first is because the class to teach the data compression algorithm to achieve more complex, and all operations must be written in C or C + +, if you have not learned these two languages ​​before the comparison headache. The second is because the three homework assignments are about algorithm optimization, that is, to constantly improve their own writing algorithm, in the time complexity and space complexity to find an optimal balance between, and this optimization, Can be said to be endless. For example, you can write an algorithm that runs only 0.1 seconds but requires a 300M memory, but you can also write an algorithm that runs 1 second but only 10M of memory, and you can also write a run time as long as 0.05 seconds Only need to use 1M memory algorithm. This course is taught by Raymond Wong, one of the best teachers taught in the college, and graduated from Stanford University. The teacher's job requirements are not very harsh, it is difficult to understand their own algorithms continue to understand and improve the above. After completing this course, you can write your own file compression and decompression, the class will introduce a lot of industry popular algorithm.",
    "tags": [
        {
            "name": "Web Data Compresssion"
        },
        {
            "name": "search"
        },
        {
            "name": "9319"
        }
    ]
};
let job6 = {
    "title": "Advanced Operating Systems ",
    "content": "Amazing. Brutal. Exhilarating. You will jolt awake in the middle of the night, sweating profusely and screaming out for help. You will cry like a sad child. You will come out a changed person. Quite possibly the hardest course CSE has to offer, and you will learn a metric shit-ton.- such subject. much learn. \n" +
    "- AOS = Area of Study\n" +
    "- aos is love, aos is life\n" +
    "* free T shirt to show how excl00sive u are\n" +
    "* AOS = no sleep. If you had a significant other before AOS, you won't after\n" +
    "-kappa.jpg\n" +
    "10/10 review would read again",
    "tags": [
        {
            "name": "9242"
        },
        {
            "name": "Operating Systems"
        },
        {
            "name": "hard"
        }
    ]
};
let job7 = {
    "title": "COMP9331 COMPUTER NETWORKS & APPLICATIONS",
    "content": "Textbook:\n" +
    "\n" +
    "Computer Networking: A Top-Down Approach, James Jurose and Keith Ross, 4th Edition, Addison Wesley, 2007\n" +
    "\n" +
    "Computer Networks:  A Systems Approach,  Larry Peterson and Bruce Davie, 4th Edition, Morgan Kaufmann, 2007\n" +
    "\n" +
    "Topics:\n" +
    "\n" +
    "Internet Protocol Architecture\n" +
    "Circuit and Packet Switching\n" +
    "Application Layer\n" +
    "HTTP\n" +
    "E-mail\n" +
    "FTP\n" +
    "Peer to Peer Networks\n" +
    "DNS\n" +
    "Transport Layer Principles\n" +
    "TCP\n" +
    "UDP\n" +
    "Congestion Control\n" +
    "IP\n" +
    "Network Layer Principles\n" +
    "IP Addressing\n" +
    "Virtual Circuits\n" +
    "Routing Algorithms\n" +
    "Link Layer Services\n" +
    "Multiple Access Protocols\n" +
    "Link Layer Addressing\n" +
    "Ethernet\n" +
    "Hubs and Switches\n" +
    "IEEE 802.11 Local Area Networks\n" +
    "Network Security Basics\n" +
    "Public and Private Key Cryptography\n" +
    "Digital Signatures\n" +
    "Authentication, Firewalls.",
    "tags": [
        {
            "name": "NETWORKS"
        },
        {
            "name": "COMP9331 "
        }
    ]
};




let request = require('sync-request');
let baseUrl = 'http://localhost:8080';
let apiRegister = '/api/register';
let apiExperience = '/api/article';
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

    res = request('POST', baseUrl + apiExperience, {
        headers: commonHeader,
        json: job1
    });
    res = request('POST', baseUrl + apiExperience, {
        headers: commonHeader,
        json: job2
    });
    res = request('POST', baseUrl + apiExperience, {
        headers: commonHeader,
        json: job3
    });
    res = request('POST', baseUrl + apiExperience, {
        headers: commonHeader,
        json: job4
    });
    res = request('POST', baseUrl + apiExperience, {
        headers: commonHeader,
        json: job5
    });
    res = request('POST', baseUrl + apiExperience, {
        headers: commonHeader,
        json: job6
    });
    res = request('POST', baseUrl + apiExperience, {
        headers: commonHeader,
        json: job7
    });
    console.log('jb1 response', res.getBody('utf-8'));
})();
