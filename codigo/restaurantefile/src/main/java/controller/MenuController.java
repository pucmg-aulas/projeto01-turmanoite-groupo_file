/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.TelaMenu;

public class MenuController {

    private static MenuController instancia;
    TelaMenu view;

    public MenuController() {
        view = new TelaMenu();
        view.setVisible(true);
    }

    public static MenuController getInstancia() {
        if (instancia == null) {
            instancia = new MenuController();
        }
        return instancia;
    }

}
