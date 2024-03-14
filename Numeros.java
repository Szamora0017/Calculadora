import javax.swing.JOptionPane;

class Calculadora {
    double numero1;
    double numero2;

    Calculadora(double numero1, double numero2) {
        this.numero1 = numero1;
        this.numero2 = numero2;
    }

    double sumar() {
        return numero1 + numero2;
    }

    double restar() {
        return numero1 - numero2;
    }

    double multiplicar() {
        return numero1 * numero2;
    }

    double dividir() {
        if (numero2 != 0) {
            return numero1 / numero2;
        } else {
            JOptionPane.showMessageDialog(null, "No se puede dividir entre cero", "Error", JOptionPane.ERROR_MESSAGE);
            return Double.NaN; // Devuelve NaN (Not a Number) si hay un error
        }
    }
}

public class Numeros {
    public static void main (String[] args) {
        double numero1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el primer número:", "Dato", JOptionPane.QUESTION_MESSAGE ));
        double numero2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el segundo número:", "Dato", JOptionPane.QUESTION_MESSAGE));

        Calculadora calculadora = new Calculadora(numero1, numero2);

        String[] operaciones = { "+", "-", "x", "/" };
        int seleccion = JOptionPane.showOptionDialog(null, "Seleccione una operación", "Operaciones",
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, operaciones, operaciones[0]);

        double resultado = 0;

        switch (seleccion) {
            case 0:
                resultado = calculadora.sumar();
                break;
            case 1:
                resultado = calculadora.restar();
                break;
            case 2:
                resultado = calculadora.multiplicar();
                break;
            case 3:
                resultado = calculadora.dividir();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Operación no válida", "Error", JOptionPane.ERROR_MESSAGE);
                return;
        }

        JOptionPane.showMessageDialog(null, "El resultado es: " + resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
    }
}