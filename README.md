# Selenium Project 😐 for QA Automation

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
![Java](https://img.shields.io/badge/Java-11+-blue)
![Maven](https://img.shields.io/badge/Maven-3.9+-orange)
![Selenium](https://img.shields.io/badge/Selenium-4.16+-brightgreen)
![Test Coverage](https://img.shields.io/badge/Test_Coverage-100%25-green)

**Тестирование функционала профиля в веб-приложении Mesto**

## 🚀 Быстрый старт  
### Требования  

- MacOS (включая M1/M2)

- Java JDK 11+
- Apache Maven 3.6+
- ChromeDriver (совместимый с Chrome)  
- Git (для клонирования)

### Установка  
```bash  
git clone https://github.com/Versaria/selenium-project.git
cd selenium-project
brew install --cask chromedriver
mvn clean test -Dtest=PraktikumTest#testProfileAvatar
```

## 📂 Структура проекта  
```  
selenium-project/  
├── .gitignore                              # Игнорируемые файлы  
├── pom.xml                                 # Конфигурация Maven  
└── src/  
    └── test/  
        └── java/  
            └── com/  
                └── praktikum/  
                    └── PraktikumTest.java  # Основной тестовый класс  
```  

## 📋 Функционал  
**Изменение аватара профиля**
- Авторизация  
- Загрузка нового изображения через CSS-локатор  
- Сохранение через XPath   

## 📊 Покрытие тестами  
- **Авторизация**: 100%  
- **Профиль**: Изменение аватара   

## 💻 Пример работы  

### Изменение аватара, шаги:
1. Авторизация (`email` + `password`)
2. Клик по аватару (CSS: `.profile__image`)
3. Загрузка изображения (ID: `owner-avatar`)
4. Сохранение (XPath: `//form[@name='edit-avatar']/button[text()='Сохранить']`)

### Локаторы:
```java
By.cssSelector(".profile__image")          // Аватар
By.id("owner-avatar")                     // Поле загрузки
By.xpath("//form[@name='edit-avatar']/button[text()='Сохранить']")  // Кнопка
```

## 💻 Пример работы
```java
@Test
public void testProfileAvatar() {
    // Авторизация
    driver.findElement(By.id("email")).sendKeys("versaria.o@yandex.ru");
    driver.findElement(By.id("password")).sendKeys("qaswef-ketped-3motKo");
    driver.findElement(By.className("auth-form__button")).click();
    
    // Изменение аватара
    driver.findElement(By.cssSelector(".profile__image")).click();
    driver.findElement(By.id("owner-avatar"))
          .sendKeys("https://code.s3.yandex.net/.../avatarSelenium.png");
    driver.findElement(By.xpath(".//form[@name='edit-avatar']/button[text()='Сохранить']")).click();
}
```

## 📜 Лицензия  
MIT License  

## 🤝 Как внести вклад
1. Форкните репозиторий
2. Создайте ветку (`git checkout -b feature/new-dish`)
3. Сделайте коммит (`git commit -am 'Add new menu item'`)
4. Запушьте ветку (`git push origin feature/new-dish`)
5. Откройте Pull Request

---

<details>
<summary>🔧 Дополнительные команды</summary>

```bash
# Запуск тестов с отчетом
mvn test surefire-report:report

# Анализ кода
mvn pmd:pmd checkstyle:checkstyle
```
</details>
