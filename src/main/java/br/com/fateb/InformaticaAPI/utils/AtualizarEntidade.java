package br.com.fateb.InformaticaAPI.utils;

import br.com.fateb.InformaticaAPI.entity.Cliente;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class AtualizarEntidade {
    public void atualizarEntidade(Object novaEntidade, Object existente) {
        Class<?> clazz = existente.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object valor = field.get(novaEntidade);
                if (valor != null) { // Certifique-se de que só atualiza se não for nulo
                    field.set(existente, valor);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Erro ao acessar o campo", e);
            }
        }
    }
}
