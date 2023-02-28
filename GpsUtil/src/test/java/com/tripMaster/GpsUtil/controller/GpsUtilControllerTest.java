package com.tripMaster.GpsUtil.controller;

import com.tripMaster.GpsUtil.service.GpsUtilService;
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
@WebMvcTest(GpsUtilController.class)
public class GpsUtilControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private GpsUtilService gpsUtilService;

    @Test
    public void testGetUserLocation() throws Exception {
        mockMvc.perform(get("/userLocation/" + UUID.randomUUID()))
                .andExpect(status().isOk());
    }
    @Test
    public void testGetAttractions() throws Exception {
        mockMvc.perform(get("/attractions"))
                .andExpect(status().isOk());
    }
}
