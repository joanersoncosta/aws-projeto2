package com.github.joanersoncosta.aws_projeto02.produto.infra;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.joanersoncosta.aws_projeto02.produto.domain.ProdutoEnvelope;
import com.github.joanersoncosta.aws_projeto02.produto.domain.ProdutoEvento;
import com.github.joanersoncosta.aws_projeto02.produto.domain.SnsMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.TextMessage;
import java.io.IOException;

@Log4j2
@RequiredArgsConstructor
@Service
public class ProdutoEventoConsumer {

    private final ObjectMapper objetcMapper;

    @JmsListener(destination = "${aws.sqs.queue.product.events.name}")
    public void receiveProductEvent(TextMessage textMessage) throws JMSException, IOException {
        log.info("[start] ProdutoEventoConsumer - receiveProductEvent");
        SnsMessage snsMessage = objetcMapper.readValue(textMessage.getText(), SnsMessage.class);
        ProdutoEnvelope produtoEnvelope = objetcMapper.readValue(snsMessage.getMessage(), ProdutoEnvelope.class);
        ProdutoEvento produtoEvento = objetcMapper.readValue(produtoEnvelope.getData(), ProdutoEvento.class);
        log.info("Produto recebido - Evento: {} - idProduto: {} - mensagemId: {}", produtoEnvelope.getEventType(), produtoEvento.getIdProduto(), snsMessage.getMessageId());
        log.info("[finish] ProdutoEventoConsumer - receiveProductEvent");
    }
}