package com.phonecompany.billing;

import com.phonecompany.billing.dto.PhoneCall;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TelephoneBillCalculatorImpl implements TelephoneBillCalculator {
    public static LocalTime timeStart = LocalTime.parse("08:00:00");
    public static LocalTime timeStop = LocalTime.parse("15:59:59");

    public BigDecimal calculate(String phoneLog) throws ParseException {
        String[] rows = phoneLog.split("\n");
        List<PhoneCall> phoneCalls = new ArrayList<>();

        for (int i = 0; i < rows.length; i++) {
            String[]parts = rows[i].split(",");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime callStart = LocalDateTime.parse(parts[1], formatter);
            LocalDateTime callEnd = LocalDateTime.parse(parts[2], formatter);

            phoneCalls.add(new PhoneCall(parts[0], callStart, callEnd));
        }

        return calculate(phoneCalls);
    }

    //TODO
    private BigDecimal calculate(List<PhoneCall> phoneCallList) {
        //number, calledCount
        Map<String, Integer> mostCalledNumbers;
        Map<String, BigDecimal> paymentsOfCalls;

        //phoneNumber -> {minutesInIntervalCount, minutesOutOfIntervalCount, allMinutes}
        phoneCallList.stream().map(
            phoneCall -> {
                LocalDateTime callStart = phoneCall.getCallStart();
                int minutesInInterval = 0;
                BigDecimal finalPayment = BigDecimal.ZERO;

                if(callStart.getHour() > timeStart.getHour()) {
                    //TODO
                }

                Duration duration = Duration.between(phoneCall.getCallStart(), phoneCall.getCallEnd());
                long callInMinutes = duration.toMinutes();

                //TODO
                return finalPayment;
            }
        ).collect(Collectors.toList());

        return null;
    }
}
