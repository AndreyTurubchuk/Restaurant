Задание на стажировку 
===============================
Создайте систему голосования, чтобы решить, где взять обед.
1. типа пользователей: администратор и постоянные пользователи
2. Администратор может ввести ресторан и это обеденное меню дня (обычно 2-5 предметов, только название и цена) 
3. Меню меняется каждый день (администраторы делают обновления) 
4. Пользователи могут проголосовать, в каком ресторане они хотят пообедать  
5.Только один голос подсчитывается для каждого пользователя
6. Если пользователь снова проголосовал в тот же день: Если до 11:00 мы предполагаем, что он передумал. Если это после 11:00, то уже слишком поздно, голосование не может быть изменено 
7. Каждый ресторан предлагает новое меню каждый день.

Стек используемых технологий 
===============================
REST API, Spring Boot, Spring Security, Spring Data JPA, H2, Gradle, IDEA. Для тестирования использовался curl.

Порядок запуска программы и curl запросы 
===============================
Инструкция
В приложении реализовано 2 пользователя с ролями:
Admin (Имя: admin, пароль: password)
User (Имя: user, пароль: password)
Пользователи прописаны в коде программы.
Добавление других пользователей и ролей не предусмотрено.

Для запуска программы необходимо:
1. Скачать с репозитория проект и собрать его
2. Записать текущую сессию (имя и пароль user/admin) в cookies файл.
Для  Admin
curl -i -X POST -d username=admin -d password=password -c cookies.txt  http://localhost:8080/restaurant/login

Для User
curl -X POST -d username=user -d password=password -c cookies.txt  http://localhost:8080/restaurant/login

Для администратора и пользователя реализованы следующие запросы

Запросы admin

1. Рестораны 
1.1. Показать все рестораны
curl  -X GET -b cookies.txt http://localhost:8080/restaurant/admin/rest/api/v1/restaurants

1.2. Показать ресторан 1
curl  -X GET -b cookies.txt http://localhost:8080/restaurant/admin/rest/api/v1/restaurants/1

1.3. Создать ресторан
curl -H "Content-Type: application/json" -X POST -d {\"name\":\"Spb\"} -b cookies.txt http://localhost:8080/restaurant/admin/rest/api/v1/restaurants

1.4. Редактировать ресторан 1
curl -H "Content-Type: application/json" -X PUT -d {\"restaurantId\":\"1\",\"name\":\"Moscow\",\"rating\":\"10\"} -b cookies.txt http://localhost:8080/restaurant/admin/rest/api/v1/restaurants/1


1.5. Удалить ресторан 276
curl -X DELETE -b cookies.txt http://localhost:8080/restaurant/admin/rest/api/v1/restaurants/276

2. Блюда 
2.1. Показать все блюда
curl  -X GET -b cookies.txt http://localhost:8080/restaurant/admin/rest/api/v1/dishes

2.2. Показать блюдо 255
curl -X GET -b cookies.txt http://localhost:8080/restaurant/admin/rest/api/v1/dishes/255

2.3. Создать блюдо
curl -H "Content-Type: application/json" -X POST -d {\"name\":\"FishSoup\",\"price\":\"300.0\"} -b cookies.txt http://localhost:8080/restaurant/admin/rest/api/v1/dishes

2.4. Редактировать блюдо 253
curl -H "Content-Type: application/json" -X PUT -d {\"id\":\"253\",\"name\":\"milk\",\"price\":\"20.0\"} -b cookies.txt http://localhost:8080/restaurant/admin/rest/api/v1/dishes/253

2.5. Удалить блюдо 280
curl -X DELETE -b cookies.txt -b cookies.txt http://localhost:8080/restaurant/admin/rest/api/v1/dishes/280

3. Меню ресторана
3.1. Показать все меню  всех ресторанов
curl  -X GET -b cookies.txt http://localhost:8080/restaurant/admin/rest/api/v1/menu

3.2. Показать меню  под номером 255
curl -X GET -b cookies.txt http://localhost:8080/restaurant/admin/rest/api/v1/menu/255

3.3. Добавить пустое меню  (без привязки к ресторану и без блюда) 
curl -H "Content-Type: application/json" -X POST -d {} -b cookies.txt http://localhost:8080/restaurant/admin/rest/api/v1/menu

3.4. Добавить пустое меню  с указанием ресторана (без блюда) 
curl -H "Content-Type: application/json" -X POST -d {\"restaurant\":{\"restaurantId\":\"1\",\"name\":\"Moscow\",\"rating\":\"10\"}} -b cookies.txt http://localhost:8080/restaurant/admin/rest/api/v1/menu

3.5. Добавить блюдо 279 в меню  ресторана 2 (POST)
curl -H "Content-Type: application/json" -X POST -d {\"dish\":{\"id\":\"279\",\"name\":\"FishSoup\",\"price\":\"300.0\"},\"restaurant\":{\"restaurantId\":\"2\",\"name\":\"sara\",\"rating\":\"0\"}} -b cookies.txt http://localhost:8080/restaurant/admin/rest/api/v1/menu
curl -H "Content-Type: application/json" -X POST -d {\"dish\":{\"id\":\"279\"},\"restaurant\":{\"restaurantId\":\"2\"}} -b cookies.txt http://localhost:8080/restaurant/admin/rest/api/v1/menu

3.6. Добавить блюдо 254 в меню  ресторана 3 (GET)
curl  -X GET -b cookies.txt http://localhost:8080/restaurant/admin/rest/api/v1/restaurants/3/dish/254/addDishByMenuByRestaurant

3.7. Редактировать меню  305 ресторана 3 (изменение блюда и/или ресторана) 
curl -H "Content-Type: application/json" -X PUT -d {\"restaurantMenuId\":\"305\",\"dish\":{\"id\":\"253\"},\"restaurant\":{\"restaurantId\":\"1\"}} -b cookies.txt  http://localhost:8080/restaurant/admin/rest/api/v1/menu/305

3.8. Удалить меню под номером 305
curl -X DELETE -b cookies.txt http://localhost:8080/restaurant/admin/rest/api/v1/menu/305

3.9. Показать меню ресторана 1 на сегодня
curl -X GET -b cookies.txt http://localhost:8080/restaurant/admin/rest/api/v1/restaurants/1/menuToday

3.10. Показать историю голосований (какой пользователь за какой ресторан проголосовал)
curl -X GET -b cookies.txt http://localhost:8080/restaurant/admin/rest/api/v1/voteHistory



Запросы user

1. Голосование за ресторан, где пользователь желает пообедать (если пользователь голосует повторно в тот же день с 0:00 до 11:00, то рейтинг голосования предыдущего ресторана уменьшается на единицу)
curl -X GET -b cookies.txt  http://localhost:8080/restaurant/user/rest/api/v1/restaurants/3/vote

2. Список блюд на сегодня ресторана 1
curl -X GET -b cookies.txt  http://localhost:8080/restaurant/user/rest/api/v1/restaurant/1/menuToday





Примерный порядок действий

Админ

1. Создать cookies для админа
curl -X POST -d username=admin -d password=password -c cookies.txt  http://localhost:8080/restaurant/login

2. Создать рестораны Spb1, Spb2, Spb3 
curl -H "Content-Type: application/json" -X POST -d {\"name\":\"Spb1\"} -b cookies.txt http://localhost:8080/restaurant/admin/rest/api/v1/restaurants

curl -H "Content-Type: application/json" -X POST -d {\"name\":\"Spb2\"} -b cookies.txt http://localhost:8080/restaurant/admin/rest/api/v1/restaurants

curl -H "Content-Type: application/json" -X POST -d {\"name\":\"Spb3\"} -b cookies.txt http://localhost:8080/restaurant/admin/rest/api/v1/restaurants

3. Показать все рестораны Spb1, Spb2, Spb3 
curl -X GET -b cookies.txt http://localhost:8080/restaurant/admin/rest/api/v1/restaurants

4. Создать блюда:
-  FishSoup, цена: 300
-  FishSoup2, цена: 350
-  FishSoup3, цена: 400
curl -H "Content-Type: application/json" -X POST -d {\"name\":\"FishSoup\",\"price\":\"300.0\"} -b cookies.txt http://localhost:8080/restaurant/admin/rest/api/v1/dishes

curl -H "Content-Type: application/json" -X POST -d {\"name\":\"FishSoup2\",\"price\":\"350.0\"} -b cookies.txt http://localhost:8080/restaurant/admin/rest/api/v1/dishes

curl -H "Content-Type: application/json" -X POST -d {\"name\":\"FishSoup3\",\"price\":\"400.0\"} -b cookies.txt http://localhost:8080/restaurant/admin/rest/api/v1/dishes

5. Показать все блюда:
curl  -X GET -b cookies.txt http://localhost:8080/restaurant/admin/rest/api/v1/dishes

6. Добавить блюдо в меню  ресторана 
curl -H "Content-Type: application/json" -X POST -d {\"dish\":{\"id\":\"36\"},\"restaurant\":{\"restaurantId\":\"1\"}} -b cookies.txt http://localhost:8080/restaurant/admin/rest/api/v1/menu

7. Показать все меню  всех ресторанов
curl  -X GET -b cookies.txt http://localhost:8080/restaurant/admin/rest/api/v1/menu


Пользователь

1. Создать cookies для пользователя
curl -X POST -d username=user -d password=password -c cookies.txt  http://localhost:8080/restaurant/login
2. Голосование за ресторан, где пользователь желает пообедать
curl  -X GET -b cookies.txt  http://localhost:8080/restaurant/user/rest/api/v1/restaurants/3/increase

3. Голосование за ресторан, где пользователь желает пообедать (решил проголосовать за другой ресторан)
curl  -X GET -b cookies.txt  http://localhost:8080/restaurant/user/rest/api/v1/restaurants/2/increase


Далее необходимо зайти админом и посмотреть изменение рейтинга и историю голосований. 
 curl -X GET -b cookies.txt http://localhost:8080/restaurant/admin/rest/api/v1/restaurants