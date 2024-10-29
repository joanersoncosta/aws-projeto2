package com.github.joanersoncosta.aws_projeto02.produto.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class SnsMessage {
    @JsonProperty("Message")
    private String message;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("TopicArn")
    private String topicArn;
    @JsonProperty("Timestamp")
    private String timestamp;
    @JsonProperty("MessageId")
    private String messageId;
}