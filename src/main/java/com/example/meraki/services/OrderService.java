package com.example.meraki.services;

import com.example.meraki.common.createrequests.CreateOrderRequestDTO;
import com.example.meraki.entities.AdminPortalUsers;
import com.example.meraki.entities.BusinessPartner;
import com.example.meraki.entities.Order;
import com.example.meraki.repositories.AdminPortalUsersRepository;
import com.example.meraki.repositories.BusinessPartnerRepository;
import com.example.meraki.repositories.OrderRepository;
import com.example.meraki.services.response.CreateOrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BusinessPartnerRepository businessPartnerRepository;

    @Autowired
    private AdminPortalUsersRepository adminPortalUsersRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order getOrder(Long id) {
        return orderRepository.getReferenceById(id);
    }

    public List<Order> getOrdersByBusinessPartnerId(BusinessPartner businessPartner) {
        return orderRepository.findByBusinessPartner(businessPartner);
    }

    @Transactional
    public CreateOrderResponse createOrder(CreateOrderRequestDTO createOrderRequestDTO) throws IOException {
        BusinessPartner businessPartner1 = businessPartnerRepository.getReferenceById(createOrderRequestDTO.getBusinessPartnerId());
        AdminPortalUsers adminPortalUsers1 = adminPortalUsersRepository.getReferenceById(createOrderRequestDTO.getAdminPortalUserId());
        Order order = new Order(
                businessPartner1,
                adminPortalUsers1,
                createOrderRequestDTO.getOrder().getAmount(),
                createOrderRequestDTO.getOrder().getPayingAccountNumber(),
                createOrderRequestDTO.getOrder().getQuantity(),
                createOrderRequestDTO.getOrder().getDateCreated()

        );
        orderRepository.save(order);

        return new CreateOrderResponse(
                order,
                businessPartner1,
                adminPortalUsers1
        );
    }

    public boolean checkOrderExistsInBusinessPartner(Long id, BusinessPartnerService businessPartnerService) {
        boolean result = false;

        try {

            orderRepository.findByBusinessPartner(businessPartnerService.getBusinessPartner(id));
        } catch (EntityNotFoundException entityNotFoundException) {
            result = true;
        }
        return result;
    }



}
