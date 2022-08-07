/*
    1 Выбросить случайное целое число и сохранить в i
    2 Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
    3 Найти все кратные n числа большие i и сохранить в массив m1
    4 Найти все некратные n числа меньшие i и сохранить в массив m2
    5 Сохранить оба массива в файлы с именами m1 и m2 соответственно.

      Пункты реализовать в методе main
       *Пункты реализовать в разных методах
      **Реализовать один из пунктов рекурсией
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class TaskSolution {
    public static void main(String[] args) {
        int i = random();
        int n = mostSignificantBit(i);

        int[] m1 = multiple(i, n);
        int[] m2 = notMultiple(i, n);

        writeFile(m1, "m1");
        writeFile(m2, "m2");

//        System.out.printf("i = %d, n = %d.\n", i, n);
//        for (int j = 0; j < m1.length; j++) System.out.printf("%d ", m1[j]);
//        System.out.println();
//        for (int j = 0; j < m2.length; j++) System.out.printf("%d ", m2[j]);
    }

    static int random() {
        Random r = new Random();
        int result = r.nextInt(100);
        return result;
    }

    static int mostSignificantBit(int numb) {
        int result = 0;
        for (; numb != 1; numb /= 2, result++) ;
        return result;
    }

    static int[] multiple(int numb, int bit) {
        int lenght = 0;
        for (int i = numb + 1; i <= 100; i++) {
            if (i % bit == 0) lenght++;
        }
        int[] result = new int[lenght];

        for (int i = 0, j = numb + 1; i < result.length; j++) {
            if (j % bit == 0) {
                result[i] = j;
                i++;
            }
        }
        return result;
    }

    static int[] notMultiple(int numb, int bit) {
        int lenght = 0;
        for (int i = numb + 1; i <= 100; i++) {
            if (i % bit != 0) lenght++;
        }
        int[] result = new int[lenght];

        for (int i = 0, j = numb + 1; i < result.length; j++) {
            if (j % bit != 0) {
                result[i] = j;
                i++;
            }
        }
        return result;
    }

    static void writeFile(int[] array, String name) {
        try(FileWriter file = new FileWriter(name, false)) {
            for (int i = 0; i < array.length; i++) {
                file.write(Integer.toString(array[i]));
                file.append(" ");
            }
        } catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}