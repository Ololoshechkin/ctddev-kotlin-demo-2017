[![Build status](https://travis-ci.org/anton-bannykh/ctddev-kotlin-demo-2017.svg?branch=master)](https://travis-ci.org/anton-bannykh/ctddev-kotlin-demo-2017)

# Описание

Репозиторий предназначен для знакомства студентов второго курса КТ с основами языка [Kotlin](kotlinlang.org)

[Google Doc c баллами](https://docs.google.com/spreadsheets/d/1rpBErIUVnsn0_QTr-PFzxGzP3exrx2vTqB1tMRyDSB8/edit?usp=sharing)

# Инструкция

1. Основы
  * Создайте issue в этом репозитории с указанием имени и фамилии на английском языке.
    Это необходимо для создания ветки в формате `"$name-$surname"`, в которую Вы будете отправлять pull request-ы.
    Также укажите выбранный алгоритм.
  * Убедитесь, что `./gradlew check` собирает проект и запускает тесты (`gradlew.bat check` для Windows).
  * Реализуйте этот алгоритм на языке Kotlin (можно прямо в `Main.kt`).
  * Напишите тесты к нему (можно не очень сложные).
  * Создайте pull request в ветку `"$name-$surname"`
2. Реализовано : 
  * алгоритм Куна
  * поиск Эйлерова пути
  * алгоритм разбиения на мин. число путей ациклического ор. графа (на основе алгоритма Куна)
  * алгоритм разбиения на мин. число путей произвольного неор. графа (с помощью эйлерова пути).
  * Для ориентированного графа с циклами задача является NP-полной.
  * Написаны тесты для каждогй из компонент проекта.

# Разное

## Gradle

Полезные команды

* `./gradlew assemble` собрать проект
* `./gradlew test` собрать и запустить тесты
* `./gradlew check` собрать, запустить все проверки (тесты и style-checker)
* `./gradlew ktlintCheck` запустить style-checker (ошибки в `build/reports/ktlint`)
* `./gradlew ktlintFormat` попытаться отформатировать код (работает не всегда :-( )
