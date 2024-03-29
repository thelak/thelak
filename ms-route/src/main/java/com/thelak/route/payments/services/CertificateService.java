package com.thelak.route.payments.services;

import com.thelak.route.common.services.BaseMicroservice;
import com.thelak.route.exceptions.MicroServiceException;
import com.thelak.route.payments.interfaces.ICertificateService;
import com.thelak.route.payments.models.certificate.CertificateModel;
import com.thelak.route.payments.models.certificate.CreateCertificateRequest;
import com.thelak.route.payments.models.certificate.EmailCertificateRequest;
import com.thelak.route.payments.models.certificate.IssuedCertificateModel;
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

    @Override
    public CertificateModel create(CreateCertificateRequest request) throws MicroServiceException {
        return null;
    }

    @Override
    public CertificateModel update(CertificateModel request) throws MicroServiceException {
        return null;
    }

    @Override
    public Boolean delete(Long id) throws MicroServiceException {
        return null;
    }

    @Override
    public IssuedCertificateModel generate(Long certificateId) throws MicroServiceException {
        return retry(() -> restTemplate.postForEntity(buildUrl(CERTIFICATE_GENERATE), certificateId, IssuedCertificateModel.class).getBody());
    }

    @Override
    public IssuedCertificateModel getByUUID(String uuid) throws MicroServiceException {
        return null;
    }

    @Override
    public Boolean activate(String uuid) throws MicroServiceException {
        return retry(() -> restTemplate.getForEntity(buildUrl(CERTIFICATE_ACTIVATE), Boolean.class, uuid).getBody());
    }

    @Override
    public Boolean email(EmailCertificateRequest request) throws MicroServiceException {
        return null;
    }
}
