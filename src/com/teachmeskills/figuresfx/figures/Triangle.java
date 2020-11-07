package com.teachmeskills.figuresfx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Triangle extends Figure {
    private double lengthOfTheEdge;

    public Triangle(double cx, double cy, double lineWidth, Color color) {
        super(FIGURE_TYPE_TRIANGLE, cx, cy, lineWidth, color);
    }

    public Triangle(double cx, double cy, double lineWidth, Color color, double lengthOfTheEdge) {
        this(cx, cy, lineWidth, color);
        this.lengthOfTheEdge = lengthOfTheEdge < 10 ? 10 : lengthOfTheEdge;
    }

    public double getLengthOfTheEdge() {
        return lengthOfTheEdge;
    }

    public void setLengthOfTheEdge(double lengthOfTheEdge) {
        this.lengthOfTheEdge = lengthOfTheEdge;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWidth);
        gc.setStroke(color);
        gc.strokePolygon(new double[]{cx, cx + lengthOfTheEdge / 2, cx + lengthOfTheEdge / 2},
                new double[]{cy, cy + lengthOfTheEdge / 2, cy - lengthOfTheEdge / 2}, 3);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.lengthOfTheEdge, lengthOfTheEdge) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lengthOfTheEdge);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "lengthOfTheEdge=" + lengthOfTheEdge +
                ", cx=" + cx +
                ", cy=" + cy +
                ", lineWidth=" + lineWidth +
                ", color=" + color +
                '}';
    }
}