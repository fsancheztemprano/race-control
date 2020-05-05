package com.campusdual.fs.vista;

import io.bretty.console.view.MenuView;
import io.bretty.console.view.ViewConfig;

public class MainMenu extends MenuView {

    public static ViewConfig viewConfig = new ViewConfig.Builder()
        .setMenuSelectionMessage("Introduce un numero para continuar: ")
        .setPauseMessage("Presiona INTRO para continuar...")
        .setQuitMessage("Cerrando...")
        .setActionCanceledMessage("Accion Cancelada")
        .setActionSuccessfulMessage("Accion Exitosa")
        .setActionFailedMessage("Accion Fallida")
        .setBackMenuName("Volver")
        .setQuitMenuName("Salir")
        .build();

    public MainMenu() {
        super("Race Control | v-0.0.1", "", MainMenu.viewConfig);
    }
}
