package ray.sumit.sbms.breweries.web.controller.v2;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ray.sumit.sbms.breweries.web.model.v2.BeerDtoV2;
import ray.sumit.sbms.breweries.web.service.v2.BeerServiceV2;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {

    private final BeerServiceV2 beerServiceV2;

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerId) {
        log.error("Inside get Beer V2 method ...");
        return new ResponseEntity<>(beerServiceV2.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handleNewBeer(@RequestBody BeerDtoV2 beer) {
        val savedBeer = beerServiceV2.saveNewBeer(beer);

        var headers = new HttpHeaders();
        headers.add("location", "http://localhost:8080/api/v1/beer/" + savedBeer.getId());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity handleExistingBeer(@PathVariable("beerId") UUID beerId, @RequestBody BeerDtoV2 beer) {
        beerServiceV2.saveExistingBeer(beerId, beer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByBeerId(@PathVariable("beerId") UUID beerId) {
        beerServiceV2.deleteByBeerId(beerId);
    }
}
