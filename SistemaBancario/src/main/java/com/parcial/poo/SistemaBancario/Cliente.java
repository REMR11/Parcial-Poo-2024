package com.parcial.poo.SistemaBancario;

import java.util.Random;

public class Cliente {
	private String nombre;
	private int numeroCuenta;
	
	/**
	 * @param nombre
	 * @param numeroCuenta
	 */
	public Cliente(String nombre) {
		super();
		this.nombre = nombre;
		this.numeroCuenta = generarNumeroCuentaAleatorio();
	}
	
	
	public Cliente() {
		super();
		this.numeroCuenta = generarNumeroCuentaAleatorio();
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the numeroCuenta
	 */
	public int getNumeroCuenta() {
		return numeroCuenta;
	}
	/**
	 * @param numeroCuenta the numeroCuenta to set
	 */
	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	private static int generarNumeroCuentaAleatorio() {
        Random random = new Random();
        return random.nextInt(1000000) + 1; // Genera un número entre 1 y 999999
    }
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cliente [");
		if (nombre != null) {
			builder.append("nombre=");
			builder.append(nombre);
			builder.append(", ");
		}
		builder.append("numeroCuenta=");
		builder.append(numeroCuenta);
		builder.append("]");
		return builder.toString();
	}
	
	
}
