const express = require("express");
const router = express.Router();
const bodyParser = require("body-parser");
const _ = require("lodash");
const dialogflow = require("dialogflow");
const { struct } = require("pb-util");

const privateKey = _.replace(
  process.env.DIALOGFLOW_PRIVATE_KEY,
  new RegExp("\\\\n", "g"),
  "\n"
);

var dialogflowClient = {
  projectId: process.env.DIALOGFLOW_PROJECT_ID,
  sessionClient: new dialogflow.SessionsClient({
    credentials: {
      client_email: process.env.DIALOGFLOW_CLIENT_EMAIL,
      private_key: privateKey,
    },
  }),
};

router.use(bodyParser.json());
router.use(bodyParser.urlencoded({ extended: true }));

router.post("/message/text/send", async (req, res) => {
  let { message, sessionId } = req.body;
  let { projectId, sessionClient } = dialogflowClient;
  let sessionPath = sessionClient.sessionPath(projectId, sessionId);

  const request = {
    session: sessionPath,
    queryInput: {
      text: {
        text: `${message}`,
        languageCode: "pt-BR",
      },
    },
    queryParams: {
      contexts: [
        {
          name: `projects/${projectId}/agent/sessions/${sessionId}/contexts/_context_data`,
          lifespanCount: 5,
          parameters: struct.encode({ sessionId: sessionId }),
        },
      ],
    },
  };

  const responses = await sessionClient.detectIntent(request);

  const messages = [];

  responses.forEach((value) => {
    if (value)
      value.queryResult.fulfillmentMessages.forEach((fulfillmentMessage) => {
        if (fulfillmentMessage && fulfillmentMessage.text)
          fulfillmentMessage.text.text.forEach((message) => {
            messages.push(message);
          });
      });
  });

  const response = messages.map((msg) => {
    return { message: msg };
  });

  res.send(response);
});

module.exports = router;
