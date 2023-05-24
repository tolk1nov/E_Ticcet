package com.example.e_ticket.domain.dto.request;

import com.example.e_ticket.domain.enums.CityName;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SearchingPostRequest {
    private CityName cityFrom;
    private CityName cityTo;
    private LocalDate localDate;
}
