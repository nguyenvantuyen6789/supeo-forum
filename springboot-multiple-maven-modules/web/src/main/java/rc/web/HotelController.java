package rc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import rc.domain.Hotel;
import rc.persistence.HotelRepository;

import java.util.List;

@RestController
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping("/hotels")
    public List<Hotel> getHotels() {
        List<Hotel> hotels = hotelRepository.findAll();

        return hotels;
    }
}
