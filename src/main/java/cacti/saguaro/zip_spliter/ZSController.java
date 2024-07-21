package cacti.saguaro.zip_spliter;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ZSController {

    @FXML
    TextField field;
    @FXML
    TextField byteField;

    @FXML
    private void initialize(){
        byteField.setText("26214400");
    }

    @FXML
    private void onSplitButtonClick() throws ZipException {
        if(field.getText().isEmpty() || byteField.getText().isEmpty() || Objects.equals(field.getText(), "u cant leave this or byte field empty"))
            field.setText("u cant leave this or byte field empty");
        else {
            field.setText(field.getText().trim());
            removeSlash();
            splitZip();
        }
    }

    private void splitZip() throws ZipException {
        List<File> filesToAdd = Arrays.asList(
                new File(field.getText())
        );

        ZipFile zipFile = new ZipFile("split.zip");
        zipFile.createSplitZipFile(filesToAdd, new ZipParameters(), true, Long.parseLong(byteField.getText().trim()));
    }

    private void removeSlash(){
        if(field.getText().charAt(field.getLength() - 1) == '/'){
            field.setText(field.getText().substring(0, field.getLength() - 1));
            removeSlash();
        }
    }
}