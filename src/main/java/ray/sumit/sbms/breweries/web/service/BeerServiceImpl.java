package ray.sumit.sbms.breweries.web.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ray.sumit.sbms.breweries.web.model.BeerDto;

import java.util.UUID;
@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("ThunderBolt")
                .beerStyle("Light")
                .upc(999L)
                .build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beer) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Foster")
                .beerStyle("pale yellow")
                .upc(123L)
                .build();
    }

    @Override
    public void saveExistingBeer(UUID beerId, BeerDto beer) {
        //TODO: Implement this method
    }

    @Override
    public void deleteByBeerId(UUID beerId) {
      log.info("Deleting the Beer with beerId: " + beerId);
    }


}
