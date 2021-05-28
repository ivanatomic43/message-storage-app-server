package rs.ac.uns.ftn.androidserver.AndroidServer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import rs.ac.uns.ftn.androidserver.AndroidServer.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findOneById(Integer id);

    List<User> findAll();

    @Query("select u.email from User u where u.email =?1")
    User findOneByEmail(String email);

}
