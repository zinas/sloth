class Container extends Scaffolder {

    public Container(String name) {
        super(name);

        // Folder where all the template files are located
        this._templateFolder = "templates/container/";

        // Template filenames
        this._files.put("catalog-containers.xml", "catalog-containers.xml");
        this._files.put("container-templates.xml", "container-templates.xml");
        this._files.put("template.jsp", this.dashedName+".jsp");
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