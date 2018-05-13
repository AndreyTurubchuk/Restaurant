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
    public String dishList(Model model) {
        model.addAttribute("dishList", dishRepository.findAll());
        return "dishAll";
    }

    @GetMapping(value = "/dishesList")
    public List<Dish> dishes() {
        return dishRepository.findAll();
    } // лист

    @GetMapping(value = "/dish/create") //создание
    public String dishCreate(Model model) {
        model.addAttribute("dish", new Dish());
        return "dishForm";
    }

    @GetMapping(value = "/dishes/{id}") //редактирование
    public String dishEdit(Model model, @PathVariable long id) {
        model.addAttribute("dish", dishRepository.getOne(id));
        return "dishForm";
    }

    @PostMapping("/dishes/save") //post для create, update
    public String dishSaveSubmit(@ModelAttribute Dish dish) {
        dishRepository.save(dish);
        return "redirect:/restaurant/dishes";
    }

    @DeleteMapping(value = "/dishes/{id}") // удаление
    public String delete(@PathVariable("id") long id) {
        dishRepository.delete(id);
        return "restaurant/dishes";
    }

    @GetMapping("/{id}")
    public Dish get(@PathVariable("id") long id) {
        return dishService.getById(id);
    } // поиск по id

}



