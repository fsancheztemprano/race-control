package com.campusdual.fs.data;

import com.campusdual.fs.modelo.Carrera;
import com.campusdual.fs.modelo.TipoDeCompeticion;
import com.campusdual.fs.modelo.Torneo;
import java.io.Serializable;
import java.util.Arrays;

public class TorneoDao implements Serializable {

    //Singleton instance
    private static TorneoDao instance;

    private TorneoDao() {
    }

    public static TorneoDao getInstance() {
        if (instance == null) {
            synchronized (TorneoDao.class) {
                if (instance == null) {
                    instance = new TorneoDao();
                }
            }
        }
        return instance;
    }

    private Torneo torneoEstandar;
    private Torneo torneoEliminacion;

    public Torneo getTorneoEstandar() {
        return torneoEstandar;
    }

    public void setTorneoEstandar(Torneo torneoEstandar) {
        this.torneoEstandar = torneoEstandar;
    }

    public Torneo getTorneoEliminacion() {
        return torneoEliminacion;
    }

    public void setTorneoEliminacion(Torneo torneoEliminacion) {
        this.torneoEliminacion = torneoEliminacion;
    }

    public void descartarTorneo(TipoDeCompeticion tipoDeCompeticion) {
        if (tipoDeCompeticion == TipoDeCompeticion.ELIMINACION)
            setTorneoEliminacion(null);
        else
            setTorneoEstandar(null);
    }

    public boolean carreraEnTorneo(Carrera carrera) {
        boolean enTorneo = false;
        if (getTorneoEstandar() != null && Arrays.stream(getTorneoEstandar().getCarreras()).anyMatch(carrera1 -> carrera == carrera1))
            enTorneo = true;
        if (getTorneoEliminacion() != null && Arrays.stream(getTorneoEliminacion().getCarreras()).anyMatch(carrera1 -> carrera == carrera1))
            enTorneo = true;
        return enTorneo;
    }

}
