package com.smartms.AppNotification.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Contact {
    private String Name;
    private String number;


}
