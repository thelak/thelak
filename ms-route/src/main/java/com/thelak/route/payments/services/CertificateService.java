package com.thelak.route.payments.services;

import com.thelak.route.common.services.BaseMicroservice;
import com.thelak.route.exceptions.MicroServiceException;
import com.thelak.route.payments.interfaces.ICertificateService;
import com.thelak.route.payments.models.CertificateModel;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class CertificateService extends BaseMicroservice implements ICertificateService {

    public CertificateService(RestTemplate restTemplate) {
        super("ms-payments", restTemplate);
    }

    @Override
    public CertificateModel get(Long id) throws MicroServiceException {
        return retry(() -> restTemplate.getForEntity(buildUrl(CERTIFICATE_GET), CertificateModel.class, id).getBody());

    }

    @Override
    public List<CertificateModel> list() throws MicroServiceException {
        return retry(() -> restTemplate.getForEntity(buildUrl(CERTIFICATE_LIST), List.class).getBody());
    }
}
