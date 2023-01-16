package com.example.meraki.services;

import com.example.meraki.common.updaterequests.UpdateBundleCategoryRequestDTO;
import com.example.meraki.common.updaterequests.UpdateBundleRequestDTO;
import com.example.meraki.entities.*;
import com.example.meraki.repositories.*;
import com.example.meraki.services.response.UpdateBundleCategoryResponse;
import com.example.meraki.services.response.UpdateBundleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.example.meraki.common.createrequests.CreateBundlesRequestDTO;
import com.example.meraki.services.response.CreateBundlesResponse;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;


@Service
public class BundlesService {

    private boolean quit = false;

    @Autowired
    protected CustomersRepository custDB;

    @Autowired
    private BundlesRepository bundlesRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private BundlesCategoryRepository bundlesCategoryRepository;

    public BundlesService(BundlesRepository bundlesRepository) {
        this.bundlesRepository = bundlesRepository;
    }

    public List<Bundles> getAllBundles() {
        return bundlesRepository.findAll();
    }

    /*public List<Bundles> findByid(Long id) {
        return bundlesRepository.findByBundleCategory(id);
    }*/

    public List<Bundles> getBundleByBundleId(Long id) {
        return bundlesRepository.findByid(id);
    }

    public List<Bundles> getBundlesByActive(Boolean active) {
        return bundlesRepository.findByActive(active);
    }

    public Bundles getBundle(Long id) {
        return bundlesRepository.getReferenceById(id);
    }


    public Bundles getBundlesById(Long id) {
        return bundlesRepository.getReferenceById(id);
    }


    public boolean checkBundleExistsInCategory(Long id, BundleCategoryService bundleCategoryService) {
        boolean result = false;

        try {
            bundlesRepository.findByBundleCategory(bundleCategoryService.getBundlesCategory(id));
        } catch (EntityNotFoundException entityNotFoundException) {
            result = true;
        }
        return result;
    }

    /* public Boolean checkBundleExists(Long id){
         return bundlesRepository.findById(id).isPresent();
     }
 */
    public List<Bundles> getBundlesByCategory(BundleCategory category) {
        return bundlesRepository.findByBundleCategory(category);
    }


    @Transactional
    public CreateBundlesResponse createBundles(CreateBundlesRequestDTO createBundlesRequestDTO) throws IOException {
        User user1 = userRepository.getReferenceById(createBundlesRequestDTO.getUserID());
        Currency currency1 = currencyRepository.getReferenceById(createBundlesRequestDTO.getCurrencyID());
        BundleCategory bundlesCategory1 = bundlesCategoryRepository.getReferenceById(createBundlesRequestDTO.getBundleCategoryID());
        Bundles bundles = new Bundles(
                user1,
                currency1,
                bundlesCategory1,
                createBundlesRequestDTO.getBundle().getName(),
                createBundlesRequestDTO.getBundle().getGroupPolicyId(),
                createBundlesRequestDTO.getBundle().getDescription(),
                //createBundlesRequestDTO.getBundle().getDateCreated(),
                createBundlesRequestDTO.getBundle().getImage(),
                createBundlesRequestDTO.getBundle().getPrice(),
                false
        );

        bundlesRepository.save(bundles);

        return new CreateBundlesResponse(
                bundles,
                user1,
                currency1,
                bundlesCategory1
        );

    }

    public UpdateBundleResponse updateBundle(UpdateBundleRequestDTO updateBundleRequestDTO) {

        BundleCategory bundleCategory = bundlesCategoryRepository.getReferenceById(updateBundleRequestDTO.getBundleCategoryId());
        Currency currency = currencyRepository.getReferenceById(updateBundleRequestDTO.getCurrencyId());
        Bundles bundles = bundlesRepository.getReferenceById(updateBundleRequestDTO.getId());
        bundles.setName(updateBundleRequestDTO.getName());
        bundles.setDescription(updateBundleRequestDTO.getDescription());
        bundles.setImage(updateBundleRequestDTO.getImage());
        bundles.setPrice(updateBundleRequestDTO.getPrice());
        bundles.setGroupPolicyId(updateBundleRequestDTO.getGroupPolicyId());
        bundles.setActive(updateBundleRequestDTO.getActive());

        bundlesRepository.save(bundles);

        UpdateBundleResponse updateBundleResponse = new UpdateBundleResponse(
                bundleCategory.getId(),
                currency.getId(),
                bundles.getName(),
                bundles.getDescription(),
                bundles.getImage(),
                bundles.getPrice(),
                bundles.getGroupPolicyId(),
                bundles.getActive()
        );

        return updateBundleResponse;
    }
}

    /*public void BundleExpire() {
        while (!quit) {
            try {

                LocalDate currentDate = LocalDate.now();
                LocalDate currentDateMinus6Months = currentDate.minusMonths(1);
                Date today = new Date();
                Long Duration;
                // get all coupons
                //10min = 10min * 60s
                //1day =  24*60min*60s
                //1week = 24hrs*7days*60*60
                //1months = 24hrs*30days*60*60
                //List<Bundles> AllBundles()
                List<Bundles> BundleList = new ArrayList<Bundles>();
                for (Bundles bundles : BundleList) {
                    (bundles.getStartDate() - bundles.getDuration())= Duration;
                    if (bundles.getDuration()!==0) {
                        System.out.println("Bundle balance is" + Duration);
                    } else {
                        System.out.println("you have depleted your bundle");
                    }

                    // to the next time
            }




    /*public void removeFromCompany(Coupon coup) {
        List<Company> companies = compDB.getAllCompanies();
        for (Company comp : companies) {
            List<Coupon> compCoupons = comp.getCoupons();
            compCoupons.remove(coup);
            compDB.updateCompany(comp);
        }
    }*/



