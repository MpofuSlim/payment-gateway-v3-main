package com.example.meraki.controllers;

import com.example.meraki.common.createrequests.CreateBundlesRequestDTO;
import com.example.meraki.common.createrequests.CreateNetworksRequestDTO;
import com.example.meraki.common.updaterequests.UpdateAdminPortalUsersRequestDTO;
//import com.example.meraki.common.updaterequests.UpdateNetworksRequestDTO;
import com.example.meraki.common.updaterequests.UpdateNetworksRequestDTO;
import com.example.meraki.controllers.UserDTO.UserDTO;
import com.example.meraki.controllers.bundlesDTO.BundleCategoryDTO;
import com.example.meraki.controllers.bundlesDTO.BundlesDTO;
import com.example.meraki.controllers.bundlesDTO.BundlesDetailDTO;
import com.example.meraki.controllers.currencyDTO.CurrencyDTO;
import com.example.meraki.controllers.networksDTO.NetworksDTO;
import com.example.meraki.controllers.networksDTO.NetworksDetailDTO;
import com.example.meraki.controllers.organisationDTO.OrganisationDTO;
import com.example.meraki.entities.AdminPortalUsers;
import com.example.meraki.entities.Networks;
import com.example.meraki.entities.Organisations;
import com.example.meraki.services.*;
import com.example.meraki.services.response.CreateBundlesResponse;
import com.example.meraki.services.response.CreateNetworksResponse;
import com.example.meraki.services.response.UpdateAdminPortalUsersResponse;
//import com.example.meraki.services.response.UpdateNetworksResponse;
import com.example.meraki.services.response.UpdateNetworksResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
public class NetworksController {

    @Autowired
    private NetworksService networksService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrganisationService organisationService;

    @CrossOrigin
    @GetMapping(path = "/networks/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "list all networks", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<Networks>> listAllNetworks(
    ) {
        List<Networks> networks;

        networks = networksService.getAllNetworks();

        return new Response<>(ResponseCode.SUCCESS, "OK", networks);
    }

    @CrossOrigin
    @PutMapping("/networks/{id}")
    @ApiParam(value = "update networks", example = "", required = true)
    public Response<UpdateNetworksResponse> updateAdminPortalUsers(
            @RequestBody UpdateNetworksRequestDTO updateNetworksRequestDTO) {
        UpdateNetworksResponse response =  networksService.updateNetworks(updateNetworksRequestDTO);
        return new Response<>(ResponseCode.SUCCESS, "Ok", response);
    }

    @CrossOrigin
    @PostMapping(path = "/networks/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create network", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    private Response<NetworksDetailDTO> createNetworks(@RequestBody CreateNetworksRequestDTO createNetworksRequestDTO){

        NetworksDetailDTO networksDetailDTO=null;
        try{
            CreateNetworksResponse createNetworksResponse = networksService.createNetworks(createNetworksRequestDTO);
            networksDetailDTO=new NetworksDetailDTO(
                    NetworksDTO.fromNetworks(createNetworksResponse.getNetworks()),
                    UserDTO.fromUser(userService.getUser(createNetworksRequestDTO.getUserID())),
                    OrganisationDTO.fromOrganisations(organisationService.getOrganisation(createNetworksRequestDTO.getOrganisationsID()))

            );
        }catch (IOException e){

        }
        return new Response<>(ResponseCode.SUCCESS, "network  added.",  networksDetailDTO);
    }
}
