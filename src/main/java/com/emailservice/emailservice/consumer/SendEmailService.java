package com.emailservice.emailservice.consumer;

import com.emailservice.emailservice.DTOs.SendEmailDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SendEmailService {
    @Autowired
    ObjectMapper objectMapper;

    @KafkaListener(id = "EmailHandlerConsumerGroup",
    topics = {"SendEmail"})
    public void handleSendEmail(String sendEmailDto){
        System.out.println("Send Welcome Email");
        try {
            objectMapper.readValue(sendEmailDto, SendEmailDto.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }
}
