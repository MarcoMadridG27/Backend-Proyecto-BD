package com.dbp.backendspotify.service;

import com.dbp.backendspotify.model.Listener;
import com.dbp.backendspotify.repository.ListenerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListenerService {

    private final ListenerRepository listenerRepository;

    public ListenerService(ListenerRepository listenerRepository) {
        this.listenerRepository = listenerRepository;
    }

    public List<Listener> getAllListeners() {
        return listenerRepository.findAll();
    }

    public Optional<Listener> getListenerById(String id) {
        return listenerRepository.findById(id);
    }

}
