package com.hector.pokmeon.controllers;

import com.hector.pokmeon.dtos.CardDTO;
import com.hector.pokmeon.models.Card;
import com.hector.pokmeon.services.CardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }
    @PostMapping
    public ResponseEntity<CardDTO> addCard(@RequestBody CardDTO card) {
        return ResponseEntity.ok(cardService.addCard(card));
    }
    @PostMapping("/all")
    public ResponseEntity<List<CardDTO>> addCards(@RequestBody List<CardDTO> card) {
        return ResponseEntity.ok(cardService.addCards(card));
    }

    @GetMapping
    public ResponseEntity<List<CardDTO>> getCards() {
        return ResponseEntity.ok(cardService.getAllCards());
    }
    @GetMapping("/{id}")
    public ResponseEntity<CardDTO> getCardById(@PathVariable Long id) {
        return ResponseEntity.ok(cardService.getCardById(id));
    }

}
