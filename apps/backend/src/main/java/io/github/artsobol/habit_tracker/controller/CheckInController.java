package io.github.artsobol.habit_tracker.controller;

import io.github.artsobol.habit_tracker.model.dto.checkInDto.CheckInCreateDto;
import io.github.artsobol.habit_tracker.model.dto.checkInDto.CheckInResponseDto;
import io.github.artsobol.habit_tracker.service.CheckInService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1/habits/{habitId}/checkins")
public class CheckInController {

    private final CheckInService checkInService;

    public CheckInController(CheckInService checkInService) {
        this.checkInService = checkInService;
    }

    @GetMapping
    public ResponseEntity<List<CheckInResponseDto>> getCheckInsByPeriod(@PathVariable Long habitId,
                                                                        @RequestParam(required = false) LocalDate from,
                                                                        @RequestParam(required = false) LocalDate to) {
        return ResponseEntity.status(HttpStatus.OK).body(checkInService.getCheckInsByPeriod(habitId, from, to));
    }

    @PostMapping
    public ResponseEntity<CheckInResponseDto> createCheckIn(@PathVariable Long habitId, @RequestBody @Valid CheckInCreateDto checkInCreateDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(checkInService.createCheckIn(habitId, checkInCreateDto));
    }

    @DeleteMapping("/{date}")
    public ResponseEntity<Void> deleteCheckIn(@PathVariable Long habitId, @PathVariable LocalDate date) {
        checkInService.deleteCheckIn(habitId, date);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
