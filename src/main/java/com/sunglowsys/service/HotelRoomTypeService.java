package com.sunglowsys.service;

import com.sunglowsys.domain.HotelRoomType;

import java.util.List;

public interface HotelRoomTypeService {


    HotelRoomType create(HotelRoomType hotelRoomType);

    HotelRoomType update(HotelRoomType hotelRoomType, Integer id);

    List<HotelRoomType> findAll();

    HotelRoomType findById(Integer id);

    void delete(Integer id);
}
