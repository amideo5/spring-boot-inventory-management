package com.practice.practice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.practice.practice.Outbound_Data.DispatchItenary;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Orders {

    @Id
    private String trackId;
    private DispatchItenary dispatchItenary;

    public Orders() {
    }

    public Orders(DispatchItenary dispatchItenary) {
        this.dispatchItenary = dispatchItenary;
    }

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public DispatchItenary getDispatchItenary() {
        return dispatchItenary;
    }

    public void setDispatchItenary(DispatchItenary dispatchItenary) {
        this.dispatchItenary = dispatchItenary;
    }

}