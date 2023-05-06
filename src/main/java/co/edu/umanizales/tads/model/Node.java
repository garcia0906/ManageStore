package co.edu.umanizales.tads.model;

import ch.qos.logback.core.pattern.Converter;
import lombok.Data;

@Data
public class Node extends NodeDE {
    public String name;
    private Kid data;
    private Node next;

    public Node(Kid data) {
        this.data = data;
    }

    public Node getPrev() {
        return null;
    }

    public void setPrev(Node next) {
    }

    public <E> Converter getPrevious() {

        return null;
    }
}
