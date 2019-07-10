package com.gotogether.service;

import com.gotogether.app.Profiles;
import com.gotogether.entity.Theme;
import org.springframework.context.annotation.Profile;

import java.util.List;
import java.util.Optional;

public interface ThemeService {

    Iterable<Theme> getAll();

    Optional<Theme> getOne(long id);

    void add(Theme theme);

    List<Theme> add(List<Theme> themes);

    @Profile(Profiles.DEV)
    void truncate();

}
