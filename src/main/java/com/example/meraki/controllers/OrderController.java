package com.example.meraki.controllers;

import com.example.meraki.common.createrequests.CreateOrderRequestDTO;
import com.example.meraki.controllers.AdminPortalUsersDTO.AdminPortalUsersDTO;
import com.example.meraki.controllers.businessPartnerDTO.BusinessPartnerDTO;
import com.example.meraki.controllers.businessPartnerDTO.BusinessPartnerDetailDTO;
import com.example.meraki.controllers.orderDTO.OrderDTO;
import com.example.meraki.controllers.orderDTO.OrderDetailDTO;
import com.example.meraki.entities.BusinessPartner;
import com.example.meraki.entities.Order;
import com.example.meraki.services.AdminPortalUsersService;
import com.example.meraki.services.BusinessPartnerService;
import com.example.meraki.services.OrderService;
import com.example.meraki.services.response.CreateOrderResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@AllArgsConstructor
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private BusinessPartnerService businessPartnerService;

    @Autowired
    private AdminPortalUsersService adminPortalUsersService;

    @CrossOrigin
    @PostMapping(path = "/order/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "all orders", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    private Response<OrderDetailDTO> createOrder(@RequestBody CreateOrderRequestDTO createOrderRequestDTO){

        OrderDetailDTO orderDetailDTO=null;
        try{
            CreateOrderResponse createOrderResponse = orderService.createOrder(createOrderRequestDTO);
            orderDetailDTO=new OrderDetailDTO(
                    OrderDTO.fromOrder(createOrderResponse.getOrder()),
                    BusinessPartnerDTO.fromBusinessPartner(businessPartnerService.getBusinessPartner(createOrderRequestDTO.getBusinessPartnerId())),
                    AdminPortalUsersDTO.fromAdminPortalUsers(adminPortalUsersService.getAdminPortalUser(createOrderRequestDTO.getAdminPortalUserId()))


            );

        }catch (IOException e){

        }
        return new Response<>(ResponseCode.SUCCESS, "order was added.", orderDetailDTO);
    }

    @CrossOrigin
    @GetMapping(path = "/order/{businessPartnerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Retrieve an order using a business partner Id.", produces = MediaType.APPLICATION_JSON_VALUE)

    public Response<List<BusinessPartnerDetailDTO>> getByBusinessPartnerId(
            @ApiParam(value = "Id of business partner", example = "1", required = true)
            @PathVariable Long businessPartnerId) {

        if (orderService.checkOrderExistsInBusinessPartner(businessPartnerId, this.businessPartnerService)) {
            return new Response<>(ResponseCode.NOT_FOUND, "No business partner found", null);
        } else {
            List<Order> orderResult = orderService.getOrdersByBusinessPartnerId(businessPartnerService.getBusinessPartner(businessPartnerId));
            List<BusinessPartnerDetailDTO> payload = orderResult.stream().map(this::getOrderDetail).collect(toList());
            return new Response<>(ResponseCode.SUCCESS, "OK", payload);
        }
    }

    private BusinessPartnerDetailDTO getOrderDetail(Order order) {
        BusinessPartner businessPartner = businessPartnerService.getBusinessPartner(order.getBusinessPartner().getId());
        Order order1 = orderService.getOrder(order.getId());

        return new BusinessPartnerDetailDTO(
                BusinessPartnerDTO.fromBusinessPartner(businessPartner),
                OrderDTO.fromOrder(order1)




        );

    }



}
