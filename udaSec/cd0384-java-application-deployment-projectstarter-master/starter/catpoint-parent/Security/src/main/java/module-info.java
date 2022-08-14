module com.udacity.catpoint.security {
    exports com.udacity.catpoint.security.securityService;
    exports com.udacity.catpoint.security.data;
    requires java.desktop;
    requires com.udacity.catpoint.image;
    requires com.google.common;
    requires com.google.gson;
    requires java.prefs;
    requires miglayout;
}