package com.teachmeskills.figuresfx.controller;

import com.teachmeskills.figuresfx.drawutils.Drawer;
import com.teachmeskills.figuresfx.exceptions.UnknownFigureTypeException;
import com.teachmeskills.figuresfx.figures.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import org.apache.log4j.Logger;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;


public class MainScreenViewController implements Initializable {
    private static final Logger logger = Logger.getLogger(MainScreenViewController.class);
    private ArrayList<Figure> figures = new ArrayList<>();
    private Random random;

    @FXML
    private Canvas canvas;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logger.info("MainScreenViewController started.");
        random = new Random(System.currentTimeMillis());
    }

    private Figure createFigure(double x, double y) {
        Figure figure = null;

        switch (random.nextInt(5)) {
            case Figure.FIGURE_TYPE_CIRCLE:
                figure = new Circle(x, y, Math.max(random.nextInt(3), 10), Color.BLUE, random.nextInt(50));
                logger.info("Circle was created.");
                break;
            case Figure.FIGURE_TYPE_RECTANGLE:
                figure = new Rectangle(x, y, Math.max(random.nextInt(3), 10), Color.GREEN, random.nextInt(100), random.nextInt(50));
                logger.info("Rectangle was created.");
                break;
            case Figure.FIGURE_TYPE_TRIANGLE:
                figure = new Triangle(x, y, Math.max(random.nextInt(3), 10), Color.RED, random.nextInt(50));
                logger.info("Triangle was created.");
                break;
            case Figure.FIGURE_TYPE_ELLIPSE:
                figure = new Ellipse(x, y, Math.max(random.nextInt(3), 10), Color.AQUA, random.nextInt(30));
                logger.info("Ellipse was created.");
                break;
            case Figure.FIGURE_TYPE_STAR:
                figure = new Star(x, y, Math.max(random.nextInt(3), 10), Color.BISQUE, random.nextInt(30));
                logger.info("Star was created.");
                break;
            default:
                try {
                    throw new UnknownFigureTypeException("Unknown figure.");
                } catch (UnknownFigureTypeException e) {
                    logger.error(e.getMessage());
                }
        }
        return figure;
    }

    private void repaint() {
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        Drawer<Figure> drawer = new Drawer<>(figures);
        drawer.draw(canvas.getGraphicsContext2D());
    }

    @FXML
    private void onMouseClicked(MouseEvent mouseEvent) {
        figures.add(createFigure(mouseEvent.getX(), mouseEvent.getY()));
        repaint();
    }
}