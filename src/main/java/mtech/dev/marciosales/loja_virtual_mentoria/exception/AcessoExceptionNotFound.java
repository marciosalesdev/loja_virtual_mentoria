package mtech.dev.marciosales.loja_virtual_mentoria.exception;

import java.util.NoSuchElementException;

public class AcessoExceptionNotFound extends NoSuchElementException {
  public AcessoExceptionNotFound(String message) {
    super(message);
    message = "Acesso não encontrado";
  }
}
