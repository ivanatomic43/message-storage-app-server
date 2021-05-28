package rs.ac.uns.ftn.androidserver.AndroidServer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.androidserver.AndroidServer.model.Message;
import rs.ac.uns.ftn.androidserver.AndroidServer.repository.MessageRepository;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public Message findOneById(Long id) {
        return messageRepository.findOneById(id);
    }

    public List<Message> findAll() {
        return messageRepository.findAll();
    }

}
