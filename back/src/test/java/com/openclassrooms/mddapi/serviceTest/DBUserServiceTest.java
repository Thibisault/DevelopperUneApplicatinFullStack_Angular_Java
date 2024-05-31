/*
package com.openclassrooms.mddapi.serviceTest;

import com.openclassrooms.mddapi.dto.DBUserDTO;
import com.openclassrooms.mddapi.model.DBUser;
import com.openclassrooms.mddapi.services.DBUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DBUserServiceTest {

    @Autowired
    private DBUserService dbUserService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testCreateUser() {
        DBUserDTO dbUserDTO = new DBUserDTO();
        dbUserDTO.setId(1);
        dbUserDTO.setUsername("user");
        dbUserDTO.setPassword("user");
        dbUserDTO.setRole("USER");
        dbUserService.create(dbUserDTO);

        //System.out.println(dbUserService.readAll());

        System.out.println(dbUserService.readByUsername("user"));


    }
}
 */