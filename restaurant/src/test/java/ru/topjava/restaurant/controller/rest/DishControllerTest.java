package ru.topjava.restaurant.controller.rest;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

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


