package Diario_Virtual;

public class Usuario {
    private String username;
    private String senha;
    private boolean isAdmin;
    
    //cria um construtor para o Usuario atrelando-o um username, senha e (caso seja adm, verificando a veracidade)
    public Usuario(String username, String senha, boolean isAdmin) {
        this.username = username;
        this.senha = senha;
        this.isAdmin = isAdmin;
    }
    //retorna o valor booleano de adm, verificando se é verdadeiro ou falso
    public boolean isAdmin(){
    	return isAdmin;
    }
    //retorna o valor string de username, comparando se é igual a string escrita pelo usuario
    public String getUsername() {
    	return username;
    }
    //retorna o valor string de senha, comparando se é igual a string escrita pelo usuario 
    public String getSenha() {
    	return senha;
    }
}
