import java.util.Scanner;

public class Cat {
    private static final String[] months = {
            "января",
            "февраля",
            "марта",
            "апреля",
            "мая",
            "июня",
            "июля",
            "августа",
            "сентября",
            "октября",
            "ноября",
            "декабря"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueInput = true;

        while (continueInput) {
            System.out.println("Введите дату в формате mm/dd/yyyy (например, 01/10/2020) или 'exit' для выхода: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                continueInput = false;
                continue;
            }

            String[] parts = input.split("/");
            if (parts.length == 3) {
                int month = Integer.parseInt(parts[0]);
                int day = Integer.parseInt(parts[1]);
                int year = Integer.parseInt(parts[2]);

                if (isValidDate(day, month, year)) {
                    String monthName = months[month - 1];
                    System.out.println(day + " " + monthName + " " + year + " года");
                } else {
                    System.out.println("Некорректная дата или формат. Пожалуйста, введите корректную дату.");
                }
            } else {
                System.out.println("Некорректный формат. Пожалуйста, введите дату в формате mm/dd/yyyy.");
            }
        }

        System.out.println("Программа завершена.");
    }

    private static boolean isValidDate(int day, int month, int year) {
        if (year < 0 || year > 9999) return false;
        if (month < 1 || month > 12) return false;
        int maxDay = 31; // Максимальное количество дней в месяце (по умолчанию 31)

        if (month == 4 || month == 6 || month == 9 || month == 11) {
            maxDay = 30;
        } else if (month == 2) {
            if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                maxDay = 29; // Високосный год
            } else {
                maxDay = 28; // Невисокосный год
            }
        }

        return day >= 1 && day <= maxDay;
    }
}
