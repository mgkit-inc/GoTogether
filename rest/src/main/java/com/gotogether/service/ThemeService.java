package com.gotogether.service;

import com.gotogether.entity.Theme;

import java.util.List;
import java.util.Optional;

public interface ThemeService {

    Iterable<Theme> getAll();

    Optional<Theme> getOne(long id);

    void add(Theme theme);

    void add(List<Theme> themes);

    @Deprecated
    void truncate();

}
