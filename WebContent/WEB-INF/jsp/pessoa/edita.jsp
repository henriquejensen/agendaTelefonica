<form action="altera">
  <fieldset>
    <legend>Editar dados de um contato</legend>
    
    <input type="hidden" name="pessoa.id" 
      value="${pessoa.id }" />
  
    <label for="nome">Nome:</label>
    <input id="nome" type="text" 
      name="pessoa.nome" value="${pessoa.nome }"/>
    <br>
        
    <label for="rua">Rua:</label>
    <input id="endereco" type="text" 
      name="pessoa.endereco.rua" value="${pessoa.endereco.rua }"/> 
      
    <label for="numero">N� Casa:</label>
    <input id="endereco" type="text" 
      name="pessoa.endereco.numeroCasa" value="${pessoa.endereco.numeroCasa }"/>
      
    <label for="bairro">Bairro:</label>
    <input id="endereco" type="text" 
      name="pessoa.endereco.bairro" value="${pessoa.endereco.bairro }"/>
      
    <label for="estado">Estado:</label>
    <input id="endereco" type="text" 
      name="pessoa.endereco.estado" value="${pessoa.endereco.estado }"/>    
      
    <button type="submit">Enviar</button>
  </fieldset>
</form>