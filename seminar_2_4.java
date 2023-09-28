import java.util.Scanner;
public class seminar_2_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Введите строку: ");
            String input = scanner.nextLine();
            
            if (input.isEmpty()) {
                throw new IllegalArgumentException("Пустые строки вводить нельзя!");
            }
            
            System.out.println("Вы ввели: " + input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
        scanner.close();
    }
    
}
