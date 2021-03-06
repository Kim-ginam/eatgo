package com.example.eatgo.interfaces;

import com.example.eatgo.application.RestaurantService;
import com.example.eatgo.domain.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@CrossOrigin
@RestController
public class RestaurantController {


    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<Restaurant> list(){

        List<Restaurant> restaurants = restaurantService.getRestaurants();
        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id){


        Restaurant restaurant = restaurantService.getRestaurant(id);
        // 기본 정보 + 메뉴 정보

//        Restaurant restaurant = restaurantRepository.findById(id);
//
//        List<MenuItem> menuItems = menuItemRepository.findAllByRestaurantId(id);
//        restaurant.setMenuItem(menuItems);

        return restaurant;
    }

    @PostMapping("/restaurants")
    public ResponseEntity<?> create(@RequestBody Restaurant resource) throws URISyntaxException {
        Restaurant restaurant = restaurantService.addRestaurant(Restaurant.builder()
                .name(resource.getName())
                .address(resource.getAddress())
                .build());



        URI location = new URI("/restaurants/" + restaurant.getId());
        return ResponseEntity.created(location).body("{}");
    }

    @PatchMapping("/restaurants/{id}")
    public String update(@PathVariable("id") Long id,
        @RequestBody Restaurant restaurant){
        String name = "JOKER Bar";
        String address = "Busan";
        restaurantService.updateRestaurant(id, name, address);
    return "{}";
    }

}
