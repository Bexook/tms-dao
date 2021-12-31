package com.tms.dao.tmsdao.domain;


import com.tms.dao.tmsdao.changeRequestDomain.entityMarker.ChangeRequestEntityMarker;
import com.tms.dao.tmsdao.domain.enumTypes.CalendarDayType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;


@NamedNativeQueries(value = {
        @NamedNativeQuery(name = "fetchByTimeSpan", query = "SELECT * FROM time_log WHERE date => :startDate AND date <= :endDate"),
        @NamedNativeQuery(name = "fetchByUserAndTimeSpan", query = "SELECT * FROM time_log WHERE date => :startDate AND date <= :endDate AND created_by = :createdBy")
})

@Data
@Entity
@Table(name = "time_log")
@EqualsAndHashCode(callSuper = true)
public class TimeLogEntity extends BaseEntity implements ChangeRequestEntityMarker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "time_spend")
    private Double timeSpend;

    @Column(name = "calendar_day_type")
    @Enumerated(value = EnumType.ORDINAL)
    private CalendarDayType calendarDayType;

    @Column(name = "created_by")
    private String createdBy;
}
