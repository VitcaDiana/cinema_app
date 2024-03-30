package com.springapps.cinema.C_repository;

import com.springapps.cinema.D_model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findAllByProjection_Id(Long projectionId);

    Optional<Ticket> findByProjection_IdAndSeat_Id(Long projectionId, Long seatId);


}
