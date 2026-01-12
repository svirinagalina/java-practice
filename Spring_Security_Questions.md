# Spring / Security / REST / Hibernate / HTTP / Bootstrap

## Оглавление

- [Spring Security: базовые понятия](#spring-security-базовые-понятия)
- [Principal, Authorities, Authentication](#principal-authorities-authentication)
- [InMemoryAuthentication vs Basic authentication](#inmemoryauthentication-vs-basic-authentication)
- [Способы добавить секьюрность к контроллеру](#способы-добавить-секьюрность-к-контроллеру)
- [Идентификация, аутентификация, авторизация](#идентификация-аутентификация-авторизация)
- [Как достать авторизованного пользователя](#как-достать-авторизованного-пользователя)
- [Процесс логина в Spring Security](#процесс-логина-в-spring-security)
- [Основные интерфейсы Spring Security](#основные-интерфейсы-spring-security)
- [Способы аутентификации в Spring Security](#способы-аутентификации-в-spring-security)
- [Basic authentication](#basic-authentication)
- [InMemory authentication](#inmemory-authentication)
- [JWT authentication](#jwt-authentication)
- [CSRF и CORS](#csrf-и-cors)
- [Связи таблиц в Hibernate](#связи-таблиц-в-hibernate)
- [Односторонняя и двусторонняя связь](#односторонняя-и-двусторонняя-связь)
- [Lazy и Eager загрузка](#lazy-и-eager-загрузка)
- [Каскады в Hibernate и БД](#каскады-в-hibernate-и-бд)
- [Опасности каскадов на проде](#опасности-каскадов-на-проде)
- [HTTP протокол, методы, коды состояний](#http-протокол-методы-коды-состояний)
- [Идемпотентные и безопасные методы](#идемпотентные-и-безопасные-методы)
- [Разница между GET и POST](#разница-между-get-и-post)
- [Что такое REST](#что-такое-rest)
- [REST-сервисы: плюсы и минусы](#rest-сервисы-плюсы-и-минусы)
- [Форматы данных для REST](#форматы-данных-для-rest)
- [RestController vs Controller](#restcontroller-vs-controller)
- [@ResponseBody, @RequestBody, ResponseEntity](#responsebody-requestbody-responseentity)
- [Отправка REST-запроса в Spring](#отправка-rest-запроса-в-spring)
- [RestTemplate и современный клиент](#resttemplate-и-современный-клиент)
- [@RequestParam vs @PathVariable](#requestparam-vs-pathvariable)
- [Что такое AJAX / fetch](#что-такое-ajax--fetch)
- [Spring Boot: что это, плюсы-минусы](#spring-boot-что-это-плюсы-минусы)
- [Аннотация @SpringBootApplication](#аннотация-springbootapplication)
- [Spring Boot vs Spring MVC](#spring-boot-vs-spring-mvc)
- [Плюсы-минусы Spring Security](#плюсы-минусы-spring-security)
- [Bootstrap](#bootstrap)

---

## Spring Security: базовые понятия

Что такое авторизация, аутентификация.

---

## Principal, Authorities, Authentication

Объекты Principal, Authorities, Authentication.

---

## InMemoryAuthentication vs Basic authentication

Чем отличается InMemoryAuthentication от basicAuthentication?

---

## Способы добавить секьюрность к контроллеру

Как мы можем добавить секьюрность к контроллеру? (минимум 2 способа).

---

## Идентификация, аутентификация, авторизация

Чем отличаются идентификация, аутентификация и авторизация?

---

## Как достать авторизованного пользователя

Как достать авторизованного пользователя из Spring Security?

---

## Процесс логина в Spring Security

Ты находишься на главной странице, ввел свои креды- логин/ пароль и нажимаешь войти, что произойдет потом?

---

## Основные интерфейсы Spring Security

Расскажи про Spring Security. Какие основные классы и интерфейсы?  
Расскажи про: AuthenticationManager, UserDetailsService, AuthenticationProvider, FilterChainProxy, HttpSecurity, WebSecurityConfigurerAdapter.

---

## Способы аутентификации в Spring Security

Расскажи про способы аутентификации в spring security.  
Какие виды аутентификации использовал в работе?  
Basic authentication, InMemory authentication, JDBC authentication, JWT authentication.

---

## Basic authentication

Расскажи про Basic authentication. Реализация, плюсы и минусы.

---

## InMemory authentication

Расскажи про InMemory authentication.  
Отличие In Memory Authentication от basicAuthentication?

---

## JWT authentication

Расскажи про JWT authentication.

---

## CSRF и CORS

CSRF атака, CORS — что это и где используется?

---

## Связи таблиц в Hibernate

Какие связи между таблицами существуют в Hibernate?  
Связи таблиц many-to-many, one-to-one.

---

## Односторонняя и двусторонняя связь

Односторонняя и двухсторонняя связь.

---

## Lazy и Eager загрузка

Что такое Lazy и Eager?  
Когда использовать Lazy и Eager в своем проекте?

---

## Каскады в Hibernate и БД

Что такое каскады?  
Каскады: какие есть и что делают?  
Каскады в Хибернейте и в БД. В чем отличие?

---

## Опасности каскадов на проде

Какие опасности могут возникнуть при работе с каскадами на проде?

---

## HTTP протокол, методы, коды состояний

HTTP протокол.  
Коды состояния.  
Какие есть методы HTTP?

---

## Идемпотентные и безопасные методы

Идемпотентные и безопасные методы HTTP?

---

## Разница между GET и POST

В чем разница между POST и GET?

---

## Что такое REST

Что такое REST?

---

## REST-сервисы: плюсы и минусы

Rest-сервисы. Их преимущества и недостатки.

---

## Форматы данных для REST

Популярные форматы данных использующиеся в REST-сервисах.

---

## RestController vs Controller

Чем аннотация RestController отличается от Controller?

---

## @ResponseBody, @RequestBody, ResponseEntity

Что такое @ResponseBody, @RequestBody, класс ResponseEntity?

---

## Отправка REST-запроса в Spring

Как отправить REST-запрос в Spring?

---

## RestTemplate и современный клиент

RestTemplate и его методы.  
RestTemplate — устаревший способ и современный способ.

---

## @RequestParam vs @PathVariable

Чем отличается аннотация @RequestParam от @PathVariable?

---

## Что такое AJAX / fetch

Что такое AJAX/fetch? (эйджакс / фетч).

---

## Spring Boot: что это, плюсы-минусы

Что такое Spring Boot и для чего он нужен?  
Spring Boot плюсы и минусы.

---

## Аннотация @SpringBootApplication

Что из себя представляет аннотация @SpringBootApplication?  
Какие аннотации внутри @SpringBootApplication?

---

## Spring Boot vs Spring MVC

Чем отличается Spring Boot от Spring MVC?

---

## Плюсы-минусы Spring Security

Spring Security: плюсы и минусы.

---

## Bootstrap

Bootstrap — расскажи все, что знаешь.
