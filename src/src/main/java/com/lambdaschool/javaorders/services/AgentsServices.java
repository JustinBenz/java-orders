package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Agent;

import java.util.List;

public interface AgentsServices {
    Agent findAgentById(long agentcode);
}
