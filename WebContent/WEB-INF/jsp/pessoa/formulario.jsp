 <form action="adiciona">
   <fieldset>
     <legend>Adicionar Contato</legend>     
	     <tr>
	     	<td>
	     		<label for="nome">Nome:</label>
	     	</td>
	     	<td>
	     		<input type="text" name="pessoa.nome"/>
	     	</td>
	     </tr>     
     	<br>
     	
     	<p>Endereço</p>
     	
     	<tr>
	     	<td>
	     		<label for="rua">Rua:</label>
	     	</td>
	     	<td>
	     		<input type="text" name="endereco.rua" />
	     	</td>
	     	<td>
	     		<label for="numero">Numero:</label>
	     	</td>
	     	<td>
	     		<input type="text" name="endereco.numeroCasa" />
	     	</td>
	     	<td>
	     		<label for="numero">Bairro:</label>
	     	</td>
	     	<td>
	     		<input type="text" name="endereco.bairro" />
	     	</td>
	     	<td>
	     		<label for="numero">Estado:</label>
	     	</td>
	     	<td>
	     		<input type="text" name="endereco.estado" />
	     	</td>
	     </tr>
	     <br>
	     
	     <p> Telefone </p>
	     <tr>
	     	<td>
	     		<label for="telefone">DDD:</label>
	     	</td>
	     	<td>
	     		<input type="text" name="telefone.ddd"/>
	     	</td>
	     	<td>
	     		<label for="telefone">Numero:</label>
	     	</td>
	     	<td>
	     		<input type="text" name="telefone.numero"/>
	     	</td>
	     </tr>
        
     <button type="submit">Enviar</button>
   </fieldset>
 </form>