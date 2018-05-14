package ru.topjava.restaurant.controller.rest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import ru.topjava.restaurant.model.Dish;
import ru.topjava.restaurant.repository.DishRepository;
import ru.topjava.restaurant.service.DishService;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

//@WebAppConfiguration
//@RunWith(SpringJUnit4ClassRunner.class)

//@RunWith(SpringRunner.class)
//@WebMvcTest(RestDishController.class)
//@AutoConfigureMockMvc(secure = false)
//@WebAppConfiguration
//@RunWith(SpringJUnit4ClassRunner.class)
//@Transactional
//@RunWith(SpringRunner.class)
//@SpringBootTest
/*
@RunWith(SpringRunner.class)
@WebMvcTest(RestDishController.class)
@AutoConfigureMockMvc
public class DishControllerTest {

    //static final String REST_URL = "/rest/admin/users";
    private static final String REST_URL = "/restaurant/rest/admin/api/v1/dishes";

    private static final CharacterEncodingFilter CHARACTER_ENCODING_FILTER = new CharacterEncodingFilter();

    static {
        CHARACTER_ENCODING_FILTER.setEncoding("UTF-8");
        CHARACTER_ENCODING_FILTER.setForceEncoding(true);
    }

    // protected MockMvc mockMvc;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @PostConstruct
    private void postConstruct() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .addFilter(CHARACTER_ENCODING_FILTER)
                .build();
    }

    @MockBean
    private DishRepository dishRepository;

    @MockBean
    private DishService dishService;

*/
/*    @Test
    public void testGet() throws Exception {
        Dish dish = new Dish("Dish1", 100.0);
        Dish dish2 = new Dish("Dish2", 200.0);
        List<Dish> dishList = Arrays.asList(dish, dish2);
        doReturn(dishList).when(dishRepository).findAll();
        mockMvc.perform(get("/restaurant/rest/admin/api/v1/dishes"))
                .andExpect(status().isOk())
                .andDo(print());
        verify(dishRepository).findAll();
    }*//*

}
*/


