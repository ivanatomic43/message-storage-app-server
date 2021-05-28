package rs.ac.uns.ftn.androidserver.AndroidServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import rs.ac.uns.ftn.androidserver.AndroidServer.service.MessageService;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

}
