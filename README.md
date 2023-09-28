# DUPR Webhook Sample

This project contains an example of a client that receives request from DUPR through the webhooks.

## Subscribe your endpoint in DUPR

First we need to subscribe the client into DUPR, in order to do that send the following request to DUPR, if you don't have a client ID please ask DUPR to create one for your:

POST https://uat.mydupr.com/api/v1.0/webhook

```
{
    "clientId": "ck-8528fe60-fffc-43e7-feb3-845edc5bc97d",
    "webhookUrl": "https://www.mypickleballsite.org/webhook",
    "topics" : ["LOGIN", "TOURNAMENT"]
}
```

you can find the list of Topics by hitting this endpoint:

GET https://uat.mydupr.com/api/v1.0/topic

## Receive the Request

Once you have the webhook running and the URL is reachable you can log in a user using the read only endpoint:

POST https://api.uat.dupr.gg/auth/v1.0/login-read-only-token

```
{
  "email": "user@example.com",
  "password": "mySecretPassword"
}
```
HEADER: It must be your client ID encoded in base 64

```
x-authorization: dGVzdC1jay04NTI4ZmU2MC1mZmZjLTQzZTctZmViMy04NDVlZGM1YmM5N2Q=
```

You will receive a request in the webhook endpoint of your backend with this structure:

```
{
  "clientId": "ck-8528fe60-fffc-43e7-feb3-845edc5bc97d",
  "event": "LOGIN"
  "message": {
    ...
  }
}
```

**clientId** is the same client ID your site has in DUPR, **event** is the Topic that triggered the request, and **message** contains the body of the request. 
