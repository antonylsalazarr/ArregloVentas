package clases;

import java.util.Arrays;
import java.util.Random;

public class ArregloVentas {
    private double[] venta;

    // Constructor que inicializa el arreglo venta con valores predeterminados
    public ArregloVentas() {
        venta = new double[]{240.5, 350.2, 80.4, 100.3, 470.1, 60.0, 330.8, 260.6, 510.9, 200.7};
    }

    // Método tamaño que retorna la cantidad de números en el arreglo
    public int tamaño() {
        return venta.length;
    }

    // Método obtener que recibe la posición y retorna el número registrado en dicha posición
    public double obtener(int i) {
        return venta[i];
    }

    // Método que busca y retorna el valor máximo en el arreglo venta
    public double ventaMaximo() {
        double max = venta[0];
        for (double v : venta) {
            if (v > max) {
                max = v;
            }
        }
        return max;
    }

    // Método que busca y retorna el valor mínimo en el arreglo venta
    public double ventaMinimo() {
        double min = venta[0];
        for (double v : venta) {
            if (v < min) {
                min = v;
            }
        }
        return min;
    }

    // Método que retorna la suma de todos los números del arreglo venta
    public double totalVentas() {
        double total = 0;
        for (double v : venta) {
            total += v;
        }
        return total;
    }

    // Método que reemplaza un valor en una posición específica del arreglo
    public void reemplazoVentas(int pos, double valor) {
        if (pos >= 0 && pos < venta.length) {
            venta[pos] = valor;
        }
    }

    // Método que elimina un valor del arreglo
    public void eliminarVenta(double valor) {
        int index = -1;
        for (int i = 0; i < venta.length; i++) {
            if (venta[i] == valor) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            double[] newVenta = new double[venta.length - 1];
            for (int i = 0, j = 0; i < venta.length; i++) {
                if (i != index) {
                    newVenta[j++] = venta[i];
                }
            }
            venta = newVenta;
        }
    }

    // Método que incrementa un valor en una posición específica del arreglo
    public void incrementarVenta(int pos, double incremento) {
        if (pos >= 0 && pos < venta.length) {
            venta[pos] += incremento;
        }
    }

    // Método que busca un valor y lo adiciona si no está registrado
    public void buscarAdicionarVenta(double valor) {
        for (double v : venta) {
            if (v == valor) {
                return;
            }
        }
        double[] newVenta = Arrays.copyOf(venta, venta.length + 1);
        newVenta[newVenta.length - 1] = valor;
        venta = newVenta;
    }

    // Método que reemplaza las ventas actuales
    public void generarVentas() {
        Random rand = new Random();
        for (int i = 0; i < venta.length; i++) {
            venta[i] = 99.9 + (999.9 - 99.9) * rand.nextDouble();
            venta[i] = Math.round(venta[i] * 10.0) / 10.0; // Redondear a un decimal
        }
    }
}