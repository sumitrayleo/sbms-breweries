package ray.sumit.sbms.breweries.web.service.v2;

import org.springframework.stereotype.Service;
import ray.sumit.sbms.breweries.web.model.v2.BeerDtoV2;

import java.util.UUID;

@Service
public class BeerServiceV2Impl implements BeerServiceV2 {
    @Override
    public BeerDtoV2 getBeerById(UUID beerId) {
        return null;
    }

    @Override
    public BeerDtoV2 saveNewBeer(BeerDtoV2 beer) {
        return null;
    }

    @Override
    public void saveExistingBeer(UUID beerId, BeerDtoV2 beer) {

    }

    @Override
    public void deleteByBeerId(UUID beerId) {

    }
}
