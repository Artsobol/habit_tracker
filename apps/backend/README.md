# Habit Tracker

## Описание
Habit Tracker - это сервис для создания и отслеживания привычек.  
Пользователь может фиксировать выполнение, просматривать прогресс, управлять тегами и настраивать напоминания.

## Статус проекта
### Реализовано
- **Habit**
    - Сущность `Habit`
    - DTO: `HabitCreateDto`, `HabitPatchDto`, `HabitResponseDto`.
    - Enum: `DayOfWeek`, `HabitStatus`, `ScheduleType`.
    - Репозиторий: `HabitRepository`.
    - Сервис: `HabitService`, `HabitServiceImpl`.
    - Контроллер: `HabitController`.
- **Ошибки**
    - `HabitNotFoundException`.
    - `GlobalExceptionHandler`

### Запланировано
- **User**: регистрация, авторизация (JWT), профиль.
- **Checkin**: отметки выполнения по датам.
- **Tag и HabitTag**: теги и привязка к привычкам.
- **Reminder**: напоминания для привычек.
- **Statistics**: API для отчетов и аналитики.
- **Security**: Spring Security с JWT.
- **Testing**: JUnit 5.
- **CI/CD**: GitHub Actions, Docker.

## API (частично)
Версия: `/api/v1`
- `GET /habits` - список привычек.
- `POST /habits` - создать привычку.
- `PATCH /habits/{id}` - обновить привычку.
- `POST /habits/{id}/archive` - архивировать.

## Стек технологий
- **Backend**: Java 21, Spring Boot
- **Database**: PostgreSQL
- **Testing**: JUnit 5
- **CI/CD**: GitHub Actions, Docker
- **Logging**: SLF4J

## Установка и запуск
### Локально
```bash
# Склонировать проект
git clone https://github.com/username/habit-tracker.git
cd habit-tracker

# Собрать проект
./mvnw clean package

# Запустить приложение
java -jar target/habit-tracker-0.0.1-SNAPSHOT.jar
