package com.nisum.api.nisum.service;

import static com.nisum.api.util.TestUtil.jsonStringToObject;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import com.nisum.api.nisum.exception.BusinessException;
import com.nisum.api.nisum.service.impl.UserService;
import com.nisum.api.nisum.web.request.UserRequest;
import com.nisum.api.nisum.web.response.UserResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringNisumServiceTest {

    @Autowired
    private UserService service;

    @Mock
    private UserRequest request;

    @BeforeEach
    void setMockOutput() throws IOException {
        request = jsonStringToObject("service/request.json", UserRequest.class);
    }

    @Test
    public void test1() throws BusinessException {
        UserResponse obj = service.registerUser(request);
        assertEquals(obj.getIsActive(), "SI");
    }


}
