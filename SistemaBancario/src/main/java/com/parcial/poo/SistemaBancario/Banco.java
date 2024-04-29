package com.parcial.poo.SistemaBancario;

import java.util.ArrayList;

public class Banco {
	private ArrayList<Cliente> clientes;
	private ArrayList<Cuenta> cuentas;
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

	public void agregarCuenta(Cuenta cuenta) {
		try {
			this.cuentas.add(cuenta);
			numCuentas++;
		} catch (Exception e) {
			System.err.println("Error al agregar cuenta: " + e.getMessage());
		}
	}

	public void eliminarCuenta(int numeroCuenta) {
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	/**
	 * Metodo de transacciones
	 * @param origenIndex
	 * @param destinoIndex
	 * @param cantidad
	 * @return valor booleano para verificar el exito de la transferencia
	 * @throws IndexOutOfBoundsException
	 */
	public boolean transferir(int origenIndex, int destinoIndex, double cantidad) {
        try {
            if (origenIndex >= 0 && origenIndex < numCuentas && destinoIndex >= 0 && destinoIndex < numCuentas) {
                return Transaccion.transferir(cuentas.indexOf(origenIndex), cuentas.indexOf(destinoIndex), cantidad, cuentas);
            } else {
                throw new IndexOutOfBoundsException("Índice fuera de rango");
            }
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Error: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.err.println("Error al transferir: " + e.getMessage());
            return false;
        }
    }
}