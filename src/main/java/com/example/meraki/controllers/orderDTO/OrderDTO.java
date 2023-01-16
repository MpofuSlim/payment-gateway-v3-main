package com.example.meraki.controllers.orderDTO;

import com.example.meraki.entities.Order;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "orders")

public class OrderDTO {

    @ApiModelProperty(value = "id", required = true, example = "1")
    private Long id;

    @ApiModelProperty(value = "amount", required = true, example = "1.23")
    private Double amount;

    @ApiModelProperty(value = "paying_account_number", required = true, example = "")
    private String payingAccountNumber;

    @ApiModelProperty(value = "quantity", required = true, example = "6")
    private Integer quantity;

    @ApiModelProperty(value = "dateCreated", required = true, example = "")
    private Date dateCreated;


    public static OrderDTO fromOrder(Order order) {
        return new OrderDTO(order.getId(),order.getAmount(), order.getPayingAccountNumber(), order.getQuantity(), order.getDateCreated());
    }

}
