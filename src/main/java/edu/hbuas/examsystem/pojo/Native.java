package edu.hbuas.examsystem.pojo;

import java.io.Serializable;

public class Native implements Serializable {
    private String card;

    private String place;

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card == null ? null : card.trim();
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }
}