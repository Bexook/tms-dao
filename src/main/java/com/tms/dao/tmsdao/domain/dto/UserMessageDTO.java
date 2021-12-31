package com.tms.dao.tmsdao.domain.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserMessageDTO {

    private Long id;

    private Long senderId;

    private Long receiverId;

    private LocalDateTime sendingTime;

    private Boolean isRead;

    private LocalDateTime readTime;

    private Boolean delete;

}
