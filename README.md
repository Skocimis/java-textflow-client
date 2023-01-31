# Java TextFlow client

[![Maven Central](https://img.shields.io/maven-central/v/me.textflow/client.svg)](https://mvnrepository.com/artifact/me.textflow/client)

## Installation

java-textflow-client uses Maven. At present the jars *are* available from a public [maven](https://mvnrepository.com/artifact/me.textflow/client) repository.

Use the following dependency in your project to grab via Maven:

```
       <dependency>
          <groupId>me.textflow</groupId>
          <artifactId>client</artifactId>
          <version>1.0.3</version>
       </dependency>
```
## Sample Usage

To send an SMS, you have to create an API key using the [Textflow dashboard](https://textflow.me/api). When you register an account, you automatically get an API key with one free SMS which you can send anywhere.

### Just send a message

```java
import me.textflow.TextFlowClient;

...

TextFlowClient textFlowClient = new TextFlowClient("YOUR_API_KEY");
textFlowClient.sendSMS("+3811231234", "Message body...");
```

### Handle send message request result

```java

var result = textFlowClient.sendSMS("+3811231234", "Message body...");
System.out.println(result.getMessage());

```

### Example properties of the successfully sent message result
`result` is an instance of `TextFlowSendMessageResult`, which has the appropriate getters.
```json
{
    "ok": true,
    "status": 200,
    "message": "Message sent successfully",
    "data": {
        "to": "+381611231234",
        "content": "Dummy message text...",
        "countryCode": "RS",
        "price": 0.05,
        "timestamp": 1674759108881
    }
}
```

### Example properties of the unsuccessfully sent message result
`result` is an instance of `TextFlowSendMessageResult`, which has the appropriate getters.
```json
{
    "ok": false,
    "status": 404,
    "message": "API key not found"
}
```

## Getting help

If you need help installing or using the library, please check the [FAQ](https://textflow.me) first, and contact us at [support@textflow.me](mailto://support@textflow.me) if you don't find an answer to your question.

If you've found a bug in the API, package or would like new features added, you are also free to contact us!
