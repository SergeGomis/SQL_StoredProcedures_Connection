package com.sergegomis.practicaltest;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class PracticaltestApplication implements Serializable {

    public static void main(String[] args) {
        SpringApplication.run(PracticaltestApplication.class, args);
    }

}

@RestController
@RequestMapping("users")
@CrossOrigin("*")
class UserRestController {

    @Autowired
    private UserDao userDao;
    
    @GetMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public List<User> getAllUsers(@RequestParam(required = false) Integer userId) {
        return userDao.callStoredProcedureGetX(userId);
    }

}

@Entity
@XmlRootElement
@Data
class User implements Serializable {

    @Id
    @GeneratedValue
    Integer id;
    @Column(name = "modifieddate")
    LocalDateTime modifiedDate;
    @Column(name = "firstname")
    String firstName;
    @Column(name = "lastname")
    String lastName;
    String email;
    @Column(name = "phonenumber")
    String phoneNumber;
}

@Repository
interface UserDao extends JpaRepository<User, Integer> { //https://www.baeldung.com/spring-data-jpa-stored-procedures

    @Query(value = "CALL getX(:x);", nativeQuery = true)
    List<User> callStoredProcedureGetX(@Param("x") Integer userId);
}
