import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import java.nio.file.*;

/*
NOMES:
ARTHUR BERNARDO ESCORCIO HARDT TIA: 32159341
AUGUSTO KOSHIYAMA BENTO TIA: 32150741
MATHEUS GUARNIERI PFAU FERREIRA TIA: 32113072
RAFAEL CARREIRA CALVACANTE TIA: 32134061
*/


class Main {
  public static void main(String[] args) throws FileNotFoundException, IOException{
    int achou = 0;
    Scanner scan = new Scanner (System.in);
    ArrayList<Produto> listaProdutos = new ArrayList<>();
    boolean teste = true;
    Carrinho carrinho = new Carrinho(10);
    
    
    
    FileReader data = new FileReader("produtos.txt");
    BufferedReader linha = new BufferedReader(data);
    String aux = linha.readLine();

    while (aux != null){
      String[] dados = aux.split(";");
      Produto entrada = new Produto(Integer.parseInt(dados[0]), dados[1], Double.parseDouble(dados[2]));
      listaProdutos.add(entrada);
      aux = linha.readLine();
    }

    
    int op;
		           
	  do{
	    System.out.println("\nMercado\n1-Ver catalogo\n2-Adicionar ao carrinho\n3-Finalizar compra");
	    op = scan.nextInt();
	    switch (op){
        case 1:
          System.out.println("==========================================");
          for(int i =0;i<listaProdutos.size();i++) {
            System.out.println("Codigo: " + listaProdutos.get(i).getCod());
            System.out.println("Descricao "+ listaProdutos.get(i).getDescricao());
            System.out.println("Preco: R$" + listaProdutos.get(i).getPreco());
            System.out.println("=========================================="); 
          }
          break;
        case 2:
          while(teste){
            System.out.println("\n===== Carrinho de compras =====");
            System.out.println("\nInforme o código do produto: ");
            int codProduto = scan.nextInt();
            achou = 0;
            for(int i  = 0; i<listaProdutos.size();i++){
              if(codProduto == listaProdutos.get(i).getCod()){
              achou = 1;
              System.out.println("!!! Item encontrado !!!");          
              System.out.println("Codigo: " + listaProdutos.get(i).getCod());
              System.out.println("Descricao: " + listaProdutos.get(i).getDescricao());
              System.out.println("Preco: R$" + listaProdutos.get(i).getPreco());  
              System.out.println("\nQuantos deste item voce quer?"); 
              int qtdeItens = scan.nextInt();
                
              itemCompra Itemcompra = new itemCompra(listaProdutos.get(i).getDescricao(),qtdeItens,listaProdutos.get(i).getPreco());
                
              carrinho.listaItens.add(Itemcompra);
          
              System.out.println("\nDeseja finalizar a compra? (1 = Sim | 2 = Não)");
              int opc = scan.nextInt();
              if(opc == 1){
                System.out.println("Finalizando a compra..");
                teste = false;
               } // if sair do carrinho
            }  // if codProduto
          } // for
              if (achou == 0){
                System.out.println("Item não encontrado.");
            } // if achou
          } // while
          break;
        case 3:
          break;
      }
    }while(op!=3);
    
    System.out.println("=========== Itens no carrinho ===========");
    carrinho.mostraCarrinho();
    double subtotal = carrinho.somaValores();
    double desconto = carrinho.calcDesconto(subtotal);
    double total = carrinho.somaValores() - carrinho.calcDesconto(subtotal);
    System.out.printf("Subtotal: R$"+"%.2f",subtotal);
    System.out.printf("\nDesconto: R$-"+"%.2f",desconto);
    System.out.printf("\nTotal: R$"+"%.2f",total);
  } // public class
} // main