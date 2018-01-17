package ru.topjava.restaurant.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.topjava.restaurant.model.Dish;
import ru.topjava.restaurant.service.DishService;

import java.util.List;


@RestController
//@RequestMapping(value = "/")
public class AppController {

    @Autowired
    private DishService dishService;

    @RequestMapping({"/"})
    public List<Dish> dishList() {
        Dish dish = new Dish("картошка", 3.0);
        dishService.saveDish(dish);
        Dish dish2 = new Dish("картошка2", 32.0);
        dishService.saveDish(dish2);
        return dishService.getAll();
    }

  /*  @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable long id) {
        personService.delete(id);
        return "redirect:/person/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return "personAdd";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Person person) {
       personService.savePerson(person);
        return "redirect:/person/list";
 }

    @ExceptionHandler(MailException.class)
    public String err(Model model, Exception ex){
        model.addAttribute("texterror", ex.getMessage());
        return "error";
    }

    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public String view(@PathVariable Long id, Model model) {
        Person person = personService.getOne(id);
        List<Letter> letterList = letterService.findByTo(person.getEmailAddress());
        model.addAttribute("personLetterList", letterList);
        model.addAttribute("personFullName", person.getFirstName() + " " + person.getLastName());
        return "personLetterList";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Long id, Model model) {
        Person person = personService.getOne(id);
        model.addAttribute("person", person);
        return "personEdit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String edit(@PathVariable Long id, Person personDetails) {
        personService.editPerson(id, personDetails);
        return "redirect:/person/list";
    }

    @RequestMapping(value = "/")
    public String main() {
        return "personList";
    }*/
}



