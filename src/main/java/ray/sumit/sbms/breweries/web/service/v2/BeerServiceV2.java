package ray.sumit.sbms.breweries.web.service.v2;

import ray.sumit.sbms.breweries.web.model.v2.BeerDtoV2;

import java.util.UUID;

public interface BeerServiceV2 {
    BeerDtoV2 getBeerById(UUID beerId);

    BeerDtoV2 saveNewBeer(BeerDtoV2 beer);

    void saveExistingBeer(UUID beerId, BeerDtoV2 beer);

    void deleteByBeerId(UUID beerId);
}
