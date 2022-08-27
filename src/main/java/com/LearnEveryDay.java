package com;


import com.expedia.www.global.insurance.contracts.car.CarComponent;
import com.expedia.www.global.insurance.contracts.shopping.module.InsuranceModuleRequestV2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@SpringBootApplication
@RestController
public class LearnEveryDay {

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setDisallowedFields(/*all fields are expected to bound*/);
    }

    @PostMapping(value = "/v2/module/data", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getModuleData(HttpServletRequest httpServletRequest, @RequestBody @Valid InsuranceModuleRequestV2 request) {
        httpServletRequest.getAuthType();
        request.getAbacusOverrides();
        final CarComponent carComponent = (CarComponent) request.getTripComponents().get(0);

        return new ResponseEntity<>(new String("Done"), HttpStatus.OK);
    }

    public static void main(String[]args){
        SpringApplication.run(LearnEveryDay.class, args);
    }

}