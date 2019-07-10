package com.gotogether.repos;

import com.gotogether.entity.EventPeople;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventPeopleRepo extends JpaRepository<EventPeople, Long> {
}