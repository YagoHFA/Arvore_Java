package Main.Java;


import Main.Java.Model.Obj;

public class Main {

    public static void main(String[] args) {

        ArvoreBinaria<Obj> minhaArvore = new ArvoreBinaria<>();

        minhaArvore.insert(new Obj(13));
        minhaArvore.insert(new Obj(10));
        minhaArvore.insert(new Obj(25));
        minhaArvore.insert(new Obj(2));
        minhaArvore.insert(new Obj(12));
        minhaArvore.insert(new Obj(20));
        minhaArvore.insert(new Obj(31));
        minhaArvore.insert(new Obj(29));
        minhaArvore.insert(new Obj(32));

        minhaArvore.remove(new Obj(32));

        minhaArvore.showInOrder();
        minhaArvore.showPreOrder();
        minhaArvore.showPosOrder();
    }
}
