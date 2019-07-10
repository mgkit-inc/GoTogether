package com.gotogether.controllers;

import com.gotogether.entity.Theme;
import com.gotogether.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/themes")
public class ThemeController {

    private final ThemeService themeService;

    @Autowired
    public ThemeController(ThemeService themeService) {
        this.themeService = themeService;
    }

    @RequestMapping
    public Iterable<Theme> getAll() {
        return themeService.getAll();
    }

    @RequestMapping(value = "/{id}")
    public Theme getOne(@PathVariable long id) {
        return themeService.getOne(id).orElse(null);
    }

    @RequestMapping(method = RequestMethod.POST)
    public List<Theme> add(@RequestBody List<Theme> themes) {
        return themeService.add(themes);
    }

}
