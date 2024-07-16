package com.demo.hugging_face.rest.service;

import com.demo.hugging_face.config.properties.HuggingFaceProperties;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Vector;

@Service
@RequiredArgsConstructor
public class HuggingFaceService {

    private final HuggingFaceProperties huggingFaceProperties;
    private final RestTemplate restTemplate;

    public Vector<Double> getFeature(String modelName, String text){

        HttpHeaders headers = new HttpHeaders();
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("inputs", text);
        HttpEntity<String> entity = new HttpEntity<>(jsonBody.toString(), headers);

        ResponseEntity<Vector<Double>> response = restTemplate.exchange(String.format("%s/%s", huggingFaceProperties.getUrl(), modelName),
                HttpMethod.POST,
                entity,
                new ParameterizedTypeReference<>() {});

        return response.getBody();
    }
}
