package ru.donni.vkbot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Data transfer object for messages.send request
 */
@Builder
@Getter
@Setter
public class MessageToSendDto {
	@JsonProperty(value = "user_id")
    Integer userId;
	@JsonProperty(value = "random_id")
    Integer randomId;
    String message;
    @JsonProperty(value = "group_id")
    Integer groupId;
}
