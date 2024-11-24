package com.dbp.backendspotify.controller;

import com.dbp.backendspotify.model.Listener;
import com.dbp.backendspotify.service.ListenerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/listeners")
public class ListenerController {

    private final ListenerService listenerService;

    public ListenerController(ListenerService listenerService) {
        this.listenerService = listenerService;
    }

    @GetMapping
    public ResponseEntity<List<Listener>> getAllListeners() {
        List<Listener> listeners = listenerService.getAllListeners();
        return ResponseEntity.ok(listeners);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Listener> getListenerById(@PathVariable String id) {
        return listenerService.getListenerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
