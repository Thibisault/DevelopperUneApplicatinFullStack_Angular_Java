/*
package com.openclassrooms.mddapi.serviceTest;

import com.openclassrooms.mddapi.dto.ThemeDto;
import com.openclassrooms.mddapi.services.ThemeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.plaf.synth.SynthTextAreaUI;

@SpringBootTest
public class ThemeServiceTest {


    @Autowired
    private ThemeService themeService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testCreateTheme() {
        ThemeDto themeDto = new ThemeDto();
        themeDto.setId(1);
        themeDto.setName("name");
        themeDto.setDescription("description");
        themeService.createTheme(themeDto);
        System.out.println(themeService.getThemeById(1));

        System.out.println(themeService.getAllThemes());
    }

    @Test
    public void getAllThemes() {
        System.out.println(themeService.getAllThemes());
    }

}
 */