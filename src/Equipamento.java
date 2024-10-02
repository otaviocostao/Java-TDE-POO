public class Equipamento {

    // Declaração de variaveis privadas
    // Elas só podem ser acessadas dentro da classe
    private String codEquipamento;
    private String descricaoEqp;
    private String dataCompraEqp;
    private double pesoEqp;
    private double larguraEqp;
    private double comprimentoEqp;
    private String historicoManutencaoEqp;
    private String estadoConservacaoEqp;
    private String disponibilidade;

    // Metodo construtor da classe Equipamento
    public Equipamento(String codEquipamento, String descricaoEqp, String dataCompraEqp, double pesoEqp, double larguraEqp, double comprimentoEqp, String historicoManutencaoEqp, String estadoConservacaoEqp){
        this.codEquipamento = codEquipamento;
        this.descricaoEqp = descricaoEqp;
        this.dataCompraEqp = dataCompraEqp;
        this.pesoEqp = pesoEqp;
        this.larguraEqp = larguraEqp;
        this.comprimentoEqp =comprimentoEqp;
        this.historicoManutencaoEqp = historicoManutencaoEqp;
        this.estadoConservacaoEqp = estadoConservacaoEqp;
        this.disponibilidade = "disponivel";
    }

    // Metodos Setters

    public void setCodEquipamento(String codEquipamento) {
        this.codEquipamento = codEquipamento;
    }

    public void setDescricaoEqp(String descricaoEqp) {
        this.descricaoEqp = descricaoEqp;
    }

    public void setDataCompraEqp(String dataCompraEqp) {
        this.dataCompraEqp = dataCompraEqp;
    }

    public void setPesoEqp(double pesoEqp) {
        this.pesoEqp = pesoEqp;
    }

    public void setLarguraEqp(double larguraEqp) {
        this.larguraEqp = larguraEqp;
    }

    public void setComprimentoEqp(double comprimentoEqp) {
        this.comprimentoEqp = comprimentoEqp;
    }

    public void setHistoricoManutencaoEqp(String historicoManutencaoEqp) {
        this.historicoManutencaoEqp = historicoManutencaoEqp;
    }

    public void setEstadoConservacaoEqp(String estadoConservacaoEqp) {
        this.estadoConservacaoEqp = estadoConservacaoEqp;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    // Metodos Getters
    public String getCodEquipamento() {
        return codEquipamento;
    }

    public String getDescricaoEqp() {
        return descricaoEqp;
    }

    public String getDataCompraEqp() {
        return dataCompraEqp;
    }

    public double getPesoEqp() {
        return pesoEqp;
    }

    public double getLarguraEqp() {
        return larguraEqp;
    }

    public double getComprimentoEqp() {
        return comprimentoEqp;
    }

    public String getHistoricoManutencaoEqp() {
        return historicoManutencaoEqp;
    }

    public String getEstadoConservacaoEqp() {
        return estadoConservacaoEqp;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;  // Verifica se os objetos são o mesmo
        if (obj == null || getClass() != obj.getClass()) return false;  // Verifica se o tipo é diferente ou nulo

        // Converte obj para Equipamento
        Equipamento equipamento = (Equipamento) obj;

        // Compara os códigos do equipamento
        return this.codEquipamento.equals(equipamento.codEquipamento);  // Supondo que `codEquipamento` seja uma String
    }


    // Metodo para exibir informações de equipamentos
    public void infoEquipamento(){
        System.out.println("--- Informações do equipamento ---");
        System.out.println("Código: "+ this.codEquipamento);
        System.out.println("Descrição: "+ this.descricaoEqp);
        System.out.println("Data de compra: " + this.dataCompraEqp);
        System.out.println("Peso: "+ this.pesoEqp+"Kg");
        System.out.println("Largura: "+ this.larguraEqp);
        System.out.println("Comprimento: "+ this.comprimentoEqp);
        System.out.println("Histórico de manutenção: "+ this.historicoManutencaoEqp);
        System.out.println("Estado de conservação: "+this.estadoConservacaoEqp);
        System.out.println("Disponibilidade: " + this.disponibilidade + "\n");
    }
}
