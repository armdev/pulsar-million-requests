/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.shine.resources;

import io.project.app.shine.domain.EventModel;
import io.project.app.shine.services.ShineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author root
 */
@RestController
@RequestMapping("/api/v2/shine")
public class ShineResource {

    @Autowired
    private ShineService shineService;

    @GetMapping("/find")
    public EventModel find(@RequestParam String eventName) {
        return shineService.findByEventName(eventName).get();

    }

    @PostMapping("/create")
    public EventModel post(@RequestBody EventModel model) {        
     

        return shineService.save(model);

    }
}
