package it.unibo.generics.graph.impl;

import java.text.CollationElementIterator;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N> {

    final Map<N, Set<N>> edges= new HashMap<>();
    @Override
    public void addNode(N node) {
        if(node==null){
            return ;
        }
        if(!edges.containsKey(node)){
            edges.put(node, new HashSet<N>());
        }

    }

    @Override
    public void addEdge(N source, N target) {
        if(source==null|| target==null || target==source){
            return;
        }else{
            /*riutilizzo addNode per aggiungere i nodi */
            addNode(target);
            addNode(source);
            /*al nodo di partenza, aggiungo nel suo Set il nodo destinazione */
            edges.get(source).add(target);
        }
    }

    @Override
    public Set<N> nodeSet() {
        Set<N> setNodeTemp= new HashSet<>();
        for(N tempNode : edges.keySet()){
            setNodeTemp.add(tempNode);
        }
        return new HashSet<>(setNodeTemp);
    }

    @Override
    public Set<N> linkedNodes(N node) {
        Set<N> linkedSetFromNode= edges.get(node);
        /*controllo che non sia null */
        if(linkedSetFromNode==null){
            return Collections.emptySet();
        }
        return new HashSet<>(linkedSetFromNode);
    }

    @Override
    public List<N> getPath(N source, N target) {
        
        List<N> queueOfNodes= new LinkedList<N>();
        Set<N> visitedNodes= new HashSet<N>();
        Map<N, N> predecessorsN = new HashMap<N,N>();
        /*aggiungo il nodo A */
        queueOfNodes.add(source);

        if(source.equals(target)){
            return queueOfNodes;
        }

        visitedNodes.add(source);

        while(!queueOfNodes.isEmpty()){
            
            N currentNode=queueOfNodes.getFirst();
            queueOfNodes.removeFirst();

            for(N neighborNodes : linkedNodes(currentNode)){
                /*controllo il set del nodo */
                if(!visitedNodes.contains(neighborNodes)){
                    
                    visitedNodes.add(neighborNodes);
                    predecessorsN.put(neighborNodes,currentNode);
                    /*metto in coda il vicino per continuare la ricerca*/
                    queueOfNodes.add(neighborNodes);

                    if(neighborNodes.equals(target)){
                                List<N> Path= new LinkedList<N>();
                        N step=target;
                        while(step!=null){
                            Path.addFirst(step);
                            step=predecessorsN.get(step);
                        }
                        return Path;
                    }

                }
            }
        }
        return Collections.emptyList();
    }
    
}
