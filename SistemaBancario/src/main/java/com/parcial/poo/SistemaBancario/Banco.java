package com.parcial.poo.SistemaBancario;

import java.util.ArrayList;

public class Banco {
	private ArrayList<Cliente> clientes;
	private static ArrayList<Cuenta> cuentas;
	private int numClientes;
	private int numCuentas;

	public Banco() {
		this.clientes = new ArrayList<Cliente>();
		this.cuentas = new ArrayList<Cuenta>();
		this.numClientes = 0;
		this.numCuentas = 0;
	}

	public void agregarCliente(Cliente cliente) {
		try {
			this.clientes.add(cliente);
			numClientes++;
		} catch (Exception e) {
			System.err.println("Error al agregar cliente: " + e.getMessage());
		}
	}
	/**
	 * Agrega una nueva cuenta al sistema.
	 * 
	 * @param nombre el nombre del cliente dueño de la cuenta
	 * @param saldo el saldo inicial de la cuenta
	 * @throws NullPointerException si el nombre del cliente es nulo
	 * @throws IllegalArgumentException si el saldo es negativo
	 */
	public void agregarCuenta(String nombre, double saldo) {
	    try {
	        if (nombre == null) {
	            throw new NullPointerException("El nombre del cliente no puede ser nulo");
	        }
	        if (saldo < 0) {
	            throw new IllegalArgumentException("El saldo no puede ser negativo");
	        }
	        Cliente pCliente = new Cliente(nombre);
	        Cuenta pCuenta = new Cuenta(pCliente, saldo);
	        cuentas.add(pCuenta);
	    } catch (NullPointerException e) {
	        System.err.println("Error: " + e.getMessage());
	    } catch (IllegalArgumentException e) {
	        System.err.println("Error: " + e.getMessage());
	    } catch (Exception e) {
	        System.err.println("Error inesperado: " + e.getMessage());
	    }
	}
	
	/**
	 * Busca una cuenta en el sistema por su número.
	 * 
	 * @param numeroCuenta el número de cuenta a buscar
	 * @return la cuenta si existe, o null si no existe
	 */
	Cuenta buscarCuenta(int numeroCuenta) {
	    return Cuenta.cuentaExiste(this.cuentas, numeroCuenta);
	}

	/**
	 * Modifica una cuenta existente en el sistema.
	 * 
	 * @param cuenta la cuenta a modificar
	 * @param nuevoNombre el nuevo nombre del cliente dueño de la cuenta
	 * @param nuevoSaldo el nuevo saldo de la cuenta
	 * @throws NullPointerException si el nuevo nombre es nulo
	 * @throws IllegalArgumentException si el nuevo saldo es negativo
	 */
	private void modificarCuentaPropiedades(Cuenta cuenta, String nuevoNombre, double nuevoSaldo) {
	    if (nuevoNombre == null) {
	        nuevoNombre = cuenta.getCliente().getNombre();
	        if (nuevoNombre == null) {
	            throw new NullPointerException("El nuevo nombre del cliente no puede ser nulo");
	        }
	    }
	    if (nuevoSaldo < 0) {
	        nuevoSaldo = cuenta.getSaldo();
	        if (nuevoSaldo < 0) {
	            throw new IllegalArgumentException("El nuevo saldo no puede ser negativo");
	        }
	    }
	    cuenta.getCliente().setNombre(nuevoNombre);
	    cuenta.setSaldo(nuevoSaldo);
	}
	/**
	 * Modifica una cuenta existente en el sistema por su número.
	 * 
	 * @param numeroCuenta el número de cuenta a modificar
	 * @param nuevoNombre el nuevo nombre del cliente dueño de la cuenta
	 * @param nuevoSaldo el nuevo saldo de la cuenta
	 * @throws NullPointerException si el número de cuenta o el nuevo nombre es nulo
	 * @throws IllegalArgumentException si el nuevo saldo es negativo
	 * @throws Exception si la cuenta no existe o no se puede modificar
	 */
	public void modificarCuenta(int numeroCuenta, String nuevoNombre, double nuevoSaldo) {
	    try {
	        if (numeroCuenta <= 0) {
	            throw new NullPointerException("El número de cuenta no puede ser nulo o cero");
	        }
	        Cuenta cuenta = buscarCuenta(numeroCuenta);
	        if (cuenta != null) {
	        	modificarCuentaPropiedades(cuenta, nuevoNombre, nuevoSaldo);
	        } else {
	            throw new Exception("La cuenta no existe");
	        }
	    } catch (NullPointerException e) {
	        System.err.println("Error: " + e.getMessage());
	    } catch (IllegalArgumentException e) {
	        System.err.println("Error: " + e.getMessage());
	    } catch (Exception e) {
	        System.err.println("Error al modificar cuenta: " + e.getMessage());
	    }
	}
	
	public boolean eliminarCuenta(int numeroCuenta) {
		try {
			Cuenta cuenta = Cuenta.cuentaExiste(this.cuentas, numeroCuenta);
			if (cuenta != null) {
				this.cuentas.remove(cuenta);
				this.numCuentas--;
				return true;
			}
			return false;
		} catch (Exception e) {
			System.err.println("Error al eliminar cuenta: " + e.getMessage());
			return false;
		}
	}

	/**
	 * Metodo de transacciones
	 * 
	 * @param origenIndex
	 * @param destinoIndex
	 * @param cantidad
	 * @return valor booleano para verificar el exito de la transferencia
	 * @throws IndexOutOfBoundsException
	 */
	public boolean transferir(int numeroCuentaOrigen, int numeroCuentaDestino, double cantidad) {
	    try {
	        Cuenta cuentaOrigen = Cuenta.cuentaExiste(this.cuentas, numeroCuentaOrigen);
	        Cuenta cuentaDestino = Cuenta.cuentaExiste(this.cuentas, numeroCuentaDestino);
	        if (cuentaOrigen != null && cuentaDestino != null) {
	            if (cuentaOrigen.retirar(cantidad) == 1) {
	                cuentaDestino.depositar(cantidad);
	                return true;
	            }
	        }
	        return false;
	    } catch (Exception e) {
	        System.err.println("Error al transferir: " + e.getMessage());
	        return false;
	    }
	}
	
	/**
	 * Imprime las cuentas creadas en el sistema.
	 */
	public void imprimirCuentas() {
	    System.out.println("Cuentas creadas:");
	    for (Cuenta cuenta : cuentas) {
	        System.out.println("Número de cuenta: " + cuenta.getCliente().getNumeroCuenta());
	        System.out.println("Nombre del cliente: " + cuenta.getCliente().getNombre());
	        System.out.println("Saldo: " + cuenta.getSaldo());
	        if(cuenta.getJustificaciones()!=null) {
	        	System.out.println("Justificaciones por transacciones altas:\n"+cuenta.imprimirJustificaciones());
	        }
	        System.out.println();
	    }
	}
}