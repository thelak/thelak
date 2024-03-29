package com.thelak.route.payments.models.certificate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IssuedCertificateModel {

    Long id;

    String buyerEmail;

    String uuid;

    String fio;

    String description;

    CertificateViewType type;

    Boolean active;

    LocalDateTime activeDate;

    CertificateModel certificateModel;
}
