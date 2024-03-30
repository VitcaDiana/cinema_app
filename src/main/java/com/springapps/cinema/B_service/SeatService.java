package com.springapps.cinema.B_service;

import com.springapps.cinema.C_repository.ProjectionRepository;
import com.springapps.cinema.C_repository.SeatRepository;
import com.springapps.cinema.C_repository.TicketRepository;
import com.springapps.cinema.D_model.CinemaRoom;
import com.springapps.cinema.D_model.Projection;
import com.springapps.cinema.D_model.Seat;
import com.springapps.cinema.D_model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeatService {
    private SeatRepository seatRepository;

    private ProjectionRepository projectionRepository;

    private TicketRepository ticketRepository;

    @Autowired
    public SeatService(SeatRepository seatRepository, ProjectionRepository projectionRepository, TicketRepository ticketRepository) {
        this.seatRepository = seatRepository;
        this.projectionRepository = projectionRepository;
        this.ticketRepository = ticketRepository;
    }


    @Transactional
    public List<Seat> getAvailableSeats (Long projectionId) {

        //gasim toate seat-urile care nu au tickete pentru proiectia cu id-ul projectionId

        //gasim toate ticketele proiectiei
        //deci stim care sunt toate seat-urile ocupate
        //gasim toate seat-urile si le filtram

        /*
        Projection projection = projectionRepository.findById(projectionId).orElseThrow(() -> new RuntimeException("cinema room not found"));


        List<Ticket> projectionTickets = ticketRepository.findAllByProjection_Id(projectionId);

        List<Seat> occupiedSeats = projectionTickets.stream()
                .map(ticket -> ticket.getSeat())
                .collect(Collectors.toList());

        List<Seat> allSeats = seatRepository.findAllByCinemaRoom(projection.getCinemaRoom());

        return allSeats.stream()
                .filter(seat -> !occupiedSeats.contains(seat))
                .collect(Collectors.toList());
                */

        return seatRepository.findAvailableSeatsBy(projectionId);
        //

    }

    public boolean isSeatAvailable (Long projectionId, Long seatId){
        return ticketRepository.findByProjection_IdAndSeat_Id(projectionId, seatId).isEmpty();
    }
}
