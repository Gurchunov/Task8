package com.company.teachmeskills;

import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите логин:");
        String login = scanner.nextLine();
        System.out.println("Введите пароль:");
        String password = scanner.nextLine();
        System.out.println("Введите пароль еще раз:");
        String confirmPassword = scanner.nextLine();
        cheсkData(login, password, confirmPassword);
    }

    static boolean cheсkData(String login, String password, String confirmPassword) {
        String PATTERN = "\\w";

        try {
            if (login == null || login.length() == 0 || login.matches(PATTERN) || login.length() >= 20) {
                throw new WrongLoginException("логин не соотвествует требованиям");
            }
            if (password == null || password.length() == 0 || password.matches(PATTERN) || password.length() >= 20) {
                throw new WrongPasswordException("пароль не соотвествует требованиям");
            }
            if (!password.contains(confirmPassword)) {
                throw new WrongPasswordException("пароли не верны");
            }
        } catch (WrongLoginException | WrongPasswordException exception) {
            System.out.println(exception.getMessage());
            return false;
        }
        return true;
    }
}
