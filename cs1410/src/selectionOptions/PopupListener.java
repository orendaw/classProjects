package selectionOptions;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPopupMenu;

public class PopupListener extends MouseAdapter {
	
	private JPopupMenu menu;
	
	public PopupListener(JPopupMenu _menu) {
		menu = _menu;
	}
	
    public void mousePressed(MouseEvent e) {
        maybeShowPopup(e);
    }

    public void mouseReleased(MouseEvent e) {
        maybeShowPopup(e);
    }

    private void maybeShowPopup(MouseEvent e) {
        if (e.isPopupTrigger()) {
            menu.show(e.getComponent(), e.getX(), e.getY());
        }
    }
}