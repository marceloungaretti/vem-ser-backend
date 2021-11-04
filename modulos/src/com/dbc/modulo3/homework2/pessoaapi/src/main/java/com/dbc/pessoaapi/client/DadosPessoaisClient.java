package com.dbc.pessoaapi.client;

import com.dbc.pessoaapi.dto.DadosPessoaisDTO;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient(value="dados-pessoais", url="https://my-application-teste.herokuapp.com")
@Headers("Content-Type: application/json")
public interface DadosPessoaisClient {

    @RequestLine("GET /dados-pessoais")
    List<DadosPessoaisDTO> listar();

    @RequestLine("GET /dados-pessoais/{cpf}")
    DadosPessoaisDTO getPorCpf(@Param("cpf") String cpf);

}