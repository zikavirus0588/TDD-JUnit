package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonusServiceTest {

    private Funcionario funcionario;
    private BonusService service;

    @BeforeEach
    public void setUp() {
        this.service = new BonusService();
    }

    @Test
    public void bonusDeveriaLancarExceptionParaFuncionarioComSalarioMaiorQue10000() {
        seRequerFuncionario("Zica","12000");
        assertThrows(IllegalArgumentException.class,
                () -> service.calcularBonus(funcionario),
                "Funcionário com salário maior que R$ 10.000,00 não recebe bônus.");

    }
    @Test
    public void bonusDeveriaSer10PorCentoParaSalarioExatamenteIgualA1000() {
        seRequerFuncionario("Zica","10000");
        BigDecimal bonus = service.calcularBonus(funcionario);

        assertEquals(new BigDecimal("1000.00"),bonus);
    }
    @Test
    public void bonusDeveriaSer10PorCentoParaSalarioMenorQue10000() {
        seRequerFuncionario("Zica","2500");
        BigDecimal bonus = service.calcularBonus(funcionario);

        assertEquals(new BigDecimal("250.00"),bonus);
    }

    private void seRequerFuncionario(String nome, String salario){
        this.funcionario = new Funcionario(nome, LocalDate.now(), new BigDecimal(salario));
    }
}
