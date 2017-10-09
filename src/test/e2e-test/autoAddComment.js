'use strict';

let users = {
    r1: {
        "username": "test@gmail.com",
        "password": "123",
    }
};
let job1 = {
    "postId": "1",
    "commenter": "295046974@qq.com",
    "content": "this is a new Comment Content"
};
let job2 = {
    "postId": "",
    "commenter": "295046974@qq.com",
    "content": "this is a new Comment Content"
};
let job3 = {
    "postId": "1",
    "commenter": "295046974@qq.com",
    "content": "this is a new Comment Content"
};
let job4 = {
    "postId": "1",
    "commenter": "295046974@qq.com",
    "content": "this is a new Comment Content"
};
let job5 = {
    "postId": "1",
    "commenter": "295046974@qq.com",
    "content": "this is a new Comment Content"
};
let job6 = {
    "postId": "1",
    "commenter": "295046974@qq.com",
    "content": "this is a new Comment Content"
};
let job7 = {
    "postId": "1",
    "commenter": "295046974@qq.com",
    "content": "this is a new Comment Content"
};


let request = require('sync-request');
let baseUrl = 'http://localhost:8080';
let apiRegister = '/api/register';
let apiExperience = '/api/comment/type';
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

