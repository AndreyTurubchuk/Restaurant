package ru.topjava.restaurant.controller.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.topjava.restaurant.model.Dish;
import ru.topjava.restaurant.repository.DishRepository;
import ru.topjava.restaurant.service.DishService;

import java.util.List;

@RestController
//@RequestMapping(value = "restaurant/dish/api/v1")
@RequestMapping(value = "/restaurant/rest/admin/api/v1")
public class RestDishController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private DishService dishService;

    @GetMapping("/dishes")
    public List<Dish> dishes() {
        return dishRepository.findAll();
    }

    @GetMapping("/dishes/{id}")
    public Dish get(@PathVariable("id") long id) {
        return dishRepository.findByDishId(id);
    }

    @DeleteMapping(value = "/dishes/{id}") // удаление
    public void delete(@PathVariable("id") long id) {
        dishRepository.delete(id);
    }

    @PutMapping("/dishes/{id}")
    public void update (@RequestBody Dish dish, @PathVariable("id") long id) {
        dishRepository.save(dish);
    }


/*    @PutMapping("/dishes/save")
    public Dish update (@PathVariable("id") long id) {
        return dishRepository.findByDishId(id);
    }*/

/*    @PutMapping("/dishes/{id}")
    public void update (@RequestBody Dish dish, @PathVariable("id") long id) {
        log.info("update {} with id={}", dish, id);
        //  assureIdConsistent(dish, id);
        dishService.update(dish);
    }*/

    @PutMapping("/dishes/save")
    public void update (@RequestBody Dish dish) {
        log.info("update {}", dish);
        //  assureIdConsistent(dish, id);
        dishService.update(dish);
    }
/*    @Override
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody User user, @PathVariable("id") int id) {
        super.update(user, id);
    }*/


/*
    @PostMapping("/dishes")
    public Dish dishSubmit(@ModelAttribute Dish dish) {
        dishRepository.save(dish);
        return dish;
    }



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
