/*7.
• Metodo crearPersona(): el método crear persona, le pide los valores de los atributos
al usuario y después se le asignan a sus respectivos atributos para llenar el objeto
Persona. Además, comprueba que el sexo introducido sea correcto, es decir, H, M o
O. Si no es correcto se deberá mostrar un mensaje
• Método calcularIMC(): calculara si la persona está en su peso ideal (peso en
kg/(altura^2 en mt2)). Si esta fórmula da por resultado un valor menor que 20, la
función devuelve un -1. Si la fórmula da por resultado un número entre 20 y 25
(incluidos), significa que el peso está por debajo de su peso ideal y la función
devuelve un 0. Finalmente, si el resultado de la fórmula es un valor mayor que 25
significa que la persona tiene sobrepeso, y la función devuelve un 1. Se recomienda
hacer uso de constantes para devolver estos valores.
• Método esMayorDeEdad(): indica si la persona es mayor de edad. La función
devuelve un booleano.
 */
package Ejercicio07;

import java.util.Scanner;

public class PersonaControl {

    Scanner leer = new Scanner(System.in);
    Persona persona = new Persona();

    public Persona crearPersona() {

        System.out.println("Ingrese nombre completo");
        persona.setNombre(leer.nextLine());
        System.out.println("¿Cuantos años tiene?");
        persona.setEdad(Integer.valueOf(leer.nextLine()));

        do {
            System.out.println("Sexo (H hombre, M mujer, O otro):");
            persona.setSexo(leer.nextLine().toUpperCase());
            if (persona.getSexo().equals("H") || persona.getSexo().equals("M") || persona.getSexo().equals("O")) {
            } else {
                System.out.println("Esa opcion no es correcta");
            }
        } while (!persona.getSexo().equals("H") && !persona.getSexo().equals("M") && !persona.getSexo().equals("O"));

        System.out.println("Ingrese su peso en kilogramos");
        persona.setPeso(Double.parseDouble(leer.nextLine()));
        System.out.println("Ingrese su altura en metros");
        persona.setAltura(Double.parseDouble(leer.nextLine()));
        return persona;
    }

    public double calcularIMC() {
        double imc = persona.getPeso() / Math.pow(persona.getAltura(), 2);
        if (imc < 20) {
            System.out.println("El participante se encuentra por debajo de su peso");
            imc = -1;
        } else if (imc >= 20 && imc <= 25) {
            System.out.println("El participante se encuentra en su peso ideal");
            imc = 0;
        } else if (imc > 25) {
            System.out.println("El participante tiene sobrepeso");
            imc = 1;
        }
        return imc;
    }

    public boolean esMayorDeEdad() {
        boolean mayor;
        if (persona.getEdad() >= 18) {
            mayor = true;
            System.out.println("Es mayor de edad");
        } else {
            mayor = false;
            System.out.println("Es menor de edad");
        }
        return mayor;
    }

}//fin clase
