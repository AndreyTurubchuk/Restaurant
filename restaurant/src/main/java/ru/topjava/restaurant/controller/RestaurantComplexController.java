package ru.topjava.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.topjava.restaurant.model.Restaurant;
import ru.topjava.restaurant.model.RestaurantComplex;
import ru.topjava.restaurant.repository.RestaurantComplexRepository;
import ru.topjava.restaurant.repository.RestaurantRepository;

@Controller
@RequestMapping(value = "restaurant")
public class RestaurantComplexController {

    @Autowired
    RestaurantComplexRepository restaurantComplexRepository;

    @Autowired
    RestaurantRepository restaurantRepository;

    @GetMapping(value = "/complexes")
    public String complexList(Model model) {
        model.addAttribute("complexList", restaurantComplexRepository.findAll());
        return "complexAll";
    }

/*    @GetMapping(value = "/complex/{id}") //редактирование
    public String complexEdit(Model model, @PathVariable long id) {
        model.addAttribute("complex", restaurantComplexRepository.getOne(id));
        return "complexForm";
    }*/

    @GetMapping(value = "/complex/delete/{id}") // удаление
    public String delete(@PathVariable("id") long id) {
        restaurantComplexRepository.delete(id);
        return "redirect:/restaurant/restaurants";
    }

    @GetMapping(value = "/{restaurantId}/complex") // получение списка комплексов у ресторана по id ресторана
    public String complexAll(Model model, @PathVariable long restaurantId) {
        model.addAttribute("complexList", restaurantComplexRepository.findRestaurantComplexByRestaurantRestaurantId(restaurantId));
        model.addAttribute("restaurantId" , restaurantId);
        return "complexAll";
    }


    @GetMapping(value = "/{restaurantId}/complex/create") // создание комплекса у ресторана
    public String complexCreate(Model model, @PathVariable long restaurantId) {
        RestaurantComplex restaurantComplex = new RestaurantComplex();
        Restaurant restaurant = restaurantRepository.getOne(restaurantId);
        restaurantComplex.setRestaurant(restaurant);
        restaurantComplexRepository.save(restaurantComplex);
        model.addAttribute("complexList", restaurantComplexRepository.findRestaurantComplexByRestaurantRestaurantId(restaurantId));
        return "complexAll";
    }
}
