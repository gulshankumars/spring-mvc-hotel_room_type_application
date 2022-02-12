package com.sunglowsys.service;

import com.sunglowsys.domain.HotelRoomType;
import com.sunglowsys.repository.HotelRoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelRoomTypeServiceImpl implements HotelRoomTypeService{

    @Autowired
    private HotelRoomTypeRepository hotelRoomTypeRepository;


    @Override
    public HotelRoomType create(HotelRoomType hotelRoomType) {
        return hotelRoomTypeRepository.save(hotelRoomType);
    }

    @Override
    public HotelRoomType update(HotelRoomType hotelRoomType, Integer id) {
        HotelRoomType hotelRoomType1 = hotelRoomTypeRepository.findById(id).get();
        hotelRoomType1.setHotelId(hotelRoomType1.getHotelId());
        hotelRoomType1.setRoomTypeId(hotelRoomType1.getRoomTypeId());
        return hotelRoomTypeRepository.save(hotelRoomType);
    }

    @Override
    public List<HotelRoomType> findAll() {
        return hotelRoomTypeRepository.findAll();
    }

    @Override
    public HotelRoomType findById(Integer id) {
        Optional<HotelRoomType> optional = hotelRoomTypeRepository.findById(id);
        HotelRoomType hotelRoomType = null;
        if (optional.isPresent()){
            hotelRoomType = optional.get();
        }
        else {
            throw new RuntimeException("Hotel_Room_Type not found for id:" +id);
        }
        return hotelRoomType;
    }

    @Override
    public void delete(Integer id) {
        hotelRoomTypeRepository.deleteById(id);
    }
}
