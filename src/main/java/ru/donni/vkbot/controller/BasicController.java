package ru.donni.vkbot.controller;

import lombok.RequiredArgsConstructor;
import ru.donni.vkbot.dto.CallbackDto;
import ru.donni.vkbot.service.CallbackInterface;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller that works with VK API requests
 */
@Controller
@RequestMapping(value = "/vkbot",  method=RequestMethod.POST)
@RequiredArgsConstructor
public class BasicController {
	private final CallbackInterface callbackInterface;
	
	@PostMapping
    @ResponseBody
    public ResponseEntity<String> handleCallback(@RequestBody CallbackDto callbackDto) {
        return new ResponseEntity<>(callbackInterface.handleCallback(callbackDto), HttpStatus.OK);
    }
}
