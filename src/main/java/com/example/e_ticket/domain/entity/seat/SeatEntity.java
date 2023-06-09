package com.example.e_ticket.domain.entity.seat;

import com.example.e_ticket.domain.entity.BaseEntity;
import com.example.e_ticket.domain.entity.carriage.TrainCarriageEntity;
import com.example.e_ticket.domain.entity.ticket.TicketEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "seats")
public class SeatEntity extends BaseEntity {
    @Column(name = "seat_number")
    private int seatNumber;

    @OneToMany(mappedBy = "seats")
    private List<TicketEntity> tickets;

    @ManyToOne
    @JoinColumn(name = "carriage_id")
    private TrainCarriageEntity carriages;

    public SeatEntity(int seatNumber, TrainCarriageEntity carriages){
        this.seatNumber = seatNumber;
        this.carriages = carriages;
    }

}
