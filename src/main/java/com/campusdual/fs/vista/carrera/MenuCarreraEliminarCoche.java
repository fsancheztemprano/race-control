package com.campusdual.fs.vista.carrera;

import com.campusdual.fs.modelo.Carrera;
import com.campusdual.fs.modelo.Coche;
import com.campusdual.fs.vista.local.ActionViewLocal;
import com.campusdual.fs.vista.local.MenuViewLocal;
import io.bretty.console.view.AbstractView;
import java.util.ArrayList;
import java.util.Collection;

public class MenuCarreraEliminarCoche extends ActionViewLocal {

    private final MenuViewLocal menuViewLocal = new MenuViewLocal("Elige un Coche", "");
    private final Carrera carrera;

    public MenuCarreraEliminarCoche(Carrera carrera) {
        super("Eliminando Coche", "Eliminar Coche");
        this.carrera = carrera;
    }

    @Override
    public void executeCustomAction() {
        refreshView();
        menuViewLocal.setParentView(this);
        menuViewLocal.display();

    }

    @Override
    public void refreshView() {
        Collection<Coche> coches = carrera.getParticipantes();
        ArrayList<AbstractView> cochesMenu = new ArrayList<>();
        for (Coche coche : coches) {
            cochesMenu.add(new ActionCarreraEliminarCoche(this, carrera, coche));
        }
        menuViewLocal.setMenuItems(cochesMenu);
    }
}
