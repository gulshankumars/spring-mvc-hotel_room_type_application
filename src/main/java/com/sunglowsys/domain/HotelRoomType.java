package com.sunglowsys.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class HotelRoomType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(nullable = false)
    private Integer hotelId;

    @Column(nullable = true)
    private Integer roomTypeId;


    public HotelRoomType() {
        System.out.println("RatePlan object is created:");
    }

    public HotelRoomType(Integer hotelId, Integer roomTypeId) {
        this.hotelId = hotelId;
        this.roomTypeId = roomTypeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Integer roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelRoomType that = (HotelRoomType) o;
        return Objects.equals(id, that.id) && Objects.equals(hotelId, that.hotelId) && Objects.equals(roomTypeId, that.roomTypeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hotelId, roomTypeId);
    }

    @Override
    public String toString() {
        return "HotelRoomType{" +
                "id=" + id +
                ", hotelId=" + hotelId +
                ", roomTypeId=" + roomTypeId +
                '}';
    }
}
