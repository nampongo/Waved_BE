package com.senity.waved.domain.paymentRecord.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentRecordRequestDto {
    private String imp_uid;
    private Long deposit;
}
