Модульная архитектура выбрана просто с целью изучения данной темы

### todo:
- спрятать секреты из [application.yml](jack-and-jill-root/src/main/resources/application.yml)
- спрятать секреты из настроек плагина liquibase[build.gradle](jack-and-jill-entity/build.gradle)
- добавить лицензию [LICENCE](LICENCE)
- проверить какие именно эндпоинты нужно добавить в вайтлист без авторизации в [SecurityConfig.java](jack-and-jill-api/src/main/java/org/elena/api/config/SecurityConfig.java)
- проверить где именно должны стоять аннотации @EnableWebSecurity и @EnableMethodSecurity и для чего они нужны:
  - [SecurityConfig.java](jack-and-jill-api/src/main/java/org/elena/api/config/SecurityConfig.java)
  - [SecurityConfiguration.java](jack-and-jill-security/src/main/java/org/elena/auth/SecurityConfiguration.java)
- тесты
- удалить ненужные блоки из файлов build.gradle
