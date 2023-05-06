package co.edu.umanizales.tads.model;

public class ListDE {
    private Node head;
    private Node tail;
    char letter;
    String id;
    int gain;
    byte age;


    private Node getHead() {

        return null;
    }

    private void addInpos(Kid data, int sum) {
    }

    private void add(Kid data) {
    }


    // 1. (Doblemente enlazado)

    public void invertdoble() {
        if (this.head != null) {
            Node temp = this.head;
            while (temp != null) {
                Node prev = temp.getPrev();
                temp.setPrev(temp.getNext());
                temp.setNext(prev);
                temp = temp.getPrev();
            }
            Node newHead = this.tail;
            this.tail = this.head;
            this.head = newHead;
        }
    }


// 2. (Doblemente enlazada)

    public void getOrderedPetsToStart() {
        if (this.head == null) {
            return;
        }

        Node temp = this.head;
        Node lastPet = null;


        while (temp != null) {
            if (temp.getData().getType() == 'P') {
                if (lastPet != null) {
                    // Agregar al principio de la lista
                    lastPet.setNext(temp);
                    temp.setPrev((Node) lastPet);
                    lastPet = temp;
                    temp = temp.getNext();

                    // Remover nodo de su posición original
                    ((Node) lastPet).getPrev().setNext(temp);
                    if (temp != null) {
                        temp.setPrev(((Node) lastPet).getPrev());
                    }
                    ((Node) lastPet).setPrev(null);
                } else {
                    lastPet = temp;
                    temp = temp.getNext();
                }
            } else {
                temp = temp.getNext();
            }
        }

        if (lastPet != null) {
            // Agregar al principio de la lista
            lastPet.setNext(this.head);
            this.head.setPrev((Node) lastPet);
            lastPet = null;

            // Actualizar cabeza de la lista
            this.head = this.head.getPrev();
            this.head.setPrev(null);
        }
    }


// 3.

    public void getAlternatePets() {
        if (this.head == null || this.head.getNext() == null) {
            return;
        }

        Node pets = this.head;
        Node otherPets = this.head.getNext();
        Node otherPetsHead = otherPets;

        while (otherPets != null && pets != null) {
            // Conectar la siguiente mascota a la siguiente otra mascota
            pets.setNext(otherPets.getNext());
            if (otherPets.getNext() != null) {
                otherPets.getNext().setPrev(pets);
            }

            // Conectar la siguiente otra mascota a la siguiente mascota
            otherPets.setNext(pets.getNext());
            if (pets.getNext() != null) {
                pets.getNext().setPrev(otherPets);
            }

            // Mover a las siguientes mascotas
            pets = pets.getNext();
            if (pets != null) {
                otherPets = pets.getNext();
            }
        }

        // Si quedan otras mascotas, agregarlas al final de la lista
        if (otherPets != null) {
            pets.setNext(otherPetsHead);
            otherPetsHead.setPrev(pets);
        }
    }

// 4.

    public void deletePetByAge() {
        Node current = this.head;

        // Si el nodo a eliminar es la cabeza de la lista
        if (current != null && current.getData().getAge() == age) {
            this.head = current.getNext();
            if (this.head != null) {
                this.head.setPrev(null);
            }
            return;
        }

        // Buscamos el nodo a eliminar
        while (current != null && current.getData().getAge() != age) {
            current = current.getNext();
        }

        // Si el nodo a eliminar no se encuentra en la lista
        if (current == null) {
            return;
        }

        // Eliminamos el nodo de la lista
        if (current.getNext() != null) {
            current.getNext().setPrev(current.getPrev());
        }
        current.getPrev().setNext(current.getNext());
    }


// 5.

    public float averageAge() {
        if (head == null) {
            return 0;
        }

        int count = 0;
        int sum = 0;
        Node current = head;

        while (current != null) {
            sum += current.getData().getAge();
            count++;
            current = current.getNext();
        }

        return (float) sum / count;
    }


// 6.

    public int getCountPetsByLocationCode(String code) {
        int count = 0;

        if (head == null) {
            return 0;
        }

        Node current = head;
        while (current != null) {
            if (current.getData().getLocation().getCode().equals(code)) {
                count++;
            }
            current = current.getNext();
        }

        return count;
    }


// 7.

    public void gainPositionPet() {
        int sum = 0;
        ListDE listDE = new ListDE();

        if (head == null) {
            return;
        }

        Node current = head;
        while (current != null && !current.getData().getIdentification().equals(id)) {
            listDE.add(current.getData());
            current = current.getNext();
        }

        if (current == null) {
            return;
        }

        sum = gain - getCountPetByLocationCode(current.getData().getLocation().getCode());
        listDE.addInpos(current.getData(), sum);
        if (current == head) {
            head = listDE.getHead();
        } else {
            current.getPrevious().setNext(listDE.getHead().getPrevious());
        }
    }

    public int getCountPetByLocationCode(String code) {
        int count = 0;

        if (head == null) {
            return 0;
        }

        Node current = head;
        while (current != null) {
            if (current.getData().getLocation().getCode().equals(code)) {
                count++;
            }
            current = current.getNext();
        }

        return count;
    }

// 8.

    public int getPostById() {
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

// 9.



// 10.


    public void movePet() {
        Node prev = null;
        Node current = head;
        Node last = null;
        while (current != null) {
            if (current.getData().getName().startsWith(String.valueOf(letter))) {
                if (prev == null) {
                    head = current.getNext();
                } else {
                    prev.setNext(current.getNext());
                    if (current.getNext() != null) {
                        current.getNext().setPrev(prev);
                    }
                }
                if (last == null) {
                    last = current;
                } else {
                    last.setNext(current);
                    current.setPrev(last);
                    last = current;
                }
                current = current.getNext();
                if (last != null) {
                    last.setNext(null);
                    if (current != null) {
                        last.setPrev(current.getPrev());
                    }
                }
            } else {
                prev = current;
                current = current.getNext();
            }
        }
    }
}


