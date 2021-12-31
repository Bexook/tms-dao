package com.tms.dao.tmsdao.domain.dto;


import com.tms.dao.tmsdao.domain.BaseEntity;
import com.tms.dao.tmsdao.domain.UserEntity;
import com.tms.dao.tmsdao.domain.enumTypes.CalendarDayType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
public class TimeLogDTO extends BaseEntity {

    private LocalDate date;
    private Double timeSpend;
    private CalendarDayType calendarDayType;
    private UserEntity userEntity;

}
