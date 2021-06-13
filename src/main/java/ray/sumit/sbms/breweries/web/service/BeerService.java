package ray.sumit.sbms.breweries.web.service;

import ray.sumit.sbms.breweries.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beer);

    void saveExistingBeer(UUID beerId, BeerDto beer);

    void deleteByBeerId(UUID beerId);
}
