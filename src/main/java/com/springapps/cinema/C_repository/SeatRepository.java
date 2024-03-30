package com.springapps.cinema.C_repository;

import com.springapps.cinema.D_model.CinemaRoom;
import com.springapps.cinema.D_model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

    public List<Seat> findAllByCinemaRoom(CinemaRoom cinemaRoom);

    @Query("SELECT s FROM Seat s WHERE s NOT IN (SELECT t.seat FROM Ticket t WHERE t.projection.id = :projectionId)")
    List<Seat> findAvailableSeatsBy(@Param("projectionId") Long projectionId);


    public Optional<Seat> findSeatBySeatRowAndSeatColumnAndCinemaRoom_Id(Integer row, Integer col, Long cinemaRoomId);
}
