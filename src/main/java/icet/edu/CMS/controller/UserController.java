package icet.edu.CMS.controller;

import icet.edu.CMS.dao.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {

    ArrayList<UserEntity> users = new ArrayList<>();
    @PostMapping("/signUp")
    public void createUser(@RequestBody UserEntity user){
        users.add(user);


    }

//    @PostMapping("/login")
//    public ResponseEntity<?> getUserByUsername(@RequestBody UserEntity user){
//        System.out.println("hello"+user);
//
//        Map<String, String> response = new HashMap<>();
//        response.put("messsage","helloo");
//        return ResponseEntity.ok(response);
//    }



    @PostMapping("/login")
    public ResponseEntity<?> getUserByUsername(@RequestBody UserEntity externalUser){

       List<UserEntity> foundUser = users.stream()
                        .filter(user -> user.getEmail().equalsIgnoreCase(externalUser.getEmail()))
                                .collect(Collectors.toList());
       if( foundUser.size()!=0) {
           if(foundUser.get(0).getPassword().equals(externalUser.getPassword())){
               foundUser.get(0);
               Map<String, Object> response = new HashMap<>();
               response.put("user", UserEntity.builder().email(foundUser.get(0).getEmail()).password("").build());
               response.put("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9");

               return ResponseEntity.ok(response);
           }
           return ResponseEntity.badRequest().build();
       }
        return  ResponseEntity.badRequest().build();
    }

}
