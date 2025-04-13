package ru.donni.vkbot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * Configuration properties for VK API
 */
@Component
@Getter
@Setter
@PropertySource(value = "classpath:vk.properties")
@ConfigurationProperties(prefix = "vk.api")
public class VkApiProperties {
	@NotBlank
	private String accessToken;
	@NotBlank
	private Double v;
	@NotBlank
	private String secret;
	@NotBlank
	private String confirmation;
}
