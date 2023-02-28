package com.tripMaster.TripPricer.controller;

import com.tripMaster.TripPricer.service.TripPricerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(TripPricerController.class)
public class TripPricerControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private TripPricerService tripPricerService;

    @Test
    public void testGetPrice() throws Exception {
        mockMvc.perform(get("/getPrice/" + UUID.randomUUID() + "/" + UUID.randomUUID() +
                "/" + 2 + "/" + 3 + "/" + 4 + "/" + 0))
                .andExpect(status().isOk());
    }
}
