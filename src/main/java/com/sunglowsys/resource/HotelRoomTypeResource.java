package com.sunglowsys.resource;

import com.sunglowsys.domain.HotelRoomType;
import com.sunglowsys.service.HotelRoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HotelRoomTypeResource {

    @Autowired
    private HotelRoomTypeService hotelRoomTypeService;

    @PostMapping("/hotel_room_type")
    public ResponseEntity<?> create(@RequestBody HotelRoomType hotelRoomType){
        HotelRoomType result = hotelRoomTypeService.create(hotelRoomType);
        return ResponseEntity.ok().body(" HotelRoomType is created successfully: " + result);
    }

    @GetMapping
    public List<HotelRoomType> getAll(){
        List<HotelRoomType> result1 = hotelRoomTypeService.findAll();
        return result1;
    }

    @GetMapping("find_hotel_room_type/{id}")
    public HotelRoomType getById(@PathVariable("id") Integer id){
        return hotelRoomTypeService.findById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody HotelRoomType hotelRoomType, @PathVariable("id") Integer id){
        hotelRoomTypeService.update(hotelRoomType, id);
        return ResponseEntity.ok().body(" HotelRoomType is updated successfully: " + id);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        hotelRoomTypeService.delete(id);
        return ResponseEntity.ok().body(" HotelRoomType is successfully Deleted on this ID: " + id);
    }
}
