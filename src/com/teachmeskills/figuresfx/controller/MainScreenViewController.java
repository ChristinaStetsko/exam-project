package com.teachmeskills.figuresfx.controller;

import com.teachmeskills.figuresfx.figures.Circle;
import com.teachmeskills.figuresfx.figures.Figure;
import com.teachmeskills.figuresfx.figures.Rectangle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class MainScreenViewController implements Initializable {
    private Figure[] figures;
    private Random random;

    @FXML
    private Canvas canvas;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        figures = new Figure[1];
        random = new Random(System.currentTimeMillis());
    }

    private void addFigure(Figure figure) {
        if (figures[figures.length - 1] == null) {
            figures[figures.length - 1] = figure;
            return;
        }

        Figure[] tmp = new Figure[figures.length + 1];


        int index = 0;
        for (; index < figures.length; index++) {
            tmp[index] = figures[index];
        }

        tmp[index] = figure;
        figures = tmp;
    }

    private Figure createFigure(double x, double y) {
        Figure figure = null;

        switch (random.nextInt(3)) {
            case Figure.FIGURE_TYPE_CIRCLE:
                figure = new Circle(x, y, Math.max(random.nextInt(3), 10), Color.BLUE, random.nextInt(50));
                break;
            case Figure.FIGURE_TYPE_RECTANGLE:
                figure = new Rectangle(x, y, Math.max(random.nextInt(3), 10), Color.GREEN, random.nextInt(100), random.nextInt(50));
                break;
            case Figure.FIGURE_TYPE_TRIANGLE:  //отрисовать треугольник + ещё 2 фигуры (квадрат и элипс - проще всего)
                break; // можно сердечки, менюшки
        }

        return figure;
    }

    private void repaint() {
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (Figure figure : figures) {
            if (figure != null) {
                figure.draw(canvas.getGraphicsContext2D());
            }
        }
    }

    @FXML
    private void onMouseClicked(MouseEvent mouseEvent) {
        addFigure(createFigure(mouseEvent.getX(), mouseEvent.getY()));
        repaint();
    }
}
