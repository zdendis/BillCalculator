package com.phonecompany.billing.dto;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneCall {
    @CsvBindByPosition(position = 0)
    private String phoneNumber;
    @CsvDate(value = "dd-MM-yyyy HH:mm:ss")
    @CsvBindByPosition(position = 1)
    private LocalDateTime callStart;
    @CsvDate(value = "dd-MM-yyyy HH:mm:ss")
    @CsvBindByPosition(position = 2)
    private LocalDateTime callEnd;
}
