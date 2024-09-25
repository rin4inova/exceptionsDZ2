package DZ2;
/* Задача 3. Сортировка массива строк.
Напишите метод, который принимает массив строк и сортирует его в алфавитном порядке.
Если входной массив null, метод должен вернуть пустой массив и вывести сообщение об ошибке.
 */

import java.util.Arrays;

public class DZ2_3 {
    public static String[] sortStrings(String[] strings) {
        try {
            if (strings == null) {
                System.out.println("Input array is null. Returning an empty array.");
                return new String[0];
            }
            Arrays.sort(strings);
            return strings;
        } catch (Exception e) {
            System.out.println("An error occured during sorting.");
            return new String[0];
        }
    }

    public static void main(String[] args) {
        String [] strings;
        if (args.length > 0) {
            strings = args[0].split(",");
        } else {
            strings = new String[]{"banana", "apple", "cherry"}; //Значение по умолчанию
        }

        String [] result = sortStrings(strings);
        System.out.println(Arrays.toString(result));
    }
}
