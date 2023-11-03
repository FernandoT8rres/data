package Burbuja;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class App {

    private static int[] arr; 

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ordenamiento de arreglos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Tamaño del arreglo:");
        userLabel.setBounds(10, 20, 100, 25);
        panel.add(userLabel);

        JTextField userInput = new JTextField(20);
        userInput.setBounds(10, 50, 100, 25);
        panel.add(userInput);

        JButton bubbleSortButton = new JButton("Ordenar con burbuja");
        bubbleSortButton.setBounds(10, 80, 175, 25);
        panel.add(bubbleSortButton);

        JButton selectionSortButton = new JButton("Ordenar con selección");
        selectionSortButton.setBounds(10, 110, 175, 25);
        panel.add(selectionSortButton);

        bubbleSortButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                arr = new int[Integer.parseInt(userInput.getText())];
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = (int) (Math.random() * 100);
                }
                bubbleSort(arr);
                JOptionPane.showMessageDialog(null, "Arreglo ordenado con burbuja: " + Arrays.toString(arr));
            }
        });

        selectionSortButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                arr = new int[Integer.parseInt(userInput.getText())];
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = (int) (Math.random() * 100);
                }
                selectionSort(arr);
                JOptionPane.showMessageDialog(null, "Arreglo ordenado con selección: " + Arrays.toString(arr));
            }
        });
    }

    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
