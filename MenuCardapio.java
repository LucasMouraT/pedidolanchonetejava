import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class MenuCardapio {
    public static void main(String[] args) {
        Map<Integer, String[]> categorias = new HashMap<>();
        categorias.put(1, new String[]{"Hamburguer", "X-Burguer", "X-Bacon", "X-Frango", "X-Calabresa", "X-Salsicha", "X-Tudo", "X-Tudão", "Egg Burguer", "X-Egg Burguer", "X-Egg Bacon", "X-Egg Calabresa", "X-Egg Frango", "X-Egg Frango c/ Bacon", "X-Egg Frango c/ Calabresa", "Misto", "Bauru", "Sanduiche de Queijo", "Americano", "American Burguer"});
        categorias.put(2, new String[]{"Salgados", "Coxinha", "Coxinha c/ Catupiry", "Enroladinho", "Pastel", "Pizza", "Empada", "Cachorro-Quente", "Torta de Frango"});
        categorias.put(3, new String[]{"Doces", "Bolo", "Bolo de Noiva", "Açaí 300ml", "Açaí 500ml", "Guaraná do Amazonas", "Milk-Shake"});
        categorias.put(4, new String[]{"Bebidas", "Coca Cola 200ml", "Coca Cola 290ml", "Coca Pet 1L", "Coca Pet 2L", "Coca Retornavel", "Antarctica 1L", "Antarctica 2L", "Fanta 1L", "Fanta 2L", "Refri Lata","Refri 200ml", "Suco da Polpa c/ Leite", "Suco da Polpa sem Leite",});

        Map<String, Double> precos = new HashMap<>();
        precos.put("Hamburguer", 7.00);
         precos.put("X-Burguer", 9.00);
        precos.put("X-Bacon", 13.00);
        precos.put("X-Frango", 14.00);
        precos.put("X-Calabresa", 14.00);
        precos.put("X-Salsicha", 10.00);
        precos.put("X-Tudo", 10.00);
        precos.put("X-Tudo", 19.50);
        precos.put("X-Tudão", 33.00);
        precos.put("Egg Burguer", 8.00);
        precos.put("X-Egg Burguer", 10.00);
        precos.put("X-Egg Bacon", 16.00);
        precos.put("X-Egg Calabresa", 16.00);
        precos.put("X-Egg Frango", 16.00);
        precos.put("X-Egg Frango c/ Bacon", 19.00);
        precos.put("X-Egg Frango c/ Calabresa", 19.00);
        precos.put("Misto", 7.00);
        precos.put("Bauru", 8.00);
        precos.put("Sanduiche de Queijo", 7.00);
        precos.put("Americano", 11.00);
        precos.put("American Burguer", 13.00);
        precos.put("Coxinha", 4.00);
        precos.put("Coxinha c/ Catupiry", 4.00);
        precos.put("Enroladinho", 4.00);
        precos.put("Pastel", 8.00);
        precos.put("Pizza", 7.00);
        precos.put("Empada", 5.00);
        precos.put("Cachorro-Quente", 6.00);
        precos.put("Torta de Frango", 9.00);
        precos.put("Bolo", 9.00);
        precos.put("Bolo de Noiva", 15.00);
        precos.put("Açaí 300ml", 10.00);
        precos.put("Açaí 500ml", 14.00);
        precos.put("Guaraná do Amazonas", 6.00);
        precos.put("Milk-Shake", 14.00);
        precos.put("Coca Cola 200ml", 3.50);
        precos.put("Coca Cola 290ml", 5.00);
        precos.put("Coca Pet 1L", 9.00);
        precos.put("Coca Pet 2L", 14.00);
        precos.put("Coca Retornavel", 8.00);
        precos.put("Antarctica 1L", 8.00);
        precos.put("Antarctica 2L", 10.00);
        precos.put("Fanta 1L", 9.00);
        precos.put("Fanta 2L", 14.00);
        precos.put("Refri Lata", 6.00);
        precos.put("Refri 200ml", 2.50);
        precos.put("Suco da Polpa c/ Leite", 7.00);
        precos.put("Suco da Polpa sem Leite", 6.00);

        Scanner scanner = new Scanner(System.in);

        System.out.println("------Bem-vindo ao Nick Burguer Lanches!------");

        while (true) {
            double total = 0.0;
            String nomeCliente = "";

            String[][] pedidos = new String[50][3];
            int contadorPedidos = 0;

            while (true) {
                System.out.println("Categorias de Itens:");
                for (Integer key : categorias.keySet()) {
                    System.out.println(key + ". " + categorias.get(key)[0]);
                }

                System.out.println("Selecione um número de categoria ou digite '0' para encerrar o pedido:");
                int escolhaCategoria = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer

                if (escolhaCategoria == 0) {
                    break;
                }

                String[] itensDaCategoria = categorias.get(escolhaCategoria);
                if (itensDaCategoria != null) {
                    System.out.println("Itens em " + itensDaCategoria[0] + ":");
                    for (int i = 0; i < itensDaCategoria.length; i++) {
                        System.out.println((i + 1) + ". " + itensDaCategoria[i] + " - R$" + precos.get(itensDaCategoria[i]));
                    }

                    System.out.print("Escolha um número de item ou digite '0' para voltar: ");
                    int escolhaItem = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer

                    if (escolhaItem == 0) {
                        continue;
                    }

                    try {
                        if (escolhaItem >= 1 && escolhaItem <= itensDaCategoria.length) {
                            String itemEscolhido = itensDaCategoria[escolhaItem - 1];

                            System.out.print("Digite a quantidade desejada para " + itemEscolhido + ": ");
                            int quantidade = scanner.nextInt();
                            scanner.nextLine(); // Limpa o buffer

                            double precoUnitario = precos.get(itemEscolhido);
                            double precoTotalItem = precoUnitario * quantidade;

                            total += precoTotalItem;
                            System.out.println("Você escolheu " + quantidade + "x " + itemEscolhido + " - Total: R$" + precoTotalItem);

                            pedidos[contadorPedidos][0] = itemEscolhido;
                            pedidos[contadorPedidos][1] = String.valueOf(quantidade);
                            pedidos[contadorPedidos][2] = String.valueOf(precoTotalItem);

                            contadorPedidos++;
                        } else {
                            System.out.println("Opção inválida. Por favor, escolha um número de item válido.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Opção inválida. Por favor, escolha um número de item válido.");
                    }
                } else {
                    System.out.println("Categoria inválida. Por favor, escolha uma categoria válida.");
                }
            }

            System.out.print("Digite seu nome para concluir o pedido ou digite 'sair' para encerrar: ");
            nomeCliente = scanner.nextLine();

            if (nomeCliente.equalsIgnoreCase("sair")) {
                break;
            }

            System.out.println("\nLista de Pedidos:");
            for (int i = 0; i < contadorPedidos; i++) {
                System.out.println("Item: " + pedidos[i][0] + " | Quantidade: " + pedidos[i][1] + " | Total: R$" + pedidos[i][2]);
            }

            System.out.println("Total a pagar: R$" + total);

            System.out.print("Deseja fazer mais pedidos? (s/n): ");
            String continuar = scanner.nextLine();

            if (continuar.equalsIgnoreCase("n")) {
                break;
            }
        }

        System.out.println("Obrigado por escolher o Nick Burguer Lanches!");
        scanner.close();
    }
}