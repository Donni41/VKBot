package ru.donni.vkbot.service;

import java.net.URI;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import ru.donni.vkbot.dto.MessageToSendDto;

/**
 * Sender service that works with VK API
 */
@Service
@RequiredArgsConstructor
public class SenderService implements SenderInterface<MessageToSendDto> {
	private final VkUriGenerator vkUriGenerator;
	private final RestTemplate restTemplate;
	
	@Override
    public void send(MessageToSendDto message) {
		message.setRandomId(0);
        URI uri = vkUriGenerator.GenerateUri(message);
        restTemplate.postForEntity(uri, null, String.class);
    }
}
