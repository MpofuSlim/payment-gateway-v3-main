
package com.example.meraki.services.response;

import com.example.meraki.entities.Currency;
import com.example.meraki.entities.User;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateCurrencyResponse {

    private Currency currency;

    private User user;

}



