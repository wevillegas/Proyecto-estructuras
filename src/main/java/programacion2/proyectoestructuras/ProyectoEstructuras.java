package programacion2.proyectoestructuras;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ProyectoEstructuras {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario el tamaño del arreglo
        System.out.print("Ingrese el tamaño del arreglo: ");
        int n = scanner.nextInt();

        // Crear un arreglo de n elementos
        int[] arr;
        if (n > 10) {
            arr = generarArregloAleatorio(n);
        } else {
            arr = ingresarArregloManualmente(n, scanner);
        }

        // Mostrar el arreglo original
        System.out.println("Arreglo original: " + Arrays.toString(arr));

        System.out.println("----------------------------------------------------------------------");

        // método de burbuja
        int[] arrBurbuja = Arrays.copyOf(arr, arr.length);
        long tiempoBurbuja = ordenarConBurbuja(arrBurbuja);
        System.out.println("Tiempo de ejecución (burbuja): " + tiempoBurbuja + " nanosegundos");
        System.out.println("Burbuja: " + Arrays.toString(arrBurbuja));
        System.out.println("Complejidad (burbuja) = O(n^2)");

        System.out.println("----------------------------------------------------------------------");

        // método de selección
        int[] arrSeleccion = Arrays.copyOf(arr, arr.length);
        long tiempoSeleccion = ordenarConSeleccion(arrSeleccion);
        System.out.println("Tiempo de ejecución (selección): " + tiempoSeleccion + " nanosegundos");
        System.out.println("Selección: " + Arrays.toString(arrSeleccion));
        System.out.println("Complejidad (selección) = O(n^2)");

        System.out.println("----------------------------------------------------------------------");

        // método de inserción
        int[] arrInsercion = Arrays.copyOf(arr, arr.length);
        long tiempoInsercion = ordenarConInsercion(arrInsercion);
        System.out.println("Tiempo de ejecución (inserción): " + tiempoInsercion + " nanosegundos");
        System.out.println("Inserción: " + Arrays.toString(arrInsercion));
        System.out.println("Complejidad (incerción) = O(n^2)/4");

        System.out.println("----------------------------------------------------------------------");

        // método de shell
        int[] arrShell = Arrays.copyOf(arr, arr.length);
        long tiempoShell = ordenarConShell(arrShell);
        System.out.println("Tiempo de ejecución (shell): " + tiempoShell + " nanosegundos");
        System.out.println("Shell: " + Arrays.toString(arrShell));
        System.out.println("Complejidad (shell) = O(n log n)");

        System.out.println("----------------------------------------------------------------------");

        // merge sort
        int[] arrMergeSort = Arrays.copyOf(arr, arr.length);
        long tiempoMergeSort = ordenarConMergeSort(arrMergeSort);
        System.out.println("Tiempo de ejecución (Merge Sort): " + tiempoMergeSort + " nanosegundos");
        System.out.println("Merge Sort: " + Arrays.toString(arrMergeSort));
        System.out.println("Complejidad (Merge sort) = O(n log n)");

        System.out.println("----------------------------------------------------------------------");

        // Quick Sort
        int[] arrQuickSort = Arrays.copyOf(arr, arr.length);
        long tiempoQuickSort = ordenarConQuickSort(arrQuickSort, 0, arrQuickSort.length - 1);
        System.out.println("Tiempo de ejecución (Quick Sort): " + tiempoQuickSort + " nanosegundos");
        System.out.println("Quick Sort: " + Arrays.toString(arrQuickSort));
        System.out.println("Complejidad (Quick sort) = O(n^2) en el peor de los casos. O(n log n) en el promedio de los casos");

    }

    // arreglo aleatorio de tamaño n
    private static int[] generarArregloAleatorio(int n) {
        int[] arr = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(1000);
        }
        return arr;
    }

    // ingresar manualmente los elementos del arreglo
    private static int[] ingresarArregloManualmente(int n, Scanner scanner) {
        int[] arr = new int[n];
        System.out.println("Ingrese los elementos del arreglo uno por uno:");
        for (int i = 0; i < n; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    // método de burbuja
    private static long ordenarConBurbuja(int[] arr) {
        long startTime = System.nanoTime();
        int n = arr.length;
        int operaciones = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                operaciones += 1; // Comparación

                if (arr[j] > arr[j + 1]) {
                    operaciones += 3; // Intercambio
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        long endTime = System.nanoTime();
        System.out.println("Operaciones (burbuja): " + operaciones);
        return endTime - startTime;
    }

    // método de selección
    private static long ordenarConSeleccion(int[] arr) {
        long startTime = System.nanoTime();
        int n = arr.length;
        int operaciones = 0;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                operaciones += 1;

                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            operaciones += 3;
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }

        long endTime = System.nanoTime();
        System.out.println("Operaciones (selección): " + operaciones);
        return endTime - startTime;
    }

    // método de inserción
    private static long ordenarConInsercion(int[] arr) {
        long startTime = System.nanoTime();
        int n = arr.length;
        int operaciones = 0;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            operaciones += 1;
            while (j >= 0 && arr[j] > key) {
                operaciones += 2;
                arr[j + 1] = arr[j];
                j = j - 1;
            }

            operaciones += 1;
            arr[j + 1] = key;
        }

        long endTime = System.nanoTime();
        System.out.println("Operaciones (inserción): " + operaciones);
        return endTime - startTime;
    }

    // método de shell
    private static long ordenarConShell(int[] arr) {
        long startTime = System.nanoTime();
        int n = arr.length;
        int operaciones = 0;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;

                operaciones += 1; 
                while (j >= gap && arr[j - gap] > temp) {
                    operaciones += 3; 
                    arr[j] = arr[j - gap];
                    j -= gap;
                }

                operaciones += 1; 
                arr[j] = temp;
            }
        }

        long endTime = System.nanoTime();
        System.out.println("Operaciones (shell): " + operaciones);
        return endTime - startTime;
    }

    // metodo Merge Sort
    private static long ordenarConMergeSort(int[] arr) {
        long startTime = System.nanoTime();
        long operaciones = mergeSort(arr, 0, arr.length - 1);
        long endTime = System.nanoTime();
        System.out.println("Operaciones (Merge Sort): " + operaciones);
        return endTime - startTime;
    }

    private static long mergeSort(int[] arr, int l, int r) {
        long operaciones = 0;
        if (l < r) {
            int m = (l + r) / 2;
            operaciones += mergeSort(arr, l, m);
            operaciones += mergeSort(arr, m + 1, r);
            operaciones += merge(arr, l, m, r);
        }
        return operaciones;
    }

    private static long merge(int[] arr, int l, int m, int r) {
        long operaciones = 0;
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            operaciones += 1;
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }

        return operaciones;
    }

    // método Quick Sort
    private static long ordenarConQuickSort(int[] arr, int low, int high) {
        long startTime = System.nanoTime();
        long operaciones = quickSort(arr, low, high, 0);
        long endTime = System.nanoTime();
        System.out.println("Operaciones (Quick Sort): " + operaciones);
        return endTime - startTime;
    }

    private static long quickSort(int[] arr, int low, int high, long operaciones) {
        if (low < high) {
            int pi = partition(arr, low, high);
            operaciones++;
            operaciones = quickSort(arr, low, pi - 1, operaciones);
            operaciones = quickSort(arr, pi + 1, high, operaciones);
        }
        return operaciones;
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
