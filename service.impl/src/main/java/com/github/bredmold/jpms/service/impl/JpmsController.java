package com.github.bredmold.jpms.service.impl;

import com.github.bredmold.jpms.service.api.ApiObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/jpms")
public class JpmsController {
    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ApiObject hello() {
        var apiObject = new ApiObject();
        apiObject.setValue("hello");

        return apiObject;
    }
}
