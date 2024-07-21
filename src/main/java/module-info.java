module cacti.saguaro.zip_spliter {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires zip4j;
    requires javafx.graphics;

    opens cacti.saguaro.zip_spliter to javafx.fxml;
    exports cacti.saguaro.zip_spliter;
}