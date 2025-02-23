package com.hector.pokmeon.mappers;

import com.hector.pokmeon.dtos.CardDTO;
import com.hector.pokmeon.models.Card;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring")
public interface CardMapper {

    CardMapper INSTANCE = Mappers.getMapper(CardMapper.class);

    Card toEntity(CardDTO cardDTO);
    CardDTO toDTO(Card card);


}
