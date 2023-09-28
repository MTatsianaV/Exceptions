import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class seminar_3_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Введите через пробел данные (Фамилия Имя Отчество ДатаРождения НомерТелефона Пол):");
            String input = scanner.nextLine();

            String[] data = input.split(" ");
            if (data.length != 6) {
                throw new IllegalArgumentException("Неверное количество данных");
            }

            String surname = data[0];
            String name = data[1];
            String patronymic = data[2];
            String dateOfBirth = data[3];
            long phoneNumber = Long.parseLong(data[4]);
            char gender = data[5].charAt(0);

            // Проверяем формат даты рождения
            if (!dateOfBirth.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
                throw new IllegalArgumentException("Неверный формат даты рождения");
            }

            // Проверяем пол
            if (gender != 'f' && gender != 'm') {
                throw new IllegalArgumentException("Неверное значение пола");
            }

            String fileName = surname + ".txt";

            // Записываем данные в файл
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
                String output = surname + " " + name + " " + patronymic + " " + dateOfBirth + " " + phoneNumber + " " + gender;
                writer.write(output);
                writer.newLine();
                System.out.println("Данные успешно записаны в файл " + fileName);
            } catch (IOException e) {
                System.err.println("Ошибка при записи в файл:");
                e.printStackTrace();
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка в введенных данных:");
            System.err.println(e.getMessage());
        }

        scanner.close();
    }
}
