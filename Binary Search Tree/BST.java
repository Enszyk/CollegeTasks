import java.util.LinkedList;
import java.util.Queue;

public class BST {

    Element head;
    Queue<Element> childQueue;
    Queue<Element> resultQueue;

    class Element {

        int value;
        boolean isEmpty;
        boolean hasValue = true;
        Element childLeft;
        Element childRight;

        public Element(int value) {
            this.value = value;
        }

        public Element(boolean isEmpty, boolean hasValue) {
            this.isEmpty = isEmpty;
            this.hasValue = hasValue;
        }
    }

    boolean hasChildRight(Element node) {
        if (node.childRight == null)
            return false;
        return true;
    }

    boolean hasChildLeft(Element node) {
        if (node.childLeft == null)
            return false;
        return true;
    }

    //
    //
    //
    // Wstawianie do drzewa
    //
    //
    //

    void insert(int value) {
        if (head == null) // nowy rodzic
            head = new Element(value);
        else {
            Element tmp = head;
            insertRecursion(value);
            head = tmp;
        }
    }

    void insertRecursion(int value) {
        if (value > head.value) {
            if (!hasChildRight(head))
                head.childRight = new Element(value);
            else {
                head = head.childRight;
                insertRecursion(value);
            }
        } else {
            if (!hasChildLeft(head))
                head.childLeft = new Element(value);
            else {
                head = head.childLeft;
                insertRecursion(value);
            }
        }
    }

    //
    //
    //
    // PRZECHODZENIE PO DRZEWIE
    //
    //
    //

    void preOrderWalk() {
        System.out.print("\n\npreOrderWalk:   ");
        preOrderWalkRecursion(head);
    }

    void preOrderWalkRecursion(Element node) {
        System.out.print(node.value + " ");
        if (hasChildLeft(node))
            preOrderWalkRecursion(node.childLeft);

        if (hasChildRight(node))
            preOrderWalkRecursion(node.childRight);

    }

    void postOrderWalk() {
        System.out.print("\n\npostOrderWalk:  ");
        postOrderWalkRecursion(head);
    }

    void postOrderWalkRecursion(Element node) {
        if (node == null)
            return;

        postOrderWalkRecursion(node.childLeft);
        postOrderWalkRecursion(node.childRight);
        System.out.print(node.value + " ");
    }

    //
    //
    //
    // Usuwanie
    //
    //
    //

    void delete(int value) {
        Element result = searchRecursion(head, value);
        Element resultParent = searchParent(head, result);

        int childCounter = 0;
        if (hasChildLeft(result))
            childCounter++;
        if (hasChildRight(result))
            childCounter++;

        if (childCounter == 0) {
            if (resultParent.childLeft == result)
                resultParent.childLeft = null;
            else
                resultParent.childRight = null;
        }

        if (childCounter == 1) {
            if (resultParent.childLeft == result) {
                if (hasChildLeft(result))
                    resultParent.childLeft = result.childLeft;
                else
                    resultParent.childLeft = result.childRight;
            } else {
                if (hasChildLeft(result))
                    resultParent.childRight = result.childLeft;
                else
                    resultParent.childRight = result.childRight;
            }
        }

        if (childCounter == 2) {
            int lowestValue = lowestValue(result.childRight);
            delete(lowestValue);
            result.value = lowestValue;

        }
    }

    Element searchRecursion(Element node, int value) {
        if (node.value == value || node == null)
            return node;
        if (node.value > value)
            return searchRecursion(node.childLeft, value);
        else
            return searchRecursion(node.childRight, value);
    }

    Element searchParent(Element node, Element result) {

        if ((node.childLeft == result || node.childRight == result) || result == head)
            return node;
        if (node.value > result.value)
            return searchParent(node.childLeft, result);
        else
            return searchParent(node.childRight, result);
    }

    int lowestValue(Element node) {
        int result = 0;
        while (node != null) {
            if (!hasChildLeft(node))
                result = node.value;
            node = node.childLeft;
        }
        return result;
    }

    //
    //
    // DRAWING TREE
    //
    //

    // _______1 7 przerwy
    // ___1_______1 3 7
    // _1___1___1___1 1 3 7 3
    // 1_1_1_1_1_1_1_1 0 1 1 1 1 1 1

    // _______________1 15 przerwy
    // _______1_______________1 7 15 przerwy
    // ___1_______1_______1_______1 3 7 7 7
    // _1___1___1___1___1___1___1___1 1 3 3 3 3 3 3 3
    // 1_1_1_1_1_1_1_1_1_1_1_1_1_1_1_1 0 1...

    void printTree() {
        childQueue = new LinkedList<>();
        resultQueue = new LinkedList<>();
        if (head != null) {
            childQueue.add(head);
            while (childQueue.size() > 0) {
                if (!childQueue.peek().isEmpty) {
                    if (hasChildLeft(childQueue.peek()))
                        childQueue.add(childQueue.peek().childLeft);
                    else {
                        if (hasChildRight(childQueue.peek()))
                            childQueue.add(new Element(false, false));
                        else
                            childQueue.add(new Element(true, false));
                    }
                    if (hasChildRight(childQueue.peek()))
                        childQueue.add(childQueue.peek().childRight);
                    else {
                        if (hasChildLeft(childQueue.peek()))
                            childQueue.add(new Element(false, false));
                        else
                            childQueue.add(new Element(true, false));
                    }
                }
                resultQueue.add(childQueue.remove());
            }

            int i = 1;
            int toPower = 2;
            boolean newLine = true;
            int spaces = getSpacesFromSize(resultQueue.size());
            System.out.println("\n");
            for (Element el : resultQueue) {

                if (newLine)
                    printNSpaces(spaces / 2 - 1);
                else
                    printNSpaces(spaces - 1);

                newLine = false;

                if (!el.isEmpty && el.hasValue)
                    System.out.print(el.value);
                else
                    System.out.print("x");
                if (i == toPower - 1) {
                    System.out.println();
                    spaces /= 2;
                    newLine = true;
                    toPower *= 2;
                }
                i++;
            }
        }
    }

    void printNSpaces(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(" ");
        }
    }

    int getSpacesFromSize(int n) {
        int toPower2 = 1;
        while (toPower2 < n) {
            toPower2 *= 2;
        }
        return toPower2;
    }

}