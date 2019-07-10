package com.gotogether.repos;

import com.gotogether.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EventRepo extends JpaRepository<Event, Long> {

    List<Event> findByName(String name);

}
