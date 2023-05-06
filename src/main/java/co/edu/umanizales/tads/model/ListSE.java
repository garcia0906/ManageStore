package co.edu.umanizales.tads.model;

import lombok.Data;

@Data
public class ListSE {
    private Node head;
    private int size;
    private Node tail;
    private byte age;
    private int gain;
    private String id;
    private char[] letter;

    private void addInpos(Object kidByid, int sum) {

    }

    private Object getKidByid(String id) {

        return null;
    }

    /*
    Algoritmo de adicionar al final
    Entrada
        un niño
    si hay datos
    si
        llamo a un ayudante y le digo que se posicione en la cabeza
        mientras en el brazo exista algo
            pasese al siguiente
        va estar ubicado en el ùltimo

        meto al niño en un costal (nuevo costal)
        y le digo al ultimo que tome el nuevo costal
    no
        metemos el niño en el costal y ese costal es la cabeza
     */
    public void add(Kid kid) {
        if (head != null) {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            /// Parado en el último
            Node newNode = new Node(kid);
            temp.setNext(newNode);
        } else {
            head = new Node(kid);
        }
        size++;
    }

    /* Adicionar al inicio
    si hay datos
    si
        meto al niño en un costal (nuevocostal)
        le digo a nuevo costal que tome con su brazo a la cabeza
        cabeza es igual a nuevo costal
    no
        meto el niño en un costal y lo asigno a la cabez
     */
    public void addToStart(Kid kid) {
        if (head != null) {
            Node newNode = new Node(kid);
            newNode.setNext(head);
            head = newNode;
        } else {
            head = new Node(kid);
        }
        size++;
    }

    public void orderBoysToStart() {
        if (this.head != null) {
            ListSE listCp = new ListSE();
            Node temp = this.head;
            while (temp != null) {
                if (temp.getData().getGender() == 'M') {
                    listCp.addToStart(temp.getData());
                } else {
                    listCp.add(temp.getData());
                }

                temp = temp.getNext();
            }
            this.head = listCp.getHead();
        }
    }

    public void changeExtremes() {
        if (this.head != null && this.head.getNext() != null) {
            Node temp = this.head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            //temp está en el último
            Kid copy = this.head.getData();
            this.head.setData(temp.getData());
            temp.setData(copy);
        }

    }

    public int getCountKidsByLocationCode(String code) {
        int count = 0;
        if (this.head != null) {
            Node temp = this.head;
            while (temp != null) {
                if (temp.getData().getLocation().getCode().equals(code)) {
                    count++;
                }
                temp = temp.getNext();
            }
        }
        return count;
    }

    //Metodos parcial
// 1. Invertir lista
    public void invert() {
        if (this.head != null) {
            ListSE listCp = new ListSE();
            Node temp = this.head;
            while (temp != null) {
                listCp.addToStart(temp.getData());
                temp = temp.getNext();
            }
            this.head = listCp.getHead();
        }
    }
// 2. Niños al inicio y niñas al final

    public void getorderBoysToStart() {
        ListSE listSE = new ListSE();
        Node temp = this.head;
        Node lastBoy = null;
        while (temp != null) {
            if (temp.getData().getGender() == 'M') {
                if (lastBoy != null) {
                    listSE.addToStart(lastBoy.getData());
                }
                lastBoy = temp;
            } else {
                listSE.add(temp.getData());
            }
            temp = temp.getNext();
        }
        if (lastBoy != null) {
            listSE.addToStart(lastBoy.getData());
        }
        this.head = listSE.getHead();
    }

// 3. Intercalar niño,niña,niño,niña

    public void getAlternateKids() {
        Node boys = head;
        Node girls = head.getNext();
        Node girlsHead = girls;
        if (head == null || head.getNext() == null)
            while (girls != null && boys != null) {
                boys.setNext(girls.getNext());
                if (girls.getNext() != null) {
                    girls.setNext(girls.getNext().getNext());
                }
                boys = boys.getNext();
                girls = girls.getNext();
            }
        if (girls == null) {
            boys.setNext(girlsHead);
        } else {
            girls.setNext(girlsHead);
        }
    }

    // 4. Dada una edad eliminar a los niños de la edad dada
        public void deleteKidbyAge() {

            Node temp = this.head;
            ListSE listSECp = new ListSE();
            while (temp != null) {
                if (temp.getData().getAge() != age) {
                    listSECp.addToStart(temp.getData());
                    temp.getNext();
                }
            }
            this.head = listSECp.getHead();
        }


// 5. Obtener el promedio de edad de los niños de la lista

    public float averageAge() {
        if (head != null) {
            Node temp = head;
            int count = 0;
            int ages = 0;
            while (temp.getNext() != null) {
                count++;
                ages = ages + temp.getData().getAge();
                temp = temp.getNext();
            }
            return (float) ages / count;
        } else {
            return (int) 0;
        }
    }


// 6. Generar un reporte que me diga cuantos niños hay de cada ciudad.    Chinchiná 3, Manizales 4, Pereira 5

    public int getCountKidByLocationCode(String code) {
        int count = 0;
        if (this.head != null) {
            Node temp = this.head;
            while (temp != null) {
                if (temp.getData().getLocation().getCode().equals(code)) {
                    count++;
                }
                temp = temp.getNext();
            }
        } else {
            return 0;

        }
        return count;
    }


// 7. Método que me permita decirle a un niño determinado que adelante un numero de posiciones dadas

    public void GainPositionKid () {
        Node temp = head;
        gain = 0;
        int sum = 0;
        ListSE listSECp = new ListSE();
        if (head != null) {
            while (temp != null && !temp.getData().getIdentification().equals(id)) {
                listSECp.add(temp.getData());
            }
            temp.getNext();
        }
        sum = gain - getCountKidByLocationCode(id);
        listSECp.addInpos(getKidByid(id), sum);
    }


// 8. Método que me permita decirle a un niño determinado que pierda un numero de posiciones dadas

    public int GetPostById() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            if (temp.getData().getIdentification().equals(id)) {
                return count;
            }
            temp = temp.getNext();
            count++;
        }
        return -1;
    }



// 10. Implementar un método que me permita enviar al final de la lista a los niños que su nombre inicie con una letra dada

    public void moveKid() {
        Node prev = null;
        Node current = head;
        Node last = null;
        while (current != null) {
            if (current.name.startsWith(String.valueOf(letter))) {
                if (prev == null) {
                    head = current.getNext();
                } else {
                    prev.setNext(current.getNext());
                }
                if (last == null) {
                    last = current;
                } else {
                    last.setNext(current);
                    last = current;
                }
                current = current.getNext();
                last.setNext(null);
            } else {
                prev = current;
                current = current.getNext();
            }
        }
    }
    
}






