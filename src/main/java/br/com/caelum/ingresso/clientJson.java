package br.com.caelum.ingresso;

import java.lang.reflect.Type;
import java.util.Optional;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import br.com.caelum.ingresso.model.FilmeDados;

public class clientJson<T> {
	
	


	public <T> Optional<T> ConsultaServico(String parametros,Class<T> tClass)
	{
		Optional<T> retorno;
		
		String urlClient = "http://imdb-fj22.herokuapp.com/imdb";
		String ParametrosTratado  = parametros.replace(' ','+');
		String URL = urlClient+"?"+ParametrosTratado;
		System.out.println("URL: "+URL);
		RestTemplate client = new RestTemplate();
		
		try
		{
			retorno = Optional.of((T) client.getForObject(URL,tClass));
			System.out.println("Sucesso: ConsultaServico");
			return retorno;
			
		}
		catch (Exception e) {
			System.out.println("Errpo URL: "+e.getMessage());
			return Optional.empty();
		}
		

	}
	

	
	
}
