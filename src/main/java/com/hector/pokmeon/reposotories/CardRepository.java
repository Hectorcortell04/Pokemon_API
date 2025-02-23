package com.hector.pokmeon.reposotories;

import com.hector.pokmeon.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}
