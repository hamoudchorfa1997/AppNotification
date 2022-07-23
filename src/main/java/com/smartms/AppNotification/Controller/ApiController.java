package com.smartms.AppNotification.Controller;

import com.smartms.AppNotification.Model.Contact;
import com.smartms.AppNotification.Model.Message;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


@RequestMapping("/AppNotification")
public class ApiController {

	@PostMapping("/send")
	public void sendMessage(Message msg){
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Authorization", "Bearer EAAKV62RxupMBAMVqjtzZCdrzg6EmaoptG0cFhdvNBuNUOPpCQmCKWcivNWbbN0cWjwMBYKM0TSEk7QoHy9aQ0zPyw9ZBZAUzAbsBR0Xfa1PwVSOAgnoqLENdIgpLXNPiGouKb20XSke8QfuM46bHwmxPIralHC7AHhTFvZBZAU8NZBX7kz8o0pjAVN1NarzCeROoyYF4hQ0QZDZD");
		Map<String, Object> body = new HashMap<>();
		body.put("messaging_product", "whatsapp");
		body.put("to", msg.getDestinationContatct().getNumber());
		body.put("type", "template");
		Map<String, Object> template = new HashMap<>();
		template.put("name", msg.getMessage());
		Map<String, Object> language = new HashMap<>();
		language.put("code", "en_US");
		template.put("language", language);
		body.put("template", template);
		HttpEntity httpEntity = new HttpEntity(body, httpHeaders);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange("https://graph.facebook.com/v13.0/102037062588316/messages", HttpMethod.POST, httpEntity, String.class);
		System.out.println(response.getStatusCode());
	}

}

