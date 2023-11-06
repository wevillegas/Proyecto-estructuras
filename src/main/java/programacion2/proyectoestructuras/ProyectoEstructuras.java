package programacion2.proyectoestructuras;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ProyectoEstructuras {

    public static void main(String[] args) {
        
        //Llamo a la pantalla
        ProyectoEstructurasGUI principal = new ProyectoEstructurasGUI();
        principal.setVisible(true);
        principal.setLocationRelativeTo(null);

        
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

        System.out.println("----------------------------------------------------------------------");

        // método de selección
        int[] arrSeleccion = Arrays.copyOf(arr, arr.length);
        long tiempoSeleccion = ordenarConSeleccion(arrSeleccion);
        System.out.println("Tiempo de ejecución (selección): " + tiempoSeleccion + " nanosegundos");
        System.out.println("Selección: " + Arrays.toString(arrSeleccion));

        System.out.println("----------------------------------------------------------------------");

        // método de inserción
        int[] arrInsercion = Arrays.copyOf(arr, arr.length);
        long tiempoInsercion = ordenarConInsercion(arrInsercion);
        System.out.println("Tiempo de ejecución (inserción): " + tiempoInsercion + " nanosegundos");
        System.out.println("Inserción: " + Arrays.toString(arrInsercion));

        System.out.println("----------------------------------------------------------------------");

        // método de shell
        int[] arrShell = Arrays.copyOf(arr, arr.length);
        long tiempoShell = ordenarConShell(arrShell);
        System.out.println("Tiempo de ejecución (shell): " + tiempoShell + " nanosegundos");
        System.out.println("Shell: " + Arrays.toString(arrShell));

        System.out.println("----------------------------------------------------------------------");

        // merge sort
        int[] arrMergeSort = Arrays.copyOf(arr, arr.length);
        long tiempoMergeSort = ordenarConMergeSort(arrMergeSort);
        System.out.println("Tiempo de ejecución (Merge Sort): " + tiempoMergeSort + " nanosegundos");
        System.out.println("Merge Sort: " + Arrays.toString(arrMergeSort));

        System.out.println("----------------------------------------------------------------------");

        // Quick Sort
        int[] arrQuickSort = Arrays.copyOf(arr, arr.length);
        long tiempoQuickSort = ordenarConQuickSort(arrQuickSort, 0, arrQuickSort.length - 1);
        System.out.println("Tiempo de ejecución (Quick Sort): " + tiempoQuickSort + " nanosegundos");
        System.out.println("Quick Sort: " + Arrays.toString(arrQuickSort));

    }

    // arreglo aleatorio de tamaño n
    private static int[] generarArregloAleatorio(int n) {
        int[] arr = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(100);
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
        int movimientos = 0;
        int comparaciones = 0;

        for (int i = 0; i < n - 1; i++) {;
            operaciones += 5;
            for (int j = 0; j < n - i - 1; j++) {
                operaciones += 5;
                comparaciones++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    movimientos += 3;
                    operaciones += 10;
                }
            }
        }

        long endTime = System.nanoTime();
        System.out.println("Operaciones (burbuja): " + operaciones);
        System.out.println("Comparaciones (burbuja: )" + comparaciones);
        System.out.println("Movimientos (burbuja): " + movimientos);
        return endTime - startTime;
    }

    // método de selección
    private static long ordenarConSeleccion(int[] arr) {
        long startTime = System.nanoTime();
        int n = arr.length;
        int operaciones = 0;
        int movimientos = 0;
        int comparaciones = 0;

        for (int i = 0; i < n - 1; i++) {
            operaciones += 5;
            int minIndex = i;
            operaciones += 1;
            for (int j = i + 1; j < n; j++) {
                operaciones += 5;
                comparaciones++;
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                    operaciones += 3;
                }
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
            movimientos += 3;
            operaciones += 7;
        }

        long endTime = System.nanoTime();
        System.out.println("Operaciones (selección): " + operaciones);
        System.out.println("Comparaciones (selección: )" + comparaciones);
        System.out.println("Movimientos (selección): " + movimientos);
        return endTime - startTime;
    }

    // método de inserción
    private static long ordenarConInsercion(int[] arr) {
        long startTime = System.nanoTime();
        int n = arr.length;
        int operaciones = 0;
        int movimientos = 0;
        int comparaciones = 0;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            operaciones += 8;
            comparaciones++;

            while (j >= 0 && arr[j] > key) {

                arr[j + 1] = arr[j];
                j = j - 1;
                operaciones += 11;
                movimientos++;
                comparaciones++;
            }

            arr[j + 1] = key;
            operaciones += 2;
            movimientos++;
        }

        long endTime = System.nanoTime();
        System.out.println("Operaciones (inserción): " + operaciones);
        System.out.println("Comparaciones (inserción: )" + comparaciones);
        System.out.println("Movimientos (inserción): " + movimientos);
        return endTime - startTime;
    }

    // método de shell
    private static long ordenarConShell(int[] arr) {
        long startTime = System.nanoTime();
        int n = arr.length;
        int operaciones = 0;
        int movimientos = 0;
        int comparaciones = 0;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            operaciones += 5;
            for (int i = gap; i < n; i++) {
                operaciones += 4;
                int temp = arr[i];
                int j = i;
                movimientos++;
                operaciones += 3;

                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                    operaciones += 10;
                    movimientos++;
                    comparaciones++;
                }

                arr[j] = temp;
                operaciones += 2;
                movimientos++;
            }
        }

        long endTime = System.nanoTime();
        System.out.println("Operaciones (shell): " + operaciones);
        System.out.println("Comparaciones (shell: )" + comparaciones);
        System.out.println("Movimientos (shell): " + movimientos);
        return endTime - startTime;
    }

    // metodo Merge Sort
    private static long ordenarConMergeSort(int[] arr) {
        long startTime = System.nanoTime();
        long[] operaciones = new long[3]; // [Comparaciones, Movimientos, Operaciones Elementales]
        mergeSort(arr, 0, arr.length - 1, operaciones);
        long endTime = System.nanoTime();
        System.out.println("Operaciones Elementales (Merge Sort): " + operaciones[2]);
        System.out.println("Comparaciones (Merge Sort): " + operaciones[0]);
        System.out.println("Movimientos (Merge Sort): " + operaciones[1]);
        return endTime - startTime;
    }

    private static void mergeSort(int[] arr, int l, int r, long[] operaciones) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m, operaciones);
            mergeSort(arr, m + 1, r, operaciones);
            merge(arr, l, m, r, operaciones);
        }
    }

    private static void merge(int[] arr, int l, int m, int r, long[] operaciones) {
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
            operaciones[0]++;
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
            operaciones[1]++;
            operaciones[2] += 3;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
            operaciones[1]++;
            operaciones[2] += 2;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
            operaciones[1]++;
            operaciones[2] += 2;
        }
    }

    // método Quick Sort
    private static long ordenarConQuickSort(int[] arr, int low, int high) {
        long startTime = System.nanoTime();
        long[] contadores = {0, 0, 0}; // Índice 0 para movimientos, índice 1 para comparaciones, índice 2 para operaciones elementales
        quickSort(arr, low, high, contadores);
        long endTime = System.nanoTime();
        System.out.println("Operaciones elementales (Quick Sort): " + contadores[2]);
        System.out.println("Comparaciones (Quick Sort): " + contadores[1]);
        System.out.println("Movimientos (Quick Sort): " + contadores[0]);
        
        
        return endTime - startTime;
    }

    private static void quickSort(int[] arr, int low, int high, long[] contadores) {
        if (low < high) {
            int pi = partition(arr, low, high, contadores);
            quickSort(arr, low, pi - 1, contadores);
            quickSort(arr, pi + 1, high, contadores);
        }
    }

    private static int partition(int[] arr, int low, int high, long[] contadores) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            contadores[1]++;
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j, contadores);
            }
            contadores[2] += 1;
        }

        swap(arr, i + 1, high, contadores);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j, long[] contadores) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        contadores[0] += 3; 
        contadores[2] += 3;
    }

}
