package ru.topjava.restaurant.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.topjava.restaurant.model.Dish;
import ru.topjava.restaurant.repository.DishRepository;
import ru.topjava.restaurant.service.DishService;

import java.util.Date;
import java.util.List;

//@RestController
@Controller
//@RequestMapping(value = "restaurant/dish/api/v1")
@RequestMapping(value = "restaurant")
public class DishController {

    @Autowired
    private DishService dishService;

    @Autowired
    private DishRepository dishRepository;

    @GetMapping(value = "/dishes")
    public List<Dish> dishes() {
        return dishService.getAll();
    } // лист

    //@GetMapping(value = "/dish/add") //создание
    @GetMapping(value = "/dish/add") //создание
    public String dishAdd(Model model) {
        model.addAttribute("dish", new Dish());
        return "dishAddForm";
        //return "test";
    }

    @PostMapping("/dish/add")
    public String dishSubmit(@ModelAttribute Dish dish) {
        dishRepository.save(dish);
        //dishService.create(dish);
        return "redirect:/restaurant/dish/add"; // переход на форму ввода блюд

    }



/*    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE) //создание
    public void create(@RequestBody Dish dish) {
        dishService.create(dish);
    }*/

    @GetMapping("/{id}")
    public Dish get(@PathVariable("id") long id) {
        return dishService.getById(id);
    } // поиск по id

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE) //обновление
    public void update(@PathVariable("id") long id, @RequestBody Dish dish) {
        dishService.update(dish, id);
    }

    @GetMapping(value = "/")
    public List<Dish> dishList() {
        Dish dish = new Dish("картошка", 3.0);
        dishService.create(dish);
        Dish dish2 = new Dish("картошка2", 32.0);
        dishService.create(dish2);
        return dishService.getAll();
    }

    @DeleteMapping("/{id}") // удаление
    public void delete(@PathVariable("id") long id) {
        dishService.delete(id);
    }

}



