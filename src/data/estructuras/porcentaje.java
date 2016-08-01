/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.estructuras;

/**
 *
 * @author raul
 */
public class porcentaje {
    private double porcentaje_equipo1;
    private double porcentaje_equipo2;
    private double porcentaje_empate;

    public porcentaje(double porcentaje_equipo1, double porcentaje_equipo2, double porcentaje_empate) {
        this.porcentaje_equipo1 = porcentaje_equipo1;
        this.porcentaje_equipo2 = porcentaje_equipo2;
        this.porcentaje_empate = porcentaje_empate;
    }
    

    public double getPorcentaje_equipo1() {
        return porcentaje_equipo1;
    }

    public double getPorcentaje_equipo2() {
        return porcentaje_equipo2;
    }

    public double getPorcentaje_empate() {
        return porcentaje_empate;
    }


    public void setPorcentaje_equipo1(double porcentaje_equipo1) {
        this.porcentaje_equipo1 = porcentaje_equipo1;
    }

    public void setPorcentaje_equipo2(double porcentaje_equipo2) {
        this.porcentaje_equipo2 = porcentaje_equipo2;
    }

    public void setPorcentaje_empate(double porcentaje_empate) {
        this.porcentaje_empate = porcentaje_empate;
    }
    
    
}
