# Apollo API

### Getting a JWT

<details>

<summary>Instructions for getting a JWT for hitting the endpoints</summary>

once you have signed in through okta on the [client]("https://github.com/Lambda-School-Labs/Labs26-Apollo-FE-TeamB") do
```JS
let tokenObj = JSON.parse(localStorage.getItem("okta-token-storage"));
```
![Client Dev Console](./screenshots/img_1.PNG)
```JS
tokenObj.idToken.value
```
![Another Dev Console](./screenshots/img_2.PNG)

Ok so now that you have copied that idtoken property head over to postman, and in the auth tab select barer token and paste in the token.

![Postman](./screenshots/img_3.PNG)

</details>

### Local Development Setup

<details>

<summary>When working with the api locally you may configure env variables to make testing easier</summary>

![Env Vars](./screenshots/img_4.PNG)

</details>




### Database layout

<details>
<summary> Image of Database Layout </summary>

![Image of Database Layout](db.png)
</details>

### Endpoints:

## Topics

<details>

<summary>POST: http://apollo-b-api.herokuapp.com/topics/new - create a new topic</summary>

Creates a Topic with the current user as the owner.

Expected body
```JSON
{
    "title": "My New Topic",
    "frequency": "WEEKLY",
    "defaultsurvey": {
        "questions": [
                    {
                        "body": "Do you have any blockers?",
                        "type": "TEXT",
                        "leader": true
                    },
                    {
                        "body": "What is the teams priority?",
                        "type": "TEXT",
                        "leader": true
                    },
                    {
                        "body": "How is your weekend?",
                        "type": "TEXT",
                        "leader": false
                    }
        ]
    }
}

```

Results

```JSON
{
    "topicId": 62,
    "title": "My New Topic",
    "owner": {
        "userid": 10,
        "username": "llama001@maildrop.cc"
    },
    "frequency": "WEEKLY",
    "defaultsurvey": {
        "surveyId": 63,
        "questions": [
            {
                "questionId": 64,
                "body": "Do you have any blockers?",
                "type": "TEXT",
                "leader": true
            },
            {
                "questionId": 65,
                "body": "What is the teams priority?",
                "type": "TEXT",
                "leader": true
            },
            {
                "questionId": 66,
                "body": "How is your weekend?",
                "type": "TEXT",
                "leader": false
            }
        ]
    },
    "joincode": "QkJlKGwYM",
    "surveysrequests": [],
    "users": []
}
```


</details>

<details>

<summary>GET: http://apollo-b-api.herokuapp.com/topics/topics - Get all topics for a user</summary>

Returns all topics that a user is connected to, either as an owner or as a member

GET Endpoint

```JSON
[
    {
        "topicId": 37,
        "title": "Topic 2",
        "owner": {
            "userid": 4,
            "username": "admin"
        },
        "frequency": "MONDAY",
        "defaultsurvey": {
            "surveyId": 36,
            "questions": []
        },
        "joincode": "lRQlkNGkg",
        "surveysrequests": [
            {
                "surveyId": 46,
                "questions": [
                    {
                        "questionId": 56,
                        "body": "Leader Question 1",
                        "type": "TEXT",
                        "leader": true
                    },
                    {
                        "questionId": 58,
                        "body": "Leader Question 2",
                        "type": "TEXT",
                        "leader": true
                    },
                    {
                        "questionId": 59,
                        "body": "Member Question 1",
                        "type": "TEXT",
                        "leader": false
                    }
                ]
            },
            {
                "surveyId": 57,
                "questions": []
            }
        ],
        "users": [
            {
                "user": {
                    "userid": 5,
                    "username": "cinnamon"
                }
            },
            {
                "user": {
                    "userid": 10,
                    "username": "llama001@maildrop.cc"
                }
            }
        ]
    },
    {
        "topicId": 62,
        "title": "My New Topic",
        "owner": {
            "userid": 10,
            "username": "llama001@maildrop.cc"
        },
        "frequency": "WEEKLY",
        "defaultsurvey": {
            "surveyId": 63,
            "questions": [
                {
                    "questionId": 64,
                    "body": "Do you have any blockers?",
                    "type": "TEXT",
                    "leader": true
                },
                {
                    "questionId": 65,
                    "body": "What is the teams priority?",
                    "type": "TEXT",
                    "leader": true
                },
                {
                    "questionId": 66,
                    "body": "How is your weekend?",
                    "type": "TEXT",
                    "leader": false
                }
            ]
        },
        "joincode": "QkJlKGwYM",
        "surveysrequests": [
            {
                "surveyId": 63,
                "questions": [
                    {
                        "questionId": 64,
                        "body": "Do you have any blockers?",
                        "type": "TEXT",
                        "leader": true
                    },
                    {
                        "questionId": 65,
                        "body": "What is the teams priority?",
                        "type": "TEXT",
                        "leader": true
                    },
                    {
                        "questionId": 66,
                        "body": "How is your weekend?",
                        "type": "TEXT",
                        "leader": false
                    }
                ]
            }
        ],
        "users": []
    }
]
```

</details>

<details>

<summary>POST: http://appollo-b-api.herokuapp.com/topics/{joinCode} Current user joins a Topic.</summary>

Example: http://appollo-b-api.herokuapp.com/topics/lRQlkNGkg

Returns 200 Success message

</details>

<details>
<summary>GET: http://appollo-b-api.herokuapp.com/topics/all Returns list of all Topics regardless of user</summary>

N/A

</details>

<details>
<summary>GET: http://localhost:2019/topics/topic/{topicId} Returns a specific topic</summary>

Example : http://appollo-b-api.herokuapp.com/topics/topic/37

</details>

## Users

<details>

<summary>GET: http://apollo-b-api.herokuapp.com/users/getuserinfo Returns user info included topics of which they are a member</summary>

Example: 

```JSON
{
    "userid": 10,
    "username": "llama001@maildrop.cc",
    "ownedtopics": [
        {
            "topicId": 62,
            "title": "My New Topic",
            "frequency": "WEEKLY",
            "defaultsurvey": {
                "surveyId": 63,
                "questions": [
                    {
                        "questionId": 64,
                        "body": "Do you have any blockers?",
                        "type": "TEXT",
                        "leader": true
                    },
                    {
                        "questionId": 65,
                        "body": "What is the teams priority?",
                        "type": "TEXT",
                        "leader": true
                    },
                    {
                        "questionId": 66,
                        "body": "How is your weekend?",
                        "type": "TEXT",
                        "leader": false
                    }
                ]
            },
            "joincode": "QkJlKGwYM",
            "surveysrequests": [
                {
                    "surveyId": 63,
                    "questions": [
                        {
                            "questionId": 64,
                            "body": "Do you have any blockers?",
                            "type": "TEXT",
                            "leader": true
                        },
                        {
                            "questionId": 65,
                            "body": "What is the teams priority?",
                            "type": "TEXT",
                            "leader": true
                        },
                        {
                            "questionId": 66,
                            "body": "How is your weekend?",
                            "type": "TEXT",
                            "leader": false
                        }
                    ]
                }
            ]
        }
    ],
    "topics": [
        {
            "topic": {
                "topicId": 37,
                "title": "Topic 2",
                "owner": {
                    "userid": 4,
                    "username": "admin"
                },
                "frequency": "MONDAY",
                "defaultsurvey": {
                    "surveyId": 36,
                    "questions": []
                },
                "joincode": "lRQlkNGkg",
                "surveysrequests": [
                    {
                        "surveyId": 46,
                        "questions": [
                            {
                                "questionId": 56,
                                "body": "Leader Question 1",
                                "type": "TEXT",
                                "leader": true
                            },
                            {
                                "questionId": 58,
                                "body": "Leader Question 2",
                                "type": "TEXT",
                                "leader": true
                            },
                            {
                                "questionId": 59,
                                "body": "Member Question 1",
                                "type": "TEXT",
                                "leader": false
                            }
                        ]
                    },
                    {
                        "surveyId": 57,
                        "questions": []
                    }
                ]
            }
        }
    ]
}

```

</details>



## Surveys
<details>
     
<summary>GET: http://apollo-b-api.herokuapp.com/surveys/all Returns list of surveys</summary>

```JSON
[
    {
        "surveyId": 34,
        "topic": null,
        "questions": []
    },
    {
        "surveyId": 41,
        "topic": {
            "topicId": 35,
            "title": "Topic 1",
            "frequency": "MONDAY"
        },
        "questions": [
            {
                "questionId": 51,
                "body": "Leader Question 1",
                "type": "TEXT",
                "leader": true
            },
            {
                "questionId": 52,
                "body": "Leader Question 2",
                "type": "TEXT",
                "leader": true
            },
            {
                "questionId": 53,
                "body": "Member Question 1",
                "type": "TEXT",
                "leader": false
            }
        ]
    },
    {
        "surveyId": 42,
        "topic": {
            "topicId": 35,
            "title": "Topic 1",
            "frequency": "MONDAY"
        },
        "questions": [
            {
                "questionId": 54,
                "body": "Member Question 2",
                "type": "TEXT",
                "leader": false
            },
            {
                "questionId": 55,
                "body": "Member Question 3",
                "type": "TEXT",
                "leader": false
            }
        ]
    },
    {
        "surveyId": 43,
        "topic": {
            "topicId": 35,
            "title": "Topic 1",
            "frequency": "MONDAY"
        },
        "questions": []
    },
    {
        "surveyId": 44,
        "topic": {
            "topicId": 35,
            "title": "Topic 1",
            "frequency": "MONDAY"
        },
        "questions": []
    },
    {
        "surveyId": 45,
        "topic": {
            "topicId": 35,
            "title": "Topic 1",
            "frequency": "MONDAY"
        },
        "questions": []
    }
]

```

</details>

## Questions
<details>

<summary>GET: http://apollo-b-api.herokuapp.com/questions Returns list of questions</summary>

```JSON
[
    {
        "questionId": 51,
        "body": "Leader Question 1",
        "type": "TEXT",
        "survey": {
            "surveyId": 41,
            "topic": {
                "topicId": 35,
                "title": "Topic 1",
                "frequency": "MONDAY"
            }
        },
        "leader": true
    },
    {
        "questionId": 52,
        "body": "Leader Question 2",
        "type": "TEXT",
        "survey": {
            "surveyId": 41,
            "topic": {
                "topicId": 35,
                "title": "Topic 1",
                "frequency": "MONDAY"
            }
        },
        "leader": true
    },
    {
        "questionId": 53,
        "body": "Member Question 1",
        "type": "TEXT",
        "survey": {
            "surveyId": 41,
            "topic": {
                "topicId": 35,
                "title": "Topic 1",
                "frequency": "MONDAY"
            }
        },
        "leader": false
    },
    {
        "questionId": 54,
        "body": "Member Question 2",
        "type": "TEXT",
        "survey": {
            "surveyId": 42,
            "topic": {
                "topicId": 35,
                "title": "Topic 1",
                "frequency": "MONDAY"
            }
        },
        "leader": false
    },
    {
        "questionId": 55,
        "body": "Member Question 3",
        "type": "TEXT",
        "survey": {
            "surveyId": 42,
            "topic": {
                "topicId": 35,
                "title": "Topic 1",
                "frequency": "MONDAY"
            }
        },
        "leader": false
    }
]

```

</details>
