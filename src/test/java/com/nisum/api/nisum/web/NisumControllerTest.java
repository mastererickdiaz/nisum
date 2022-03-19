package com.nisum.api.nisum.web;

import static com.nisum.api.util.TestUtil.jsonStringToObject;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nisum.api.nisum.service.IUserService;
import com.nisum.api.nisum.web.request.UserRequest;
import com.nisum.api.nisum.web.response.UserResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(NisumController.class)
public class NisumControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    IUserService service;

    UserRequest request;
    UserResponse response;

    @BeforeEach
    public void setUp() throws Exception {
        request = jsonStringToObject("controller/request.json", UserRequest.class);
        response = jsonStringToObject("controller/response.json", UserResponse.class);
    }

    @Test
    public void test_post_valid_success_registerUser() throws Exception {
        given(service.registerUser(any(UserRequest.class))).willReturn(response);
        mockMvc.perform(post("/register").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))).andDo(print())
                .andExpect(status().isOk()).andExpect(jsonPath("$.id", is(1)));

        verify(service, times(1)).registerUser(any(UserRequest.class));
    }

}
