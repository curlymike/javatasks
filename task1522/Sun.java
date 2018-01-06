package com.javarush.task.task15.task1522;

public class Sun implements Planet {
  // Приватная статическая переменная типа Sun
  // в ней будет храниться объект Sun
  // единственный его экземпляр.
  private static Sun instance;
  // Это конструктор класса и у него
  // модификатор доступа private - не public
  // или default таким образом объект невозможно
  // создать находясь "снаружи", единственный
  // способ получить объект - вызвать метод getInstance()ю
  private Sun() {
  }
  public static Sun getInstance() {
    if (instance == null) {
      // Однако находясь внутри класса
      // объект создать можно, если переменная
      // instance ещё не была инициализирована - т.е.
      // ей не присвоено значение - создаём объект
      // и присваиваем переменной instance ссылку на него.
      instance = new Sun();
    }
    return instance;
  }
}
