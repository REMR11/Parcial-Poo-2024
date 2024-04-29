package com.parcial.poo.SistemaBancario;

public class Cuenta {

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
	}

	private Cliente cliente;
	private double saldo;

	/**
	 * Metodo encargado de depositar en cuenta
	 * @param cantidad
	 */
	public void depositar(double cantidad) {
		this.saldo += cantidad;
	}
	
	/**
	 * Metodo que se encarga del retiro de efectivo
	 * @param cantidad
	 * @return 1 si la operacion tuvo exito  y 0 si ocurrio algun error
	 */
	public int retirar(double cantidad){
		try {
			if (this.saldo >= cantidad) {
	            this.saldo -= cantidad;
	            return 1;
	        } 	
		} catch (NumberFormatException e) {
			System.out.println("Verifica que sea un valor valido: "+e);
		}
		return 0;
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
