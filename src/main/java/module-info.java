module iutdijon.cryptomessengerclient {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.base;
    opens derniertourencotedor.controler to javafx.fxml ;
    exports derniertourencotedor;
}