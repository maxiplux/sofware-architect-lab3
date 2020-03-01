package blog.juanfrancisco.net.sofware.architecture.lab3.controllers;

import blog.juanfrancisco.net.sofware.architecture.lab3.models.Greeting;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @GetMapping("/greeting/{message}")
    public ResponseEntity<?> getGreeting(@PathVariable("message") String message){
        Greeting greeting= new Greeting();
        greeting.setContent("hello word "+message);
        return  new ResponseEntity<Greeting>(greeting, HttpStatus.OK);

    }
}
