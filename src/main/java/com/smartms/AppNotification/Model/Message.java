package com.smartms.AppNotification.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
public class Message {
    private Contact DestinationContatct;
    //private Contact SenderMessage;
    private String message;
}
