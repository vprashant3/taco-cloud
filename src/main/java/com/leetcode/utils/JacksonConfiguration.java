package com.leetcode.utils;

import com.expedia.www.global.insurance.contracts.LineOfBusiness;
import com.expedia.www.global.insurance.contracts.TripComponent;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;

@ConditionalOnClass(ObjectMapper.class)
@Configuration
public class JacksonConfiguration {
    public JacksonConfiguration(ObjectMapper objectMapper) {

        SimpleModule simpleModule = new SimpleModule();

        simpleModule.addDeserializer(TripComponent.class, new TripComponentCodec.Deserializer(objectMapper));

        objectMapper.registerModule(simpleModule);
    }
}