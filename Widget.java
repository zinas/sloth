class Widget extends Scaffolder {

    public Widget(String name) {
        super(name);

        // Folder where all the template files are located
        this._templateFolder = "templates/widget/";

        // Template filenames
        this._files.put("catalog-widgets.xml", "catalog-widgets.xml");
        this._files.put("index.html", "index.html");
        this._files.put("script.js", this.dashedName+".js");
        this._files.put("styles.css", this.dashedName+".css");
    }

    public String getDashed() {
        return this.dashedName;
    }

    public String getTitle() {
        return this.name;
    }

    public String getCamelCase() {
        return this.camelCaseName;
    }
}