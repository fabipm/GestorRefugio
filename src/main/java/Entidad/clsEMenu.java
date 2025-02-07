
package Entidad;

import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class clsEMenu {
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MenuType getType() {
        return type;
    }
    
    public void setType(MenuType type) {
        this.type = type;
    }

    public clsEMenu(String icon, String name, Entidad.clsEMenu.MenuType type) {
        this.icon = icon;
        this.name = name;
        this.type = type;
    }

    public clsEMenu() {
    }

    private String icon;
    private String name;
    private MenuType type;

    public Icon toIcon() {
          // Intentar cargar el icono desde el classpath usando getResource()
    URL url = getClass().getResource("/Icono/" + icon + ".png");
    if (url != null) {
        return new ImageIcon(url);
    } else {
        // Manejar el caso en el que el recurso no se encuentre
        System.err.println("No se pudo encontrar el icono: " + icon);
        return null;
    }

        
    }

    public Icon toIconSelected() {
        // Intentar cargar el icono seleccionado desde el classpath usando getResource()
    URL url = getClass().getResource("/Icono/" + icon + "_selected.png");
    if (url != null) {
        return new ImageIcon(url);
    } else {
        // Manejar el caso en que el recurso no se encuentre
        System.err.println("No se pudo encontrar el icono seleccionado: " + icon);
        return null;
    }
    }

    public static enum MenuType {
        MENU, EMPTY
    }

}