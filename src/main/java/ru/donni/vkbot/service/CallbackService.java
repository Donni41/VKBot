package ru.donni.vkbot.service;

import java.security.InvalidParameterException;
import java.util.Map;
import java.util.Objects;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.donni.vkbot.config.VkApiProperties;
import ru.donni.vkbot.dto.CallbackDto;
import ru.donni.vkbot.dto.MessageToSendDto;

/**
 * Callback service that handles confirmation and message_new callbacks.
 * Otherwise, throws UnsupportedOperationException
 */
@Service
@RequiredArgsConstructor
public class CallbackService implements CallbackInterface{
	private final VkApiProperties vkApiProperties;
	private final SenderInterface<MessageToSendDto> senderService;


	@Override
	public String handleCallback(CallbackDto callbackDto) {
		validateSecret(callbackDto);
		switch (Objects.requireNonNull(callbackDto.getType())) {
		case confirmation: {
			return vkApiProperties.getConfirmation();
		}
		case message_new: {
			MessageToSendDto messageToSendDto = parseMessageToSend(callbackDto);
            handleMessageNew(messageToSendDto);
			return "ok";
		}
		default: {
			throw new UnsupportedOperationException("Unsupported callback type");
		}
		}
	}

	private void validateSecret(CallbackDto callbackDto) {
		if (!vkApiProperties.getSecret().equals(callbackDto.getSecret())) {
			throw new InvalidParameterException("Invalid secret");
		}
	}

	private void handleMessageNew(MessageToSendDto messageToSendDto) {
		MessageToSendDto dto = MessageToSendDto.builder()
				.userId(messageToSendDto.getUserId())
				.message("Вы сказали: ".concat(messageToSendDto.getMessage()))
				.groupId(messageToSendDto.getGroupId())
				.build();
		senderService.send(dto);
	}

	private MessageToSendDto parseMessageToSend(CallbackDto callbackDto) {
		Map<String, Object> map = callbackDto.getObject();
		return MessageToSendDto.builder()
				.userId(Integer.parseInt(String.valueOf(((Map<String, Object>) map.get("message")).get("from_id"))))
				.message(String.valueOf(((Map<String, Object>) map.get("message")).get("text")))
				.groupId(callbackDto.getGroupId())
				.build();
	}
}
