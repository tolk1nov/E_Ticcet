package com.example.e_ticket.domain.dto.response;

import com.example.e_ticket.domain.entity.seat.SeatEntity;
import com.example.e_ticket.domain.enums.CityName;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TicketGetResponse {
    private SeatEntity seats;
    private CityName cityFrom;
    private CityName cityTo;
    private Double travelPrice;
    private String travelDuration;
    private LocalDateTime dateBegin;
    private LocalDateTime dateEnd;
}
