public class Funcionario {
    private String codFuncionario;
    private String nomeFuncionario;
    private String funcaoFuncionario;
    private String dataAdmissaoFuncionario;

    public Funcionario(String codFuncionario, String nomeFuncionario, String funcaoFuncionario, String dataAdmissaoFuncionario){
        this.codFuncionario = codFuncionario;
        this.nomeFuncionario = nomeFuncionario;
        this.funcaoFuncionario = funcaoFuncionario;
        this.dataAdmissaoFuncionario = dataAdmissaoFuncionario;
    }

    public void setCodFuncionario(String codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public void setFuncaoFuncionario(String funcaoFuncionario) {
        this.funcaoFuncionario = funcaoFuncionario;
    }

    public void setDataAdmissaoFuncionario(String dataAdmissaoFuncionario) {
        this.dataAdmissaoFuncionario = dataAdmissaoFuncionario;
    }

    public String getCodFuncionario() {
        return codFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public String getFuncaoFuncionario() {
        return funcaoFuncionario;
    }

    public String getDataAdmissaoFuncionario() {
        return dataAdmissaoFuncionario;
    }

    public void infoFuncionario(){
        System.out.println("--- Informações do funcionário ---");
        System.out.println("Código: "+ this.codFuncionario);
        System.out.println("Nome: "+ this.nomeFuncionario);
        System.out.println("Função: "+ this.funcaoFuncionario);
        System.out.println("Data de admissão: "+ this.dataAdmissaoFuncionario + "\n");
    }
}
