package com.teachmeskills.figuresfx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Rectangle extends Figure {
    private double width;
    private double height;


    private Rectangle(double cx, double cy, double lineWidth, Color color) {
        super(FIGURE_TYPE_RECTANGLE, cx, cy, lineWidth, color);
    }

    public Rectangle(double cx, double cy, double lineWidth, Color color, double width, double height) {
        this(cx, cy, lineWidth, color);
        this.width = width < 10 ? 10 : width; //созд. прямоуг. шириной не менее 10
        this.height = height < 10 ? 10 : height;//созд. прямоуг. высотой не менее 10
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWidth);
        gc.setStroke(color);
        gc.strokeRect(cx - width / 2, cy - height / 2, width, height);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.width, width) == 0 &&
                Double.compare(rectangle.height, height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                ", cx=" + cx +
                ", cy=" + cy +
                ", lineWidth=" + lineWidth +
                ", color=" + color +
                '}';
    }
}
