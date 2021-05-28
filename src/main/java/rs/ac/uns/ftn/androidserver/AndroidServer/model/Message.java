package rs.ac.uns.ftn.androidserver.AndroidServer.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Message {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String text;

    @Column
    private Date date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
