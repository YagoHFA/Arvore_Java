package Main.Java;

public class ArvoreBinaria<T extends Comparable<T>> {

    private BinNo<T> raiz;

    public ArvoreBinaria(){
    this.raiz = null;
    }

    public void insert(T conteudo){
        BinNo<T> novoNo = new BinNo<>(conteudo);
        raiz = insert(raiz, novoNo);
    }

    private BinNo<T> insert(BinNo<T> actual, BinNo<T> novoNo){
        if(actual == null){
            return novoNo;
        }
        else if(novoNo.getConteudo().compareTo(actual.getConteudo())< 0){
            actual.setNoEsq(insert(actual.getNoEsq(), novoNo));
        }
        else{
            actual.setNoDir(insert(actual.getNoDir(), novoNo));
        }

        return actual;
    }

    public void showInOrder(){
        System.out.println("\nExibindo em ordem");
    showInOrder(this.raiz);
    }


    private void showInOrder(BinNo<T> actual){

    if(actual != null){
        showInOrder(actual.getNoEsq());
        System.out.print(actual.getConteudo() + ", ");
        showInOrder(actual.getNoDir());
    }
    }

    public void showPosOrder(){
        System.out.println("\nExibindo em pos ordem");

        showPosOrder(this.raiz);
    }


    private void showPosOrder(BinNo<T> actual){
        if(actual != null){

            showPosOrder(actual.getNoEsq());
            showPosOrder(actual.getNoDir());
            System.out.print(actual.getConteudo() + ", ");

        }
    }

    public void showPreOrder(){
        System.out.println("\nExibindo em pre ordem");

        showPreOrder(this.raiz);
    }


    private void showPreOrder(BinNo<T> actual){
        if(actual != null){

            System.out.print(actual.getConteudo() + ", ");
            showPreOrder(actual.getNoEsq());
            showPreOrder(actual.getNoDir());
        }
    }

    public void remove(T conteudo){
        try{
            BinNo<T> actual = this.raiz;
            BinNo<T> pai = null;
            BinNo<T> filho = null;
            BinNo<T> temp = null;

            while (actual != null && !actual.getConteudo().equals(conteudo)){
                pai = actual;
                if(conteudo.compareTo(actual.getConteudo())< 0){
                    actual = actual.getNoEsq();
                }
                else {
                    actual = actual.getNoDir();
                }
            }

            if(actual == null){
                System.out.println("Conteudo nao encontrado - Bloco try");
            }

            if(pai == null){
                if(actual.getNoDir() == null){
                    this.raiz =  actual.getNoEsq();
                }
                else if(actual.getNoEsq() == null){
                    this.raiz =  actual.getNoDir();
                }
                else {
                    for(temp = actual, filho = actual.getNoEsq();
                        filho.getNoDir() !=null;
                        temp = filho, filho =  filho.getNoEsq()
                    ){
                        if(filho != actual.getNoEsq()){
                            temp.setNoDir(filho.getNoEsq());
                            filho.setNoEsq(raiz.getNoEsq());
                        }
                    }
                    filho.setNoDir(raiz.getNoDir());
                    raiz = filho;
                }
            }
            else if (actual.getNoDir() == null) {
                if(pai.getNoEsq() == actual){
                    pai.setNoEsq(actual.getNoEsq());
                }
                else{
                    pai.setNoDir(actual.getNoEsq());
                }
            }
            else if (actual.getNoEsq() == null) {
                if(pai.getNoEsq() == actual){
                    pai.setNoEsq(actual.getNoDir());
                }
                else{
                    pai.setNoDir(actual.getNoDir());
                }
            }
            else {
                for(
                        temp = actual, filho = actual.getNoEsq();
                        filho.getNoDir() != null;
                        temp = filho, filho = filho.getNoDir()
                ){
                    if(filho != actual.getNoEsq()){
                        temp.setNoDir(filho.getNoEsq());
                        filho.setNoEsq(actual.getNoEsq());
                    }

                    filho.setNoDir(actual.getNoDir());

                    if(pai.getNoEsq() == actual){
                        pai.setNoEsq(filho);
                    }else{
                        pai.setNoDir(filho);
                    }
                }
            }

        }
        catch (NullPointerException e){
            System.out.println("Conteudo nao encontrado - Bloco catch");
        }
    }
}
