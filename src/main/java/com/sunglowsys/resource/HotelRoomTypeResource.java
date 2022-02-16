package com.sunglowsys.resource;

import com.sunglowsys.domain.HotelRoomType;
import com.sunglowsys.resource.util.BadRequestException;
import com.sunglowsys.service.HotelRoomTypeService;
import com.sunglowsys.service.HotelRoomTypeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class HotelRoomTypeResource {

    private final Logger log =  LoggerFactory.getLogger(HotelRoomTypeServiceImpl.class);

    private final HotelRoomTypeService hotelRoomTypeService;

    public HotelRoomTypeResource(HotelRoomTypeService hotelRoomTypeService) {
        this.hotelRoomTypeService = hotelRoomTypeService;
    }

    @PostMapping("/hotel-Room-Types")
    public ResponseEntity<HotelRoomType> createRoomType(@RequestBody HotelRoomType hotelRoomType) throws URISyntaxException {
        log.debug("REST request to save HotelRoomType : {}", hotelRoomType);
        if (hotelRoomType.getId() != null){
            throw  new BadRequestException("Id should be null in created api call");
        }
        HotelRoomType result = hotelRoomTypeService.save(hotelRoomType);
        return ResponseEntity
                .ok().
                body(result);
    }

    @GetMapping("/hotel-Room-Types")
    public  ResponseEntity<List<HotelRoomType>> getAllRoomType(@RequestBody Pageable pageable){
        log.debug("REST request to getAll hotelRoomTypes : {}",pageable.toString());
        Page<HotelRoomType> result = hotelRoomTypeService.findAll(pageable);
        return ResponseEntity.ok().body(result.getContent());
    }

    @GetMapping("/hotel-Room-Type{id}")
    public ResponseEntity<Optional<HotelRoomType>> getRoomType(@PathVariable("id") Long id){
        log.debug("REST request to get HotelRoomType : {}",id);
        Optional<HotelRoomType> result = hotelRoomTypeService.findById(id);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @PutMapping("/hotel-Room-Type/{id}")
    public ResponseEntity<HotelRoomType> updateRoomType(@RequestBody HotelRoomType hotelRoomType, @PathVariable("id") Long id) throws URISyntaxException{
        log.debug("REST request to updateHotelRoomType : {}", id);
        if (hotelRoomType.getId() == null){
            throw new BadRequestException("Id should not be null in update api call");
        }
        HotelRoomType result = hotelRoomTypeService.update(hotelRoomType,id);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @DeleteMapping("hotel-Room-Type/{id}")
    public ResponseEntity<HotelRoomType> deleteRoomType(@PathVariable("id") Long id){
        log.debug("REST request to deleteRoomType : {}",id);
        hotelRoomTypeService.delete(id);
        return ResponseEntity
                .ok()
                .build();
    }
}
