package com.gitrats.checkIn;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/checkin")
public class CheckInController {

    private final CheckInService checkInService;

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
    public CheckIn listCheckInId(@PathVariable Long id){
        return checkInService.listCheckInId(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCheckIn(@PathVariable Long id){
        checkInService.deleteCheckIn(id);
    }

    @PatchMapping("/{id}")
    public CheckIn updateCheckIn(@PathVariable Long id, @RequestBody CheckIn checkIn){
        return checkInService.updateCheckIn(id, checkIn);
    }
}
