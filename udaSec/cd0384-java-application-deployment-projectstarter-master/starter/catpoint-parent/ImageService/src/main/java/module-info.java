module com.udacity.catpoint.imageService {
    exports com.udacity.catpoint.imageService to com.udacity.catpoint.security;
    requires org.slf4j;
    requires software.amazon.awssdk.auth;
    requires software.amazon.awssdk.core;
    requires software.amazon.awssdk.regions;
    requires software.amazon.awssdk.services.rekognition;
    requires java.desktop;

//    requires software.amazon.awssdk.services.rekognition;
//    requires software.amazon.awssdk.auth;
//    requires software.amazon.awssdk.core;
//    requires software.amazon.awssdk.regions;
//    requires org.slf4j;
//    requires java.desktop;
//    opens com.udacity.catpoint.imageService;
//    exports com.udacity.catpoint.imageService;


}