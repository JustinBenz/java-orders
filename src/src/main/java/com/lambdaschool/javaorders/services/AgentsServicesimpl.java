package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Agent;
import com.lambdaschool.javaorders.repositories.AgentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Transactional
@Service(value = "agentsService")
public class AgentsServicesimpl implements AgentsServices {

    @Autowired
    private AgentsRepository agrepos;

    @Override
    public Agent findAgentById(long agentcode) {
        Agent a = agrepos.findById(agentcode).orElseThrow(() -> new EntityNotFoundException("Agent with " + agentcode + "was not found"));
        return null;
    }
}
