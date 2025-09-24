# Habit Tracker

Habit Tracker - это система для отслеживания привычек, фиксации прогресса и получения напоминаний.  
Проект включает backend (Java Spring), Telegram-бота (Python) и frontend (React).

---

## Функционал
- Регистрация и авторизация (JWT).
- Управление привычками: создание, редактирование, архивирование.
- Отметки выполнения с количеством и заметками.
- Теги и фильтрация привычек.
- Напоминания с временем суток.
- Просмотр статистики и прогресса.

---

## Архитектура
- **apps/backend** - серверная часть на Java + Spring Boot

- **apps/web** - фронтенд на React

- **apps/bot** - Telegram-бот (Python + aiogram)

- **docs** - документация (архитектура, схемы, API)

---

## Технологии
- **Backend**: Java, Spring Boot, JPA/Hibernate, PostgreSQL
- **Frontend**: React
- **Bot**: Python, aiogram
- **CI/CD**: GitHub Actions, Docker
- **Тесты**: JUnit 5
- **Логирование**: SLF4J

---

## Структура проекта
```
apps/
├── backend   
├── web       
├── bot     
docs/        
target/       
```

## TODO 
In progress...