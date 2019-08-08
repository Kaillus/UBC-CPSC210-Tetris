package ui.logic;

import javax.swing.*;
import java.awt.event.ActionEvent;

public abstract class KeyInteractor extends AbstractAction {

    private static final String commandPrefix = "KeyInteractor";

    public KeyInteractor(JComponent comp, int keyCode, int mod) {
        super();
        String actionID = commandPrefix + keyCode + "." + mod;
        InputMap imap = comp.getInputMap();
        imap.put(KeyStroke.getKeyStroke(keyCode, mod), actionID);
        ActionMap amap = comp.getActionMap();
        amap.put(actionID,this);
    }

    public KeyInteractor(JComponent comp, int keyCode) {
        this(comp, keyCode, 0);
    }

    public abstract void actionPerformed(ActionEvent e);



}
