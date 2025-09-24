package io.github.artsobol.habit_tracker.model.entity;

import jakarta.persistence.*;
import io.github.artsobol.habit_tracker.model.enums.habit.DayOfWeek;
import io.github.artsobol.habit_tracker.model.enums.habit.HabitStatus;
import io.github.artsobol.habit_tracker.model.enums.habit.ScheduleType;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "habit")
public class Habit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    @NotNull
    private String title;

    @Column
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 7)
    private HabitStatus status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "schedule_type")
    private ScheduleType scheduleType;

    // TODO: add validation for daysOfWeek when scheduleType is DAYS_OF_WEEK
    @ElementCollection(targetClass = DayOfWeek.class)
    @CollectionTable(name = "habit_days", joinColumns = @JoinColumn(name = "habit_id"))
    @Column(name = "day", nullable = false, length = 9)
    @Enumerated(EnumType.STRING)
    private Set<DayOfWeek> daysOfWeek = new HashSet<>();

    // TODO: add validation for targetPerDay when scheduleType in (DAILY, DaysOfWeek)
    @Column(name = "target_per_day")
    private Integer targetPerDay;

    // TODO: add validation for targetPerWeek when scheduleType is N_PER_WEEK
    @Column(name = "target_per_week")
    private Integer targetPerWeek;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(updatable = false, name = "created_at")
    private LocalDateTime createdAt;

    // TODO: add DB trigger to auto-update updated_at on UPDATE
    @Column(nullable = false, name = "updated_at")
    private LocalDateTime updatedAt ;

    public Habit() {}

    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;

        if (this.status == null) {
            this.status = HabitStatus.ACTIVE;
        }
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public HabitStatus getStatus() {
        return status;
    }

    public void setStatus(HabitStatus status) {
        this.status = status;
    }

    public ScheduleType getScheduleType() {
        return scheduleType;
    }

    public void setScheduleType(ScheduleType scheduleType) {
        this.scheduleType = scheduleType;
    }

    public Set<DayOfWeek> getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(Set<DayOfWeek> daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    public Integer getTargetPerDay() {
        return targetPerDay;
    }

    public void setTargetPerDay(Integer targetPerDay) {
        this.targetPerDay = targetPerDay;
    }

    public Integer getTargetPerWeek() {
        return targetPerWeek;
    }

    public void setTargetPerWeek(Integer targetPerWeek) {
        this.targetPerWeek = targetPerWeek;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
