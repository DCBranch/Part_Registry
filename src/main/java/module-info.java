module part_registry {
    requires java.base;
	requires javafx.base;
	requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens dCB.portfolio.part_registry to javafx.fxml;
    exports dCB.portfolio.part_registry;
}