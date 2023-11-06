package programacion2.proyectoestructuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class ProyectoEstructurasGUI extends JFrame {

    ProyectoEstructuras pe = new ProyectoEstructuras();

    private int[] originalArray;
    private JTextArea unsortedTextArea;
    private JTextArea sortedTextArea;
    private JTextArea statisticsTextArea;

    public ProyectoEstructurasGUI() {
        initUI();
    }

    private void initUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Proyecto Estructuras GUI");
        setSize(800, 600);
        setLayout(new GridLayout(3, 2));

        // Botón para elegir el tamaño del vector
        JButton sizeButton = new JButton("Elegir Tamaño del Vector");
        sizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showSizeDialog();
            }
        });

        // Sección para mostrar el vector desordenado
        unsortedTextArea = new JTextArea();
        JScrollPane unsortedScrollPane = new JScrollPane(unsortedTextArea);
        unsortedScrollPane.setBorder(BorderFactory.createTitledBorder("Vector Desordenado"));

        // Sección para mostrar el vector ordenado
        sortedTextArea = new JTextArea();
        JScrollPane sortedScrollPane = new JScrollPane(sortedTextArea);
        sortedScrollPane.setBorder(BorderFactory.createTitledBorder("Vector Ordenado"));

        // Sección para mostrar estadísticas
        statisticsTextArea = new JTextArea();
        JScrollPane statisticsScrollPane = new JScrollPane(statisticsTextArea);
        statisticsScrollPane.setBorder(BorderFactory.createTitledBorder("Estadísticas"));

        // Agregar elementos a la ventana
        add(sizeButton);
        add(new JPanel()); // Espacio en blanco
        add(unsortedScrollPane);
        add(sortedScrollPane);
        add(statisticsScrollPane);

        // Mostrar la ventana
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void showSizeDialog() {
    String sizeInput = JOptionPane.showInputDialog("Ingrese el tamaño del arreglo:");
    try {
        int size = Integer.parseInt(sizeInput);

        if (size <= 10) {
            // El usuario ingresa manualmente los datos
            originalArray = new int[size];
            for (int i = 0; i < size; i++) {
                String elementInput = JOptionPane.showInputDialog("Ingrese el elemento " + (i + 1) + ":");
                originalArray[i] = Integer.parseInt(elementInput);
            }
        } else {
            // Se generan aleatoriamente
            originalArray = generarArregloAleatorio(size);
        }

        unsortedTextArea.setText(Arrays.toString(originalArray));

        // Ordenar y actualizar las secciones
        ordenarYActualizar();
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Ingrese un número válido.");
    }
}


    private void ordenarYActualizar() {
        int[] arrBurbuja = Arrays.copyOf(originalArray, originalArray.length);
        int[] arrSeleccion = Arrays.copyOf(originalArray, originalArray.length);
        int[] arrInsercion = Arrays.copyOf(originalArray, originalArray.length);
        int[] arrShell = Arrays.copyOf(originalArray, originalArray.length);
        int[] arrMerge = Arrays.copyOf(originalArray, originalArray.length);
        int[] arrQuick = Arrays.copyOf(originalArray, originalArray.length);

        // Obtener estadísticas del algoritmo de burbuja
        long[] estadisticasBurbuja = ordenarConBurbuja(arrBurbuja);
        long tiempoBurbuja = estadisticasBurbuja[0];
        int operacionesBurbuja = (int) estadisticasBurbuja[1];
        int comparacionesBurbuja = (int) estadisticasBurbuja[2];
        int movimientosBurbuja = (int) estadisticasBurbuja[3];

        // Obtener estadísticas del algoritmo de burbuja
        long[] estadisticasSeleccion = ordenarConSeleccion(arrSeleccion);
        long tiempoSeleccion = estadisticasSeleccion[0];
        int operacionesSeleccion = (int) estadisticasSeleccion[1];
        int comparacionesSeleccion = (int) estadisticasSeleccion[2];
        int movimientosSeleccion = (int) estadisticasSeleccion[3];

        // Obtener estadísticas del algoritmo de Insercion
        long[] estadisticasInsercion = ordenarConInsercion(arrInsercion);
        long tiempoInsercion = estadisticasInsercion[0];
        int operacionesInsercion = (int) estadisticasInsercion[1];
        int comparacionesInsercion = (int) estadisticasInsercion[2];
        int movimientosInsercion = (int) estadisticasInsercion[3];

        // Obtener estadísticas del algoritmo de shell
        long[] estadisticasShell = ordenarConShell(arrShell);
        long tiempoShell = estadisticasShell[0];
        int operacionesShell = (int) estadisticasShell[1];
        int comparacionesShell = (int) estadisticasShell[2];
        int movimientosShell = (int) estadisticasShell[3];

        // Obtener estadísticas del algoritmo de merge
        long[] estadisticasMerge = ordenarConMergeSort(arrMerge);
        long tiempoMerge = estadisticasMerge[0];
        int operacionesMerge = (int) estadisticasMerge[1];
        int comparacionesMerge = (int) estadisticasMerge[2];
        int movimientosMerge = (int) estadisticasMerge[3];
        
        // Obtener estadísticas del algoritmo de quick
        long[] estadisticasQuick = ordenarConQuickSort(arrQuick, 0, arrQuick.length - 1);
        long tiempoQuick = estadisticasQuick[0];
        int operacionesQuick = (int) estadisticasQuick[1];
        int comparacionesQuick = (int) estadisticasQuick[2];
        int movimientosQuick = (int) estadisticasQuick[3];

        // Actualizar las secciones
        sortedTextArea.setText("Burbuja: " + Arrays.toString(arrBurbuja) + "\n\n Seleccion: " + Arrays.toString(arrSeleccion) + "\n\n Insercion: " + Arrays.toString(arrInsercion)
                + "\n\n Shell: " + Arrays.toString(arrShell) + "\n\n Merge: " + Arrays.toString(arrMerge) + "\n\n Merge: " + Arrays.toString(arrQuick)
        + "\n\n Quick: " + Arrays.toString(arrQuick));

        // Mostrar estadísticas delos algoritmos
        String estadisticasBurbujaStr = "Burbuja:\n"
                + "Tiempo de ejecución: " + tiempoBurbuja + " nanosegundos\n"
                + "Operaciones: " + operacionesBurbuja + "\n"
                + "Comparaciones: " + comparacionesBurbuja + "\n"
                + "Movimientos: " + movimientosBurbuja + "\n\n";

        String estadisticasSeleccionStr = "Seleccion:\n"
                + "Tiempo de ejecución: " + tiempoSeleccion + " nanosegundos\n"
                + "Operaciones: " + operacionesSeleccion + "\n"
                + "Comparaciones: " + comparacionesSeleccion + "\n"
                + "Movimientos: " + movimientosSeleccion + "\n\n";

        String estadisticasInsercionStr = "Insercion:\n"
                + "Tiempo de ejecución: " + tiempoInsercion + " nanosegundos\n"
                + "Operaciones: " + operacionesInsercion + "\n"
                + "Comparaciones: " + comparacionesInsercion + "\n"
                + "Movimientos: " + movimientosInsercion + "\n\n";

        String estadisticasShellStr = "Shell:\n"
                + "Tiempo de ejecución: " + tiempoShell + " nanosegundos\n"
                + "Operaciones: " + operacionesShell + "\n"
                + "Comparaciones: " + comparacionesShell + "\n"
                + "Movimientos: " + movimientosShell + "\n\n";

        String estadisticasMergeStr = "Merge:\n"
                + "Tiempo de ejecución: " + tiempoMerge + " nanosegundos\n"
                + "Operaciones: " + operacionesMerge + "\n"
                + "Comparaciones: " + comparacionesMerge + "\n"
                + "Movimientos: " + movimientosMerge + "\n\n";
        
        String estadisticasQuickStr = "Quick:\n"
                + "Tiempo de ejecución: " + tiempoQuick + " nanosegundos\n"
                + "Operaciones: " + operacionesQuick + "\n"
                + "Comparaciones: " + comparacionesQuick + "\n"
                + "Movimientos: " + movimientosQuick + "\n\n";

        statisticsTextArea.setText("Estadísticas:\n\n" + estadisticasBurbujaStr + estadisticasSeleccionStr + estadisticasInsercionStr + estadisticasShellStr + estadisticasMergeStr + estadisticasQuickStr);

        // Repintar la ventana
        repaint();

    }

    private int[] generarArregloAleatorio(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        return arr;
    }

    // BURBUJA
    private long[] ordenarConBurbuja(int[] arr) {
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
        return new long[]{endTime - startTime, operaciones, comparaciones, movimientos};
    }

    // SELECCION
    private static long[] ordenarConSeleccion(int[] arr) {
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
        return new long[]{endTime - startTime, operaciones, comparaciones, movimientos};
    }

    //INSERCION
    private static long[] ordenarConInsercion(int[] arr) {
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
        return new long[]{endTime - startTime, operaciones, comparaciones, movimientos};
    }

    // SHELL
    private static long[] ordenarConShell(int[] arr) {
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
        return new long[]{endTime - startTime, operaciones, comparaciones, movimientos};
    }

    // MERGE
    private static long[] ordenarConMergeSort(int[] arr) {
        long startTime = System.nanoTime();
        long[] operaciones = new long[3]; // [Comparaciones, Movimientos, Operaciones Elementales]
        mergeSort(arr, 0, arr.length - 1, operaciones);
        long endTime = System.nanoTime();
        return new long[]{endTime - startTime, operaciones[2], operaciones[0], operaciones[1]};
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

    // QUICK SORT
    private static long[] ordenarConQuickSort(int[] arr, int low, int high) {
        long startTime = System.nanoTime();
        long[] contadores = {0, 0, 0}; // Índice 0 para movimientos, índice 1 para comparaciones, índice 2 para operaciones elementales
        quickSort(arr, low, high, contadores);
        long endTime = System.nanoTime();
        return new long[]{endTime - startTime, contadores[2], contadores[1], contadores[0]};
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
