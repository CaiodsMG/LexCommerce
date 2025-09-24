package com.lex.LexCommerce.entities;

import com.lex.LexCommerce.entities.enums.PedidoStatus;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "tb_pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP SEM TIME ZONE")
    private Instant moment;
    private PedidoStatus status;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Usuario cliente;

    public Pedido() {
    }

    public Pedido(Long id, Instant moment, PedidoStatus status, Usuario cliente) {
        this.id = id;
        this.moment = moment;
        this.status = status;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PedidoStatus getStatus() {
        return status;
    }

    public void setStatus(PedidoStatus status) {
        this.status = status;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }


}
