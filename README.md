Alerting Support
================

This functionality notifies the developer(s) on-call about production alerts. Notification methods include SMS text
messages via Twilio and email alerts via ceMail.

Oncall functionality added to allow a query for current oncall members.

Endpoints
---------
1. /alert (POST)
2. /oncall (GET)

Sample JSON
------------
```
{
  "department": {
    "id": 1,
    "name": "Development"
  },
  "team": {
    "id": 1,
    "name": "Backend"
  },
  "teamMemberList": [
    {
      "id": 1,
      "name": "Jaime Soto",
      "phone": "M: +14073308085",
      "email": "jaime.soto@accesso.com"
    },
    {
      "id": 4,
      "name": "Michael Garcia",
      "phone": "M: +14073308086",
      "email": "michael.garcia@accesso.com"
    }
  ],
  "startDate": "2015-08-03",
  "endDate": "2015-08-09"
}
```