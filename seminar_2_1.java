/* 
Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), 
и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению 
приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных. 
*/
import java.util.Scanner;

public class seminar_2_1 {
    public static float getUserInput() {
        Scanner scanner = new Scanner(System.in);
        float number = 0;

        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("Введите дробное число:");
                number = Float.parseFloat(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Пожалуйста, введите дробное число.");
            }
        }

        return number;
    }

    public static void main(String[] args) {
        float input = getUserInput();
        System.out.println("Введенное число: " + input);
    }
    
}