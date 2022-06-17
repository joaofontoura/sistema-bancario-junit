package com.sistemabancario.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContaTest {
    private final Conta conta = new Conta();

    @Test
    void setNumeroR1(){
        final String invalido = "123";
        assertThrows(IllegalArgumentException.class, () -> conta.setNumero(invalido));
        final String obtido = conta.getNumero();
        assertNotEquals(invalido, obtido);
    }

    @Test
    void setNumeroR1a(){
        final String invalido = "abcde-f";
        assertThrows(IllegalArgumentException.class, () -> conta.setNumero(invalido));
    }

    @Test
    void setNumeroR1b(){
        final String esperado = "12345-6";
        conta.setNumero(esperado);
        final String obtido = conta.getNumero();
        assertEquals(esperado, obtido);
    }

    @Test
    void setNumeroR1c(){
        final String invalido = "12345-f";
        assertThrows(IllegalArgumentException.class, () -> conta.setNumero(invalido));
    }

    @Test
    void isContaCorrenteAoInstanciarContaR2(){
        assertFalse(conta.isPoupanca());
    }

    @Test
    void setLimiteParaContaNaoEspecialR3b(){
        final double esperado = 1000;
        conta.setEspecial(false);
        assertThrows(IllegalStateException.class, () -> conta.setLimite(esperado));
        conta.setPoupanca(true);
    }

    @Test
    void setLimiteParaContaEspecialR3a(){
        final double limiteEsperado = 1000;
        final Conta conta = getConta(limiteEsperado);
        assertEquals(limiteEsperado, conta.getLimite());
    }

    @Test
    void getMovimentacaoR4(){
        conta.addMovimentacao(null);
        assertThrows(NullPointerException.class, () -> conta.getMovimentacoes());
    }

    private Conta getConta(double limite) {
        final Conta conta = new Conta();
        conta.setEspecial(true);
        conta.setLimite(limite);
        return conta;
    }

    @Test
    void getSaldoTotalParaContaEspecialComLimiteR6a(){
        final double esperado = 3000;
        final double saldo = 1000, limite = 2000;
        final Conta conta = getConta(limite);
        conta.setSaldo(saldo);
        assertEquals(esperado, conta.getSaldoTotal());
    }

    @Test
    void getSaldoTotalParaContaEspecialComLimiteR6b(){
        final double saldo = 0.1, limite = 0.2;
        final double esperado = 0.3;
        final Conta conta = getConta(limite);
        conta.setSaldo(saldo);
        assertEquals(esperado, conta.getSaldoTotal(), 0.0001);
    }

    @Test
    void addMovimentacao() {
        //TODO: Você precisa implementar este teste
    }
}
