package main.controllers;

import main.exceptions.CannotDetectException;
import main.exceptions.NoServiceException;
import main.model.License;
import main.services.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping(value = "api/license/")
public class LicenseController {

    @Autowired
    private LicenseService service;

    @PostMapping(value = "getPlate", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    License getPlate(@RequestParam("file") MultipartFile file) throws IOException, NoServiceException, CannotDetectException {

        byte[] fileBytes = file.getBytes();
        return service.getPlate(fileBytes);
    }
}
