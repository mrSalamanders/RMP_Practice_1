package ru.itmo.practice1;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void bubbleSort(int[] A) {
        int n = A.length;
        int temp = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 1; j < (n - i); j++) {
                if(A[j - 1] > A[j]){
                    temp = A[j - 1];
                    A[j - 1] = A[j];
                    A[j] = temp;
                }
            }
        }
    }
    public static int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        int choose = 1;
        while (choose != 0) {
            System.out.println("Please give me task number 1-9 (0 for quit) ");
            Scanner scanner = new Scanner(System.in);
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    first();
                    break;
                case 2:
                    second();
                    break;
                case 3:
                    third();
                    break;
                case 4:
                    fourth();
                    break;
                case 5:
                    fifth();
                    break;
                case 6:
                    sixth();
                    break;
                case 7:
                    seventh();
                    break;
                case 8:
                    eighth();
                    break;
                case 0:
                    System.out.println("На нет и суда нет");
                    break;
                default:
                    System.out.println("1-9 либо 0");
                    break;
            }
        }
    }
    public static void first() {
        int n = 100;
        double[] array = new double[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random();
        }
        double max = array[0];
        double min = array[0];
        double avg = 0;
        for (int i = 0; i < array.length; i++) {
            if(max < array[i])
                max = array[i];
            if(min > array[i])
                min = array[i];
            avg += array[i] / array.length;
        }
        System.out.println("max = " + max);
        System.out.println("min = " + min);
        System.out.println("avg = " + avg);
    }
    public static void second() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please give me number N ");
        int N = scanner.nextInt();
        System.out.print("Please give me number k ");
        int k = scanner.nextInt();
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += Math.pow(i, k);
        }
        System.out.println("sum = " + sum);
    }
    public static void third() {
        int n = 50;
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(0, 100 + 1); // stack overflow
        }
        bubbleSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
    public static void fourth() {
        int i, j;
        boolean isPrime;
        for(i = 2; i < 100; i++) {
            isPrime = true;
            for (j = 2; j <= i / j; j++) // math forum
                if((i % j) == 0) {
                    isPrime = false;
                }
            if (isPrime)
                System.out.print(i + " ");
        }
    }
    public static void fifth() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please give me number fibonacci ");
        int num = scanner.nextInt();
        System.out.println("Число n фибоначчи = " + fibonacci(num));
    }
    public static void sixth() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please give me number N (size of array) ");
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            Integer ch = scanner.nextInt();
            arrayList.add(ch);
        }
        System.out.print("Please give me target number ");
        Integer target = scanner.nextInt();
        int count = 0;
        for (Integer el : arrayList) {
            if (el == target) {
                count++;
            }
        }
        for (int i = 0; i < count; i++) {
            arrayList.remove(target);
        }
        for (Integer el : arrayList) {
            System.out.print(el + " ");
        }
    }
    public static void seventh() {
        int[] a = {2, 2, 2, 3, 3, 4, 5, 5, 6};
        boolean isUn;
        for (int i = 0; i < a.length; i++) {
            isUn = true;
            for (int j = 0; j < a.length; j++) {
                if (i == j) {
                    continue;
                } else {
                    if (a[i] == a[j]) {
                        isUn = false;
                        break;
                    }
                }
            }
            if (isUn) {
                System.out.print(a[i]);
                break;
            }
        }
    }
    public static void eighth() {
        HashMap<Integer, Integer> m = new HashMap<>();
        int[] a = {2, 2, 2, 3, 3, 4, 5, 5, 6};
        Integer count = 1;
        for (int i = 0; i < a.length; i++) {
            count = 0;
            for (int j = 0; j < a.length; j++) {
                    if (a[i] == a[j]) {
                        count++;
                        m.put(a[i], count);
                    }
            }
        }
        System.out.print(m);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please give me number N ");
        int N = scanner.nextInt();

        while(m.size()>N){
            Map.Entry<Integer,Integer> min = null;
            for (Map.Entry<Integer,Integer> entry : m.entrySet()) {
                if (min == null || entry.getValue().compareTo(min.getValue()) < 0) {
                    min = entry;
                }
            }
            m.remove(min.getKey(),min.getValue());
        }

        System.out.print(m);
    }
}
