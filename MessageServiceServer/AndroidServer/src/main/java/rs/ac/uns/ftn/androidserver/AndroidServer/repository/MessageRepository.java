package rs.ac.uns.ftn.androidserver.AndroidServer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.uns.ftn.androidserver.AndroidServer.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    Message findOneById(Long id);

    List<Message> findAll();

}
