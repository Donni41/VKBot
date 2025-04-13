package ru.donni.vkbot.service;

import ru.donni.vkbot.dto.CallbackDto;


/**
 * Service that handles callback requests
 */
public interface CallbackInterface {
	String handleCallback(CallbackDto callbackDto);
}
