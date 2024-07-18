package Diario_Virtual;

public class Usuario {
    private String username;
    private String senha;
    private boolean ehADM;
 
    public Usuario(String username, String senha, boolean ehADM) {
        this.username = username;
        this.senha = senha;
        this.ehADM = ehADM;
    }
    public boolean ehADM(){
    	return ehADM;
    }
    public void souADM(boolean ehADM){
    	this.ehADM = ehADM;
    }
    public String getUsername() {
    	return username;
    }
    public String getSenha() {
    	return senha;
    }
}