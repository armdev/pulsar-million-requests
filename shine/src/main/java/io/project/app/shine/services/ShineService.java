/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.shine.services;

import io.project.app.shine.domain.EventModel;
import io.project.app.shine.repositories.EventModelRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ShineService {

    @Autowired
    private EventModelRepository eventModelRepository;

    public EventModel save(EventModel eventModel) {
        eventModel.setRecordDate(LocalDateTime.now());
        eventModel.setId(UUID.randomUUID());
        return eventModelRepository.save(eventModel);

    }

    public EventModel saveFromStream(String event) {
        EventModel eventModel = new EventModel();
        eventModel.setRecordDate(LocalDateTime.now());
        eventModel.setId(UUID.randomUUID());
        eventModel.setEventName(event);
        return eventModelRepository.save(eventModel);

    }

    public List<EventModel> findAll() {

        return (List<EventModel>) eventModelRepository.findAll();

    }

}
