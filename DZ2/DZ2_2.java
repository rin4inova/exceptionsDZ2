package DZ2;
/*Проверка строки на палиндром.
Напишите метод, который проверяет, является ли введенная строка палиндромом.
Если строка палиндром, возвращайте "Palindrome".
Если нет - "Not a palindrome". */

public class DZ2_2 {
    public static boolean isPalindrome(String input) {
        try {
            //Удаляем пробелы и переводим строку в нижний регистр
            String cleanedInput = input.replace(" ","").toLowerCase();

            //Получаем длину строки
            int length = cleanedInput.length();

            //Проверяем, является ли строка палиндромом.
            for (int i =0; i < length/2; i++){
                if(cleanedInput.charAt(i) != cleanedInput.charAt(length-i-1)) {
                    return false; // Строка не является палиндромом
                }
            }
            return true; // Строка является палиндромом
        }catch (Exception e) {
            //В случае ошибки, например, если входные данные некорректны
            System.err.println("An error occured while checking for palindrome.");
        }
        return false;
    }
    public static void main(String[] args) {
        String input;
        if (args.length > 0) {
            input = args[0];
        } else {
            input = "A man a plan a canal Panama"; //Значение по умолчанию
        }
        boolean result = isPalindrome(input);
        System.out.println("Is the input a palindrome? " + result);
    }
}
