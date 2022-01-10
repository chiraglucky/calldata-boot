package com.callcentersystem.Controller;

import com.callcentersystem.Service.CallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CallController {

    @Autowired
    CallService callService;

    @GetMapping("/call/volume/hour/{date}")
    public String getHourVolumeHighest(@PathVariable("date") String date){
        return callService.callVolumeHighestHOfD(date);
    }

    @GetMapping("/call/longest/hour/{date}")
    public String getHourCallLongest(@PathVariable("date") String date){
        return callService.callLongestHOfD(date);
    }

    @GetMapping("/call/longest/day/{week}")
    public String getDayCallLongest(@PathVariable("week") String week){
        return callService.callLongestWOfD(week);
    }

    @GetMapping("/call/volume/day/{week}")
    public String getDayCallVolumeHighest(@PathVariable("week") String week){
        return callService.callLongestWOfD(week);
    }

}
