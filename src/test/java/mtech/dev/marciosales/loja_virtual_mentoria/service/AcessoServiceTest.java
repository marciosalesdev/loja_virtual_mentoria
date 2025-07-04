package mtech.dev.marciosales.loja_virtual_mentoria.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import mtech.dev.marciosales.loja_virtual_mentoria.LojaVirtualMentoriaApplication;
import mtech.dev.marciosales.loja_virtual_mentoria.controller.AcessoController;
import mtech.dev.marciosales.loja_virtual_mentoria.model.Acesso;
import mtech.dev.marciosales.loja_virtual_mentoria.repository.AcessoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = LojaVirtualMentoriaApplication.class)
public class AcessoServiceTest{

    @Autowired
   private AcessoController acessoController;
    @Autowired
    private AcessoRepository acessoRepository;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testRestApiCadastrarAcesso() throws Exception {
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(webApplicationContext);
        MockMvc mockMvc = builder.build();

        Acesso acesso = new Acesso();
        acesso.setDescricao("ROLE_COMPRADOR");

        ObjectMapper objectMapper = new ObjectMapper();

        ResultActions retornoApi = mockMvc
                        .perform(MockMvcRequestBuilders.post("/deleteAcesso   Accesso")
                        .content(objectMapper.writeValueAsString(acesso))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON));

        System.out.println("Retorno da api "+ retornoApi.andReturn().getResponse().getContentAsString());
        System.out.println("Status: " + retornoApi.andReturn().getResponse().getStatus() );

//        Acesso objetoRetorno = objectMapper.readValue(retornoApi.andReturn().getResponse().getContentAsString(),
//                Acesso.class);
//
//        Assertions.assertEquals(acesso.getDescricao(),
//                objetoRetorno.getDescricao());
    }


    @DisplayName("quandoSalvarAcessoDeveRetornarObjet")
    @Test
     void salvarCadastro() {
        Acesso acesso = new Acesso();
        acesso.setDescricao("descricaoagora vai");

        /*teste de salvar acesso */
       acesso = acessoController.salvarAcesso(acesso).getBody();


        /*verificando se salvou no banco normalmente */
       Assertions.assertEquals(acesso.getDescricao(), "descricaoagora vai");
       Assertions.assertEquals(true, acesso.getId() != null);

       /*Test de query*/

        List<Acesso> acessos = acessoRepository.buscarAcessoDesc("descricaoagora vai");




    }
    @DisplayName("testDeletePorId")
    @Test
    public void testDeletePorId() throws Exception {
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(webApplicationContext);
        MockMvc mockMvc = builder.build();

        Acesso acesso = new Acesso();
        acesso.setDescricao("ROLE_COMPRADOR");

        ObjectMapper objectMapper = new ObjectMapper();

        ResultActions retornoApi = mockMvc
                .perform(MockMvcRequestBuilders.post("/deleteAcesso   Accesso")
                        .content(objectMapper.writeValueAsString(acesso))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON));

        System.out.println("Retorno da api "+ retornoApi.andReturn().getResponse().getContentAsString());
        System.out.println("Status: " + retornoApi.andReturn().getResponse().getStatus() );

    }

    @DisplayName("testObterAcessoPorID")
    @Test
    public void testObterAcessoPorID() throws Exception {
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(webApplicationContext);
        MockMvc mockMvc = builder.build();

        Acesso acesso = new Acesso();
        acesso.setDescricao("ROLE_OBTER_POR_ID");

        ObjectMapper objectMapper = new ObjectMapper();

        ResultActions retornoApi = mockMvc
                .perform(MockMvcRequestBuilders.post("/deleteAcesso   Accesso")
                        .content(objectMapper.writeValueAsString(acesso))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON));

        System.out.println("Retorno da api "+ retornoApi.andReturn().getResponse().getContentAsString());
        System.out.println("Status: " + retornoApi.andReturn().getResponse().getStatus() );

    }
}