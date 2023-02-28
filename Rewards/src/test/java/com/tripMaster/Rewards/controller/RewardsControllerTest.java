package com.tripMaster.Rewards.controller;

import com.tripMaster.Rewards.service.RewardsService;
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

@WebMvcTest(RewardsController.class)
@ExtendWith(SpringExtension.class)
public class RewardsControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private RewardsService rewardsService;

    @Test
    public void testGetAttractionRewardPoints() throws Exception {
        mockMvc.perform(get("/getAttractionRewardPoints/" + UUID.randomUUID() + "/" + UUID.randomUUID()))
                .andExpect(status().isOk());
    }
}
