package com.sunglowsys.service;

import com.sunglowsys.domain.HotelRoomType;
import com.sunglowsys.repository.HotelRoomTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class HotelRoomTypeServiceImpl implements HotelRoomTypeService{

    private final Logger log = LoggerFactory.getLogger(HotelRoomType.class);

    private final HotelRoomTypeRepository hotelRoomTypeRepository;

    public HotelRoomTypeServiceImpl(HotelRoomTypeRepository hotelRoomTypeRepository) {
        this.hotelRoomTypeRepository = hotelRoomTypeRepository;
    }


    @Override
    public HotelRoomType save(HotelRoomType hotelRoomType) {
        log.debug("Request to save HotelRoomType: {}",hotelRoomType);
        return hotelRoomTypeRepository.save(hotelRoomType);
    }

    @Override
    public HotelRoomType update(HotelRoomType hotelRoomType, Long id) {
        log.debug("Request to update HotelRoomType: {}",hotelRoomType);
        return hotelRoomTypeRepository.save(hotelRoomType);
    }

    @Override
    public Page<HotelRoomType> findAll(Pageable pageable) {
        log.debug("Request to findAll HotelRoomType:", pageable.toString());
        return hotelRoomTypeRepository.findAll(pageable);
    }

    @Override
    public Optional<HotelRoomType> findById(Long id) {
        log.debug("Request to findById HotelRoomType: {}",id);
        return hotelRoomTypeRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to findById HotelRoomType: {}",id);
        hotelRoomTypeRepository.deleteById(id);
        


    }

}
