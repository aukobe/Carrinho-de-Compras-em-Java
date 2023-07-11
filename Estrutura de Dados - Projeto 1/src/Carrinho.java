import java.util.*;

public class Carrinho {
    ArrayList<itemCompra> listaItens;
    double totalCompra;
    double PorcDesconto;
    double valorPagar;

    Carrinho(double PorcDesconto){
        listaItens = new ArrayList();
        totalCompra = 0;
        this.PorcDesconto = PorcDesconto;
        valorPagar = 0;
    }

    public void mostraCarrinho(){
        int cont = 1;
        for (int i= 0; i < listaItens.size(); i++){
            System.out.print(cont + "        ");
            listaItens.get(i).mostraItem();
            cont++;
        }
    }

    public double calcDesconto(double total){
        return (total * PorcDesconto) / 100;
    }

    public double somaValores(){
        double soma = 0;
        for (int i = 0; i < listaItens.size(); i++){
            soma += listaItens.get(i).calcSubtotal();
        }
        return soma;
    }
}
