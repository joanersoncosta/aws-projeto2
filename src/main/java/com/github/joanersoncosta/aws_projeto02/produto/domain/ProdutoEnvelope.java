package com.github.joanersoncosta.aws_projeto02.produto.domain;

import com.github.joanersoncosta.aws_projeto02.produto.domain.enuns.EventType;
import lombok.Getter;

@Getter
public class ProdutoEnvelope {
    private EventType eventType;
    private String data;
}