import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Equipamento {

    // Declaração de variáveis privadas
    private String codEquipamento;
    private String descricaoEqp;
    private LocalDate dataCompraEqp;
    private double pesoEqp;
    private double larguraEqp;
    private double comprimentoEqp;
    private String historicoManutencaoEqp;
    private String estadoConservacaoEqp;
    private String disponibilidade;

    // Método construtor da classe Equipamento
    public Equipamento(String codEquipamento, String descricaoEqp, String dataCompraEqp, double pesoEqp, double larguraEqp, double comprimentoEqp, String historicoManutencaoEqp, String estadoConservacaoEqp) {
        this.codEquipamento = codEquipamento;
        this.descricaoEqp = descricaoEqp;
        setDataCompraEqp(dataCompraEqp); // Usar o setter para a data
        this.pesoEqp = pesoEqp;
        this.larguraEqp = larguraEqp;
        this.comprimentoEqp = comprimentoEqp;
        this.historicoManutencaoEqp = historicoManutencaoEqp;
        this.estadoConservacaoEqp = estadoConservacaoEqp;
        this.disponibilidade = "disponivel";
    }

    // Métodos Setters
    public void setCodEquipamento(String codEquipamento) {
        this.codEquipamento = codEquipamento;
    }

    public void setDescricaoEqp(String descricaoEqp) {
        this.descricaoEqp = descricaoEqp;
    }

    public void setDataCompraEqp(String dataCompraEqp) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            this.dataCompraEqp = LocalDate.parse(dataCompraEqp, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Data inválida: " + dataCompraEqp);
            this.dataCompraEqp = null; // Ou atribuir uma data padrão
        }
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

    // Métodos Getters
    public String getCodEquipamento() {
        return codEquipamento;
    }

    public String getDescricaoEqp() {
        return descricaoEqp;
    }

    public LocalDate getDataCompraEqp() {
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

    // Método para exibir informações de equipamentos
    public void infoEquipamento() {
        System.out.println("--- Informações do equipamento ---");
        System.out.println("Código: " + this.codEquipamento);
        System.out.println("Descrição: " + this.descricaoEqp);
        System.out.println("Data de compra: " + (this.dataCompraEqp != null ? this.dataCompraEqp.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : "Data inválida inserida"));
        System.out.println("Peso: " + this.pesoEqp + " Kg");
        System.out.println("Largura: " + this.larguraEqp + " cm");
        System.out.println("Comprimento: " + this.comprimentoEqp + " cm");
        System.out.println("Histórico de manutenção: " + this.historicoManutencaoEqp);
        System.out.println("Estado de conservação: " + this.estadoConservacaoEqp);
        System.out.println("Disponibilidade: " + this.disponibilidade + "\n");
    }
}
