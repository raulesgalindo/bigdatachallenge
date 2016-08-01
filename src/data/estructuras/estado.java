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
public class estado {
    private boolean estado_equipo1;
    private boolean estado_equipo2;
    private boolean empate;

    public estado(boolean estado_equipo1, boolean estado_equipo2, boolean empate) {
        this.estado_equipo1 = estado_equipo1;
        this.estado_equipo2 = estado_equipo2;
        this.empate = empate;
    }
    
    public boolean isEstado_equipo1() {
        return estado_equipo1;
    }

    public boolean isEstado_equipo2() {
        return estado_equipo2;
    }

    public boolean isEmpate() {
        return empate;
    }
    
    
}
