package com.callcentersystem.Repository;

import com.callcentersystem.Entity.CallData;
import org.aspectj.weaver.ast.Var;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface CallRepository extends JpaRepository<CallData,Long> {

    //Hour of the day when calls are longest
    @Query(value="SELECT function('date_format',c.callStartTime,'%h %p') from CallData as c WHERE function('date_format',c.callStartTime,'%d %m %Y')= :date ORDER BY c.callDuration DESC")
    List<String> callLongestHourOfDay(@Param("date") String date,Pageable pageable);

    //Hour of the day when call volume is highest
    @Query("SELECT function('date_format',c.callStartTime,'%h %p') as hour,COUNT(c.callId) as total_call from CallData as c WHERE function('date_format',c.callStartTime,'%d %m %Y')= :date group by function('date_format',c.callStartTime,'%D %H %p') ORDER BY total_call DESC")
    List<String> callVolumeHighestHourOfDay(@Param("date") String date, Pageable pageable);

    //Day of the week when calls are longest
    @Query("SELECT function('date_format',c.callStartTime,'%a') as day from CallData as c where function('date_format',c.callStartTime,'%U %Y')= :week ORDER BY c.callDuration DESC")
    List<String> callLongestDayOfWeek(@Param("week") String week,Pageable pageable);

    //Day of the week when call volume is highest
    @Query("SELECT function('date_format',c.callStartTime,'%a') as day,COUNT(c.callId) as total_call from CallData as c WHERE function('date_format',c.callStartTime,'%U %Y')= :week ORDER BY total_call")
    List<String> callVolumeHighestDayOfWeek(@Param("week") String week, Pageable pageable);

}
