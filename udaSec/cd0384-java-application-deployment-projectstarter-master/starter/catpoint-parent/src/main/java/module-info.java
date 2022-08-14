module com.udacity.catpoint {
    requires java.desktop;
    requires miglayout;
    requires com.udacity.catpoint.image;
    requires com.udacity.catpoint.security;
    opens com.udacity.catpoint.application to com.udacity.catpoint.security;
    exports com.udacity.catpoint.image;
    exports com.udacity.catpoint.application;

}