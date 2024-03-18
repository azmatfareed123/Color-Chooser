// Fig. 13.9: ColorChooserController.java
// Controller for the ColorChooser app

package com.mycompany.colorchooser;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ColorChooserController {
    @FXML private Slider redSlider;
    @FXML private Slider greenSlider;
    @FXML private Slider blueSlider;
    @FXML private Slider alphaSlider;
    @FXML private TextField redTextField;
    @FXML private TextField greenTextField;
    @FXML private TextField blueTextField;
    @FXML private TextField alphaTextField;
    @FXML private Rectangle colorRectangle;

    public void initialize() {
        bindSliderAndTextField(redSlider, redTextField);
        bindSliderAndTextField(greenSlider, greenTextField);
        bindSliderAndTextField(blueSlider, blueTextField);
        bindSliderAndTextField(alphaSlider, alphaTextField);

        redSlider.valueProperty().addListener((observable, oldValue, newValue) -> updateColor());
        greenSlider.valueProperty().addListener((observable, oldValue, newValue) -> updateColor());
        blueSlider.valueProperty().addListener((observable, oldValue, newValue) -> updateColor());
        alphaSlider.valueProperty().addListener((observable, oldValue, newValue) -> updateColor());
    }


    
    private void bindSliderAndTextField(Slider slider, TextField textField) {
    slider.valueProperty().addListener((observable, oldValue, newValue) -> {
        if (newValue != null) {
            textField.setText(String.format("%.0f", newValue));
        }
    });

    textField.textProperty().addListener((observable, oldValue, newValue) -> {
        if (newValue != null && !newValue.isEmpty()) {
            try {
                double value = Double.parseDouble(newValue);
                slider.setValue(value);
            } catch (NumberFormatException e) {
            }
        }
    });
}


    private void updateColor() {
        int red = (int) redSlider.getValue();
        int green = (int) greenSlider.getValue();
        int blue = (int) blueSlider.getValue();
        double alpha = alphaSlider.getValue();
        colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
    }
}



/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
