package io.swagger.api;

import io.swagger.model.ResponseMsg;
import io.swagger.model.TopTen;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.repository.ResortRepository;
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
public class ResortApiController implements ResortApi {

    private static final Logger log = LoggerFactory.getLogger(ResortApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final ResortRepository resortRepository;

    @org.springframework.beans.factory.annotation.Autowired
    public ResortApiController(ObjectMapper objectMapper, HttpServletRequest request, ResortRepository resortRepository) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.resortRepository = resortRepository;
    }

    public ResponseEntity<TopTen> getTopTenVert(@NotNull @ApiParam(value = "resort to query by", required = true) @Valid @RequestParam(value = "resortID", required = true) String resortID
,@NotNull @ApiParam(value = "day number in the season", required = true) @Valid @RequestParam(value = "dayID", required = true) String dayID
) {
        try {
            return new ResponseEntity<TopTen>(this.resortRepository.getTopTenVert(resortID, dayID),
                HttpStatus.OK);
        } catch (Exception e) {
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity<TopTen>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
