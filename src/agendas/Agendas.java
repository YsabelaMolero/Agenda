package agendas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Agendas {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        List<Contato> lista = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);
        System.out.println("Adicione contatos: ");
        System.out.println("Quantas pessoas serão adicionadas?");
        int quantidade = teclado.nextInt();
        teclado.nextLine();
        for (int i = 0; i < quantidade; i++) {
            System.out.println("Nome: ");
            String nome = teclado.nextLine();
            System.out.println("Descrição: ");
            String descrição = teclado.nextLine();
            System.out.println("Telefone: ");
            String telefone = teclado.nextLine();
            System.out.println("Email: ");
            String email = teclado.nextLine();
            System.out.println("Endereço: ");
            String endereço = teclado.nextLine();
            System.out.println("Data Nascimento: ");
            String data = teclado.nextLine();
            System.out.println("------------------------------------------------");
            Date date = (Date) sdf.parse(data);
            Calendar dataNascimento = Calendar.getInstance();
            dataNascimento.setTime(date);
            Contato contato = new Contato(nome, descrição, telefone, email, endereço, dataNascimento);
            lista.add(contato);
        }
        do{
        System.out.println("Selecione: ");
        System.out.println("(1) Buscar todos: ");
        System.out.println("(2) Pesquisar por nome");
        System.out.println("SAIR");
        int opcao = teclado.nextInt();
        teclado.nextLine();
        System.out.println("------------------------------------------------");
        switch (opcao) {
            case 1:
                System.out.println("Lista de contatos: ");
                for (Contato con : lista) {
                    System.out.println(con.toString());
                }
                break;
            case 2:
                System.out.println("Pesquise um contato a partir do nome: ");
                String nomePesquisa = teclado.nextLine();
                System.out.println("------------------------------------------------");
                Contato busca = lista.stream().filter(x -> x.getNome().equals(nomePesquisa)).findFirst().orElse(null);
                if (busca == null) {
                    System.out.println("esse contato não existe");
                } else {
                    System.out.println(busca.toString());
                }
                break;
            default:
                System.exit(0);
        }}
        while(true);
    }
}
