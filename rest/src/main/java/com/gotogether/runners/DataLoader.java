package com.gotogether.runners;

import com.gotogether.entity.Theme;
import com.gotogether.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    private final ThemeService themeService;

    @Autowired
    public DataLoader(ThemeService themeService) {
        this.themeService = themeService;
    }

    @Override
    public void run(ApplicationArguments args) {
        themeService.add(
                List.of(
                        new Theme("Кино"),
                        new Theme("Концерт"),
                        new Theme("Клуб"),
                        new Theme("Спорт"),
                        new Theme("Просмотр порно")
                )
        );
    }
}
