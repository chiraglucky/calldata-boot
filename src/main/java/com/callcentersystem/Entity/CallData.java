package com.callcentersystem.Entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class CallData {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long callId;

    @Column(name = "From_number")
    private long callFromNumber;

    @Column(name = "Start_time")
    private Timestamp callStartTime;

    @Column(name = "End_time")
    private Timestamp callEndTime;

    @Column(name = "Duration")
    private long callDuration;

    public CallData() {
        super();
    }

    public CallData(long callId, long callFromNumber, Timestamp callStartTime, Timestamp callEndTime, long callDuration) {
        this.callId = callId;
        this.callFromNumber = callFromNumber;
        this.callStartTime = callStartTime;
        this.callEndTime = callEndTime;
        this.callDuration = callDuration;
    }

    public long getCallId() {
        return callId;
    }

    public void setCallId(long callId) {
        this.callId = callId;
    }

    public long getCallFromNumber() {
        return callFromNumber;
    }

    public void setCallFromNumber(long callFromNumber) {
        this.callFromNumber = callFromNumber;
    }

    public Timestamp getCallStartTime() {
        return callStartTime;
    }

    public void setCallStartTime(Timestamp callStartTime) {
        this.callStartTime = callStartTime;
    }

    public Timestamp getCallEndTime() {
        return callEndTime;
    }

    public void setCallEndTime(Timestamp callEndTime) {
        this.callEndTime = callEndTime;
    }

    public long getCallDuration() {
        return callDuration;
    }

    public void setCallDuration(long callDuration) {
        this.callDuration = callDuration;
    }

    @Override
    public String toString() {
        return "CallData{" +
                "callId=" + callId +
                ", callFromNumber=" + callFromNumber +
                ", callStartTime=" + callStartTime +
                ", callEndTime=" + callEndTime +
                ", callDuration=" + callDuration +
                '}';
    }
}
