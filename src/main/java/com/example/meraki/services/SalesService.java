package com.example.meraki.services;

import com.example.meraki.common.createrequests.CreateSalesRequestDTO;
import com.example.meraki.entities.Bundles;
import com.example.meraki.entities.Order;
import com.example.meraki.entities.Sales;
import com.example.meraki.repositories.BundlesRepository;
import com.example.meraki.repositories.OrderRepository;
import com.example.meraki.repositories.SalesRepository;
import com.example.meraki.repositories.VouchersRepository;
import com.example.meraki.services.response.CreateSalesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
public class SalesService {

    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private BundlesRepository bundlesRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private VouchersRepository vouchersRepository;


    @Transactional
    public CreateSalesResponse createSale(CreateSalesRequestDTO createSalesRequestDTO) throws IOException {
        Bundles bundles1 = bundlesRepository.getReferenceById(createSalesRequestDTO.getBundlesId());
        Order order1 = orderRepository.getReferenceById(createSalesRequestDTO.getOrderId());
        // Vouchers voucher1 =  vouchersRepository.getReferenceById(createSalesRequestDTO.getVouchersId());
        Sales sales = new Sales(
                bundles1,
                order1,
                createSalesRequestDTO.getSales().getQuantity()


        );
        salesRepository.save(sales);

        return new CreateSalesResponse(
                sales,
                order1,
                bundles1



        );
    }


}
