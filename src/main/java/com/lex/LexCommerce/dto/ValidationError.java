package com.lex.LexCommerce.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends ErroCustomizado{

    private List<MensagemPorCampo> erros = new ArrayList<>();

    public ValidationError(Instant timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);
    }

    public List<MensagemPorCampo> getErros() {
        return erros;
    }

    public void addErro(String nomeCampo, String mensagem){
        erros.add(new MensagemPorCampo(nomeCampo, mensagem));
    }
}
