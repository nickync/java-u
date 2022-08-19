module com.udacity.catpoint.security {
    requires miglayout;
    requires java.desktop;
    requires com.google.common;
    requires com.google.gson;
    requires java.prefs;
    requires com.udacity.catpoint.imageService;

    opens com.udacity.catpoint.security.data to com.google.gson;

//    exports com.udacity.catpoint.security.securityService;
//    exports com.udacity.catpoint.security.data;
//    exports com.udacity.catpoint.security.application;
//    requires java.desktop;
//    requires com.google.common;
//    requires com.google.gson;
//    requires java.prefs;
//    requires miglayout;
}