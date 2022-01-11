package com.callcentersystem.Controller;

import com.callcentersystem.Service.CallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CallController {

    @Autowired
    CallService callService;

    @GetMapping("/call/volume/hour/{date}")
    public ResponseEntity<Object> getHourVolumeHighest(@PathVariable("date") String date){
        String result=callService.callVolumeHighestHOfD(date);
        if(result!=null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>("Data does not exist",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/call/longest/hour/{date}")
    public ResponseEntity<Object> getHourCallLongest(@PathVariable("date") String date){
        String result=callService.callLongestHOfD(date);
        if(result!=null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>("Data does not exist",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/call/longest/day/{week}")
    public ResponseEntity<Object> getDayCallLongest(@PathVariable("week") String week){
        String result = callService.callLongestWOfD(week);
        if(result!=null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>("Data does not exist",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/call/volume/day/{week}")
    public ResponseEntity<Object> getDayCallVolumeHighest(@PathVariable("week") String week){
        String result=callService.callVolumeHighestWOfD(week);
        if(result!=null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>("Data does not exist",HttpStatus.NOT_FOUND);
    }

}
