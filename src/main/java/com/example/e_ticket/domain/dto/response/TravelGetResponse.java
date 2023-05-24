package com.example.e_ticket.domain.dto.response;

import com.example.e_ticket.domain.entity.railwayFlight.RailwayFlightEntity;
import com.example.e_ticket.domain.enums.CityName;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TravelGetResponse {
    private UUID id;
    private LocalDateTime created;
    private LocalDateTime updated;
    private boolean isDeleted;
    private CityName cityFrom;
    private CityName cityTo;
    private int cityToNumber;
    private int cityFromNumber;
    private Double plascardPrice;
    private Double kupePrice;
    private Double vipPrice;
    private int plascardSeatAmount;
    private int kupeSeatAmount;
    private int vipSeatAmount;
    private String timeDuration;
    private LocalDateTime dateBegin;
    private LocalDateTime dateEnd;
    private RailwayFlightEntity railways;
}
