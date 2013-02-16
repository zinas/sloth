import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import java.util.*;
import java.lang.reflect.*;
import java.util.regex.*;

class Scaffolder {
    protected final static Logger LOGGER = Logger.getLogger(Sloth.class.getName());

    public String name;
    public String camelCaseName;
    public String dashedName;

    // <template filename, target filename>
    protected HashMap<String, String> _files = new HashMap<String, String>();
    protected String _templateFolder = "templates/";

    public Scaffolder(String name) {
        LOGGER.setLevel(Level.INFO);

        // Set the variables
        this.name = name;
        this.camelCaseName = this.__camel(name);
        this.dashedName = this.__dash(name);
    }

    public void scaffold() {
        this._createFolder();
        for (Map.Entry<String, String> entry : this._files.entrySet()) {
            this._processFile(entry.getKey(), entry.getValue());
        }
    }

    protected void _processFile(String template, String target) {
        String contents = this._read(template);
        String processed = this._template(contents);
        this._write(target, processed);
    }

    private String __camel(String str) {
        String[] tokens = str.split("\\s");
        str = "";
        for(int i = 0; i < tokens.length; i++){
            char capLetter = Character.toUpperCase(tokens[i].charAt(0));
            str +=  " " + capLetter + tokens[i].substring(1, tokens[i].length());
        }

        return str.replaceAll("\\s", "");
    }

    private String __dash(String str) {
        String[] tokens = str.split("\\s");
        str = "";

        for(int i = 0; i < tokens.length; i++){
            char capLetter = Character.toLowerCase(tokens[i].charAt(0));
            str +=  " " + capLetter + tokens[i].substring(1, tokens[i].length());
        }

        return str.trim().replaceAll("\\s", "-");
    }

    protected boolean _createFolder() {
        File dir = new File(this.dashedName);
        return dir.mkdir();
    }

    protected String _read(String filename) {
        String contents = "";
        FileReader fr;
        BufferedReader reader;
        try {
             fr = new FileReader(this._templateFolder+filename);
             reader = new BufferedReader(fr);
            String line;
            while ( (line=reader.readLine()) != null ) {
                contents += line + "\n";
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contents;
    }

    protected void _write(String filename, String contents) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(this.dashedName+"/"+filename));
            writer.write(contents);
        } catch ( IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close( );
            } catch ( IOException e )  {
                e.printStackTrace();
            }
        }
    }

    protected String _template(String template) {
        Pattern variables = Pattern.compile("\\{\\{[^\\}]*\\}\\}");
        Matcher functions = variables.matcher(template);
        String functionName;
        String function;
        Method method;
        Object value;
        while (functions.find()) {
            function = functions.group().replaceFirst("\\{\\{", "").replaceFirst("\\}\\}", "");
            functionName = "get"+Character.toUpperCase(function.charAt(0))+function.substring(1, function.length());

            try {
                method = this.getClass().getMethod(functionName);
                value = method.invoke(this);
                template = template.replaceAll("\\{\\{"+function+"\\}\\}", value.toString());
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return template;
    }
}