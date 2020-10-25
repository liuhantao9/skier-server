package io.swagger.api;

import io.swagger.model.LiftRide;
import io.swagger.model.ResponseMsg;
import io.swagger.model.SkierVertical;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.repository.SkierRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-10-24T07:26:28.713Z[GMT]")
@Controller
public class SkiersApiController implements SkiersApi {

    private static final Logger log = LoggerFactory.getLogger(SkiersApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final SkierRepository skierRepository;

    @org.springframework.beans.factory.annotation.Autowired
    public SkiersApiController(ObjectMapper objectMapper, HttpServletRequest request, SkierRepository skierRepository) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.skierRepository = skierRepository;
    }

    public ResponseEntity<SkierVertical> getSkierDayVertical(@ApiParam(value = "ID of the resort the skier is at",required=true) @PathVariable("resortID") String resortID
,@DecimalMin("1") @DecimalMax("366") @ApiParam(value = "ID number of ski day in the ski season",required=true) @PathVariable("dayID") String dayID
,@ApiParam(value = "ID of the skier riding the lift",required=true) @PathVariable("skierID") String skierID
) {
        try {
            return new ResponseEntity<SkierVertical>(skierRepository.getSkierDayVertical(resortID, dayID, skierID), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity<SkierVertical>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<SkierVertical> getSkierResortTotals(@ApiParam(value = "ID the skier to retrieve data for",required=true) @PathVariable("skierID") String skierID
,@NotNull @ApiParam(value = "resort to filter by", required = true) @Valid @RequestParam(value = "resortID", required = true) String resortID
) {
        try {
            return new ResponseEntity<SkierVertical>(skierRepository.getSkierResortTotals(skierID, resortID), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity<SkierVertical>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Void> writeNewLiftRide(@ApiParam(value = "information for new lift ride event" ,required=true )  @Valid @RequestBody LiftRide body
) {
        String accept = request.getHeader("Accept");
        skierRepository.writeNewLiftRide(body);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

}
