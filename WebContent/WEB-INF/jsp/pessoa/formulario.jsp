
<div id="body">
 <form action="adiciona">
   <fieldset>
     <legend>Adicionar Contato</legend>     
	     <tr>
	     	<td>
	     		<label for="nome">Nome:</label>
	     	</td>
	     	<td>
	     		<input type="text" name="pessoa.nome" value= "${pessoa.nome }"/>
	     	</td>
	     </tr>     
     	<br>
     	
     	<p></p>
     	
     	<tr>
	     	<td>
	     		<label for="rua">Rua:</label>
	     	</td>
	     	<td>
	     		<input type="text" name="endereco.rua" value= "${endereco.rua }"/>
	     	</td>
	     	<td>
	     		<label for="numero">Numero:</label>
	     	</td>
	     	<td>
	     		<input type="text" name="endereco.numeroCasa" value= "${endereco.numeroCasa }"/>
	     	</td>
	     	<td>
	     		<label for="numero">Bairro:</label>
	     	</td>
	     	<td>
	     		<input type="text" name="endereco.bairro" value= "${endereco.bairro }"/>
	     	</td>
	     	<td>
	     		<label for="numero">Estado:</label>
	     	</td>
	     	<td>
	     		<input type="text" name="endereco.estado" value= "${endereco.estado }"/>
	     	</td>
	     </tr>
	     <br>
	     
	     <p>  </p>
	     <tr>
	     	<td>
	     		<label for="telefone">DDD:</label>
	     	</td>
	     	<td>
	     		<input type="text" name="telefone[0].ddd"/>
	     	</td>
	     	<td>
	     		<label for="telefone">Numero:</label>
	     	</td>
	     	<td>
	     		<input type="text" name="telefone[0].numero"/>
	     	</td>
	     	<br>
	     	<td>
	     		<label for="telefone">DDD:</label>
	     	</td>
	     	<td>
	     		<input type="text" name="telefone[1].ddd"/>
	     	</td>	     	
	     	<td>
	     		<label for="telefone">Numero:</label>
	     	</td>
	     	<td>
	     		<input type="text" name="telefone[1].numero"/>
	     	</td>
	     	<br>
	     	<td>
	     		<label for="telefone">DDD:</label>
	     	</td>
	     	<td>
	     		<input type="text" name="telefone[2].ddd" value= "${telefone[2].ddd }"/>
	     	</td>	     	
	     	<td>
	     		<label for="telefone">Numero:</label>
	     	</td>
	     	<td>
	     		<input type="text" name="telefone[2].numero" value= "${telefone[2].numero }"/>
	     	</td>
	     </tr>
        
     <button type="submit">Enviar</button>
   </fieldset>
 </form>
</div>
