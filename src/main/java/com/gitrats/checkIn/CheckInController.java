package com.gitrats.checkIn;

import org.hibernate.annotations.DialectOverride;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/checkin")
public class CheckInController {

    private CheckInService checkInService;

    public CheckInController(CheckInService checkInService) {
        this.checkInService = checkInService;
    }

    @PostMapping
    public CheckIn createCheckIn(@RequestBody CheckIn checkIn){
        return checkInService.createCheckIn(checkIn);
    }

    @GetMapping
    public List<CheckIn> listCheckIn(){
        return checkInService.listCheckIn();
    }

    @GetMapping("/{id}")
    public CheckIn listCheckInId(@RequestParam Long id){
        return checkInService.listCheckInId(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCheckIn(@RequestParam Long id){
        checkInService.deleteCheckIn(id);
    }

    @PutMapping("/{id}")
    public CheckIn updateCheckIn(@RequestParam Long id, @RequestBody CheckIn checkIn){
        return checkInService.updateCheckIn(id, checkIn);
    }




}
