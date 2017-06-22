Spring MVC with (mybatis-mysql) connection and (jquery+bootstrap) integration
========================

Если у нас на компьютере установлен git 
-------------------------
Чтобы скачать с гитхаба проект запускаем команду:
<git clone https://github.com/Temirtator/SpringMVC-mybatis-mysql-jquery-bootstrap>

Импортируем свой проект на наш IDE.

После того как вы импортировали проект, наш проект автоматически начнет скачивать зависимости с помощью Maven.


Если у нас на компьютере не установлен git 
-------------------------
На верхнем правом углу можно скачать архив проекта.

>Не забываем разархивировать проект



Настройка базы данных.
-------------------------

На файле:
>[src/main/resources/spring-config.xml], 

и

>[com.example.Main], 

нам необходимо настроить соединение к базе данных.

Там где написано в файле localhost, вы должны поменять своим локальным MySQL сервером.

>Примечание: не менять остальные переменные

Если вы настроили вашу базу и сервер успешно запущен.

Запускаем проект.
>Примечание: в процессе запуска: у вас должна запускаться установленный на IDE, сервер. 
>>На NetBeans IDE, используется GlassFish 

Откроется ваш браузер по умолчанию и зайдет на адрес 
>localhost:8080

Наслаждаемся проектом.