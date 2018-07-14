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
curl request.txt