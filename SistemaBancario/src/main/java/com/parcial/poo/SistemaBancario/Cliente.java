package com.parcial.poo.SistemaBancario;

public class Cliente {
	private String nombre;
	private int numeroCuenta;
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
	public Cliente(String nombre, int numeroCuenta) {
		super();
		this.nombre = nombre;
		this.numeroCuenta = numeroCuenta;
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
