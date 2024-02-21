package org.example.ui.Components;

public class Button extends javafx.scene.control.Button implements Component {

    private Boolean active;
    private String text;

    public Button(Boolean active, String text){
        super();
        this.active = active;
        this.text = text;
        initComponent();
    }

    private void initComponent() {

        getStyleClass().add("button-login");
        updateState();

        this.setText(text);

        setOnMouseClicked(e -> {
            this.active = !this.active;
            updateState();
        });


        getStylesheets().add("styles.css");


    }

    @Override
    public void updateState(){
        getStyleClass().remove(!active ? "active-button" : "disabled-button");
        getStyleClass().add(active ? "active-button" : "disabled-button");
        requestLayout();
    }

    public void activeButton(){
        this.active = true;
    }

    public void disableButton(){
        this.active = false;
    }

}
