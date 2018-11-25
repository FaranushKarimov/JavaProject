package lesson2;

import java.util.Arrays;

public class MagicMatrix {

    private int[][] mas = {{2,7,6},{9,5,1},{4,3,8}};
    private int f_sum;

    public MagicMatrix() {

        f_sum = sum(Arrays.copyOf(mas[0], mas[0].length));
    }

    //метод генерации рандомной матрицы
    public void gen_matrix(int str, int stb) {

        mas = new int[str][stb];

        for(int i = 0; i < str; i++)
            for(int j = 0; j < stb; j++)
                mas[i][j] = (int) (Math.random() * 100);
    }

    //метод суммирования элементов переданного массива
    public int sum(int... numbers){

        if(numbers == null) {
            return 0;
        }

        int result = 0;
        for(int number: numbers){

            result += number;
        }

        return result;
    }

    //метод определяющий является ли заданная матрица магическим квадратом
    public boolean magic_square() {

        if(comparing_strings())
            return false;

        if(comparison_of_columns())
            return false;

        if(diagonal_matrices())
            return false;

        return true;
    }

    //метод сравнивающий суммы элементов каждой строки матрицы
    public boolean comparing_strings() {

        for(int[] temp : mas) {

            int value = sum(temp);

            if(f_sum != value) {
                return true;
            }
        }

        return false;
    }

    //метод сравнивающий суммы элементов каждого столбца матрицы
    public boolean comparison_of_columns() {

        for(int i = 0; i < mas.length; ++i) {

            int[] temp = new int[mas[i].length];
            for(int j = 0; j < mas[i].length; ++j) {

                temp[j] = mas[j][i];
            }

            int value = sum(temp);

            if(f_sum != value) {
                return true;
            }

            temp = null;
        }

        return false;
    }

    //метод сравнивающий суммы элементов главной и побочной диагоналей матрицы
    public boolean diagonal_matrices() {

        int[] temp = new int[mas.length];
        for(int i = 0; i < mas.length; ++i)
            temp[i] = mas[i][i];

        int value = sum(temp);

        if(f_sum != value) {
            return true;
        }

        temp = new int[mas.length];

        for(int i = 0, j = mas.length - 1; i < mas.length; ++i, --j)
            temp[i] = mas[i][j];

        value = sum(temp);

        if(f_sum != value) {
            return true;
        }

        return false;
    }

    //тест
    public static void main(String[] args)  {

        boolean AllFlag = false;
        MagicMatrix test = new MagicMatrix();

        AllFlag = test.magic_square();

        if(AllFlag)
            System.out.println("Это магический квадрат!");
        else
            System.out.println("Это не магический квадрат!");
    }
}