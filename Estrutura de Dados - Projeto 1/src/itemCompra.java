public class itemCompra {
    String descricao;
    int qtde;
    double preco;
    
    itemCompra(String descricao, int qtde, double preco){
        this.descricao = descricao;
        this.qtde = qtde;
        this.preco = preco;
    }
    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public double getPreco(){
        return preco;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }

    public int getQtde(){
        return qtde;
    }

    public void setQtde(int qtde){
        this.qtde = qtde;
    }

    public double calcSubtotal(){
        double subtotal = 0;
        subtotal = qtde * preco;
        return subtotal;
    }

    public void mostraItem(){
        System.out.println("Descrição: " + descricao + " Preço Unitário: " + preco + " Quantidade: " + qtde + " Subtotal: "+ calcSubtotal());
    }



}
