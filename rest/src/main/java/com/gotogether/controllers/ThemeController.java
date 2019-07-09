package com.gotogether.controllers;

import com.gotogether.entity.Theme;
import com.gotogether.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/themes")
public class ThemeController {

    private final ThemeService themeService;

    @Autowired
    public ThemeController(ThemeService themeService) {
        this.themeService = themeService;
    }

    @RequestMapping
    private Iterable<Theme> getAll() {
        return themeService.getAll();
    }

    @RequestMapping(value = "/{id}")
    private Theme getOne(@PathVariable long id) {
        return themeService.getOne(id).orElse(null);
    }

}
