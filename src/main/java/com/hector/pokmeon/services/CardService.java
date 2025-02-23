package com.hector.pokmeon.services;

import com.hector.pokmeon.dtos.CardDTO;
import com.hector.pokmeon.mappers.CardMapper;
import com.hector.pokmeon.models.Card;
import com.hector.pokmeon.reposotories.CardRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardService {

    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

    public CardService(CardRepository cardRepository, CardMapper cardMapper) {
        this.cardRepository = cardRepository;
        this.cardMapper = cardMapper;
    }

    public CardDTO addCard(CardDTO cardDTO) {
        Card card = cardMapper.toEntity(cardDTO);
        Card savedCard = cardRepository.save(card);
        return cardMapper.toDTO(savedCard);
    }

    public List<CardDTO> addCards(List<CardDTO> cardsDTO) {
        List<Card> allCards = cardsDTO.stream().map(cardMapper::toEntity).collect(Collectors.toList());
        List<Card> savedCards = cardRepository.saveAll(allCards);
        return savedCards.stream().map(cardMapper::toDTO).collect(Collectors.toList());
    }

    public List<CardDTO> getAllCards() {
        List<Card> allCards = cardRepository.findAll();
        ArrayList<CardDTO> cardDTOS = new ArrayList<>();
        for (Card card : allCards) {
            CardDTO cardDTO = new CardDTO();
            cardDTO.setName(card.getName());
            cardDTO.setImageUrl(card.getImageUrl());
            cardDTO.setRarity(card.getRarity());
            cardDTOS.add(cardDTO);
        }
        return cardDTOS;
    }

    public CardDTO getCardById(Long id) {
        Card card = cardRepository.findById(id).orElse(null);
        CardDTO cardDTO = new CardDTO();
        cardDTO.setName(card.getName());
        cardDTO.setImageUrl(card.getImageUrl());
        cardDTO.setRarity(card.getRarity());
        return cardDTO;
    }



    }
