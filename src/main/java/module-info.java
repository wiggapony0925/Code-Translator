module com.example.code_changer {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
                requires org.kordamp.ikonli.javafx;
                
    opens com.example.code_changer to javafx.fxml;
    exports com.example.code_changer;
}