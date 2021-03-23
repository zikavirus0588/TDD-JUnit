package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BonusServiceTest {

    @Test
    public void bonusDeveriaSerZeroParaFuncionarioComSalarioMaiorQue10000() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Zica", LocalDate.now(),new BigDecimal("12000")));

        assertEquals(new BigDecimal("0.00"),bonus);
    }
    @Test
    public void bonusDeveriaSer10PorCentoParaSalarioExatamenteIgualA1000() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Zica", LocalDate.now(),new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.00"),bonus);
    }
    @Test
    public void bonusDeveriaSer10PorCentoParaSalarioMenorQue10000() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Zica", LocalDate.now(),new BigDecimal("2500")));

        assertEquals(new BigDecimal("250.00"),bonus);
    }
}
