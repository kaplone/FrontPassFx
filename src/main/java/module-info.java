module fr.acelys.frontpassfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens fr.acelys.frontpassfx to javafx.fxml;
    exports fr.acelys.frontpassfx;
}