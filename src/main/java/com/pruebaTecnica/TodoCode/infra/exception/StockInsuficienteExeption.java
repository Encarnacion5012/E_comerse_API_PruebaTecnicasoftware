package com.pruebaTecnica.TodoCode.infra.exception;

public class StockInsuficienteExeption extends RuntimeException {
    public StockInsuficienteExeption(String mensaje) {
        super(mensaje);
    }
}
