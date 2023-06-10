package br.sc.senac.mca.model;

import java.util.Objects;

public class Teste {
    private Integer id;
    private Integer digital;
    private Integer auditivo;
    private Integer cinestesico;
    private Integer visual;

    public Teste() {

    }

    public Teste(Integer digital, Integer auditivo, Integer cinestesico, Integer visual) {
        this.digital = digital;
        this.auditivo = auditivo;
        this.cinestesico = cinestesico;
        this.visual = visual;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDigital() {
        return digital;
    }

    public void setDigital(Integer digital) {
        this.digital = digital;
    }

    public Integer getAuditivo() {
        return auditivo;
    }

    public void setAuditivo(Integer auditivo) {
        this.auditivo = auditivo;
    }

    public Integer getCinestesico() {
        return cinestesico;
    }

    public void setCinestesico(Integer cinestesico) {
        this.cinestesico = cinestesico;
    }

    public Integer getVisual() {
        return visual;
    }

    public void setVisual(Integer visual) {
        this.visual = visual;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teste teste = (Teste) o;
        return id.equals(teste.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Teste{" +
                "id=" + id +
                ", digital=" + digital +
                ", auditivo=" + auditivo +
                ", cinestesico=" + cinestesico +
                ", visual=" + visual +
                '}';
    }
}
