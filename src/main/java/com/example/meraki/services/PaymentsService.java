package com.example.meraki.services;

import com.example.meraki.common.createrequests.CreateCurrencyRequestDTO;
import com.example.meraki.common.createrequests.CreatePaymentsRequestDTO;
import com.example.meraki.common.updaterequests.UpdatePaymentsRequestDTO;
import com.example.meraki.entities.*;
import com.example.meraki.repositories.CurrencyRepository;
import com.example.meraki.repositories.CustomersRepository;
import com.example.meraki.repositories.PaymentsRepository;
import com.example.meraki.repositories.UserRepository;
import com.example.meraki.services.response.CreateCurrencyResponse;
import com.example.meraki.services.response.CreatePaymentsResponse;
import com.example.meraki.services.response.UpdatePaymentsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
public class PaymentsService {
    @Autowired
    public PaymentsRepository paymentsRepository;

    @Autowired
    private CustomersRepository customersRepository;

    public PaymentsService(PaymentsRepository paymentsRepository) {
        this.paymentsRepository = paymentsRepository;
    }

    public Payments getPayments(Long id) {
        return paymentsRepository.getReferenceById(id);
    }

    public List<Payments> getAllPayments() {
        return paymentsRepository.findAll();
    }
    @Transactional
    public CreatePaymentsResponse createPayments(CreatePaymentsRequestDTO createPaymentsRequestDTO) throws IOException {
        Customers customers1 = customersRepository.getReferenceById(createPaymentsRequestDTO.getCustomerID());
        Payments payments = new Payments(
                customers1,
                createPaymentsRequestDTO.getPayments().getAmountPaid(),
                createPaymentsRequestDTO.getPayments().getDatePaid(),
                createPaymentsRequestDTO.getPayments().getPaying_account(),
                createPaymentsRequestDTO.getPayments().getLocation(),
                false
        );

        paymentsRepository.save(payments);

        return new CreatePaymentsResponse(
                payments,
                customers1
        );
    }

    public UpdatePaymentsResponse updatePayments(UpdatePaymentsRequestDTO updatePaymentsRequestDTO) {

        Payments payments = paymentsRepository.getReferenceById(updatePaymentsRequestDTO.getId());
        payments.setPaying_account(updatePaymentsRequestDTO.getPaying_account());
        payments.setLocation(updatePaymentsRequestDTO.getLocation());
        payments.setActive(updatePaymentsRequestDTO.getActive());

        paymentsRepository.save(payments);

        UpdatePaymentsResponse updatePaymentsResponse = new UpdatePaymentsResponse(
                payments.getPaying_account(),
                payments.getLocation(),
                payments.getActive()
        );

        return  updatePaymentsResponse;
    }
}
