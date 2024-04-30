package com.parcial.poo.SistemaBancario;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Crear cuenta: ");
		int i=0;
		Banco pBanco = new Banco();
		while (i < 2) {
			System.out.println("Proporciona nombre de usuario:");
			String nombre = sc.nextLine();
			System.out.println("Proporciona Saldo de la cuenta:");
			double saldo = sc.nextDouble();
			pBanco.agregarCuenta(nombre, saldo);
			System.out.println("Cuenta agregada exitosamente");
			sc.nextLine();
			i++;
		}
		int respuesta;
		do {
		    System.out.println("Que deseas hacer ahora?\n"
		            + "(1) Agregar cuenta\n"
		            + "(2) Transferir efectivo\n"
		            + "(3) Actualizar cuenta\n"
		            + "(4) Consultar datos\n"
		            + "(5) Eliminar cuenta\n"
		            + "(7) Salir");
		    respuesta = sc.nextInt();
		    switch (respuesta) {
		        case 1:
		            agregarCuenta(sc);
		            break;
		        case 2:	        
		            System.out.println("Proporciona tu numero de cuenta ");
		            int origenCuenta = sc.nextInt();

		            System.out.println("Proporciona numero de cuenta a transferir");
		            int objetivoCuenta = sc.nextInt();

		            System.out.println("Proporciona monto a transferir:");
		            double saldo = sc.nextDouble();
		            Boolean resultado = pBanco.transferir(origenCuenta, objetivoCuenta, saldo);
		            if (resultado) {
		                System.out.println("Transferencia exitosa");
		            } else {
		                System.out.println("Parece que ocurrio un error");
		            }
		            
		            break;
		        case 3:
		            System.out.println("Proporciona numero de cuenta:\n");
		            int cuentanum = sc.nextInt();
		            System.out.println("Que deseas modificar? (1) nombre, (2) saldo");
		            int result = sc.nextInt();
		            sc.nextLine(); // Limpiar buffer del scanner
		            String nombre = null;
		            double pSaldo = 0.0;
		            Cuenta cuenta = pBanco.buscarCuenta(cuentanum);
		            if (cuenta != null) {
		                pSaldo = cuenta.getSaldo();
		            }
		            if(result ==1) {
		                System.out.println("Proporciona nuevo nombre:\n");
		                nombre = sc.nextLine();
		            }else if(result ==2) {
		                System.out.println("Proporciona el nuevo saldo");
		                pSaldo = sc.nextDouble();
		                sc.nextLine(); // Limpiar buffer del scanner
		            }

		            pBanco.modificarCuenta(cuentanum, nombre, pSaldo);
		            break;
		        case 4:
		        	pBanco.imprimirCuentas();
		            break;
		        case 5:
		            // agregar código para eliminar cuenta
		            break;
		        default:
		            System.out.println("Opción no válida. Intente de nuevo.");
		            break;
		    }
		} while (respuesta!= 7);
	}
	
	public static void agregarCuenta(Scanner sc) {
		System.out.println("Proporciona nombre de usuario:");
		String nombre = sc.nextLine();
		sc.nextLine();
		System.out.println("Proporciona Saldo de la cuenta:");
		double saldo = sc.nextDouble();
		sc.nextLine();
		Banco pBanco = new Banco();
		pBanco.agregarCuenta(nombre, saldo);
		
		System.out.println("Cuenta agregada exitosamente");
		sc.nextLine();
	}

}
