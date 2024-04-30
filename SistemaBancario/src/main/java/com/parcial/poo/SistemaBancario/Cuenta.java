package com.parcial.poo.SistemaBancario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Cuenta {
	private Cliente cliente;
	private double saldo;
	private ArrayList<String> justificaciones;

	public Cuenta() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cliente
	 * @param saldo
	 */
	public Cuenta(Cliente cliente, double saldo) {
		super();
		this.cliente = cliente;
		this.saldo = saldo;
		this.justificaciones = new ArrayList<>();

	}

	/**
	 * Deposita una cantidad en la cuenta y pide una justificación si la cantidad es mayor a 4999.
	 *
	 * @param cantidad la cantidad a depositar
	 * @throws IOException si ocurre un error al leer la entrada del usuario
	 */
	public void depositar(double cantidad) {
	    try {
	        if (cantidad > 4999) {
	            System.out.println("La cantidad ingresada es mayor a 4999. Por favor, ingrese una justificación:");
	            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	            String justificacion = reader.readLine();
	            this.justificaciones.add(justificacion);
	        }
	        this.saldo += cantidad;
	    } catch (IOException e) {
	        System.err.println("Error al leer la entrada del usuario: " + e.getMessage());	
	    }
	}

	/**
	 * Metodo que se encarga del retiro de efectivo
	 * 
	 * @param cantidad
	 * @return 1 si la operacion tuvo exito y 0 si ocurrio algun error
	 */
	public int retirar(double cantidad) {
		try {
			if (this.saldo >= cantidad) {
				this.saldo -= cantidad;
				return 1;
			}
		} catch (NumberFormatException e) {
			System.out.println("Verifica que sea un valor valido: " + e);
		}
		return 0;
	}

	/**
	 * Busca una cuenta en la lista de cuentas proporcionada por su número de
	 * cuenta.
	 * 
	 * @param pCuentas      lista de cuentas a buscar
	 * @param pNumeroCuenta número de cuenta a buscar
	 * @return la cuenta encontrada si existe, null en caso contrario
	 */
	public static Cuenta cuentaExiste(ArrayList<Cuenta> pCuentas, int pNumeroCuenta) {
		try {
			for (Cuenta cuentaObjetivo : pCuentas) {
				if (cuentaObjetivo.getCliente().getNumeroCuenta() == pNumeroCuenta) {
					return cuentaObjetivo;
				}
			}
			return null;
		} catch (NullPointerException e) {
			// Se produce cuando la lista de cuentas o alguno de sus elementos es nulo
			System.err.println("Error: La lista de cuentas o alguno de sus elementos es nulo");
			return null;
		} catch (Exception e) {
			// Se produce cuando ocurre cualquier otro error inesperado
			System.err.println("Error inesperado: " + e.getMessage());
			return null;
		}
	}
	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the saldo
	 */
	public double getSaldo() {
		return saldo;
	}

	/**
	 * @param saldo the saldo to set
	 */
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	/**
	 * @return Lista de justificaciones en caso de ser un monto mayor a 4999
	 */
	public ArrayList<String> getJustificaciones() {
        return this.justificaciones;
    }
	
	
	public String imprimirJustificaciones() {
	    String justificado =null;
		for (int i = 0; i < justificaciones.size(); i++) {
	        justificado +="Justificación " + (i+1) + ": " + justificaciones.get(i)+"\n";
	    }
		return justificado;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cuenta [");
		if (cliente != null) {
			builder.append("cliente=");
			builder.append(cliente);
			builder.append(", ");
		}
		builder.append("saldo=");
		builder.append(saldo);
		builder.append("]");
		return builder.toString();
	}

}
