package DZ2;

/* Задание 1. Проверка корректности даты.
Напишите метод, который проверяет, является ли введенная строка корректной
датой в формате "YYYY-MM-DD". Дата должна быть в пределах от 0001-01-01 до 9999-12-31.
Если дата корректна, возвращайте ее. Если нет - сообщение об ошибке.
 */

public class DZ2_1 {
    public static String validateDate(String date) {
try {
    //Проверка длины строки
    if (date.length() != 10) {
        return "Invalid date format. Please use YYYY-MM-DD.";
    }

    // Разделяем строку
    String yearStr = date.substring(0, 4);
    String monthStr = date.substring(5, 7);
    String dayStr = date.substring(8, 10);

    //Проверка формата разделителей
    if (date.charAt(4) != '-' || date.charAt(7)  != '-'){
        return "Invalid date format. Please use YYYY-MM-DD.";
    }

    //Преобразуем в числа
    int year = Integer.parseInt(yearStr);
    int month = Integer.parseInt(monthStr);
    int day = Integer.parseInt(dayStr);

    // Проверка диапазона год
    if (year < 1 || year > 9999) {
        return "Year out of range. Must be between 0001 and 9999.";
    }

    // Проверка диапазона месяца.
    if (month < 1 || month > 12){
        return "Month out of range. Must be between 01 and 12.";
    }

    // Проверка диапазона дня
    int [] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    if (month ==2 && isLeapYear(year)){
        daysInMonth[1] = 29; // Февраль в високосный год
    }
    if (day < 1 || day > daysInMonth[month-1]){
        return "Day out of range for the given month.";
    }

    return date;

    } catch (Exception e) {
        return "An error occured while validating the data.";
    }

    }


    private static boolean isLeapYear(int year){
        return (year %4 == 0 && year%100 != 0) || (year % 400 ==0);
    }

    public static void main(String[] args) {
        String date;
        if (args.length > 0) {
            date = args[0];
        } else {
            date = "2024-09-01"; //Значение по умолчанию
        }
        String result = validateDate(date);
        System.out.println(result);
    }
}
