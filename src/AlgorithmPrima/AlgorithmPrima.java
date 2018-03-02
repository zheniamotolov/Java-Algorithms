package AlgorithmPrima;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by eugene on 11/28/17.
 */
public class AlgorithmPrima {
    private List<Edge> E=new ArrayList<>();
    private List<Edge> MST=new ArrayList<>();
    private int numberV;

    public void addNewEdge(int v1, int v2, int weight) {
        Edge edge = new Edge(v1, v2, weight);
        E.add(edge);
        numberV++;

    }

    public void algorithmByPrim() {
        //неиспользованные ребра
        ArrayList<Edge> notUsedE = new ArrayList<Edge>(E);
        //использованные вершины
        ArrayList<Integer> usedV = new ArrayList<>();
        //неиспользованные вершины
        ArrayList<Integer> notUsedV = new ArrayList<>();
        for (int i = 0; i < numberV; i++)
            notUsedV.add(i);
        //выбираем случайную начальную вершину
        usedV.add(0);
        notUsedV.remove(usedV.get(0));
        while (notUsedV.size() > 0) {
            int minE = -1; //номер наименьшего ребра
            //поиск наименьшего ребра
            for (int i = 0; i < notUsedE.size(); i++) {
                if ((usedV.indexOf(notUsedE.get(i).v1) != -1) && (notUsedV.indexOf(notUsedE.get(i).v2) != -1) || (usedV.indexOf(notUsedE.get(i).v2) != -1) && (notUsedV.indexOf(notUsedE.get(i).v1) != -1)) {
                    if (minE != -1) {
                        if (notUsedE.get(i).weight < notUsedE.get(minE).weight)
                            minE = i;
                    } else
                        minE = i;
                }
            }
            //заносим новую вершину в список использованных и удаляем ее из списка неиспользованных
            if(minE==-1){
                break;
            }
            if (usedV.indexOf(notUsedE.get(minE).v1) != -1) {
                usedV.add(notUsedE.get(minE).v2);
                notUsedV.remove(notUsedE.get(minE).v2);
            } else {
                usedV.add(notUsedE.get(minE).v1);
                notUsedV.remove(notUsedE.get(minE).v1);
            }
            //заносим новое ребро в дерево и удаляем его из списка неиспользованных
            MST.add(notUsedE.get(minE));
            notUsedE.remove(minE);
        }
    }

    public void show(){
        int mass=0;
        for(Edge edge:MST){
            System.out.println(edge.v1+"-"+edge.v2);
            mass+=edge.weight;
        }
        System.out.println(mass);
    }
}