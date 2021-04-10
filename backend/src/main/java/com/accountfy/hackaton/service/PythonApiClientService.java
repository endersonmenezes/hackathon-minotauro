package com.accountfy.hackaton.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;

import com.accountfy.hackaton.dto.Matriz;
import com.accountfy.hackaton.exception.ServiceException;


@Service
public class PythonApiClientService {

	private static final Logger LOG = LogManager.getLogger(PythonApiClientService.class);
	private static final String URL_SWAPI_API = "http://localhost:5000/";
	private WebClient webClient = WebClient.create(URL_SWAPI_API);

	public Matriz performsRequestToExternalApi() throws ServiceException {
		try {
			return webClient.get().uri(
					builder -> builder.path("generateMaze").build())
					.retrieve().bodyToMono(Matriz.class).block();
		} catch (WebClientException e) {
			LOG.error("Ocorreu um erro ao realizar a requição. Erro: {}", e.getMessage());
			throw new ServiceException("Ocorreu um erro ao realizar a requisição. Erro: " + e.getMessage());
		}
	}
}
