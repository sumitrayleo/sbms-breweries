package ray.sumit.sbms.breweries.web.exception.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ErrorResponse {

    private List<BreweriesError> errorList = new ArrayList<>();
}
