package ru.topjava.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.topjava.restaurant.repository.RestaurantComplexRepository;

@Controller
@RequestMapping(value = "restaurant")
public class RestaurantComplexController {

    @Autowired
    RestaurantComplexRepository restaurantComplexRepository;

    @GetMapping(value = "/complexes")
    public String complexList(Model model) {
        model.addAttribute("complexList", restaurantComplexRepository.findAll());
        return "complexAll";
    }

    @GetMapping(value = "/complex/{id}") //редактирование
    public String complexEdit(Model model, @PathVariable long id) {
        model.addAttribute("complex", restaurantComplexRepository.getOne(id));
        return "complexForm";
    }
}
