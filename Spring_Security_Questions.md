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

Аутентификация — это процесс проверки личности пользователя (логин/пароль, токен, биометрия), система отвечает на вопрос «кто это?», и это всегда первый шаг.
​

Авторизация — это процесс проверки прав уже аутентифицированного пользователя, система решает «что этому пользователю разрешено делать» на основе ролей и правил доступа.
​
## Principal, Authorities, Authentication

Объекты Principal, Authorities, Authentication.

Principal, Authorities и Authentication — это три связанных объекта, которые описывают «кто залогинен» и «какие у него права» в Spring Security.

Principal
Principal — это «кто залогинен», уникальная личность пользователя в системе.
​

В Spring Security чаще всего это объект UserDetails или имя пользователя, который лежит внутри Authentication.getPrincipal().
​

Authorities
Authorities — это список прав/ролей пользователя, то, что ему «разрешено». Хранятся как коллекция GrantedAuthority.
​

Примеры значений: "ROLE_USER", "ROLE_ADMIN", отдельные права типа "READ_REPORTS", берутся из Authentication.getAuthorities().
​

Authentication
Authentication — это объект, который описывает текущего аутентифицированного пользователя: principal, credentials (пароль/токен), authorities, флаг isAuthenticated.
​

После логина Spring кладёт Authentication в SecurityContextHolder, и дальше по нему выполняется авторизация запросо

## InMemoryAuthentication vs Basic authentication

Чем отличается InMemoryAuthentication от basicAuthentication?

InMemoryAuthentication — это способ настроить пользователей и роли в оперативной памяти (через InMemoryUserDetailsManager), то есть где и как мы храним учётки.
​

Basic authentication — это протокол уровня HTTP (через httpBasic()), который определяет, как браузер/клиент передаёт логин/пароль на сервер в заголовке Authorization

## Способы добавить секьюрность к контроллеру

Как мы можем добавить секьюрность к контроллеру? (минимум 2 способа).

К контроллеру можно «прикрутить» секьюрность как через конфиг HttpSecurity, так и через аннотации на самих методах/классе.
​

Через HttpSecurity (URL‑правила)
В конфигурации пишем правила для путей контроллера, например: http.authorizeHttpRequests(auth -> auth.requestMatchers("/admin/**").hasRole("ADMIN").anyRequest().authenticated());.
​

Здесь доступ к методам контроллера ограничивается по URL‑паттернам и ролям/authorities, без аннотаций на самих методах.
​

Через метод‑level аннотации
Включаем методовую безопасность (@EnableMethodSecurity / @EnableGlobalMethodSecurity(prePostEnabled = true)) и вешаем на контроллер: @PreAuthorize("hasRole('ADMIN')"), @Secured("ROLE_ADMIN"), @RolesAllowed("ADMIN").
​

Тогда доступ к конкретному методу контроллера решается по выражению в аннотации, а не только по URL в конфиге.


## Идентификация, аутентификация, авторизация

Чем отличаются идентификация, аутентификация и авторизация?

Идентификация — пользователь объявляет систему, кто он (логин/ID).
​

Аутентификация — система проверяет, что этот пользователь подлинный (пароль, MFA и т.п.).
​

Авторизация — система определяет, что этому пользователю разрешено делать после успешной аутентификации.

## Как достать авторизованного пользователя

Как достать авторизованного пользователя из Spring Security?

Авторизованного пользователя можно получить из SecurityContextHolder или прямо в аргументах контроллера через Principal / Authentication / @AuthenticationPrincipal.
​

Через SecurityContextHolder
В любом бине/сервисе:

java
Authentication auth = SecurityContextHolder.getContext().getAuthentication();
Object principal = auth.getPrincipal(); // UserDetails или ваш User
Здесь principal — текущий залогиненный пользователь.
​

В контроллере через аргументы метода
Через Principal или Authentication:

java
@GetMapping("/me")
public String me(Principal principal) {
    return principal.getName();
}
java
@GetMapping("/me")
public String me(Authentication auth) {
    return auth.getName(); // или (UserDetails) auth.getPrincipal()
}
  

Через @AuthenticationPrincipal (сразу ваш UserDetails / User):

java
@GetMapping("/me")
public String me(@AuthenticationPrincipal MyUserDetails user) {
    return user.getUsername();
}

## Процесс логина в Spring Security

Ты находишься на главной странице, ввел свои креды- логин/ пароль и нажимаешь войти, что произойдет потом?

После нажатия «Войти» запрос проходит через фильтры Spring Security, где из формы берут логин/пароль, проверяют их через AuthenticationManager, и при успехе в SecurityContext кладут Authentication текущего пользователя и редиректят на защищённую страницу.
​

По шагам (интервью‑вариант)
Запрос POST /login попадает в цепочку фильтров и перехватывается UsernamePasswordAuthenticationFilter, который достаёт username и password из запроса и создаёт UsernamePasswordAuthenticationToken (ещё не аутентифицированный).
​

Этот токен передаётся в AuthenticationManager → подходящий AuthenticationProvider (обычно DaoAuthenticationProvider) через UserDetailsService находит пользователя, сравнивает пароль; при успехе создаётся аутентифицированный Authentication, который сохраняется в SecurityContextHolder, создаётся/обновляется сессия, и пользователь перенаправляется на нужную страницу (например, / или last requested URL).
​

## Основные интерфейсы Spring Security

Расскажи про Spring Security. Какие основные классы и интерфейсы?  

Spring Security — это набор фильтров и core‑интерфейсов (Authentication, AuthenticationManager, AuthenticationProvider, UserDetailsService), который обрабатывает HTTP‑запросы через FilterChainProxy и конфигурируется через HttpSecurity/SecurityFilterChain


Расскажи про: AuthenticationManager, UserDetailsService, AuthenticationProvider, FilterChainProxy, HttpSecurity, WebSecurityConfigurerAdapter.

AuthenticationManager
Это центральный интерфейс, который принимает Authentication (с логином/паролем) и возвращает аутентифицированный объект или кидает AuthenticationException.
​

Под капотом чаще всего это ProviderManager, который делегирует проверку одному или нескольким AuthenticationProvider.
​

UserDetailsService
Это DAO для пользователей: по username возвращает UserDetails (логин, пароль, роли), сам не аутентифицирует.
​

Обычно используется внутри DaoAuthenticationProvider, который спрашивает UserDetailsService пользователя и уже сравнивает пароли.
​

AuthenticationProvider
Отвечает за реальную проверку логина/пароля (или токена): принимает Authentication, валидирует данные и возвращает аутентифицированный Authentication.
​

Типичный пример — DaoAuthenticationProvider, который через UserDetailsService достаёт пользователя и сверяет пароль.
​

FilterChainProxy
Специальный Filter, который держит список SecurityFilterChain и решает, какие security‑фильтры выполнить для конкретного запроса.
​

Работает как «ворота»: получает запрос от DelegatingFilterProxy, подбирает подходящую цепочку и поочерёдно запускает фильтры (authentication, CSRF, session и т.д.).
​

HttpSecurity
Fluent‑API для настройки правил безопасности: какие URL защищены, какие роли нужны, какой тип логина (formLogin, httpBasic, JWT и т.п.).
​

На базе конфигурации HttpSecurity строится SecurityFilterChain, который потом использует FilterChainProxy.
​

WebSecurityConfigurerAdapter
Старый базовый класс, который раньше расширяли (extends WebSecurityConfigurerAdapter) и переопределяли методы configure(HttpSecurity) и configure(AuthenticationManagerBuilder).
​

Начиная с Spring Security 5.7 помечен deprecated; вместо него рекомендуют компонентный стиль: бины SecurityFilterChain (с HttpSecurity) и, при необходимости, WebSecurityCustomizer

## Способы аутентификации в Spring Security

Расскажи про способы аутентификации в spring security.  
Какие виды аутентификации использовал в работе?  
Basic authentication, InMemory authentication, JDBC authentication, JWT authentication.

В Spring Security много способов аутентификации, но все они сводятся к тому, откуда берутся пользователи и как клиент передаёт свои креды.
​

Basic authentication
Клиент на каждый запрос шлёт логин/пароль в заголовке Authorization: Basic <base64(username:password)>, а Spring Security через настроенный UserDetailsService/AuthenticationProvider их проверяет.
​

Плюсы: очень просто настроить, хорошо подходит для REST‑API и тестов; минусы: нужно обязательно HTTPS, логин/пароль летят в каждом запросе, нет «выхода» как такового (отвязано от сессии браузера).
​

InMemory authentication
Пользователи и роли хранятся в памяти приложения через InMemoryUserDetailsManager (inMemoryAuthentication()), без базы данных.
​

Подходит для демо, учебных проектов, быстрого прототипа; минусы: данные теряются при рестарте, нельзя масштабировать на прод, неудобно управлять реальными пользователями.
​

JDBC authentication
Пользователи и их роли хранятся в базе данных; Spring Security через JdbcUserDetailsManager или кастомный UserDetailsService читает их по JDBC.
​

Можно использовать дефолтную схему (users / authorities) или свои таблицы с настройкой usersByUsernameQuery и authoritiesByUsernameQuery; это уже реальный прод‑вариант с централизованным хранением учёток.
​
​

JWT authentication
Клиент один раз логинится (формой или basic), сервер выдаёт подписанный JWT‑токен, дальше клиент шлёт его в заголовке Authorization: Bearer <token> на каждый запрос.
​

Spring Security на стороне ресурса проверяет подпись, срок действия и создаёт JwtAuthenticationToken, который кладётся в SecurityContextHolder без серверной сессии.
​

Плюсы: stateless, хорошо для распределённых микросервисов и SPA; минусы: сложнее настроить, нужно аккуратно хранить и ревокировать токены.
​

Как можно сказать на интервью
В проектах можно отметить, что использовались:

Basic authentication — для простых REST‑эндпоинтов и тестирования.
​

In‑memory authentication — в учебных/демо‑проектах для быстрой настройки пользователей без БД.
​

JDBC authentication — когда пользователи хранились в реляционной БД и подгружались через JdbcUserDetailsManager или кастомный UserDetailsService.
​

JWT authentication — для REST‑сервиса без сессий, где клиент после логина работал с Bearer‑токеном в заголовках запросов.
не 

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

Lazy и Eager — это стратегии загрузки связанных сущностей: Lazy грузит их «по требованию», Eager — сразу вместе с родительской сущностью.
​

Что такое Lazy и Eager
Lazy (FetchType.LAZY) — связанный объект/коллекция не загружается сразу; Hibernate подставляет прокси и делает отдельный запрос в БД, когда ты впервые обращаешься к геттеру (user.getOrders()).
​

Eager (FetchType.EAGER) — связанный объект/коллекция загружается немедленно при загрузке «родителя», обычно через join‑запрос(ы).
​

Когда использовать Lazy
Если связь не всегда нужна (например, у User коллекция orders, которую открывают только на отдельной странице).
​

Если это большие коллекции (@OneToMany, @ManyToMany) — чтобы не тянуть тысячи строк каждый раз и не убивать производительность.
​

Когда использовать Eager
Если связанный объект маленький и почти всегда нужен для бизнес‑логики, например @ManyToOne User -> Role или обязательный Profile для User.
​

Удобно, когда важно избежать LazyInitializationException вне сессии и ты уверен, что лишних данных немного.

## Каскады в Hibernate и БД

Что такое каскады?  
Каскады: какие есть и что делают?  
Каскады в Хибернейте и в БД. В чем отличие?

Каскады — это правило «если что‑то сделал с родителем, автоматически сделай то же с детьми», но в Hibernate это работает на уровне объектов, а в БД — на уровне строк таблиц.
​

Что такое каскады в Hibernate/JPA
В Hibernate/JPA каскад говорит, какие операции над сущностью нужно автоматически распространить на связанные сущности (child).
​

Основные типы (JPA CascadeType):

PERSIST — при save/persist родителя сохраняются и новые дети.
​

MERGE — при merge/update родителя обновляются и дети.
​

REMOVE — при delete родителя удаляются дети.
​

REFRESH — при refresh родителя перечитываются и дети.
​

DETACH — при detach родителя из контекста отцепляются и дети.
​

ALL — шорткат для всех операций выше.
​

Каскады в базе данных
В реляционной БД каскады задаются в FOREIGN KEY: ON DELETE CASCADE, ON UPDATE CASCADE и т.п.
​
​

Например, если удалить строку в таблице orders с ON DELETE CASCADE, СУБД сама удалит все связанные строки из order_items.
​
​

В чем отличие Hibernate‑каскадов от каскадов в БД
Hibernate‑каскады работают внутри ORM: решают, какие сущности ещё передать в EntityManager/Session для persist/merge/remove, и генерируют соответствующие SQL.
​

Каскады в БД выполняет сама СУБД при выполнении SQL, независимо от Hibernate: приложение послало DELETE родителя, база сама удаляет детей по ON DELETE CASCADE, даже если в коде нет каскада.
​
​

Обычно:

для жизненного цикла сущностей (сохранить/обновить/удалить вместе) используют каскады Hibernate/JPA;
​

для целостности данных и «глубокой» очистки на уровне таблиц — каскады в БД (foreign key с ON DELETE CASCADE).
​​
## HTTP протокол, методы, коды состояний

HTTP протокол.  
Коды состояния.  
Какие есть методы HTTP?

HTTP — это протокол прикладного уровня для обмена данными между клиентом (обычно браузером) и сервером по схеме «запрос‑ответ»; он статeless, каждый запрос независим.
​

HTTP протокол
Используется для передачи HTML, JSON, картинок, видео и т.д. поверх TCP (в вебе — чаще HTTPS).
​

Клиент формирует HTTP‑запрос (метод, URL, заголовки, опционально тело), сервер отвечает HTTP‑ответом (статус‑код, заголовки, тело).
​

Коды состояния
Коды делятся на 5 классов.
​

1xx — информационные (почти не используются в обычных API). Пример: 100 Continue.
​

2xx — успех. 200 OK, 201 Created, 204 No Content.
​

3xx — редиректы. 301 Moved Permanently, 302 Found, 304 Not Modified.
​

4xx — ошибки клиента. 400 Bad Request, 401 Unauthorized, 403 Forbidden, 404 Not Found.
​

5xx — ошибки сервера. 500 Internal Server Error, 502 Bad Gateway, 503 Service Unavailable.
​

Основные методы HTTP
GET — получить ресурс, без изменения состояния на сервере; чаще всего используется для чтения данных.
​

POST — создать ресурс или выполнить действие с телом запроса (форма логина, создание сущности и т.п.).
​

PUT — полностью обновить ресурс по заданному URL (часто «создать или заменить»).
​

PATCH — частично обновить ресурс (изменить только часть полей).
​

DELETE — удалить ресурс.
​

HEAD — как GET, но без тела ответа (только заголовки, например, чтобы узнать размер/наличие).
​

OPTIONS — узнать, какие методы и опции поддерживает сервер/ресурс (часто в контексте CORS).
​

TRACE/CONNECT — служебные, используются редко (диагностика, прокси‑туннели)

## Идемпотентные и безопасные методы

Идемпотентные и безопасные методы HTTP?

Безопасные методы ничего не меняют на сервере, а идемпотентные при многократном повторении дают тот же результат, что и один раз.

Они пересекаются, но не одинаковые: все безопасные методы идемпотентны, но не все идемпотентные — безопасные.
​

Безопасный метод = не должен менять состояние на сервере. Пример: GET, HEAD, OPTIONS, TRACE — только читают.
​

Идемпотентный метод = сколько ни повторяй, состояние ресурса после 1‑го и 10‑го вызова одинаковое. Пример: PUT и DELETE изменяют данные (то есть не безопасны), но считаются идемпотентными: второй такой же DELETE уже ничего нового не удалит, второй такой же PUT просто перезапишет теми же данными.

## Разница между GET и POST

В чем разница между POST и GET?

Главная разница: GET — для чтения, параметры в URL и запрос считается безопасным/идемпотентным; POST — для изменения/создания, данные в теле и запрос неидемпотентный.
​

GET
Используется для чтения ресурса, без изменения состояния на сервере (safe + идемпотентный).
​

Данные передаются в query‑параметрах URL (/users?name=Anna), легко кешируется и логируется, есть ограничения по длине URL.
​

POST
Используется для создания ресурса или выполнения действия с побочными эффектами (не безопасен и обычно неидемпотентен: два одинаковых POST могут создать два заказа).
​

Данные отправляются в теле запроса (JSON/форма), URL не раздувается, такие запросы по умолчанию не кешируются

## Что такое REST

Что такое REST?

REST — это архитектурный стиль построения веб‑сервисов, где всё представлено как ресурсы с URL, а операции над ними выполняются стандартными HTTP‑методами (GET, POST, PUT, DELETE и т.д.).
​

Суть REST
Ресурсы (user, order, product) доступны по понятным URI: /users, /users/1/orders/5.
​

Действие определяется HTTP‑методом: GET — читать, POST — создавать, PUT/PATCH — обновлять, DELETE — удалять

REST — это когда ты строишь API как «таблицу в базе по HTTP»: у тебя есть ресурсы (users, orders) с понятными URL, и над ними ты делаешь стандартные HTTP‑операции — GET читать, POST создавать, PUT/PATCH обновлять, DELETE удалять. Сервер при этом не обязан помнить «предыдущий шаг» клиента: каждый запрос сам содержит всё нужное (URL, метод, тело, заголовки), и по одному только этому запросу сервер может понять, что сделать и какой ответ вернуть.

REST — это когда ты делаешь API «как таблицу в базе по HTTP», а не‑REST — когда у тебя просто «набор функций по HTTP».
​

REST: есть ресурс users.

GET /users — список

POST /users — создать

GET /users/1 — получить

PUT /users/1 — обновить

DELETE /users/1 — удалить.
​

Не‑REST:

POST /getAllUsers

POST /createNewUser

POST /deleteUserById — урлы как имена функций, всё через POST, структура не как «ресурсы + стандартные методы», а как произвольный RPC.



## REST-сервисы: плюсы и минусы

Rest-сервисы. Их преимущества и недостатки.

REST‑сервис — это API «ресурсы + HTTP‑методы», который общается по HTTP (чаще JSON) и соблюдает REST‑принципы.
​

Преимущества
Простота и понятность. Читаемые URL и стандартные методы (GET/POST/PUT/DELETE) упрощают разработку и поддержку.
​

Лёгкий и быстрый. Использует HTTP, не тянет тяжёлые протоколы, хорошо подходит для веба и мобилок.
​

Масштабируемость и stateless. Каждый запрос самодостаточен, серверу проще масштабироваться горизонтально; кэширование по HTTP повышает производительность.
​

Гибкость. Можно передавать JSON, XML и другие форматы; работает с любыми языками и платформами.
​

Недостатки
Овер‑ и андер‑фетчинг. Иногда приходится тянуть больше полей, чем нужно, или делать несколько запросов, чтобы собрать нужные данные.
​

Сложное версионирование. При росте системы появляются разные версии эндпоинтов, которые сложно поддерживать.
​

Ограничения для сложных сценариев. Не все операции естественно ложатся на CRUD по ресурсам, иногда RPC/GraphQL удобнее.

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
