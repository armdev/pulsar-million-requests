/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.shine.repositories;

import io.project.app.shine.domain.EventModel;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author root
 */
@Repository
public interface EventModelRepository extends CrudRepository<EventModel, UUID>{
    
    Optional<EventModel> findFirst1ByEventName(String name);
    
}
