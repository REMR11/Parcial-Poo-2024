package com.parcial.poo.SistemaBancario;

import java.util.ArrayList;

public class Transaccion {

	/**
	 * Realiza una transferencia entre dos cuentas.
	 *
	 * @param numeroCuentaOrigen El número de cuenta de origen.
	 * @param numeroCuentaDestino El número de cuenta de destino.
	 * @param cantidad La cantidad a transferir.
	 * @param cuentas La lista de cuentas donde buscar las cuentas de origen y destino.
	 * @return Un valor booleano que indica si la transferencia fue exitosa o no.
	 */
	public static boolean transferir(int numeroCuentaOrigen, int numeroCuentaDestino, double cantidad, ArrayList<Cuenta> cuentas) {
	    try {
	        if (!verificarCuentasExistentes(numeroCuentaOrigen, numeroCuentaDestino, cuentas)) {
	            return false;
	        }

	        Cuenta origen = encontrarCuenta(numeroCuentaOrigen, cuentas);
	        Cuenta destino = encontrarCuenta(numeroCuentaDestino, cuentas);

	        if (!realizarTransferencia(origen, destino, cantidad)) {
	            return false;
	        }

	        return true;
	    } catch (Exception e) {
	        System.err.println("Error al transferir: " + e.getMessage());
	        return false;
	    }
	}

	/**
	 * Verifica si las cuentas de origen y destino existen en la lista de cuentas.
	 *
	 * @param numeroCuentaOrigen El número de cuenta de origen.
	 * @param numeroCuentaDestino El número de cuenta de destino.
	 * @param cuentas La lista de cuentas donde buscar las cuentas de origen y destino.
	 * @return Un valor booleano que indica si las cuentas existen o no.
	 */
	private static boolean verificarCuentasExistentes(int numeroCuentaOrigen, int numeroCuentaDestino, ArrayList<Cuenta> cuentas) {
	    try {
	        return cuentaExiste(numeroCuentaOrigen, cuentas) && cuentaExiste(numeroCuentaDestino, cuentas);
	    } catch (Exception e) {
	        System.err.println("Error al verificar cuentas existentes: " + e.getMessage());
	        return false;
	    }
	}

	/**
	 * Encuentra una cuenta en la lista de cuentas dado un número de cuenta.
	 *
	 * @param numeroCuenta El número de cuenta de la cuenta a encontrar.
	 * @param cuentas La lista de cuentas donde buscar la cuenta.
	 * @return La cuenta encontrada o null si no se encontró ninguna cuenta con ese número de cuenta.
	 */
	private static Cuenta encontrarCuenta(int numeroCuenta, ArrayList<Cuenta> cuentas) {
	    try {
	        for (Cuenta c : cuentas) {
	            if (c.getCliente().getNumeroCuenta() == numeroCuenta) {
	                return c;
	}
	        }
	        return null;
	    } catch (Exception e) {
	        System.err.println("Error al encontrar cuenta: " + e.getMessage());
	        return null;
	    }
	}

	/**
	 * Realiza una transferencia entre dos cuentas.
	 *
	 * @param origen La cuenta de origen.
	 * @param destino La cuenta de destino.
	 * @param cantidad La cantidad a transferir.
	 * @return Un valor booleano que indica si la transferencia fue exitosa o no.
	 */
	private static boolean realizarTransferencia(Cuenta origen, Cuenta destino, double cantidad) {
	    try {
	        if (origen.getSaldo() >= cantidad) {
	            origen.retirar(cantidad);
	            destino.depositar(cantidad);
	            return true;
	        } else {
	            return false;
	        }
	    } catch (Exception e) {
	        System.err.println("Error al realizar transferencia: " + e.getMessage());
	        return false;
	    }
	}

	/**
	 * Verifica si una cuenta existe en la lista de cuentas dado un número de cuenta.
	 *
	 * @param numeroCuenta El número de cuenta de la cuenta a verificar.
	 * @param cuentas La lista de cuentas donde buscar la cuenta.
	 * @return Un valor booleano que indica si la cuenta existe o no.
	 */
	public static boolean cuentaExiste(int numeroCuenta, ArrayList<Cuenta> cuentas) {
	    try {
	        for (Cuenta c : cuentas) {
	            if (c.getCliente().getNumeroCuenta() == numeroCuenta) {
	                return true;
	            }
	        }
	        return false;
	    } catch (Exception e) {
	        System.err.println("Error al verificar si la cuenta existe: " + e.getMessage());
	        return false;
	    }
	}
}
