package com.gotogether.service;

import com.gotogether.entity.Theme;

import java.util.Optional;

public interface ThemeService {

    Iterable<Theme> getAll();

    Optional<Theme> getOne(long id);

}
