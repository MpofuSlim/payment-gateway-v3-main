package com.example.meraki.controllers;


import com.example.meraki.common.createrequests.CreateBundlesRequestDTO;
import com.example.meraki.common.updaterequests.UpdateBundleCategoryRequestDTO;
import com.example.meraki.common.updaterequests.UpdateBundleRequestDTO;
import com.example.meraki.controllers.UserDTO.UserDTO;
import com.example.meraki.controllers.bundlesDTO.BundleCategoryDTO;
import com.example.meraki.controllers.bundlesDTO.BundlesDTO;
import com.example.meraki.controllers.bundlesDTO.BundlesDetailDTO;
import com.example.meraki.controllers.currencyDTO.CurrencyDTO;
import com.example.meraki.entities.BundleCategory;
import com.example.meraki.entities.Bundles;
import com.example.meraki.entities.Currency;
import com.example.meraki.services.BundleCategoryService;
import com.example.meraki.services.BundlesService;
import com.example.meraki.services.CurrencyService;
import com.example.meraki.services.UserService;
import com.example.meraki.services.response.CreateBundlesResponse;
import com.example.meraki.services.response.UpdateBundleCategoryResponse;
import com.example.meraki.services.response.UpdateBundleResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@AllArgsConstructor
public class BundlesController {

    @Autowired
    private BundlesService bundlesService;

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private BundleCategoryService bundleCategoryService;

    @Autowired
    private UserService userService;

    private BundlesDetailDTO getBundleDetail(Bundles bundles) {
        Currency currency = currencyService.getCurrency((bundles.getCurrency().getId()));
        BundleCategory category = bundleCategoryService.getBundlesCategory(bundles.getBundleCategory().getId());

        return new BundlesDetailDTO(BundlesDTO.fromBundles(bundles), BundleCategoryDTO.fromBundleCategory(category), CurrencyDTO.fromCurrency(currency));


    }

    @CrossOrigin
    @GetMapping(path = "/bundle/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "list all bundles?=true/false", produces = MediaType.APPLICATION_JSON_VALUE)

    public Response<List<Bundles>> listVouchersBatch() {
        List<Bundles> bundles;

        bundles = bundlesService.getAllBundles();

        return new Response<>(ResponseCode.SUCCESS, "OK", bundles);
    }

    @CrossOrigin
    @PutMapping("/bundle/{id}")
    @ApiParam(value = "update  bundle", example = "", required = true)
    public Response<UpdateBundleResponse> updateBundle(
            @RequestBody UpdateBundleRequestDTO updateBundleRequestDTO) {
        UpdateBundleResponse response =  bundlesService.updateBundle(updateBundleRequestDTO);
        return new Response<>(ResponseCode.SUCCESS, "Ok", response);
    }

    @CrossOrigin
    @GetMapping(path = "/bundle/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Retrieve bundle by id.", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<Bundles>> getBundlesById(
            @ApiParam(value = "bundle", example = "1", required = true)
            @PathVariable Long id) {

        List<Bundles> bundlesList = bundlesService.getBundleByBundleId(id);

        return new Response<>(ResponseCode.SUCCESS, "OK", bundlesList);

    }

    @CrossOrigin
    @GetMapping(path = "/bundles/{active}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Retrieve bundle by active.", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<Bundles>> getBundleByBundleName(
            @ApiParam(value = "bundle", example = "false", required = true)
            @PathVariable Boolean active) {

        List<Bundles> activeList = bundlesService.getBundlesByActive(active);

        return new Response<>(ResponseCode.SUCCESS, "OK", activeList);

    }



    @CrossOrigin
    @GetMapping(path = "/bundle/category/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Retrieve bundle by bundle category.", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<BundlesDetailDTO>> getBundlesByBundleCategory(
            @ApiParam(value = "bundle", example = "1", required = true)
            @PathVariable Long categoryId) {

        if (bundlesService.checkBundleExistsInCategory(categoryId, this.bundleCategoryService)) {
            return new Response<>(ResponseCode.NOT_FOUND, "No bundles found in this category", null);
        } else {
            List<Bundles> bundleResult = bundlesService.getBundlesByCategory((bundleCategoryService.getBundlesCategory(categoryId)));
            List<BundlesDetailDTO> payload = bundleResult.stream().map(this::getBundleDetail).collect(Collectors.toList());
            return new Response<>(ResponseCode.SUCCESS, "OK", payload);
        }

    }



   /* @CrossOrigin
    @GetMapping(path = "/bundle/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Retrieve bundles using  Id.", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Bundles> getBundleByBatchID(
            @ApiParam(value = "Bundle Id", example = "1", required = true)
            @PathVariable Long id) {

        Bundles bundles = bundlesService.getBundlesById(id);

        return new Response<>(ResponseCode.SUCCESS, "OK", bundles);

    }*/

    @CrossOrigin
    @PostMapping(path = "/bundle/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create Bundle", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    private Response<BundlesDetailDTO> createBundles(@RequestBody CreateBundlesRequestDTO createBundlesRequestDTO) {

        BundlesDetailDTO bundlesDetailDTO = null;
        try {
            CreateBundlesResponse createBundlesResponse = bundlesService.createBundles(createBundlesRequestDTO);
            bundlesDetailDTO = new BundlesDetailDTO(
                    BundlesDTO.fromBundles(createBundlesResponse.getBundles()),
                    //  UserDTO.fromUser(userService.getUser(createBundlesRequestDTO.getUserID())),
                    BundleCategoryDTO.fromBundleCategory(bundleCategoryService.getBundlesCategory(createBundlesRequestDTO.getBundleCategoryID())),
                    CurrencyDTO.fromCurrency(currencyService.getCurrency(createBundlesRequestDTO.getCurrencyID()))

            );
        } catch (IOException e) {

        }
        return new Response<>(ResponseCode.SUCCESS, "Bundle was added.", bundlesDetailDTO);
    }
}



