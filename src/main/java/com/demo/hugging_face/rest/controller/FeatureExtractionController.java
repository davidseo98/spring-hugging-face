package com.demo.hugging_face.rest.controller;

import com.demo.hugging_face.rest.service.HuggingFaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Vector;

@RestController
@RequiredArgsConstructor
public class FeatureExtractionController {

    private final HuggingFaceService huggingFaceService;

    @GetMapping("/practice/tasks/feature-extraction")
    public Vector<Double> practiceModelFeatureExtraction(@RequestParam("modelName") String modelName,
                                                         @RequestBody String text) {

        return huggingFaceService.getFeature(modelName, text);
    }
}
