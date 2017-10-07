'use strict';
let users = {
    r1: {
        "username": "test@gmail.com",
        "password": "123",
    }
};

let job2 = {
    "title": "auto test",
    "description": "hello",
    "author": "alice",
    "tags": [
        {
            "name" : "comp"
        },
        {
            "name" : "cse"
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

(function postJobs () {
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






