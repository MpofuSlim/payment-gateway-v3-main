package com.example.meraki.services.response;

import com.example.meraki.entities.BasePrice;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateBasePriceResponse {

    private BasePrice basePrice;
}
