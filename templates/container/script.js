/*global b$,gadgets lp bd $*/
b$.module("b$.portal.view.bdom.container.original", function() {
    "use strict";

    var Class = b$.require('b$.Class');
    var htmlAPI = b$.view.htmlAPI;
    var DefaultView = b$.require("b$.portal.view.bdom.default");
    var NS = DefaultView.NS;
    var Container = NS.classes.container;

    var containerCallbacks = {
        readyHTML: function(elem) {
            return Container.prototype.readyHTML.call(this, elem);
        },
        buildHTML: function(elem) {
            return Container.prototype.buildHTML.call(this, elem);
        },
        getContainerTemplate: function(){
            var containerTmpl = '<div class="bp-container bp-{{dashed}}"><div class="bp-area"></div></div>';
            return containerTmpl;
        }
    };

    var {{camelCase}} = Container.extend(function (bdomDocument, namespaceURI, localName, node) {
        Container.call(this, bdomDocument, namespaceURI, localName, node);
        this.isPossibleDragTarget = true;
    }, containerCallbacks);

    NS.registerElement("{{camelCase}}", {{camelCase}});
});