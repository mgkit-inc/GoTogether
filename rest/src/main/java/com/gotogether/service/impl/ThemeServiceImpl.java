package com.gotogether.service.impl;

import com.gotogether.entity.Theme;
import com.gotogether.repos.ThemeRepo;
import com.gotogether.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ThemeServiceImpl implements ThemeService {

    private final ThemeRepo themeRepo;

    @Autowired
    public ThemeServiceImpl(ThemeRepo themeRepo) {
        this.themeRepo = themeRepo;
    }

    @Override
    public Iterable<Theme> getAll() {
        return themeRepo.findAll();
    }

    @Override
    public Optional<Theme> getOne(long id) {
        return themeRepo.findById(id);
    }

}
