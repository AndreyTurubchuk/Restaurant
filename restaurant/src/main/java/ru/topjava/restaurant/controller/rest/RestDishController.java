package ru.topjava.restaurant.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.topjava.restaurant.model.Dish;
import ru.topjava.restaurant.repository.DishRepository;

import java.util.List;

@RestController
//@RequestMapping(value = "restaurant/dish/api/v1")
@RequestMapping(value = "/restaurant/rest/admin/dishes/api/v1")
public class RestDishController {

    @Autowired
    private DishRepository dishRepository;



/*    @GetMapping("/dishes")
    public List<Dish> dishes() {
        return dishRepository.findAll();
    }

    @PostMapping("/dishes")
    public Dish dishSubmit(@ModelAttribute Dish dish) {
        dishRepository.save(dish);
        return dish;
    }

    @GetMapping("/dishes/{id}")
    public Dish get(@PathVariable("id") long id) {
        return dishRepository.findByDishId(id);
    } // поиск по id

    @PutMapping(value = "/dishes/{id}") //обновление
    public Dish update(@PathVariable long id, @RequestBody Dish dish) {
        //Dish dish = dishRepository.getOne(id);
        //dish.setName(dishDetails.getName());
        //dish.setPrice(dishDetails.getPrice());
        dishRepository.save(dish);
        return dish;
    }*/

   /* @PutMapping(value = "/{id}") //обновление
    public Dish update(@PathVariable long id, @RequestBody Dish dishDetails) {
        Dish dish = dishRepository.getOne(id);
        dish.setName(dishDetails.getName());
        dish.setPrice(dishDetails.getPrice());
        dishRepository.save(dish);
        return dish;
    }*/

}
