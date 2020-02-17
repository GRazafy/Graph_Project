import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GraphicalFrame extends JFrame {

    /** Pour éviter un warning venant du JFrame */
    private static final long serialVersionUID = -8123406571694511514L;
    private Button refreshButton = new Button("Refresh Graph");
    private Label explicationPrim = new Label("Please choose \n the first Vertex");
    private Graph graph;

    GraphicalFrame() {
        super("example");
        graph = new Graph(getContentPane());
        this.setMinimumSize(new Dimension(600,400));

    }

    public void Prim(){
        setTitle("Prim Example");
        refreshButton.setBounds(320,20,150,20);
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                graph.reset();
                getContentPane().repaint();
            }
        });

        explicationPrim.setBounds(280,60,200,40);


        graph.initPrimGraph();
        getContentPane().add(explicationPrim);
        getContentPane().add(refreshButton);
        getContentPane().add(graph.getComponent());
    }

    public void Kruskal(){
        setTitle("Kruskal Example");
        graph.initDefaultGraph();
        graph.KrusalAlgorithm();
        getContentPane().add(graph.getComponent());

    }

    public void run() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 320);
        this.setVisible(true);
    }
}