import com.mxgraph.model.mxCell;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.List;


public class Graph extends mxGraph {

    private  Object parent;
    final mxGraphComponent graphComponent = new mxGraphComponent(this);
    private Container localContainer;

    Graph(Container e){
        parent = this.getDefaultParent();
        localContainer = e;

    }

    public Object getParent() {
        return parent;
    }

    public void setParent(Object parent) {
        this.parent = parent;
    }


    public void initDefaultGraph(){



        Map<String, Object> edgeStyle = this.getStylesheet().getDefaultEdgeStyle();
        edgeStyle.put(mxConstants.STYLE_ENDARROW, mxConstants.NONE);


        this.getModel().beginUpdate();
        try {
            Object A = this.insertVertex(parent, "A", "A", 200, 20, 20, 20,
                    mxConstants.STYLE_SHAPE + "="+mxConstants.SHAPE_ELLIPSE);
            Object B = this.insertVertex(parent, "B", "B", 60, 100, 20, 20,
                    mxConstants.STYLE_SHAPE + "="+mxConstants.SHAPE_ELLIPSE);
            Object C = this.insertVertex(parent, "C", "C", 140, 100, 20, 20,
                    mxConstants.STYLE_SHAPE + "="+mxConstants.SHAPE_ELLIPSE);
            Object D = this.insertVertex(parent, "D", "D", 240, 100, 20, 20,
                    mxConstants.STYLE_SHAPE + "="+mxConstants.SHAPE_ELLIPSE);
            Object E = this.insertVertex(parent, "E", "E", 140, 180, 20, 20,
                    mxConstants.STYLE_SHAPE + "="+mxConstants.SHAPE_ELLIPSE);
            Object F = this.insertVertex(parent, "F", "F", 40, 260, 20, 20,
                    mxConstants.STYLE_SHAPE + "="+mxConstants.SHAPE_ELLIPSE);
            Object G = this.insertVertex(parent, "G", "G", 200, 260, 20, 20,
                    mxConstants.STYLE_SHAPE + "="+mxConstants.SHAPE_ELLIPSE);
            Object X = this.insertVertex(parent, "X", "X", 20, 100, 20, 20,
                    mxConstants.STYLE_SHAPE + "="+mxConstants.SHAPE_ELLIPSE);
            this.insertEdge(parent, "AB", 3, A, B);
            this.insertEdge(parent, "AC", 4, A, C);
            this.insertEdge(parent, "AD", 2, A, D);
            this.insertEdge(parent, "AE", 1, A, E);
            this.insertEdge(parent, "AX", 2, A, X);
            this.insertEdge(parent, "BC", 4, B, C);
            this.insertEdge(parent, "BE", 5, B, E);
            this.insertEdge(parent, "CE", 3, B, X);
            this.insertEdge(parent, null, 5, C, E);
            this.insertEdge(parent, null, 5, C, D);
            this.insertEdge(parent, null, 3, D, E);
            this.insertEdge(parent, null, 9, D, G);
            this.insertEdge(parent, null, 2, E, X);
            this.insertEdge(parent, null, 9, E, G);
            this.insertEdge(parent, null, 7, F, X);
            this.insertEdge(parent, null, 8, F, G);
            this.insertEdge(parent, null, 3, B, A);
            this.insertEdge(parent, null, 4, C, A);
            this.insertEdge(parent, null, 2, D, A);
            this.insertEdge(parent, null, 1, E, A);
            this.insertEdge(parent, null, 2, X, A);
            this.insertEdge(parent, null, 4, C, B);
            this.insertEdge(parent, null, 5, E, B);
            this.insertEdge(parent, null, 3, X, B);
            this.insertEdge(parent, null, 5, E, C);
            this.insertEdge(parent, null, 5, D, C);
            this.insertEdge(parent, null, 3, E, D);
            this.insertEdge(parent, null, 9, G, D);
            this.insertEdge(parent, null, 2, X, E);
            this.insertEdge(parent, null, 9, G, E);
            this.insertEdge(parent, null, 7, X, F);
            this.insertEdge(parent, null, 8, G, F);
        } finally {
            this.getModel().endUpdate();
        }
    }

    public void initPrimGraph(){

        this.graphComponent.getGraphControl().addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                mxCell cell =(mxCell) graphComponent.getCellAt(e.getX(), e.getY());
                if(cell != null)
                {
                    System.out.print(cell.getId()+"\n");
                    if(cell.getId() == "E"){
                        System.out.print(cell.getId()+"\n");
                    }
                    PrimAlgorithm(cell.getId());
                }
            }
        });

        Map<String, Object> edgeStyle = this.getStylesheet().getDefaultEdgeStyle();
        edgeStyle.put(mxConstants.STYLE_ENDARROW, mxConstants.NONE);


        this.getModel().beginUpdate();
        try {
            Object A = this.insertVertex(parent, "A", "A", 200, 20, 20, 20,
                    mxConstants.STYLE_SHAPE + "="+mxConstants.SHAPE_ELLIPSE);
            Object B = this.insertVertex(parent, "B", "B", 60, 100, 20, 20,
                    mxConstants.STYLE_SHAPE + "="+mxConstants.SHAPE_ELLIPSE);
            Object C = this.insertVertex(parent, "C", "C", 140, 100, 20, 20,
                    mxConstants.STYLE_SHAPE + "="+mxConstants.SHAPE_ELLIPSE);
            Object D = this.insertVertex(parent, "D", "D", 240, 100, 20, 20,
                    mxConstants.STYLE_SHAPE + "="+mxConstants.SHAPE_ELLIPSE);
            Object E = this.insertVertex(parent, "E", "E", 140, 180, 20, 20,
                    mxConstants.STYLE_SHAPE + "="+mxConstants.SHAPE_ELLIPSE);
            Object F = this.insertVertex(parent, "F", "F", 40, 260, 20, 20,
                    mxConstants.STYLE_SHAPE + "="+mxConstants.SHAPE_ELLIPSE);
            Object G = this.insertVertex(parent, "G", "G", 200, 260, 20, 20,
                    mxConstants.STYLE_SHAPE + "="+mxConstants.SHAPE_ELLIPSE);
            Object X = this.insertVertex(parent, "X", "X", 20, 100, 20, 20,
                    mxConstants.STYLE_SHAPE + "="+mxConstants.SHAPE_ELLIPSE);
            this.insertEdge(parent, "AB", 3, A, B);
            this.insertEdge(parent, "AC", 4, A, C);
            this.insertEdge(parent, "AD", 2, A, D);
            this.insertEdge(parent, "AE", 1, A, E);
            this.insertEdge(parent, "AX", 2, A, X);
            this.insertEdge(parent, "BC", 4, B, C);
            this.insertEdge(parent, "BE", 5, B, E);
            this.insertEdge(parent, "CE", 3, B, X);
            this.insertEdge(parent, null, 5, C, E);
            this.insertEdge(parent, null, 5, C, D);
            this.insertEdge(parent, null, 3, D, E);
            this.insertEdge(parent, null, 9, D, G);
            this.insertEdge(parent, null, 2, E, X);
            this.insertEdge(parent, null, 9, E, G);
            this.insertEdge(parent, null, 7, F, X);
            this.insertEdge(parent, null, 8, F, G);
            this.insertEdge(parent, null, 3, B, A);
            this.insertEdge(parent, null, 4, C, A);
            this.insertEdge(parent, null, 2, D, A);
            this.insertEdge(parent, null, 1, E, A);
            this.insertEdge(parent, null, 2, X, A);
            this.insertEdge(parent, null, 4, C, B);
            this.insertEdge(parent, null, 5, E, B);
            this.insertEdge(parent, null, 3, X, B);
            this.insertEdge(parent, null, 5, E, C);
            this.insertEdge(parent, null, 5, D, C);
            this.insertEdge(parent, null, 3, E, D);
            this.insertEdge(parent, null, 9, G, D);
            this.insertEdge(parent, null, 2, X, E);
            this.insertEdge(parent, null, 9, G, E);
            this.insertEdge(parent, null, 7, X, F);
            this.insertEdge(parent, null, 8, G, F);
        } finally {
            this.getModel().endUpdate();
        }
    }

    public boolean hasCycle(Object sourceVertex, List<Object> vericles2check,List<Object> checkedVerticles) {
        vericles2check.add(sourceVertex);

        for (Object neighbor : this.getOpposites(this.getEdges(new mxCell[]{(mxCell) sourceVertex},null,true,true,false,true),true)) {
            if (vericles2check.contains(neighbor)) {
                // backward edge exists
                return true;
            } else if (!checkedVerticles.contains(neighbor) && hasCycle(neighbor,vericles2check,checkedVerticles)) {
                return true;
            }
        }

        vericles2check.remove(sourceVertex);
        checkedVerticles.add(sourceVertex);
        return false;
    }

    public void KrusalAlgorithm(){
        Object[] cells = this.getChildVertices(this.getDefaultParent());
        List<Object> checkedVerticles = new ArrayList<>();
        List<Object> checkedVerticlesCycle = new ArrayList<>();
        List<Object> vericles2check = new ArrayList<>();
        Map<Object, Integer> edges2check = new HashMap<>();



        for (Object outgoing_edge : this.getAllEdges(cells)) {
            edges2check.put(outgoing_edge, (Integer) ((mxCell)outgoing_edge).getValue());
        }

        do {
            Map.Entry<Object, Integer> min = null;
            for (Map.Entry<Object, Integer> entry : edges2check.entrySet()) {
                if (min == null || min.getValue() > entry.getValue()) {
                    min = entry;

                }
            }

            try {
                //System.out.println(checkedVerticles.size());
                if (!hasCycle(((mxCell) min.getKey()).getSource(),vericles2check,checkedVerticlesCycle) || !hasCycle(this.getModel().getTerminal(min, false),vericles2check,checkedVerticlesCycle)) {
                    //System.out.println(( ((mxCell) min.getKey()).getSource()).getId() +" "+((mxCell)this.getModel().getTerminal(min.getKey(), false)).getId()+ " added to checkedVerticles \n");
                    checkedVerticles.add(((mxCell) min.getKey()).getSource());
                    checkedVerticles.add((mxCell)this.getModel().getTerminal(min.getKey(), false));
                    this.setCellStyles(mxConstants.STYLE_STROKECOLOR, "red", new Object[]{min.getKey()});

                }
                //System.out.println(checkedVerticles.size()+" "+((mxCell) min.getKey()).getSource().getId());
            }catch (Exception e){
                System.out.println("Dank");
            }
            System.out.println((this.getEdgesBetween(this.getModel().getTerminal(min, false),((mxCell) min.getKey()).getSource())));
            System.out.println(((mxCell) min.getKey()).getId());
            edges2check.remove(this.getEdgesBetween(this.getModel().getTerminal(min, false),((mxCell) min.getKey()).getSource()));
            edges2check.remove(min.getKey());
        }while(checkedVerticles.size() != cells.length);


    }



    public void PrimAlgorithm(String firstVertex){

        Object[] cells = this.getChildVertices(this.getDefaultParent());
        List<Object> checkedVerticles = new ArrayList<>();
        Map<Object, Integer> verticles2check = new HashMap<>();


        mxCell firstCell = new mxCell();
        for (Object c : cells)
        {
            mxCell cell = (mxCell) c;
            if(cell.getId() == firstVertex){
                firstCell = cell;

            }
        }
        checkedVerticles.add(firstCell);
        do {
            for (Object outgoing_edge : this.getOutgoingEdges(firstCell)) {
                if ( !checkedVerticles.contains(this.getModel().getTerminal(outgoing_edge, false))) {
                    if (verticles2check.containsKey(this.getModel().getTerminal(outgoing_edge, false))){
                        if((Integer) ((mxCell) (outgoing_edge)).getValue() < verticles2check.get(this.getModel().getTerminal(outgoing_edge, false))){
                            ((mxCell) this.getModel().getTerminal(outgoing_edge, false)).setParent(firstCell);
                            verticles2check.put(this.getModel().getTerminal(outgoing_edge, false), (Integer) ((mxCell) (outgoing_edge)).getValue());
                        }
                    }else {
                        ((mxCell) this.getModel().getTerminal(outgoing_edge, false)).setParent(firstCell);
                        verticles2check.put(this.getModel().getTerminal(outgoing_edge, false), (Integer) ((mxCell) (outgoing_edge)).getValue());
                    }
                }
            }




            Map.Entry<Object, Integer> min = null;
            mxCell minEdge = new mxCell();
            for (Map.Entry<Object, Integer> entry : verticles2check.entrySet()) {
                if (min == null || min.getValue() > entry.getValue()) {
                    min = entry;
                    minEdge = (mxCell) min.getKey();
                }
            }

            firstCell = minEdge;
            this.setCellStyles(mxConstants.STYLE_STROKECOLOR,"red",this.getEdgesBetween(firstCell.getParent(),firstCell));
            verticles2check.remove(minEdge);
            checkedVerticles.add(firstCell);
            System.out.print(firstCell.getId());
        }while (checkedVerticles.size() != cells.length);

    }


    public void reset(){
        Object[] myEdges = this.getAllEdges(this.getChildVertices(this.getDefaultParent()));
        this.setCellStyles(mxConstants.STYLE_STROKECOLOR,"blue",myEdges);
    }

    public mxGraphComponent getComponent(){
        return graphComponent;
    }
}
