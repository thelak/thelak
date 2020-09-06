package com.thelak.route.speaker.services;

import com.thelak.route.common.services.BaseMicroservice;
import com.thelak.route.exceptions.MicroServiceException;
import com.thelak.route.speaker.interfaces.ISpeakerService;
import com.thelak.route.speaker.models.SpeakerCreateRequest;
import com.thelak.route.speaker.models.SpeakerModel;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class SpeakerService extends BaseMicroservice implements ISpeakerService {

    public SpeakerService(RestTemplate restTemplate) {
        super("ms-speaker", restTemplate);
    }

    @Override
    public SpeakerModel get(Long id) throws MicroServiceException {
        return retry(() -> restTemplate.getForEntity(buildUrl(SPEAKER_GET), SpeakerModel.class, id).getBody());
    }

    @Override
    public List<SpeakerModel> getByIds(List<Long> ids) throws MicroServiceException {
        return retry(() -> restTemplate.getForEntity(buildUrl(SPEAKER_GET_IDS), List.class, ids).getBody());

    }

    @Override
    public List<SpeakerModel> list(Integer page, Integer size, List<String> countryFilter) throws MicroServiceException {
        return retry(() -> restTemplate.getForEntity(buildUrl(SPEAKER_LIST), List.class,
                page, size, countryFilter).getBody());
    }

    @Override
    public List<SpeakerModel> search(String search, Integer page, Integer size) throws MicroServiceException {
        return retry(() -> restTemplate.getForEntity(buildUrl(SPEAKER_SEARCH), List.class, search, page, size).getBody());
    }

    @Override
    public SpeakerModel create(SpeakerCreateRequest request) throws MicroServiceException {
        return retry(() -> restTemplate.postForEntity(buildUrl(SPEAKER_CREATE), request, SpeakerModel.class).getBody());
    }

    @Override
    public SpeakerModel update(SpeakerModel request) throws MicroServiceException {
        return null;
    }

    @Override
    public Boolean delete(Long id) throws MicroServiceException {
        return false;
    }
}