package ray.sumit.sbms.breweries.web.mapper;

import org.mapstruct.Mapper;
import ray.sumit.sbms.breweries.web.domain.Beer;
import ray.sumit.sbms.breweries.web.model.BeerDto;

@Mapper
public interface BeerMapper {
    BeerDto mapBeerToBeerDto(Beer beer);

    Beer mapBeerDtoToBeer(BeerDto beerDto);
}
