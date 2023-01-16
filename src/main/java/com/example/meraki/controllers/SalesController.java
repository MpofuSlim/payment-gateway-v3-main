package com.example.meraki.controllers;

import com.example.meraki.entities.Bundles;
import com.example.meraki.entities.Vouchers;
import com.example.meraki.services.BundlesService;
import com.example.meraki.services.OrderService;
import com.example.meraki.services.SalesService;
import com.example.meraki.services.VouchersService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Stream;

@RestController
@AllArgsConstructor
public class SalesController {

    @Autowired
    private SalesService salesService;

    @Autowired
    private BundlesService bundlesService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private VouchersService vouchersService;



    @CrossOrigin
    @PostMapping(path = "/sales/{bundleId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Sell a  voucher by bundle id.", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Stream<Vouchers>> getBatchByActive(

            @ApiParam(value = "bundleId of the voucher", example = "one", required = true)
            @PathVariable Bundles bundleId, Boolean sold, Integer quantity)

    {



        List<Vouchers> vouchersList = vouchersService.getVouchersByBundleIdAndSold(bundleId, sold);


        return new Response<>(ResponseCode.SUCCESS, "OK", vouchersList.stream().limit(quantity));

    }


}
