package org.hawhamburg;

import org.hawhamburg.view.MainView;

public class Application {

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(MainView::new);
    }

}
