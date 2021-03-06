package com.callcentersystem.Service;

import com.callcentersystem.Repository.CallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Service
public class CallService {

    @Autowired
    CallRepository callRepository;

    public String getEndHour(String hour){
        int h=Integer.parseInt(hour);
        if(h==12){
            h=1;
        }else {
            h = h + 1;
        }
        String temp="";
        if(h/10<1){
            temp="0"+h;
        }else{
            temp=""+h;
        }
        return temp;
    }

    public String callVolumeHighestHOfD(String date){
        List<String> v=callRepository.callVolumeHighestHourOfDay(date,PageRequest.of(0,1));
        if(!v.isEmpty()) {
            String val=v.get(0);
            String h = val.substring(0, 2) + "-" + getEndHour(val.substring(0, 2)) + val.substring(3, 5);
            return h;
        }
        return null;
    }

    public String callLongestHOfD(String date){
        List<String> v=callRepository.callLongestHourOfDay(date,PageRequest.of(0,1));
        if(!v.isEmpty()) {
            String val=v.get(0);
            String h = val.substring(0, 2) + "-" + getEndHour(val.substring(0, 2)) + val.substring(3, 5);
            return h;
        }
        return null;
    }

    public String callLongestWOfD(String week){
        List<String> val=callRepository.callLongestDayOfWeek(week,PageRequest.of(0,1));
        if(!val.isEmpty()) {
            return val.get(0);
        }
        return null;
    }

    public String callVolumeHighestWOfD(String week){
        List<String> val=callRepository.callVolumeHighestDayOfWeek(week,PageRequest.of(0,1));
        if(!val.isEmpty()) {
            return val.get(0).substring(0,3);
        }
        return null;
    }
}
