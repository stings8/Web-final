package com.ufc.br.model;
import javax.persistence.*;
import java.util.Objects;

@Entity
public class Compra {

    @Id
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    private long id;

    private Long idCliente;
    private Long idProduto;
    private Double total;

    public Compra(){}

    public Compra(long id, Long idCliente, Long idProduto, Double total) {
        this.id = id;
        this.idCliente = idCliente;
        this.idProduto = idProduto;
        this.total = total;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Compra)) return false;
        Compra compra = (Compra) o;
        return id == compra.id &&
                Objects.equals(getIdCliente(), compra.getIdCliente()) &&
                Objects.equals(getIdProduto(), compra.getIdProduto()) &&
                Objects.equals(getTotal(), compra.getTotal());
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, getIdCliente(), getIdProduto(), getTotal());
    }
}
