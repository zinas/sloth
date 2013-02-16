import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.System;

class Sloth {
    private final static Logger LOGGER = Logger.getLogger(Sloth.class.getName());

    public static void main(String[] args) {
        LOGGER.setLevel(Level.INFO);

        if ( args.length < 2 || (!args[0].equals("widget") && !args[0].equals("container")) ) {
            LOGGER.severe("Proper usage: java Sloth [widget|container] <name>\neg: java Sloth widget New Payment");
            System.exit(0);
        }

        String type = args[0];
        String name = "";

        for ( int i=1; i < args.length-1; i++ ) {
            name += args[i] + " ";
        }
        name += args[args.length-1];

        if ( type.equals("widget") ) {
            Widget widget = new Widget(name);
            widget.scaffold();
        } else if ( type.equals("container") ) {
            Container container = new Container(name);
            container.scaffold();
        } else {
            LOGGER.severe("Illegal type argument: "+type);
            System.exit(0);
        }

    }
}