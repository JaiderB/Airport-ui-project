package org.example.ui.Components;

import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.text.TextAlignment;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public class LinkText extends Label implements Component {

    private String text;
    private Boolean active;
    private Boolean oneLineLink;

    public LinkText(Boolean active, String text, Boolean oneLineLink){
        this.oneLineLink = oneLineLink;
        this.text = text;
        this.active = active;

        initComponents();
    }

    private void initComponents() {

        String finalText = "";
        getStyleClass().add("link-text");
        updateState();

        AtomicReference<Double> height = new AtomicReference<>(0.0);

        if(!oneLineLink){

            height.updateAndGet(v -> v + 36.0);
            finalText = Arrays.stream(text.split(" ")).reduce((x, y) -> {
                height.updateAndGet(v -> v + 36.0);
                return x + "\n" + y;
            }).get();

        }else{

            height.updateAndGet(v -> v + 45.0);
            finalText = text;

        }

        setMinHeight(height.get());
        setText(finalText);
        setTextAlignment(TextAlignment.CENTER);

        setTextOverrun(OverrunStyle.CLIP);
        setWrapText(true);


        getStylesheets().add("styles.css");

        loadEvents();

    }

    private void loadEvents() {

        setOnMouseClicked(event -> {
            this.active = !this.active;
            updateState();
        });

    }

    @Override
    public void updateState() {

        getStyleClass().remove(!this.active? "link-text-active": "link-text-disabled");
        getStyleClass().add(this.active? "link-text-active": "link-text-disabled");
        requestLayout();

    }
}
