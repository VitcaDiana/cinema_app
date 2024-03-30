package com.springapps.cinema.E_DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;


import java.util.List;

public class OrderRequestDTO {

    private Long projectionId;

    private Long userId;

    @JsonProperty("seats")
    private List<TicketRequestDTO> ticketRequestDTOs;

    public OrderRequestDTO(Long projectionId, List<TicketRequestDTO> ticketRequestDTOs, Long userId) {
        this.projectionId = projectionId;
        this.ticketRequestDTOs = ticketRequestDTOs;
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProjectionId() {
        return projectionId;
    }

    public void setProjectionId(Long projectionId) {
        this.projectionId = projectionId;
    }

    public List<TicketRequestDTO> getTicketRequestDTOs() {
        return ticketRequestDTOs;
    }

    public void setTicketRequestDTOs(List<TicketRequestDTO> ticketRequestDTOs) {
        this.ticketRequestDTOs = ticketRequestDTOs;
    }
}
