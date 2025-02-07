package swing;

import Entidad.clsEMenu;
import Eventos.EventoMenuCallBack;
import Eventos.EventoMenuSelected;
import java.awt.Component;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;

public class ListaMenu<E extends Object> extends JList<E> {


    public void addEventSelectedMenu(EventoMenuSelected event){
        events.add(event);
    }
    private final DefaultListModel model;
    private final List<EventoMenuSelected> events;
    private int selectedIndex = -1;

    public ListaMenu() {
        model = new DefaultListModel();
        events = new ArrayList<>();
        super.setModel(model);
        
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    int index = locationToIndex(me.getPoint());
                    Object obj = model.getElementAt(index);
                    if (obj instanceof clsEMenu) {
                        clsEMenu data = (clsEMenu) obj;
                        if (data.getType() == clsEMenu.MenuType.MENU) {
                            if (index != selectedIndex) {
                                selectedIndex = -1;
                                runEvent(index);
                            }
                        }
                    } else {
                        if (index != selectedIndex) {
                            selectedIndex = -1;
                            runEvent(index);
                            }
                        }
                }
            }
        });
    }

    
    private void runEvent (int indexChange){
        for (EventoMenuSelected event : events) {
            event.menuSelected(indexChange, new EventoMenuCallBack() {
                @Override
                public void call(int index) {
                    //  This call back event run when animation done
                    selectedIndex = index;
                    repaint();
                }
            });
        }

    }

    @Override
    public ListCellRenderer<? super E> getCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> jlist, Object o, int index, boolean selected, boolean focus) {
                clsEMenu data;
                if (o instanceof clsEMenu) {
                    data = (clsEMenu) o;
                } else {
                    data = new clsEMenu("1", o + "", clsEMenu.MenuType.MENU);
                }

                MenuItem item = new MenuItem(data);
                item.setSelected(index == selectedIndex);
                return item;
            }
        };
    }


    @Override
    public void setModel(ListModel<E> lm) {
        for (int i = 0; i < lm.getSize(); i++) {
            model.addElement(lm.getElementAt(i));
        }
    }

    public void addItem(clsEMenu data) {
        model.addElement(data);
    }
}
