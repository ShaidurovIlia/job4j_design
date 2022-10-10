package ru.job4j.ocp;

public class NotificationService {
    public void getMessage(String typeMessage, String message) {
        if (typeMessage.equals("email")) {
            System.out.println("write email" + message);
        }
        if (typeMessage.equals("sms")) {
            System.out.println("write sms" + message);
        }
    }
}
/**
 * Класс получения сообщения по типу, добавляя логику нарушаем принцып OCP,
 * изменяем класс, а не расширяем его.
 */
