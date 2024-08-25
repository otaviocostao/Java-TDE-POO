public class Equipamento {
    private String codEquipamento;
    private String descricaoEqp;
    private String dataCompraEqp;
    private double pesoEqp;
    private double larguraEqp;
    private double comprimentoEqp;
    private String historicoManutencaoEqp;
    private String estadoConservacaoEqp;


    public Equipamento(String codEquipamento, String descricaoEqp, String dataCompraEqp, double pesoEqp, double larguraEqp, double comprimentoEqp, String historicoManutencaoEqp, String estadoConservacaoEqp){
        this.codEquipamento = codEquipamento;
        this.descricaoEqp = descricaoEqp;
        this.dataCompraEqp = dataCompraEqp;
        this.pesoEqp = pesoEqp;
        this.larguraEqp = larguraEqp;
        this.comprimentoEqp =comprimentoEqp;
        this.historicoManutencaoEqp = historicoManutencaoEqp;
        this.estadoConservacaoEqp = estadoConservacaoEqp;
    }


}
