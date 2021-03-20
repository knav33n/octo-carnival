package dev.naveenkumar.springbootmongo.controller;

import dev.naveenkumar.springbootmongo.dto.UserDto;
import dev.naveenkumar.springbootmongo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")//pre-path
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody UserDto userDto) {
        userService.saveUser(userDto.convertToUser());
        return ResponseEntity.ok(true);
    }

    @GetMapping("country/{country}")
    public ResponseEntity<?> findByCountry(@PathVariable String country) {
        return ResponseEntity.ok(userService.findUsersByCountry((country)));
    }

    @GetMapping("count-by-country")
    public ResponseEntity<?> countByCountry() {
        return ResponseEntity.ok(userService.countByCountry());
    }

    @GetMapping("group-by-country")
    public ResponseEntity<?> groupByCountry() {
        return ResponseEntity.ok(userService.groupByCountry());
    }

}
