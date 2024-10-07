package com.example.demo1;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class HelloController {

    Graph graph =new Graph();
    Kruskal cruskal;
    Dijkstra dijkstra;
    BFS bfs;
    int current;
    int[] way = new int[14];
    int[] distance;
    int start;
    @FXML
    private Button KruskalButton;
    @FXML
    private Button KruskalPaneReturn;
    @FXML
    private Button DijkstraPaneReturn;
    @FXML
    private Button KruskalPaneNext;
    @FXML
    private Button KruskalPaneResult;
    @FXML
    private Button DijkstraPaneNext;
    @FXML
    private Button DijkstraPaneResult;
    @FXML
    private Button BFSPaneNext;
    @FXML
    private Button BFSPaneResult;
    @FXML
    private Pane KruskalPane;
    @FXML
    private Pane DijkstraPane;

    @FXML
    private Pane BFSPane;
    @FXML
    private Pane StartPane;
    @FXML
    private Line line1_2;
    @FXML
    private Line line1_3;
    @FXML
    private Line line1_4;
    @FXML
    private Line line1_5;
    @FXML
    private Line line2_6;
    @FXML
    private Line line3_2;
    @FXML
    private Line line3_6;
    @FXML
    private Line line6_10;
    @FXML
    private Line line3_10;
    @FXML
    private Line line3_7;
    @FXML
    private Line line3_8;
    @FXML
    private Line line4_3;
    @FXML
    private Line line4_8;
    @FXML
    private Line line4_9;
    @FXML
    private Line line5_9;
    @FXML
    private Line line7_10;
    @FXML
    private Line line7_11;
    @FXML
    private Line line7_14;
    @FXML
    private Line line7_8;
    @FXML
    private Line line8_12;
    @FXML
    private Line line8_13;
    @FXML
    private Line line9_13;
    @FXML
    private Line line10_14;
    @FXML
    private Line line11_14;
    @FXML
    private Line line12_14;
    @FXML
    private Line line13_14;
    @FXML
    private Polyline arrow1_2;
    @FXML
    private Polyline arrow1_3;
    @FXML
    private Polyline arrow1_4;
    @FXML
    private Polyline arrow1_5;
    @FXML
    private Polyline arrow2_6;
    @FXML
    private Polyline arrow3_2;
    @FXML
    private Polyline arrow3_6;
    @FXML
    private Polyline arrow6_10;
    @FXML
    private Polyline arrow3_10;
    @FXML
    private Polyline arrow3_7;
    @FXML
    private Polyline arrow3_8;
    @FXML
    private Polyline arrow4_3;
    @FXML
    private Polyline arrow4_8;
    @FXML
    private Polyline arrow4_9;
    @FXML
    private Polyline arrow5_9;
    @FXML
    private Polyline arrow7_10;
    @FXML
    private Polyline arrow7_11;
    @FXML
    private Polyline arrow7_14;
    @FXML
    private Polyline arrow7_8;
    @FXML
    private Polyline arrow8_12;
    @FXML
    private Polyline arrow8_13;
    @FXML
    private Polyline arrow9_13;
    @FXML
    private Polyline arrow10_14;
    @FXML
    private Polyline arrow11_14;
    @FXML
    private Polyline arrow12_14;
    @FXML
    private Polyline arrow13_14;

    private Line[][] lineMatrix = new Line[14][14];
    private Polyline[][] ArrowMatrix = new Polyline[14][14];

    @FXML
    private Circle circle1, circle2, circle3, circle4, circle5, circle6, circle7, circle8, circle9, circle10, circle11, circle12, circle13, circle14;
    private Circle[] CircleMatrix = new Circle[14];

    @FXML
    private Text text1_2, text1_3, text1_4, text1_5, text2_6, text3_2, text3_6, text6_10, text3_10;
    @FXML
    private Text text3_7, text3_8, text4_3, text4_8, text4_9, text5_9, text7_10, text7_11;
    @FXML
    private Text text7_14, text7_8, text8_12, text8_13, text9_13, text10_14, text11_14, text12_14, text13_14;

    @FXML
    private Text textCircle1, textCircle2, textCircle3, textCircle4, textCircle5, textCircle6, textCircle7, textCircle8, textCircle9, textCircle10, textCircle11, textCircle12, textCircle13, textCircle14;

    private Text[][] textMatrix = new Text[14][14];
    private Text[] textCircle = new Text[14];

    @FXML
    public void initialize() {

        lineMatrix[0][1] = line1_2;
        lineMatrix[0][2] = line1_3;
        lineMatrix[0][3] = line1_4;
        lineMatrix[0][4] = line1_5;

        lineMatrix[1][5] = line2_6;

        lineMatrix[2][1] = line3_2;
        lineMatrix[2][5] = line3_6;
        lineMatrix[2][9] = line3_10;
        lineMatrix[2][6] = line3_7;
        lineMatrix[2][7] = line3_8;

        lineMatrix[3][2] = line4_3;
        lineMatrix[3][7] = line4_8;
        lineMatrix[3][8] = line4_9;

        lineMatrix[4][8] = line5_9;

        lineMatrix[6][9] = line7_10;
        lineMatrix[6][10] = line7_11;
        lineMatrix[6][13] = line7_14;
        lineMatrix[6][7] = line7_8;

        lineMatrix[7][11] = line8_12;
        lineMatrix[7][12] = line8_13;

        lineMatrix[8][12] = line9_13;

        lineMatrix[9][13] = line10_14;

        lineMatrix[10][13] = line11_14;

        lineMatrix[11][13] = line12_14;

        lineMatrix[12][13] = line13_14;
        lineMatrix[5][9] = line6_10;
        ArrowMatrix[0][1] = arrow1_2;
        ArrowMatrix[0][2] = arrow1_3;
        ArrowMatrix[0][3] = arrow1_4;
        ArrowMatrix[0][4] = arrow1_5;

        ArrowMatrix[1][5] = arrow2_6;

        ArrowMatrix[2][1] = arrow3_2;
        ArrowMatrix[2][5] = arrow3_6;
        ArrowMatrix[2][9] = arrow3_10;
        ArrowMatrix[2][6] = arrow3_7;
        ArrowMatrix[2][7] = arrow3_8;

        ArrowMatrix[3][2] = arrow4_3;
        ArrowMatrix[3][7] = arrow4_8;
        ArrowMatrix[3][8] = arrow4_9;

        ArrowMatrix[4][8] = arrow5_9;

        ArrowMatrix[6][9] = arrow7_10;
        ArrowMatrix[6][10] = arrow7_11;
        ArrowMatrix[6][13] = arrow7_14;
        ArrowMatrix[6][7] = arrow7_8;

        ArrowMatrix[7][11] = arrow8_12;
        ArrowMatrix[7][12] = arrow8_13;

        ArrowMatrix[8][12] = arrow9_13;

        ArrowMatrix[9][13] = arrow10_14;

        ArrowMatrix[10][13] = arrow11_14;

        ArrowMatrix[11][13] = arrow12_14;

        ArrowMatrix[12][13] = arrow13_14;

        ArrowMatrix[5][9] = arrow6_10;

        textMatrix[0][1] = text1_2;
        textMatrix[0][2] = text1_3;
        textMatrix[0][3] = text1_4;
        textMatrix[0][4] = text1_5;

        textMatrix[1][5] = text2_6;

        textMatrix[2][1] = text3_2;
        textMatrix[2][5] = text3_6;
        textMatrix[2][9] = text3_10;
        textMatrix[2][6] = text3_7;
        textMatrix[2][7] = text3_8;

        textMatrix[3][2] = text4_3;
        textMatrix[3][7] = text4_8;
        textMatrix[3][8] = text4_9;

        textMatrix[4][8] = text5_9;

        textMatrix[6][9] = text7_10;
        textMatrix[6][10] = text7_11;
        textMatrix[6][13] = text7_14;
        textMatrix[6][7] = text7_8;

        textMatrix[7][11] = text8_12;
        textMatrix[7][12] = text8_13;

        textMatrix[8][12] = text9_13;

        textMatrix[9][13] = text10_14;

        textMatrix[10][13] = text11_14;

        textMatrix[11][13] = text12_14;

        textMatrix[12][13] = text13_14;
        textMatrix[5][9] = text6_10;

        CircleMatrix[0] = circle1;
        CircleMatrix[1] = circle2;
        CircleMatrix[2] = circle3;
        CircleMatrix[3] = circle4;
        CircleMatrix[4] = circle5;
        CircleMatrix[5] = circle6;
        CircleMatrix[6] = circle7;
        CircleMatrix[7] = circle8;
        CircleMatrix[8] = circle9;
        CircleMatrix[9] = circle10;
        CircleMatrix[10] = circle11;
        CircleMatrix[11] = circle12;
        CircleMatrix[12] = circle13;
        CircleMatrix[13] = circle14;

        textCircle[0]=textCircle1;
        textCircle[1]=textCircle2;
        textCircle[2]=textCircle3;
        textCircle[3]=textCircle4;
        textCircle[4]=textCircle5;
        textCircle[5]=textCircle6;
        textCircle[6]=textCircle7;
        textCircle[7]=textCircle8;
        textCircle[8]=textCircle9;
        textCircle[9]=textCircle10;
        textCircle[10]=textCircle11;
        textCircle[11]=textCircle12;
        textCircle[12]=textCircle13;
        textCircle[13]=textCircle14;

        for(Text textCircle:textCircle)
        {
            textCircle.setVisible(false);
        }

    }
    @FXML
    public void onKruskalButtonClick() {
        StartPane.setVisible(false);
        KruskalPane.setVisible(true);
        cruskal = new Kruskal(graph);
    }

    @FXML
    public void onDijkstraButtonClick() {
        StartPane.setVisible(false);
        DijkstraPane.setVisible(true);
        start=1;
        dijkstra = new Dijkstra(graph, start);
        for(int i=0; i<14; i++)
        {
            textCircle[i].setVisible(true);
            textCircle[i].setText("∞");
        }
        textCircle[start-1].setText("0");
        CircleMatrix[start-1].setFill(Color.web("#ff0000"));
    }

    @FXML
    public void onBFSButtonClick() {
        StartPane.setVisible(false);
        BFSPane.setVisible(true);
        start=1;
        current=start-1;
        bfs = new BFS(graph, start);
        for(int i=0; i<14; i++)
        {
            for(int j=0; j<14; j++)
            {
                if(textMatrix[i][j]!=null)textMatrix[i][j].setVisible(false);
            }
        }
    }


    @FXML
    public void onKruskalPaneResultClick() {
        while (cruskal.next_step());
        int[][] tree = cruskal.getTree();

        KruskalPaneNext.setVisible(false);
        KruskalPaneResult.setVisible(false);
        for (int i = 0; i < lineMatrix.length; i++) {
            for (int j = 0; j < lineMatrix[i].length; j++) {
                System.out.print(tree[i][j]+" ");
                if(tree[i][j]!=0)
                {
                    lineMatrix[i][j].setStroke(Color.web("#ff0000"));
                    lineMatrix[i][j].setStrokeWidth(5);
                    ArrowMatrix[i][j].setFill(Color.web("#ff0000"));
                    textMatrix[i][j].setFill(Color.web("#ff0000"));;
                }
                else
                {
                    if (lineMatrix[i][j]!=null) lineMatrix[i][j].setVisible(false);
                    if (textMatrix[i][j]!=null) textMatrix[i][j].setVisible(false);
                    if (ArrowMatrix[i][j]!=null) ArrowMatrix[i][j].setVisible(false);
                }

            }
            System.out.println();
        }
    }

    @FXML
    public void onDijkstraPaneResultClick() {
        while (dijkstra.next_step());
        int[][] tree = dijkstra.getTree();

        DijkstraPaneNext.setVisible(false);
        DijkstraPaneResult.setVisible(false);
        int way[]=dijkstra.getPath();
        distance=dijkstra.getDistances();
        for (int i = 0; i < lineMatrix.length; i++) {
            textCircle[i].setText(distance[i]+" ("+(way[i]+1)+")");
            textCircle[i].setFill(Color.web("#ff0000"));
            for (int j = 0; j < lineMatrix[i].length; j++) {
                System.out.print(tree[i][j]+" ");
                if(tree[i][j]!=0)
                {
                    lineMatrix[i][j].setStroke(Color.web("#ff0000"));
                    lineMatrix[i][j].setStrokeWidth(5);
                    ArrowMatrix[i][j].setFill(Color.web("#ff0000"));
                    textMatrix[i][j].setFill(Color.web("#ff0000"));;
                }

            }
            System.out.println();
        }
    }

    @FXML
    public void onBFSPaneResultClick() {
        while (bfs.next_step());
        int[][] tree = bfs.getTree();

        BFSPaneNext.setVisible(false);
        BFSPaneResult.setVisible(false);
        for (int i = 0; i < lineMatrix.length; i++) {
            for (int j = 0; j < lineMatrix[i].length; j++) {
                System.out.print(tree[i][j]+" ");
                if(tree[i][j]!=0)
                {
                    lineMatrix[i][j].setStroke(Color.web("#ff0000"));
                    lineMatrix[i][j].setStrokeWidth(5);
                    textMatrix[i][j].setFill(Color.web("#ff0000"));
                    ArrowMatrix[i][j].setFill(Color.web("#ff0000"));
                }
                else
                {
                    if (lineMatrix[i][j]!=null) lineMatrix[i][j].setVisible(false);
                    if (textMatrix[i][j]!=null) textMatrix[i][j].setVisible(false);
                    if (ArrowMatrix[i][j]!=null) ArrowMatrix[i][j].setVisible(false);
                }

            }
            System.out.println();
        }
    }

    @FXML
    public void onKruskalPaneNextClick() {
        if(cruskal.next_step()) {

            int[][] tree = cruskal.getTree();
            for (int i = 0; i < lineMatrix.length; i++) {
                for (int j = 0; j < lineMatrix[i].length; j++) {
                    if(tree[i][j]!=0)
                    {
                        lineMatrix[i][j].setStroke(Color.web("#ff0000"));
                        lineMatrix[i][j].setStrokeWidth(5);
                        ArrowMatrix[i][j].setFill(Color.web("#ff0000"));
                        textMatrix[i][j].setFill(Color.web("#ff0000"));;
                    }

                }
            }

        }
        else onKruskalPaneResultClick();

    }

    @FXML
    public void onBFSPaneNextClick() {
        CircleMatrix[current].setFill(Color.WHITE);
        if(bfs.next_step()) {
            current=bfs.getCurrent();

            int[][] tree = bfs.getTree();
            for (int i = 0; i < lineMatrix.length; i++) {
                for (int j = 0; j < lineMatrix[i].length; j++) {
                    if(tree[i][j]!=0)
                    {
                        lineMatrix[i][j].setStroke(Color.web("#ff0000"));
                        ArrowMatrix[i][j].setFill(Color.web("#ff0000"));
                        lineMatrix[i][j].setStrokeWidth(5);
                    }

                }
            }
            current =bfs.getCurrent();
            CircleMatrix[current].setFill(Color.web("#ff0000"));

        }
        else onBFSPaneResultClick();

    }

    @FXML
    public void onDijkstraPaneNextClick() {
        CircleMatrix[current].setFill(Color.WHITE);

        if(dijkstra.next_step()) {
            int[][] tree = dijkstra.getTree();
            int way[]=dijkstra.getPath();
            distance=dijkstra.getDistances();

            for (int i = 0; i < lineMatrix.length; i++) {
                if(distance[i]!=Integer.MAX_VALUE)
                {
                    textCircle[i].setText(distance[i]+" ("+(way[i]+1)+")");
                    textCircle[i].setFill(Color.web("#ff0000"));
                }
                for (int j = 0; j < lineMatrix[i].length; j++) {
                    if(tree[i][j]!=0)
                    {
                        lineMatrix[i][j].setStroke(Color.web("#ff0000"));
                        lineMatrix[i][j].setStrokeWidth(5);
                        textMatrix[i][j].setFill(Color.web("#ff0000"));
                        ArrowMatrix[i][j].setFill(Color.web("#ff0000"));
                    }

                }
            }
            current = dijkstra.getCurrent();
            CircleMatrix[current].setFill(Color.web("#ff0000"));
        }

        else onDijkstraPaneResultClick();

    }

    @FXML
    public void onDijkstraPaneReturnClick() {
        for (int i = 0; i < lineMatrix.length; i++) {
            CircleMatrix[current].setFill(Color.WHITE);
            textCircle[i].setText("");
            textCircle[i].setFill(Color.web("BLACK"));
            textCircle[i].setVisible(false);
            for (int j = 0; j < lineMatrix[i].length; j++) {
                if (lineMatrix[i][j]!=null)
                {
                    lineMatrix[i][j].setStroke(Color.web("BLACK"));
                    lineMatrix[i][j].setStrokeWidth(1);
                    ArrowMatrix[i][j].setFill(Color.web("#898484"));
                    lineMatrix[i][j].setVisible(true);
                }
                if (textMatrix[i][j]!=null)
                {
                    textMatrix[i][j].setFill(Color.web("BLACK"));
                    textMatrix[i][j].setVisible(true);
                }
                DijkstraPaneNext.setVisible(true);
                DijkstraPaneResult.setVisible(true);
                StartPane.setVisible(true);
                DijkstraPane.setVisible(false);
            }
        }
    }

    @FXML
    public void onBFSPaneReturnClick() {
        for (int i = 0; i < lineMatrix.length; i++) {
            CircleMatrix[current].setFill(Color.WHITE);
            for (int j = 0; j < lineMatrix[i].length; j++) {
                if (lineMatrix[i][j]!=null)
                {
                    lineMatrix[i][j].setStroke(Color.web("BLACK"));
                    lineMatrix[i][j].setStrokeWidth(1);
                    lineMatrix[i][j].setVisible(true);
                    ArrowMatrix[i][j].setFill(Color.web("#898484"));
                    ArrowMatrix[i][j].setVisible(true);
                }
                if (textMatrix[i][j]!=null)
                {
                    textMatrix[i][j].setFill(Color.web("BLACK"));
                    textMatrix[i][j].setVisible(true);
                }
                BFSPaneNext.setVisible(true);
                BFSPaneResult.setVisible(true);
                StartPane.setVisible(true);
                BFSPane.setVisible(false);
            }
        }
    }



    @FXML
    public void onKruskalPaneReturnClick() {
        for (int i = 0; i < lineMatrix.length; i++) {
            for (int j = 0; j < lineMatrix[i].length; j++) {
                if (lineMatrix[i][j]!=null)
                {
                    lineMatrix[i][j].setStroke(Color.web("BLACK"));
                    lineMatrix[i][j].setStrokeWidth(1);
                    lineMatrix[i][j].setVisible(true);
                    ArrowMatrix[i][j].setFill(Color.web("#898484"));
                    ArrowMatrix[i][j].setVisible(true);
                }
                if (textMatrix[i][j]!=null)
                {
                    textMatrix[i][j].setFill(Color.web("BLACK"));
                    textMatrix[i][j].setVisible(true);
                }
                KruskalPaneNext.setVisible(true);
                KruskalPaneResult.setVisible(true);
                StartPane.setVisible(true);
                KruskalPane.setVisible(false);
            }
        }
    }
}