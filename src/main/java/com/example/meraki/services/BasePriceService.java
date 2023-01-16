package com.example.meraki.services;


import com.example.meraki.common.createrequests.CreateBasePriceRequestDTO;
import com.example.meraki.common.updaterequests.UpdateBasePriceRequestDTO;
import com.example.meraki.common.updaterequests.UpdateCurrencyRequestDTO;
import com.example.meraki.entities.BasePrice;
import com.example.meraki.entities.Currency;
import com.example.meraki.repositories.BasePriceRepository;
import com.example.meraki.services.response.CreateBasePriceResponse;
import com.example.meraki.services.response.UpdateBasePriceResponse;
import com.example.meraki.services.response.UpdateCurrencyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BasePriceService{
    @Autowired
    private BasePriceRepository basePriceRepository;

    public BasePriceService(BasePriceRepository basePriceRepository) {
        this.basePriceRepository = basePriceRepository;
    }

    public BasePrice getBasePrice(Long id) {
        return basePriceRepository.getReferenceById(id);
    }


    public List<BasePrice> getAllBasePrice() {
        return basePriceRepository.findAll();
    }


    @Transactional
    public CreateBasePriceResponse CreateBasePrice(CreateBasePriceRequestDTO createBasePriceRequestDTO) {
        BasePrice basePrice = new BasePrice(
                createBasePriceRequestDTO.getBasePrice().getPrice()
        );

        basePriceRepository.save(basePrice);

        return new CreateBasePriceResponse(
                basePrice
        );
    }

    public UpdateBasePriceResponse updateBasePrice(UpdateBasePriceRequestDTO updateBasePriceRequestDTO) {

        BasePrice basePrice = basePriceRepository.getReferenceById(updateBasePriceRequestDTO.getId());
        basePrice.setPrice(updateBasePriceRequestDTO.getPrice());;

        basePriceRepository.save(basePrice);

        UpdateBasePriceResponse updateBasePriceResponse = new UpdateBasePriceResponse(
                basePrice.getPrice()

        );

        return updateBasePriceResponse;
    }
}
