package com.sunglowsys.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class HotelRoomType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id ;
    private Integer hotelId ;
    private Integer roomTypeId ;

    public HotelRoomType(){
        System.out.println("RatePlan object is creted:");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
