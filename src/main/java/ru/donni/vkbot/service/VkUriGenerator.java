package ru.donni.vkbot.service;

import java.net.URI;

import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import ru.donni.vkbot.config.VkApiProperties;
import ru.donni.vkbot.dto.MessageToSendDto;

/**
 * Component that generates URI for SenderService.
 * Method GenerateUri returns URI with specified VK API parameters and
 * other parameters transferred from MessageToSendDto
 */
@Component
@RequiredArgsConstructor
public class VkUriGenerator {
	private final VkApiProperties vkApiProperties;
	private final ObjectMapper objectMapper;

	public URI GenerateUri(MessageToSendDto dto) {
		MultiValueMap<String, String> map = objectMapper.convertValue(dto, LinkedMultiValueMap.class);
		return UriComponentsBuilder.fromUriString("https://api.vk.com/method/messages.send")
				.queryParam("access_token", vkApiProperties.getAccessToken())
				.queryParam("v", vkApiProperties.getV())
				.queryParams(map)
				.build()
				.toUri();
	}
}
