package ru.donni.vkbot.dto;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Data transfer object for VK API callbacks
 */
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CallbackDto {
    private CallbackType type;
    private Map<String, Object> object;
    @JsonProperty(value = "group_id")
    private Integer groupId;
    private String secret;
    @JsonProperty(value = "event_id")
    private String eventId;

    public enum CallbackType {
        message_new, confirmation
    }
}