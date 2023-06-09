package com.example.e_ticket.domain.entity.ticket;

import com.example.e_ticket.domain.entity.BaseEntity;
import com.example.e_ticket.domain.entity.seat.SeatEntity;
import com.example.e_ticket.domain.entity.user.UserEntity;
import com.example.e_ticket.domain.enums.CityName;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "tickets")
public class TicketEntity extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity users;

    @ManyToOne
    @JoinColumn(name = "seat_id")
    private SeatEntity seats;

    @Column(name = "travel_price")
    private Double travelPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "city_from")
    private CityName cityFrom;
    @Column(name = "city_from_number")
    private int cityFromNumber;
    @Enumerated(EnumType.STRING)
    @Column(name = "city_to")
    private CityName cityTo;
    @Column(name = "city_to_number")
    private int cityToNumber;
    @Column(name = "travel_duration")
    private String travelDuration;
    @Column(name = "date_begin")
    private LocalDateTime dateBegin;
    //for dateBegin : currentDate merge travel.begin.time
    @Column(name = "date_end")
    private LocalDateTime dateEnd;
    //for dateEnd : currentDatetime + (travel.end.datetime - travel.begin.datetime)
}
