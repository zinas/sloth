/*global define Modernizr gadgets lp*/

/**
 * {{title}} Widget
 */
define(["portal!jquery",
        "portal!mustache",
        "portal!bankApi",
        "portal!portal!launchpad/responsive",
        "portal!jquery-ui",
        "portal!ui-components"
    ], function ($, Mustache, bankApi, Responsive) {
    "use strict";

    var DEBUG = true;
    var DEBUG_PREFIX = "{{title}}";
    var _log = window.lp.getLogger(DEBUG, DEBUG_PREFIX);

    function {{camelCase}}(widget) {
        this.widget = widget;
        this.$widget = $(widget.body);
    }

    {{camelCase}}.prototype.init = function () {

    };

    return {{camelCase}};
});