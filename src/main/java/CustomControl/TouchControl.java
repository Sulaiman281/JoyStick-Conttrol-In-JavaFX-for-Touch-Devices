package CustomControl;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class TouchControl extends AnchorPane {

    private Circle boundary;
    private Circle mover;

    private double vertical;
    private double horizontal;

    private double x ,y;

    public TouchControl(){
        boundary = new Circle();
        mover = new Circle();

        setPrefWidth(300);
        setPrefHeight(300);

        boundary.setLayoutX(150);
        boundary.setLayoutY(150);
        mover.setLayoutX(150);
        mover.setLayoutY(150);

        boundary.setRadius(100);
        mover.setRadius(50);

        boundary.setFill(Color.rgb(255,255,255,.4));
        mover.setFill(Color.rgb(255,255,255,1));
        boundary.setStroke(Color.TRANSPARENT);
        mover.setStroke(Color.TRANSPARENT);

        setStyle("-fx-background-color: rgb(0,0,0)");

        mover.setOnMousePressed(e->{
            x = e.getSceneX();
            y = e.getSceneY();
        });
        mover.setOnTouchPressed(e->{
            x = e.getTouchPoint().getSceneX();
            y = e.getTouchPoint().getSceneY();
        });

        mover.setOnMouseDragged(e->{
            double offsetX = (e.getSceneX() - x);
            double offsetY = (e.getSceneY() - y);

            double new_x = mover.getLayoutX() + offsetX;
            double new_y = mover.getLayoutY() + offsetY;
            if(new_x > 200)
                mover.setLayoutX(200);
            else if(new_x < 100)
                mover.setLayoutX(100);
            else
                mover.setLayoutX(new_x);

            if(new_y > 200)
                mover.setLayoutY(200);
            else if(new_y < 100)
                mover.setLayoutY(100);
            else
                mover.setLayoutY(new_y);

            horizontal = normalize(new_x,150,200);
            vertical = normalize(new_y,150,200);
            System.out.println("Horizontal: "+horizontal+"\t"+"Vertical: "+vertical);

            x = e.getSceneX();
            y = e.getSceneY();
        });
        mover.setOnTouchMoved(e->{
            double offsetX = (e.getTouchPoint().getSceneX() - x);
            double offsetY = (e.getTouchPoint().getSceneY() - y);

            double new_x = mover.getLayoutX() + offsetX;
            double new_y = mover.getLayoutY() + offsetY;
            if(new_x > 200)
                mover.setLayoutX(200);
            else if(new_x < 100)
                mover.setLayoutX(100);
            else
                mover.setLayoutX(new_x);

            if(new_y > 200)
                mover.setLayoutY(200);
            else if(new_y < 100)
                mover.setLayoutY(100);
            else
                mover.setLayoutY(new_y);

            horizontal = normalize(new_x,150,200);
            vertical = normalize(new_y,150,200);
            System.out.println("Horizontal: "+horizontal+"\t"+"Vertical: "+vertical);

            x = e.getTouchPoint().getSceneX();
            y = e.getTouchPoint().getSceneY();
        });
        mover.setOnMouseReleased(e->{
            mover.setLayoutX(150);
            mover.setLayoutY(150);
        });
        mover.setOnTouchReleased(e->{
            mover.setLayoutX(150);
            mover.setLayoutY(150);
        });

        vertical = 0;
        horizontal = 0;

        getChildren().addAll(boundary,mover);
    }

    public double normalize(double value, double min, double max){
        return (value - min) / (max - min);
    }

    public double getVertical() {
        return vertical;
    }

    public void setVertical(double vertical) {
        this.vertical = vertical;
    }

    public double getHorizontal() {
        return horizontal;
    }

    public void setHorizontal(double horizontal) {
        this.horizontal = horizontal;
    }
}
