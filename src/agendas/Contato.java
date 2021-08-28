package agendas;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Contato {
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private String nome;
    private String descrição;
    private String telefone;
    private String email;
    private String endereco;
    private Calendar dataNascimento;
    private Integer idade;

    public Contato(String nome, String descrição, String telefone, String email, String endereco, Calendar dataNascimento) {
        this.nome = nome;
        this.descrição = descrição;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    

    public int getIdade() {
        Calendar hoje = new GregorianCalendar();
        idade = hoje.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR);
        hoje.set(Calendar.YEAR, dataNascimento.get(Calendar.YEAR));
        if (hoje.before(dataNascimento)) {
            idade--;
        }
        return idade;
    }
    
    public String getDataNascimento(){
        return sdf.format(dataNascimento.getTime());
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\n"
                + "Descrição: "+ descrição + "\n"
                + "Telefone: "+ telefone +"\n"
                + "Email: "+email+"\n"
                + "Endereço: "+endereco+"\n"
                + "Data de Nascimento: "+ getDataNascimento()+"\n"
                + "Idade: "+ getIdade()+"\n"
                +"------------------------------------------------";
    }

}
