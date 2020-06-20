public class Main {

    public static void main(String[] args) {

        BST drzewoBinarne = new BST();

        drzewoBinarne.insert(10);
        drzewoBinarne.insert(7);
        drzewoBinarne.insert(5);
        drzewoBinarne.insert(2);
        drzewoBinarne.insert(6);
        drzewoBinarne.insert(13);
        drzewoBinarne.insert(15);
        drzewoBinarne.insert(8);
        drzewoBinarne.insert(4);

        drzewoBinarne.printTree();

        drzewoBinarne.preOrderWalk();
        drzewoBinarne.postOrderWalk();

        drzewoBinarne.delete(5);

        drzewoBinarne.printTree();

    }

}
