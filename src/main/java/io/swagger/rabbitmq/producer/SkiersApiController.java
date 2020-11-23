package io.swagger.rabbitmq.producer;

import io.swagger.rabbitmq.configuration.RabbitMQConfiguration;
import io.swagger.model.LiftRide;
import io.swagger.model.SkierVertical;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.redis.model.SkierVerticalWrapper;
import io.swagger.redis.repository.RedisSkierVerticalRepository;
import io.swagger.repository.SkierRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.session.SessionProperties.Redis;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-10-24T07:26:28.713Z[GMT]")
@Controller
@Slf4j
public class SkiersApiController implements SkiersApi {

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final SkierRepository skierRepository;

    private final RabbitTemplate rabbitTemplate;

    private final RedisSkierVerticalRepository redisSkierVerticalRepository;

    @org.springframework.beans.factory.annotation.Autowired
    public SkiersApiController(ObjectMapper objectMapper,
        HttpServletRequest request,
        SkierRepository skierRepository,
        RabbitTemplate rabbitTemplate,
        RedisSkierVerticalRepository redisSkierVerticalRepository)
    {
        this.objectMapper = objectMapper;
        this.request = request;
        this.skierRepository = skierRepository;
        this.rabbitTemplate = rabbitTemplate;
        this.redisSkierVerticalRepository = redisSkierVerticalRepository;
    }

    public ResponseEntity<SkierVertical> getSkierDayVertical(@ApiParam(value = "ID of the resort the skier is at",required=true) @PathVariable("resortID") String resortID
,@DecimalMin("1") @DecimalMax("366") @ApiParam(value = "ID number of ski day in the ski season",required=true) @PathVariable("dayID") String dayID
,@ApiParam(value = "ID of the skier riding the lift",required=true) @PathVariable("skierID") String skierID
) {
        try {
//            SkierVerticalWrapper skierVerticalWrapper = redisSkierVerticalRepository.find(resortID, dayID, skierID);
//            if (skierVerticalWrapper != null) {
//                SkierVertical skierVertical = new SkierVertical();
//                skierVertical.setResortID(skierVerticalWrapper.getResortID());
//                skierVertical.setTotalVert(skierVerticalWrapper.getTotalVert());
//                return new ResponseEntity<SkierVertical>(skierVertical, HttpStatus.OK);
//            } else {
//                SkierVertical skierVertical = skierRepository.getSkierDayVertical(resortID, dayID, skierID);
//                skierVerticalWrapper = new SkierVerticalWrapper(resortID, skierVertical.getTotalVert(), skierID, dayID);
//                redisSkierVerticalRepository.save(skierVerticalWrapper);
//                return new ResponseEntity<SkierVertical>(skierVertical, HttpStatus.OK);
//            }
            SkierVertical skierVertical = skierRepository.getSkierDayVertical(resortID, dayID, skierID);
            return new ResponseEntity<SkierVertical>(skierVertical, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity<SkierVertical>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<SkierVertical> getSkierResortTotals(@ApiParam(value = "ID the skier to retrieve data for",required=true) @PathVariable("skierID") String skierID
,@NotNull @ApiParam(value = "resort to filter by", required = true) @Valid @RequestParam(value = "resort", required = true) List<String> resort
) {
        try {
//            SkierVerticalWrapper skierVerticalWrapper = redisSkierVerticalRepository.find(resort.get(0), "N/A", skierID);
//            if (skierVerticalWrapper != null) {
//                SkierVertical skierVertical = new SkierVertical();
//                skierVertical.setResortID(skierVerticalWrapper.getResortID());
//                skierVertical.setTotalVert(skierVerticalWrapper.getTotalVert());
//                return new ResponseEntity<SkierVertical>(skierVertical, HttpStatus.OK);
//            } else {
//                SkierVertical skierVertical = skierRepository.getSkierResortTotals(skierID, resort);
//                skierVerticalWrapper = new SkierVerticalWrapper(resort.get(0), skierVertical.getTotalVert(), skierID, "N/A");
//                redisSkierVerticalRepository.save(skierVerticalWrapper);
//                return new ResponseEntity<SkierVertical>(skierVertical, HttpStatus.OK);
//            }
            SkierVertical skierVertical = skierRepository.getSkierResortTotals(skierID, resort);
            return new ResponseEntity<SkierVertical>(skierVertical, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity<SkierVertical>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Void> writeNewLiftRide(@ApiParam(value = "information for new lift ride event" ,required=true )  @Valid @RequestBody LiftRide body
) {
        String accept = request.getHeader("Accept");
        rabbitTemplate.convertAndSend(RabbitMQConfiguration.EXCHANGE_NAME, "liftride.writeNewLiftRide", body);
//        redisSkierVerticalRepository.update(body.getResortID(), body.getDayID(), body.getSkierID(), body.getLiftID());
//        redisSkierVerticalRepository.update(body.getResortID(), "N/A", body.getSkierID(), body.getLiftID());
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

}
