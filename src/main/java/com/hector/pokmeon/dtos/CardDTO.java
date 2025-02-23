package com.hector.pokmeon.dtos;

import com.hector.pokmeon.models.Rarity;
import lombok.Data;

@Data
public class CardDTO {
    private String name;
    private String type;
    private String rarity;
    private String imageUrl;
}
